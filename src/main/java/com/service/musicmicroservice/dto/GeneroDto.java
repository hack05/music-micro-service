package com.service.musicmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroDto {

	private String genero;
	private String cancion;
	
	private Long userId;
	private String ciudad;
	private Double temp;
}
