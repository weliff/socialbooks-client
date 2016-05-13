package com.algaworks.socialbooks.aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.algaworks.socialbooks.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic d2VsaWZmOjEyMw==")
				.build();
		
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		for (Livro livro : response.getBody()) {
			System.out.println("Livro: " + livro.getNome());
			
		}
	
	}
}
