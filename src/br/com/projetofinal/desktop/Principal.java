package br.com.projetofinal.desktop;

import br.com.projetofinal.pojo.Competencia;
import br.com.projetofinal.gui.*;

public class Principal {

	public static void main(String[] args) {
		
		Competencia c1 = new Competencia();
		Competencia c2 = new Competencia();
		Competencia c3 = new Competencia();
		Competencia c4 = new Competencia();
		
		// O total de objetos é 4.
		System.out.println("A quantidade de objetos é: " + Competencia.getContador());
		
		//Forma de criar um vetor:
		String[] competencias = new String[4];
		competencias[0] = "conhecimento";
		competencias[1] = "habilidade";
		competencias[2] = "atitude";
		competencias[3] = "IA";
		
		System.out.println();
		System.out.println(competencias[0]);
		System.out.println(competencias[1]);
		System.out.println(competencias[2]);
		System.out.println(competencias[3]);
		
		//Outra forma de criar um vetor:
		Object[] competencias2 = {"conhecimento", "habilidade", "atitude0", "IA"};
		System.out.println(competencias2[0]);
		System.out.println(competencias2[1]);
		System.out.println(competencias2[2]);
		System.out.println(competencias2[3]);
		
		//chamando meu 1º JFrame
		new CursoGUI().setVisible(true);
		
	}

}
