package com.syneco.mapper.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syneco.mapper.model.Response;
import com.syneco.mapper.service.MapperService;

@RestController
public class Controller {

	@GetMapping("/mapper")
	public Response getMapping(@RequestParam String inputCode) {

		Random random = new Random();

		Long id = Math.abs(random.nextLong());

		String responseCode = MapperService.getResponseCode(inputCode);

		Response response = new Response(id, responseCode);

		return response;
	}

}
