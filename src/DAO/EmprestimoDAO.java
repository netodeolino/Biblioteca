package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.Emprestimo;
import repositorio.RepositorioEmprestimo;


/**
 * @author neto
 */
public class EmprestimoDAO implements RepositorioEmprestimo {
    private Connection connection;
    
    public EmprestimoDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarEmprestimo(Emprestimo a) {
        String sql = "insert into emprestimo(cpf_pessoa,isbn,data_empres,data_devolucao,valor_multa) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf_pessoa());
                        stmt.setString(2, a.getISBN());
                        stmt.setDate(3, new java.sql.Date(a.getData_emprestimo().getTime()));
                        stmt.setDate(4, new java.sql.Date(a.getData_devolucao().getTime()));
                        stmt.setFloat(5, a.getValor_multa());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Emprestimo não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Emprestimo cadastrado!");
        return true;
    }
    
    public boolean removerEmprestimo(Emprestimo a){
        String sql = "delete from emprestimo where cpf_pessoa=? and isbn=? and data_empres=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf_pessoa());
                        stmt.setString(2, a.getISBN());
                        stmt.setDate(3, new java.sql.Date(a.getData_emprestimo().getTime()));

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Emprestimo não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Emprestimo removido!");
        return true;
    }
    
    public Emprestimo buscarEmprestimo(String cpf_pessoa, String isbn, java.util.Date data_empres){
        Emprestimo aut = null;
		String sql = "select cpf_pessoa,isbn,data_empres,data_devolucao,valor_multa from emprestimo where cpf_pessoa=? and isbn=? and data_empres=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cpf_pessoa);
                        stmt.setString(2, isbn);
                        stmt.setDate(3, new java.sql.Date(data_empres.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new Emprestimo();
				aut.setCpf_pessoa(rs.getString(1));
				aut.setISBN(rs.getString(2));
                                aut.setData_emprestimo(rs.getDate(3));
                                aut.setData_devolucao(rs.getDate(4));
                                aut.setValor_multa(rs.getFloat(5));
                                
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Emprestimo não encontrado!");
			return null;
		}
        return aut;
    }
    public boolean atualizarEmprestimo(Emprestimo a) {
		String sql = "update emprestimo set data_devolucao=? where cpf_pessoa=? and isbn=? and data_empres=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
                        stmt.setDate(1, new java.sql.Date(a.getData_devolucao().getTime()));
                        //stmt.setFloat(5, a.getValor_multa());
                        stmt.setString(2, a.getCpf_pessoa());
                        stmt.setString(3, a.getISBN());
                        stmt.setDate(4, new java.sql.Date(a.getData_emprestimo().getTime()));

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Emprestimo nao Atualizado!" + e.getMessage());
			return false;
		}
		System.out.println("Emprestimo Atualizado!");
		return true;
	}
    
    public List<Emprestimo> buscarTodosEmprestimos(){
        List<Emprestimo> autors = new ArrayList<Emprestimo>();
            String sql = "select cpf_pessoa,isbn,data_empres,data_devolucao,valor_multa from emprestimo";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Emprestimo pac = new Emprestimo();
                        pac.setCpf_pessoa(rs.getString(1));
			pac.setISBN(rs.getString(2));
                        pac.setData_emprestimo(rs.getDate(3));
                        pac.setData_devolucao(rs.getDate(4));
                        pac.setValor_multa(rs.getFloat(5));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum Emprestimo encontrado!");
                return null;
                }
            return autors;
        }

}