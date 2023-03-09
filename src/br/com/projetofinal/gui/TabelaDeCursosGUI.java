package br.com.projetofinal.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.projetofinal.dao.*;
/*
 * Gerado pelo Chat GPT
 * 
 * Para criar um JTable que mostre os dados do banco de dados MySQL, voc� precisar� seguir os seguintes passos:
    1-Conectar-se ao banco de dados MySQL e recuperar os dados da tabela Curso.
    2-Criar um modelo de tabela (TableModel) para armazenar os dados recuperados.
    3-Criar uma inst�ncia de JTable e associ�-la ao modelo de tabela criado.
    4- Adicionar a tabela a um JScrollPane para permitir a rolagem.
 * 
 * 
 */
//conex�o
import java.sql.Connection;
//driver
import java.sql.DriverManager;

//buscar os dados
import java.sql.ResultSet;
//exce��o
import java.sql.SQLException;
//comandos SQL (Prepar...)
import java.sql.Statement;

import javax.swing.JButton;
//Formul�rio
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Barra de Rolagem
import javax.swing.JScrollPane;
//Tabela
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//MVC - View (tabelinha) Model (Dados)
import javax.swing.table.DefaultTableModel;

import br.com.projetofinal.dao.Conexao;
import br.com.projetofinal.pojo.Curso;

//Classe criada por mim.
public class TabelaDeCursosGUI extends JFrame implements ActionListener{
	
	private JPanel painel1;
	private JPanel painel2;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCargaHoraria;
	private JTable table;
	private int id=0;
	//POG -Prog. Orien. Gabm
	private String nome;
	private int cargaHoraria;
	 
    public TabelaDeCursosGUI() throws SQLException {
    	
    	//instanciando os pain�is
    	painel1 = new JPanel();
    	painel2 = new JPanel();
    	btnExcluir = new JButton("Excluir");
    	btnAlterar= new JButton("Alterar");
    	txtId = new JTextField(10);
    	txtNome = new JTextField("Digite o nome",60);
    	txtCargaHoraria = new JTextField("Digite a carga hor�ria",40);
        txtId.setEnabled(false);
    	painel1.add(txtId);
    	painel1.add(txtNome);
    	painel1.add(txtCargaHoraria);
    	painel1.add(btnExcluir);
    	painel1.add(btnAlterar);
    	
    	
    	painel1.setLayout(new FlowLayout());
    	
    	 BorderLayout border = new BorderLayout();
         setLayout(border);
         preencherTabela();
    
       
       //chamados dos eventos
       btnExcluir.addActionListener(this);
	   add(painel1,BorderLayout.NORTH);
	   add(painel2,BorderLayout.WEST);
	   pack();
	   setVisible(true);    	
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnExcluir) {
		    new CursoDAO().excluir(id);
			JOptionPane.showMessageDialog(null,"Dados Exclu�dos com Sucesso");
			try {
				preencherTabela();
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}else if(e.getSource()==btnAlterar) {
			Curso curso = new Curso();
			curso.setNome(nome);
			curso.setCargaHoraria(cargaHoraria);
			curso.setId(id);
			new CursoDAO().alterar(curso);
	
		}
		
	}	
	
	//Refatorei o m�todo..
	public void preencherTabela() throws SQLException {
		
	    //INICIO---------------A parte do Banco de dados 
    	Statement comando = null;
		Connection conexao = Conexao.conectar();
		String sql = "SELECT * FROM curso";
		comando = conexao.createStatement();
		ResultSet rs = comando.executeQuery(sql);
		//executar tudo que a gente a gente fez.
		// Criar modelo de tabela
		
		//Montar a DefaultTableModel
		String[] colunas = {"ID", "Nome do Curso", "CH"};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		while (rs.next()) {
		    int id = rs.getInt("id");
		    String nome = rs.getString("nome");
		    int cargaHoraria = rs.getInt("cargaHoraria");
		    Object[] row = {id, nome, cargaHoraria};
		    modelo.addRow(row);
		}
       // Criar tabela
	   table = new JTable(modelo);
	   
	   // ajuste manual da largura das colunas
	   table.getColumnModel().getColumn(0).setPreferredWidth(40);
	   table.getColumnModel().getColumn(1).setPreferredWidth(350);
	   table.getColumnModel().getColumn(2).setPreferredWidth(50);
        

	   // desabilita o redimensionamento autom�tico das colunas
	   table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
	   //trabalhar o evento de selecionar...
	   

	   table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        // verifica se o evento foi gerado pela sele��o de uma linha
		        if (!event.getValueIsAdjusting()) {
		            // obt�m o �ndice da linha selecionada
		            int rowIndex = table.getSelectedRow();

		            // obt�m o valor da c�lula da coluna 0 da linha selecionada
		            Object cellValue = table.getValueAt(rowIndex,0);
		            Object cellValue1 = table.getValueAt(rowIndex,1);
		            Object cellValue2 = table.getValueAt(rowIndex,2);
                    id = Integer.parseInt(cellValue.toString());
                    nome = String.valueOf(cellValue1.toString());
                    cargaHoraria = Integer.parseInt(cellValue2.toString());
                    txtId.setText(String.valueOf(id));
                    txtNome.setText(nome);
                    txtCargaHoraria.setText(String.valueOf(cargaHoraria));
		            // exibe o valor da c�lula em um JOptionPane
		            //JOptionPane.showMessageDialog(null, "Valor selecionado: " + cellValue);
		        }
		    }
		});
	   table.revalidate();
	   table.repaint();
	   //twitch tv 
	   //1 erro
	   
	   //******************************************************************* 
	   
	   JScrollPane scrollPane = new JScrollPane(table);
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       painel2.add(scrollPane);	
		
	}

}
