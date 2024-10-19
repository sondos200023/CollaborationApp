package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.*;
import com.demo.repository.*;

@RestController
@RequestMapping("Discussion")
public class DiscussionController {
	@Autowired
	DiscussionRepository DiscussionRepository;
	@PostMapping
	public Discussion addOne(@RequestBody Discussion Discussion)
	{
		return DiscussionRepository.save(Discussion);
	}
	@GetMapping
	public List<Discussion> getAll()
	{
		return DiscussionRepository.findAll();
	}
	@GetMapping("/{id}")
	public Discussion getOne(@PathVariable int id)
	{
		return DiscussionRepository.findById(id).get();
	}

	
}
