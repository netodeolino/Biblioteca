package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.Pessoa;
import repositorio.RepositorioPessoa;

/**
 * @author neto
 */
public class PessoaDAO implements RepositorioPessoa {
    private Connection connection;
    
    public PessoaDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarPessoa(Pessoa p) {
        String sql = "insert into pessoa(cpf,nome,rua,numero,bairro,cidade) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCpf());
                        stmt.setString(2, p.getNome());
                        stmt.setString(3, p.getRua());
                        stmt.setInt(4, p.getNumero());
                        stmt.setString(5, p.getBairro());
                        stmt.setString(6, p.getCidade());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pessoa não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Pessoa cadastrado!");
        return true;
    }
    
    public boolean removerPessoa(Pessoa p){
        String sql = "delete from pessoa where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCpf());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pessoa não removido!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Pessoa removido!");
        return true;
    }
    
    public Pessoa buscarPessoa(String cpf){
        Pessoa pessoa = null;
		String sql = "select cpf,nome,rua,numero,bairro,cidade from pessoa where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setCpf(rs.getString(1));
                                pessoa.setNome(rs.getString(2));
                                pessoa.setRua(rs.getString(3));
				pessoa.setNumero(rs.getInt(4));
                                pessoa.setBairro(rs.getString(5));
                                pessoa.setCidade(rs.getString(6));
                                
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Pessoa não encontrado!");
			return null;
		}
        return pessoa;
    }
    public boolean atualizarPessoa(Pessoa p) {
		String sql = "update pessoa set nome=?,rua=?,numero=?,bairro=?,cidade=? where nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setString(1, p.getNome());
                        stmt.setString(2, p.getRua());
                        stmt.setInt(3, p.getNumero());
                        stmt.setString(4, p.getBairro());
                        stmt.setString(5, p.getCidade());
                        stmt.setString(6, p.getNome());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Pessoa nao Atualizado!" + e.getMessage());
			return false;
		}
		System.out.println("Pessoa Atualizado!");
		return true;
	}
    
    public List<Pessoa> buscarTodosPessoas(){
        List<Pessoa> pacis = new ArrayList<Pessoa>();
            String sql = "select cpf,nome,rua,numero,bairro,cidade from pessoa";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Pessoa pac = new Pessoa();
                        pac.setCpf(rs.getString(1));
                        pac.setNome(rs.getString(2));
                        pac.setRua(rs.getString(3));
                        pac.setNumero(rs.getInt(4));
                        pac.setBairro(rs.getString(5));
                        pac.setCidade(rs.getString(6));
                        
                        pacis.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum pessoa encontrado!");
                return null;
                }
            return pacis;
        }
}