package br.com.aprendendospring.api.exception;

public class MyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -9060795134536591306L;


	public MyNotFoundException(String mensagem) {
		super(mensagem);
	}
}
