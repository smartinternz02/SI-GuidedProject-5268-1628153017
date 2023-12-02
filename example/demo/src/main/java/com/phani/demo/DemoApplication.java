package com.phani.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.phani.Entity.Book;
import com.phani.Services.bookServices;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		bookServices service = ctx.getBean(bookServices.class);
		Book foundBook = service.findByBookName("one indian girl");

		System.out.println("Found Book:= " + foundBook);

		service.updatePrice(1, 600);

		List<Book> list = ctx.getBean(bookServices.class).findAll();

		System.out.println(list);

		service.searchBooksByAuthor("Chethan bhagath").forEach(System.out::println);

		// System.out.println("Row Deleted : = "+service.remove(foundBook));

		// System.out.println("Row Deleted : = "+service.removeById(1));

		// service.removeById(1);
	}

}
