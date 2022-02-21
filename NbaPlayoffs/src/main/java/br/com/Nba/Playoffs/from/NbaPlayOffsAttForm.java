package br.com.Nba.Playoffs.from;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.Nba.Playoffs.Model.NbaPlayOffsModel;
import br.com.Nba.Playoffs.Repository.NbaPlayOffsRepository;

public class NbaPlayOffsAttForm {

	@NotNull @NotEmpty
	private String pontuacao;

	
	public String getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}


	public NbaPlayOffsModel atualizar(Long id, NbaPlayOffsRepository nbarepos) {
		NbaPlayOffsModel nba = nbarepos.getOne(id);
		nba.setPontuacao(this.pontuacao);
		return nba;
	}

}
