package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Livro {
	
	@JsonInclude(Include.NON_NULL)
	private Long id;
	@JsonInclude(Include.NON_NULL)
	private String nome;
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date publicacao;
	@JsonInclude(Include.NON_NULL)
	private String editora;
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	@JsonInclude(Include.NON_EMPTY)
	private List<Comentario> comentarios;
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
	public Livro(String nome, Autor autor, Date publicacao) {
		this.nome = nome;
		this.autor = autor;
		this.publicacao = publicacao;
	}
	
	public Livro(Livro livro, Long id) {
		this.id = id;
		this.nome = livro.nome;
		this.comentarios = livro.comentarios;
		this.editora = livro.editora;
		this.publicacao = livro.publicacao;
		this.resumo = livro.resumo;
		this.autor = livro.autor;
	}
	
	public Livro (){
		
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Date getPublicacao() {
		return publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public String getResumo() {
		return resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public Autor getAutor() {
		return autor;
	}
	

}
