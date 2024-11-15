package com.sesi.achadoseperdidos.models;

import java.time.LocalDate;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "item")
public class Item {
	
	public enum TipoObjeto {
		MOCHILA,
		BOLSINHA,
		ROUPA,
		ELETRÔNICO,
		ACESSÓRIO,
		LIVRO,
		GARRAFA,
		OUTROS
	}
	
	public enum Cor {
		AZUL,
		AMARELO,
		VERMELHO,
		VERDE,
		PRETO,
		ROSA,
		LARANJA,
		BRANCO,
		ROXO,
		DOURADO,
		PRATA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoObjeto tipoObjeto;
	
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Column
	private LocalDate dataPerda;
	
	@Column
	private String nome;
	
	@Column
	private String desc1;
	
	@Column
	private String desc2;
	
	@Column
	private String desc3;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoObjeto getTipoObjeto() {
		return tipoObjeto;
	}

	public void setTipoObjeto(TipoObjeto tipoObjeto) {
		this.tipoObjeto = tipoObjeto;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public LocalDate getDataPerda() {
		return dataPerda;
	}

	public void setDataPerda(LocalDate dataPerda) {
		this.dataPerda = dataPerda;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor, dataPerda, desc1, desc2, desc3, id, nome, tipoObjeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return cor == other.cor && Objects.equals(dataPerda, other.dataPerda) && Objects.equals(desc1, other.desc1)
				&& Objects.equals(desc2, other.desc2) && Objects.equals(desc3, other.desc3)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && tipoObjeto == other.tipoObjeto;
	}

	
}
