package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "IzenBarik") String name, 
							@RequestParam(value = "lang", defaultValue = "eu") String lang) {

		switch (lang) {
			case "en":
				return new Greeting(counter.incrementAndGet(), String.format(template, name));
			case "eu":
				return new Greeting(counter.incrementAndGet(), String.format("Kaixo, %s!", name));
			case "es":
				return new Greeting(counter.incrementAndGet(), String.format("Hola, %s!", name));
			default:
				return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}
	}
}
