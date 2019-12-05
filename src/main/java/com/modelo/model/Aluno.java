package com.modelo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



@Entity
public class Aluno {
	@Id
	@GeneratedValue
	
	private int id;
	@NotBlank (message="O nome é Obrigatorio")
	private String nome;
	private String acompanhante;
	@NotBlank
	@Column(nullable = true)
	private String nomeAcompanhante;
	private String turma;
	public String getNomeAcompanhante() {
		return nomeAcompanhante;
	}
	
	
	
	
	
	public void setNomeAcompanhante(String nomeAcompanhante) {
		this.nomeAcompanhante = nomeAcompanhante;
	}
	public int getId() {
		return id;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAcompanhante() {
		return acompanhante;
	}
	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}
	
	
	
	
	

}
