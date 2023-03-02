package com.example.Delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Delivery.auth.JwtService;
import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.model.Cart;
import com.example.Delivery.dto.CartOrderRequest;
import com.example.Delivery.dto.CartOrderRequestWrapper;
import com.example.Delivery.dto.CartRequest;
import com.example.Delivery.dto.CartResponse;
import com.example.Delivery.model.OrderEach;
import com.example.Delivery.model.Orders;
import com.example.Delivery.model.Product;
import com.example.Delivery.repository.CartRepository;
import com.example.Delivery.repository.OrderEachRepository;
import com.example.Delivery.repository.ProductRepository;
import com.example.Delivery.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService{
    private final CartRepository cartrepository;
    private final JwtService jwtservice;
    private final UsersRepository userrepository;
    private final ProductRepository productrepository;
    private final OrderEachRepository ordereachrepository;

    
    /*
     * parameter(in): CartRequest
     * return(out): String
     * purpose: add the products to the user cart
     */
    public String addCart(CartRequest request) {
        var username = jwtservice.extractUsername(request.getToken());
        var user = userrepository.findByUsername(username).orElseThrow();
        Product p = productrepository.findById(request.getProductid());

        var cart = Cart.builder()
                        .userid(user.getId())
                        .count(request.getCount())
                        .product(p)
                        .build();

        cart.setProduct(p);
        cartrepository.save(cart);
       
        return "Cart added!";
    }

    /*
     * parameter(in): AuthenticationResponse
     * return(out): List<CartResponse>
     * purpose: show all the products in the cart(for check)
     */
    public List<CartResponse> myCart(AuthenticationRequest request) {
        var token = request.getToken();
        var username = jwtservice.extractUsername(token);
        var user = userrepository.findByUsername(username).orElseThrow();
        List<Cart> cart = cartrepository.findByUserid(user.getId());    
        List<CartResponse> mycart = new ArrayList<>();  
        for (Cart c: cart) {
            var cart_each = CartResponse.builder().img_path(c.getProduct().getImgPath())
                                                .productid(c.getProduct().getId())
                                                .name(c.getProduct().getName())
                                                .price(c.getProduct().getPrice())
                                                .count(c.getCount()).build();
            mycart.add(cart_each);
        } 
        return mycart;
    }

    /*
     * parameter(in): List<Cart>
     * return(out): String
     * purpose: place an order with all products in user's cart
     */
    public String placeOrder(CartOrderRequestWrapper request) {
        // cart에서 삭제 및 order에 추가
        List<CartOrderRequest> cartorderItems = request.getCartorder();
        if (cartorderItems.size() > 0) {
            var username = jwtservice.extractUsername(request.getToken());
            var user = userrepository.findByUsername(username).orElseThrow();
            Orders o = Orders.builder().userid(user.getId()).build();
            o.setOrders_list(new ArrayList<OrderEach>());

            for (CartOrderRequest c : cartorderItems) {
                System.out.println(c);
                Product p = productrepository.findById(c.getProductid());
                OrderEach each = OrderEach.builder().count(c.getCount())
                                            .imgPath(p.getImgPath())
                                            .name(p.getName())
                                            .price(p.getPrice())
                                            .build();
                o.add_ordereach(each);
                ordereachrepository.save(each);
            }
            cartrepository.deleteByUserid(user.getId());
        }
       
        return "주문이 완료되었습니다";   
    }
}
