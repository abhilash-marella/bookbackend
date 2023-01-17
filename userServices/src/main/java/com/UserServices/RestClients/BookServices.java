package com.UserServices.RestClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UserServices.models.Book;
import com.UserServices.models.MySubscriptiondetails;
import com.UserServices.models.Subscription;

@FeignClient(value = "book", url = "http://localhost:8090")
public interface BookServices {

	@GetMapping("/BookServices/search")
	public List<Book> getBooks();

	@GetMapping("/BookServices/search/{bookId}")
	public Book getBookById(@PathVariable int bookId);

	@GetMapping("/BookServices/search/title/{title}")
	public Book getBookByName(@PathVariable String title);

	@PostMapping("/BookServices/subscribe/{userId}/{bookId}")
	public String subscribeBook(@PathVariable int userId, @PathVariable int bookId);

	@PutMapping("/BookServices/unsubscribe/{subscribeID}")
	public String unSubscribe(@PathVariable int subscribeID);

	@PostMapping("/BookServices/book/add")
	public Book addBook(@RequestBody Book book);

	@PutMapping("/BookServices/book/edit")
	public Book updateBook(@RequestBody Book book);

	@PutMapping("/BookServices/book/block/{id}")
	public String blockBook(@PathVariable int id);

	@GetMapping("/BookServices/subscribedBooks/{userId}")
	public List<MySubscriptiondetails> subscribedBooks(@PathVariable int userId);

	@GetMapping("/BookServices/subscribeHistory/{userId}")
	public List<Subscription> subscribeHistory(@PathVariable int userId);

	@GetMapping("/BookServices/myBooks/{userName}")
	public List<Book> BooksPublishedByUser(@PathVariable String userName);
	
	@GetMapping("/BookServices/reading/{userId}/{SubscriptionId}")
	public String readBook(@PathVariable int userId ,@PathVariable int SubscriptionId);
	
	@DeleteMapping("/BookServices/deleteBook/{bookId}")
	 public String deleteBook(@PathVariable int bookId );
}
