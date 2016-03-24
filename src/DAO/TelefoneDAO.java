package DAO;

import bidi.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import repositorio.RepositorioTelefone;


/**
 * @author neto
 */
public class TelefoneDAO implements RepositorioTelefone {
    private Connection connection;
    
    public TelefoneDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarTelefone(Telefone t) {
        String sql = "insert into telefones(cpf_pessoa,fone_num) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getCpf_pessoa());
                        stmt.setString(2, t.getFone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Telefone cadastrado!");
        return true;
    }
    
    public boolean removerTelefone(Telefone t){
        String sql = "delete from telefones where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getCpf_pessoa());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Telefone removido!");
        return true;
    }
    
    public Telefone buscarTelefone(String cpf_pessoa){
        Telefone fone = null;
		String sql = "select cpf_pessoa,fone_num from telefones where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cpf_pessoa);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fone = new Telefone();
				fone.setCpf_pessoa(rs.getString(1));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone não encontrado!");
			return null;
		}
        return fone;
    }
    public boolean atualizarTelefone(Telefone t) {
		String sql = "update telefones set cpf_pessoa=?,fone_num=? where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getCpf_pessoa());
			stmt.setString(2, t.getFone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Telefone nao Atualizado!");
			return false;
		}
		System.out.println("Telefone Atualizado!");
		return true;
	}
    
    public List<Telefone> buscarTodosTelefones(){
        List<Telefone> pacis = new ArrayList<Telefone>();
            String sql = "select cpf_pessoa,fone_num from telefones";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Telefone pac = new Telefone();
                        pac.setCpf_pessoa(rs.getString(1));
                        pac.setFone(rs.getString(2));
                        
                        pacis.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum telefone encontrado!");
                return null;
                }
            return pacis;
        }
}