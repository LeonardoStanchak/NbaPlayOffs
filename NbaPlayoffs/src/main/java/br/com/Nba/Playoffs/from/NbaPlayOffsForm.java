package br.com.Nba.Playoffs.from;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.Nba.Playoffs.Model.NbaPlayOffsModel;
import br.com.Nba.Playoffs.Repository.NbaPlayOffsRepository;

public class NbaPlayOffsForm {

	@NotNull @NotEmpty
	private String nbatime;
	@NotNull @NotEmpty
	private String conferencia;
	@NotNull @NotEmpty
	private String pontuacao;

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
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

	public NbaPlayOffsModel converter(NbaPlayOffsRepository nbaRepos) {
		return new NbaPlayOffsModel(nbatime, conferencia, pontuacao);
	}

}
