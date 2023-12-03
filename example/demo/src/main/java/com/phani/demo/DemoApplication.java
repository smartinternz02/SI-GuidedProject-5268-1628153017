package com.phani.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.phani.demo.Entity.Book;
import com.phani.demo.Services.bookServices;
import com.phani.demo.repository.bookRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		bookServices service = ctx.getBean(bookServices.class);
		// Book foundBook = service.findByBookName("one indian girl");

		// System.out.println("Found Book:= " + foundBook);

		// service.updatePrice(1, 600);

		// List<Book> list = ctx.getBean(bookServices.class).findAll();


		// System.out.println(list);

		// service.searchBooksByAuthor("Small man").forEach(System.out::println);

		// System.out.println("Row Deleted : = "+service.remove(foundBook));

		// System.out.println("Row Deleted : = "+service.removeById(1));

		// service.removeById(1);
	}
	
	

}
