package br.com.Nba.Playoffs.Dto;

import org.springframework.data.domain.Page;

import br.com.Nba.Playoffs.Model.NbaPlayOffsModel;

public class NbaPlayOffsDto {

	private Long id;

	private String nbatime;

	private String conferencia;

	private String pontuacao;

	public NbaPlayOffsDto(NbaPlayOffsModel nba) {
		this.id = nba.getId();
		this.nbatime = nba.getNbaTime();
		this.conferencia = nba.getConferencia();
		this.pontuacao = nba.getPontuacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNbatime() {
		return nbatime;
	}

	public void setNbatime(String nbatime) {
		this.nbatime = nbatime;
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

	public static Page<NbaPlayOffsDto> converter(Page<NbaPlayOffsModel> nba) {
		return nba.map(NbaPlayOffsDto::new);
	}
}
