package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.Professor;
import repositorio.RepositorioProfessor;


/**
 * @author neto
 */
public class ProfessorDAO implements RepositorioProfessor {
    private Connection connection;
    
    public ProfessorDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarProfessor(Professor p) {
        String sql = "insert into professor(cpf_pessoa,registro) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCpf());
                        stmt.setInt(2, p.getRegistro());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Professor não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Professor cadastrado!");
        return true;
    }
    
    public boolean removerProfessor(Professor p){
        String sql = "delete from professor where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCpf());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Professor não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Professor removido!");
        return true;
    }
    
    public Professor buscarProfessor(String cpf){
        Professor profe = null;
		String sql = "select cpf_pessoa,registro from professor where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				profe = new Professor();
				profe.setCpf(rs.getString(1));
                                profe.setRegistro(rs.getInt(2));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Professor não encontrado!");
			return null;
		}
        return profe;
    }
    public boolean atualizarProfessor(Professor p) {
		String sql = "update professor set cpf_pessoa=?,registro=? where registro=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCpf());
			stmt.setInt(2, p.getRegistro());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Professor nao Atualizado!");
			return false;
		}
		System.out.println("Professor Atualizado!");
		return true;
	}
    
    public List<Professor> buscarTodosProfessores(){
        List<Professor> pacis = new ArrayList<Professor>();
            String sql = "select cpf_pessoa,registro from professor";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Professor pac = new Professor();
                        pac.setCpf(rs.getString(1));
                        pac.setRegistro(rs.getInt(2));
                        
                        pacis.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum professor encontrado!");
                return null;
                }
            return pacis;
        }
}