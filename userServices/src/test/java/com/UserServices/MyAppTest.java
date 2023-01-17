package com.UserServices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.UserServices.RestClients.BookServices;
import com.UserServices.controllers.JwtAuthenticationController;
import com.UserServices.execptions.UserExceptions;
import com.UserServices.models.Book;
import com.UserServices.models.JwtRequest;
import com.UserServices.models.Subscription;

@SpringBootTest
public class MyAppTest {
	@MockBean
	BookServices bs;

	@MockBean
	JwtAuthenticationController authen;

	@Test
	public void test() {
		Book book = new Book();
		Book book2 = new Book();
		book2.setAuthor("abhilash");
		book2.setTitle("dome");

		Mockito.when(bs.addBook(book)).thenReturn(book2);
		System.out.println("hello user " + bs.addBook(book));

	}

	@Test
	public void testAuthentication() throws UserExceptions {
		JwtRequest jreq = new JwtRequest();
		try {
			Mockito.when(authen.authenticate(jreq)).thenThrow(new UserExceptions("Bad credentials "));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertThrows(UserExceptions.class, () -> {
			authen.authenticate(jreq);
		});

	}
	@Test
	public void testSubscription()
	{
		Mockito.when(bs.subscribeBook(1, 1)).thenReturn("Payment Done subscribed sucessfully");
		System.out.println(bs.subscribeBook(1, 1));
		
		Assertions.assertEquals("Payment Done subscribed sucessfully",bs.subscribeBook(1, 1) );
		
	}
}
