package br.com.Nba.Playoffs.Config.Validacao.dto;

public class ErroNbaDTO {
	private String campo;
	private String mensagemErro;

	public ErroNbaDTO(String campo, String mensagemErro) {
		this.campo = campo;
		this.mensagemErro = mensagemErro;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

}
