package com.service.musicmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.musicmicroservice.entity.Genero;
import com.service.musicmicroservice.service.GeneroService;






@RestController
@RequestMapping("/genero")
@CrossOrigin(origins = "*")
public class GeneroController {

	@Autowired
	GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<List<Genero>> getAll(){
		List<Genero> generos = generoService.getAll();
		if(generos.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(generos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> getById(@PathVariable("id") int id){
		Genero genero = generoService.getUserById(id);
		if(genero == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(genero);
	}
	
	@PostMapping()
	public ResponseEntity<Genero> save(@RequestBody Genero genero){
		Genero genNew = generoService.save(genero);
		return ResponseEntity.ok(genNew);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Genero>> getByUserId(@PathVariable("userId") int userId){
		List<Genero> generos = generoService.byUserId(userId);
		if(generos.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(generos);
	}
	

	

}
