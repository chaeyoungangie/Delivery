package com.example.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	@Autowired PasswordEncoder passencoder;

	// To-Do list
	// 각 controller 마다 테스트 파일 하나씩 만들고 각 method 마다 유닛테스트하기
	// 유닛테스트 찾아보기
	// 테스트 코드 작성 전에 edge case가 뭐가 있을지 고민해보기

	@Test
	void registerTest() {
		// case: username은 중복불가: 이거 처리 아직 안해줌 - 추가하기
		var user1 = Users.builder().firstname("first")
									.lastname("last")
									.email("email@gmail.com")
									.password(passencoder.encode("password"))
									.username("user").build();

		userrepository.save(user1);
		var user2 = userrepository.findByUsername("user");
	 
		assertThat(user1.getUsername()).isEqualTo(user2.get().getUsername());
		assertThat(user1.getFirstname()).isEqualTo(user2.get().getFirstname());
		assertThat(user1.getLastname()).isEqualTo(user2.get().getLastname());
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
		assertThat(myorder.size()).isEqualTo(2);

	}


	

}
