package com.example.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.delivery.auth.JwtService;
import com.example.delivery.dto.AuthenticationResponse;
import com.example.delivery.dto.CartResponse;
import com.example.delivery.model.Cart;
import com.example.delivery.model.Orders;
import com.example.delivery.model.Product;
import com.example.delivery.model.Users;
import com.example.delivery.repository.CartRepository;
import com.example.delivery.repository.OrderRepository;
import com.example.delivery.repository.ProductRepository;
import com.example.delivery.repository.UsersRepository;
import com.example.delivery.service.CartService;
import com.example.delivery.service.ProductService;
import com.example.delivery.service.UsersService;

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
