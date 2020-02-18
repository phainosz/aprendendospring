package br.com.aprendendospring.api.exception;

public class Mensagem {

	private String mensagem;
	private String httpStatus;

	public Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Mensagem(String mensagem, String httpStatus) {
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
