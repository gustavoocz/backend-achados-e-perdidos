package com.sesi.achadoseperdidos.models;

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
		OUTROS
	}
	
	public enum Cor {
		AZUL,
		AMARELO,
		VERMELHO,
		VERDE,
		PRETO,
		ROSA,
		LARANJA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoObjeto tipoObjeto;
	
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Column
	private String diaPerda;
	
	@Column
	private String nome;

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

	public String getDiaPerda() {
		return diaPerda;
	}

	public void setDiaPerda(String diaPerda) {
		this.diaPerda = diaPerda;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cor, diaPerda, id, tipoObjeto);
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
		return cor == other.cor && Objects.equals(diaPerda, other.diaPerda) && Objects.equals(id, other.id)
				&& tipoObjeto == other.tipoObjeto;
	}
	
	
}
