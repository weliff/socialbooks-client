package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client = new LivrosClient("http://localhost:8080", "weliff", "123");
		
		List<Livro> livros = client.listar();
		
		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getNome());
			
		}
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		
		Autor autor = new Autor();
		autor.setId(1L);
		
		Livro livro = new Livro("Git passo-a-passo", autor, publicacao.parse("01/01/2016"));
		
		String location = client.salvar(livro);
		System.out.println("Localização do livro salvo: " + location);
		
		Livro livroBuscado = client.buscar(location);
		
		System.out.println("Livro salvo: " + livroBuscado.getNome());
	
	}
}
