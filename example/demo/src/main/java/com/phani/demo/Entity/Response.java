package com.phani.demo.Entity;


import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Response")
@Data

public class Response {

	@Autowired
	public Response(String message, float answer) {
		super();
		this.message = message;
		this.answer = answer;
	}
	public Response() {
		
	}
	@Id
	@Column(name="message")
	private String message;
	@Column(name="answer")
	private float answer;
	
	
}
