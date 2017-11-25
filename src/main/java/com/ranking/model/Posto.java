package com.ranking.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Posto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	@Size(min=5, message="Nome deve conter mais de 5 caracteres")
	private String nome;
	
	@NotNull(message="Endereço é obrigatório")
	@Size(min=10, message="Endereço deve conter mais de 10 caracteres")
	private String endereco;
	
	@NotNull(message="Preço da Gasolina é obrigatório")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal precoGasolina;
	
	@NotNull(message="Preço do Etanol é obrigatório")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal precoEtanol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getPrecoGasolina() {
		return precoGasolina;
	}

	public void setPrecoGasolina(BigDecimal precoGasolina) {
		this.precoGasolina = precoGasolina;
	}

	public BigDecimal getPrecoEtanol() {
		return precoEtanol;
	}

	public void setPrecoEtanol(BigDecimal precoEtanol) {
		this.precoEtanol = precoEtanol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posto other = (Posto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
