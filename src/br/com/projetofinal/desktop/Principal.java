package br.com.projetofinal.desktop;

import br.com.projetofinal.pojo.Competencia;
import br.com.projetofinal.dao.ConexaoRemota;
import br.com.projetofinal.gui.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Competencia c1 = new Competencia();
        Competencia c2 = new Competencia();
        Competencia c3 = new Competencia();
        Competencia c4 = new Competencia();
        
        //Estágio Douglas
        //O total de objetos: 4
        //System.out.println("Total de Objetos:"+Competencia.getContador());      
       
        //vetor (matriz unidimensional)
        //conhecimento - habilidade - atitude - IA
       // Object[] competencia = {"conhecimento","habilidade","atitude","IA"};
        
        /*System.out.println(competencia[0]);
        System.out.println(competencia[1]);
        System.out.println(competencia[2]);
        System.out.println(competencia[3]);*/
        
        //chamando meu primeiro JFrame
       new CursoGUI().setVisible(true);
        //ConexaoRemota.conectar();
        
        
	}

}