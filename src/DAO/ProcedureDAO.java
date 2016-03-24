package DAO;

import bidi.Aluno;
import bidi.Conexao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProcedureDAO {
    private Connection connection;
    
    public ProcedureDAO() {
            this.connection = new Conexao().getConnection();
	}
    
    public void chamar(String cpf) {
        //String retorno;
        try {
            Statement st = connection.createStatement();
            PreparedStatement stm = connection.prepareStatement("select numero(?);");
            stm.setString(1, cpf);
            //stm.getString("numero");
            ResultSet rs = stm.executeQuery();
		if(rs.next()){
                    JOptionPane.showMessageDialog(null, rs.getString("numero"));
                }
            
        } catch (SQLException e) {
            System.out.println("ERRO" + e.getMessage());
        }
    }
}
