package com.service.musicmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.musicmicroservice.entity.Genero;
import com.service.musicmicroservice.repository.IGeneroRepository;
import com.service.musicmicroservice.spotify.model.City;
import com.service.musicmicroservice.spotify.model.Categories;


@Service
public class GeneroService {
	
	@Autowired
	IGeneroRepository generoRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Genero> getAll(){
		return generoRepository.findAll();
	}
	
	public Genero getUserById(int id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public Optional<Genero> getByGenero(String cityName){
		return generoRepository.findByGenero(cityName);
	}

	public Genero save(Genero genero) {
		Genero generoNew = generoRepository.save(genero);
		return generoNew;
	}
	
	public List<Genero> byUserId(int userId){
		return generoRepository.findByUserId(userId);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Categories> getGenresAll(){
		List<Categories> genres = restTemplate.getForObject("https://api.spotify.com/v1/recommendations/available-genre-seeds", List.class);
		return genres;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categories> getAllTracksByGenre(String genero){
		List<Categories> tracks = restTemplate.getForObject("https://api.spotify.com/v1/browse/categories/"+genero+"/playlists", List.class);
		return tracks;
	}
	
	@SuppressWarnings("unchecked")
	public List<City> getName(String name){
		List<City> cityName = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=dc3efb030f8eca89ffdf7f379b630afd", List.class);
		return cityName;
	}

}
