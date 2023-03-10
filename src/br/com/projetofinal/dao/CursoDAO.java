package br.com.projetofinal.dao;

import br.com.projetofinal.dao.*;
import br.com.projetofinal.pojo.*;

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
			Connection conexao = ConexaoRemota.conectar();
			String sql = "INSERT INTO curso(nome_curso,carga_horaria) VALUES(?,?)";
			comando = conexao.prepareStatement(sql);
			comando.setString(1,curso.getNome());
			comando.setInt(2,curso.getCargaHoraria());	
			comando.executeUpdate();//executar tudo que a gente fez.
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			System.out.println("mensagem ou funcionalidade padrão!");
			ConexaoRemota.conectar().close();	
			comando.close();
			
		}	
	
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void alterar(Curso curso) {
		// TODO Auto-generated method stub
		PreparedStatement comando = null;
		try {
			Connection conexao = ConexaoRemota.conectar();
			String sql = "UPDATE curso SET nome_curso=?,carga_horaria=? WHERE idcurso=?";
			comando = conexao.prepareStatement(sql);
			comando.setString(1,curso.getNome());
			comando.setInt(2,curso.getCargaHoraria());
			comando.setInt(3,curso.getId());
			comando.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			System.out.println("mensagem ou funcionalidade padrão!");			
		}			
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub	
		PreparedStatement comando = null;
		try {
			Connection conexao = ConexaoRemota.conectar();
			String sql = "DELETE FROM curso WHERE idcurso = ?";	
			comando = conexao.prepareStatement(sql);
			comando.setInt(1,id);
			comando.execute();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			System.out.println("mensagem ou funcionalidade padrão!");			
		}			
	}
}