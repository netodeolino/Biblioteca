package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.LivrosAutor;
import repositorio.RepositorioLivrosAutor;


/**
 * @author neto
 */
public class LivrosAutorDAO implements RepositorioLivrosAutor {
    private Connection connection;
    
    public LivrosAutorDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarLivrosAutor(LivrosAutor a) {
        String sql = "insert into livros_autores(id_autor,isbn) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());
                        stmt.setString(2, a.getISBN());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "LivrosAutor não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "LivrosAutor cadastrado!");
        return true;
    }
    
    public boolean removerLivrosAutor(LivrosAutor a){
        String sql = "delete from livros_autores where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "LivrosAutor não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "LivrosAutor removido!");
        return true;
    }
    
    public LivrosAutor buscarLivrosAutor(int id_autor){
        LivrosAutor aut = null;
		String sql = "select id_autor,isbn from livros_autores where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id_autor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new LivrosAutor();
				aut.setId_autor(rs.getInt(1));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "LivrosAutor não encontrado!");
			return null;
		}
        return aut;
    }
    public boolean atualizarLivrosAutor(LivrosAutor a) {
		String sql = "update livros_autores set id_autor=?,isbn=? where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());
			stmt.setString(2, a.getISBN());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("LivrosAutor nao Atualizado!");
			return false;
		}
		System.out.println("LivrosAutor Atualizado!");
		return true;
	}
    
    public List<LivrosAutor> buscarTodosLivrosAutores(){
        List<LivrosAutor> autors = new ArrayList<LivrosAutor>();
            String sql = "select id_autor,isbn from autor";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        LivrosAutor pac = new LivrosAutor();
                        pac.setId_autor(rs.getInt(1));
                        pac.setISBN(rs.getString(2));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum LivrosAutor encontrado!");
                return null;
                }
            return autors;
        }
}