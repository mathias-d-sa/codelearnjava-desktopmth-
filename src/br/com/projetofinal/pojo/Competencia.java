package br.com.projetofinal.pojo;

public class Competencia {	
	private int id;
	private String descricao;
	private int minutos;
	private static int contador;
	//private static int contador;
	
	public Competencia() {
		contador++;
	}
	
	public Competencia(int id, String descricao, int minutos) {
		this.id = id;
		this.descricao = descricao;
		this.minutos = minutos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public static int getContador() {
		return contador;
	}

	
	
	
	

}
