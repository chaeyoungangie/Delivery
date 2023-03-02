package com.example.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Delivery.auth.JwtService;
import com.example.Delivery.dto.AuthenticationResponse;
import com.example.Delivery.model.Cart;
import com.example.Delivery.dto.CartResponse;
import com.example.Delivery.model.Orders;
import com.example.Delivery.model.Product;
import com.example.Delivery.model.Users;
import com.example.Delivery.repository.CartRepository;
import com.example.Delivery.repository.OrderRepository;
import com.example.Delivery.repository.ProductRepository;
import com.example.Delivery.repository.UsersRepository;
import com.example.Delivery.service.CartService;
import com.example.Delivery.service.ProductService;
import com.example.Delivery.service.UsersService;

@SpringBootTest
class DeliveryApplicationTests {
	
	@Autowired UsersService userservice;
	@Autowired ProductService productservice;
	@Autowired CartService cartservice;
	@Autowired CartRepository cartrepository;
	@Autowired JwtService jwtservice;
	@Autowired UsersRepository userrepository;
	@Autowired OrderRepository orderrepository;


	@Test
	void userservice_test() {
		var token = "ss";
		AuthenticationResponse req = AuthenticationResponse.builder().token(token).build();

		var username = jwtservice.extractUsername(req.getToken());
        var user = userrepository.findByUsername(username).orElseThrow();    
		assertThat(user.getUsername()).isEqualTo("user");
		assertThat(user.getFirstname()).isEqualTo("firstname");
		assertThat(user.getLastname()).isEqualTo("lastname");
	}

	
	@Test
	void placeordertest() {
		// var p = Product;
		List<Cart> cart_list = new ArrayList<Cart>();
		Cart c = Cart.builder().id(8).count(3).userid(1).build();
		cart_list.add(c);
		// cartservice.placeorder(cart_list);
	}

	@Test
	void getordertest() {
		List<Orders> myorder = orderrepository.findByUserid(1);
		System.out.println(myorder);
		assertThat(myorder.size()).isEqualTo(2);

	}


	

}
