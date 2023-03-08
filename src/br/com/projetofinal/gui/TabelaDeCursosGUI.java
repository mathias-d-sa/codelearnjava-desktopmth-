package br.com.projetofinal.gui;


/*
 * Gerado pelo Chat GPT
 * 
 * Para criar um JTable que mostre os dados do banco de dados MySQL, você precisará seguir os seguintes passos:
    1-Conectar-se ao banco de dados MySQL e recuperar os dados da tabela Curso.
    2-Criar um modelo de tabela (TableModel) para armazenar os dados recuperados.
    3-Criar uma instância de JTable e associá-la ao modelo de tabela criado.
    4- Adicionar a tabela a um JScrollPane para permitir a rolagem.
 * 
 * 
 */
//conexão
import java.sql.Connection;
//driver
import java.sql.DriverManager;

//buscar os dados
import java.sql.ResultSet;
//exceção
import java.sql.SQLException;
//comandos SQL (Prepar...)
import java.sql.Statement;
//Formulário
import javax.swing.JFrame;
//Barra de Rolagem
import javax.swing.JScrollPane;
//Tabela
import javax.swing.JTable;
//MVC - View (tabelinha) Model (Dados)
import javax.swing.table.DefaultTableModel;

import br.com.projetofinal.dao.Conexao;

//Classe criada por mim.
public class TabelaDeCursosGUI extends JFrame {
	
    public TabelaDeCursosGUI() throws SQLException {
    	Statement comando = null;
		Connection conexao = Conexao.conectar();
		String sql = "SELECT * FROM curso";
		comando = conexao.createStatement();
		ResultSet rs = comando.executeQuery(sql);
		//executar tudo que a gente a gente fez.
		// Criar modelo de tabela
		String[] colunas = {"ID", "Nome do Curso", "Carga Horária"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		while (rs.next()) {
		    int id = rs.getInt("id");
		    String nome = rs.getString("nome");
		    int cargaHoraria = rs.getInt("cargaHoraria");
		    Object[] row = {id, nome, cargaHoraria};
		    modelo.addRow(row);
		}
       // Criar tabela
	   JTable table = new JTable(modelo);
	   JScrollPane scrollPane = new JScrollPane(table);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   add(scrollPane);
	   pack();
	   setVisible(true);
    	
    }
		
		


	

}