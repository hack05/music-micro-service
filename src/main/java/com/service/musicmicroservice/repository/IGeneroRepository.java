package com.service.musicmicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.musicmicroservice.entity.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer>{

	List<Genero> findByUserId(int userId);
	Optional<Genero> findByCiudad(String ciudad);
	Optional<Genero> findByGenero(String genero);
	Optional<Genero> findByTemp(Double temp);
	//Optional<Genero> SelectTempfindByCancion(String cancion);
	boolean existsByTemp(Double temp);
}
