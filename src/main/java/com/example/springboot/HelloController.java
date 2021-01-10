package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from an experiment.";
	}

	@RequestMapping("/new")
	public String newIndex() {
		return "Greetings from a new experiment.";
	}

	@RequestMapping("/new/{id}")
	public String index(@PathVariable("id") int id) {
		return "Greetings from an experiment " + id + ".";
	}

}
