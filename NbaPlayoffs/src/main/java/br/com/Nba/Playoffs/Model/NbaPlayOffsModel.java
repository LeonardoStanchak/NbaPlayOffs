package br.com.Nba.Playoffs.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "nba_Playoffs")
public class NbaPlayOffsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nbatime;

	private String conferencia;

	private String pontuacao;

	public Long getId() {
		return id;
	}

	public NbaPlayOffsModel() {

	}
	
	

	public NbaPlayOffsModel(String nbatime, String conferencia, String pontuacao) {
		this.nbatime = nbatime;
		this.conferencia = conferencia;
		this.pontuacao =  pontuacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNbaTime() {
		return nbatime;
	}

	public void setNbaTime(String nbaTime) {
		nbatime = nbaTime;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public String toString() {
		return "nbaPlayoffs [id =" + id + ",nbatime =" + nbatime + ", conferencia =" + conferencia + ", pontuacao ="
				+ pontuacao + "]";
	}

}
