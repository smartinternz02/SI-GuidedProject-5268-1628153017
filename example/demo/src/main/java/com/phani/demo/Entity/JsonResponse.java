package com.phani.demo.Entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class JsonResponse {

	// public static ResponseEntity<Object> responseBuilder(String message,HttpStatus httpStatus, Object responseData ){
	// 	Map<String, Object> response = new HashMap<>();
	// 	response.put("message",message);
	// 	response.put("httpStatus",httpStatus);
	// 	response.put("Data",responseData);
	// 	return new ResponseEntity<Object>(response, httpStatus);
	// }
	
	
	public static ResponseEntity<Object> reponseBuilder(Response response,HttpStatus httpStatus){
		Map<String,Object> json=new HashMap<>();
		 json.put("message",response.getMessage());
		 json.put("answer",response.getAnswer());
		return new ResponseEntity<Object>(response, httpStatus);
	}
}
