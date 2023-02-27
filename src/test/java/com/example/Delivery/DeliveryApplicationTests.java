package com.example.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Delivery.Auth.JwtService;
import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.Cart;
import com.example.Delivery.Model.CartResponse;
import com.example.Delivery.Model.Orders;
import com.example.Delivery.Model.Product;
import com.example.Delivery.Model.Users;
import com.example.Delivery.Repository.CartRepository;
import com.example.Delivery.Repository.OrderRepository;
import com.example.Delivery.Repository.ProductRepository;
import com.example.Delivery.Repository.UsersRepository;
import com.example.Delivery.Service.CartService;
import com.example.Delivery.Service.ProductService;
import com.example.Delivery.Service.UsersService;

@SpringBootTest
class DeliveryApplicationTests {
	
	@Autowired UsersService userservice;
	@Autowired ProductService productservice;
	@Autowired CartService cartservice;
	@Autowired CartRepository cartrepository;
	@Autowired JwtService jwtservice;
	@Autowired UsersRepository userrepository;
	@Autowired OrderRepository orderrepository;


	// @Test
	// void userservice_test() {
	// 	AuthenticationResponse req = AuthenticationResponse.builder().token(token_).build();
	// 	System.out.println("userservice test in");

	// 	UserResponse user = userservice.getAccount(req);
	// 	System.out.println(user);
	// 	assertThat(user.getUsername()).isEqualTo("user");
	// 	assertThat(user.getFirstname()).isEqualTo("firstname");
	// 	assertThat(user.getLastname()).isEqualTo("lastname");
	// }

	
	// @Test
	// void placeordertest() {
	// 	// var p = Product;
	// 	List<Cart> cart_list = new ArrayList<Cart>();
	// 	Cart c = Cart.builder().id(8).count(3).userid(1).build();
	// 	cart_list.add(c);
	// 	cartservice.placeorder(cart_list);
	// }

	@Test
	void getordertest() {
		List<Orders> myorder = orderrepository.findByUserid(1);
		System.out.println(myorder);
		// assertThat(mycar).isEqualTo(2);

	}


	

}
