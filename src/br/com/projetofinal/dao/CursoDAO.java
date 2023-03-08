package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projetofinal.pojo.Curso;
public class CursoDAO implements ICursoDAO {
    //DTO - Data Transfer Object
	@Override
	public void cadastrar(Curso curso) throws SQLException {
		// TODO Auto-generated method stub	
		//Criar um statement mais seguro e mais elegante
		PreparedStatement comando = null;
		try {
			Connection conexao = Conexao.conectar();
			String sql = "INSERT INTO curso(nome,cargaHoraria) VALUES(?,?)";//chupa hacker(lad.galinha) otário	
			comando = conexao.prepareStatement(sql);
			comando.setString(1,curso.getNome());
			comando.setInt(2,curso.getCargaHoraria());	
			comando.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			System.out.println("mensagem ou funcionalidade padrão!");
			Conexao.conectar().close();	
			comando.close();
		}	
	
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub		
	}
}