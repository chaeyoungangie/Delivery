package com.example.Delivery.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Delivery.Auth.JwtService;
import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.Cart;
import com.example.Delivery.Model.CartOrderRequest;
import com.example.Delivery.Model.CartRequest;
import com.example.Delivery.Model.CartResponse;
import com.example.Delivery.Model.OrderEach;
import com.example.Delivery.Model.Orders;
import com.example.Delivery.Model.Product;
import com.example.Delivery.Repository.CartRepository;
import com.example.Delivery.Repository.OrderEachRepository;
import com.example.Delivery.Repository.ProductRepository;
import com.example.Delivery.Repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
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
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getPrice());
        System.out.println(p.getImgPath());

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
    public List<CartResponse> getmycart(AuthenticationResponse request) {
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
    public String placeorder(List<CartOrderRequest> request) {
        // cart에서 삭제 및 order에 추가
        // Orders o = Orders.builder().userid(request.get(0).getUserid()).build();
        // o.setOrders_list(new ArrayList<OrderEach>());

        // for (Cart c : request) {
        //     OrderEach each = OrderEach.builder().count(c.getCount())
        //                                 .imgPath(c.getProduct().getImgPath())
        //                                 .name(c.getProduct().getName())
        //                                 .price(c.getProduct().getPrice())
        //                                 .build();
        //     o.add_ordereach(each);
        //     ordereachrepository.save(each);
        //     cartrepository.deleteById(c.getId());
        // }
        return "주문이 완료되었습니다";   
    }
    
    
}
