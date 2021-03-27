package com.telusko.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.dao.AlienRepo;
import com.telusko.modal.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@DeleteMapping("/alien/{id}")
	public String deleteAlien(@PathVariable int id) {

		Alien a = repo.getOne(id);

		repo.delete(a);

		return "deleted";

	}
	
	
	

	@PostMapping(path = "/alien", consumes = { "application/json" })
	public Alien addAlien(@RequestBody Alien a) {
		repo.save(a);

		return a;
	}

	@GetMapping(path = "/aliens")

	public List<Alien> getAliens() {

		return repo.findAll();

	}
	
	

	@PutMapping(path = "/alien", consumes = { "application/json" })
	public Alien saveOrupdateAlien(@RequestBody Alien a) {
		repo.save(a);

		return a;
	}

	@RequestMapping("/aliens/{id}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("id") int id) {

		return repo.findById(id);

	}

}
