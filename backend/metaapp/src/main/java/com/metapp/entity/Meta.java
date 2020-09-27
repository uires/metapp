package com.metapp.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "meta")
public class Meta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "estimado")
	private BigDecimal estimado;

	@Column(name = "acumulado")
	private BigDecimal acumulado;

	@Column(name = "data_prevista_fim_meta")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPrevistaFimMeta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getEstimado() {
		return estimado;
	}

	public void setEstimado(BigDecimal estimado) {
		this.estimado = estimado;
	}

	public BigDecimal getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(BigDecimal acumulado) {
		this.acumulado = acumulado;
	}

	public BigDecimal getPendente() {
		return this.estimado.subtract(this.acumulado);
	}

	public LocalDate getDataPrevistaFimMeta() {
		return dataPrevistaFimMeta;
	}

	public void setDataPrevistaFimMeta(LocalDate dataPrevistaFimMeta) {
		this.dataPrevistaFimMeta = dataPrevistaFimMeta;
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
		Meta other = (Meta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
