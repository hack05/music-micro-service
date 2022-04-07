package com.service.musicmicroservice.spotify.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {

	private String genres;
	private String tracks;
}
