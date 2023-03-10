package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoRemota {
	private static final String URL = "jdbc:mysql://root:806srWxdBHIVfcW8qLUz@containers-us-west-115.railway.app:7336/railway";

	
	
	public static Connection conectar() {
		
Connection conn = null;
        
        try { //tente conectar.
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexão realizada com sucesso!");//
            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }        
        return conn;
    }
	
}