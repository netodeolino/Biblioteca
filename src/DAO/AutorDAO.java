package DAO;

import bidi.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import repositorio.RepositorioAutor;


/**
 * @author neto
 */
public class AutorDAO implements RepositorioAutor {
    private Connection connection;
    
    public AutorDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarAutor(Autor a) {
        String sql = "insert into autor(id_autor,nome) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());
                        stmt.setString(2, a.getNome());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Autor não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Autor cadastrado!");
        return true;
    }
    
    public boolean removerAutor(Autor a){
        String sql = "delete from autor where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Autor não removido!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Autor removido!");
        return true;
    }
    
    public Autor buscarAutor(int id_autor){
        Autor aut = null;
		String sql = "select id_autor,nome from autor where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id_autor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new Autor();
				aut.setId_autor(rs.getInt(1));
                                aut.setNome(rs.getString(2));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Autor não encontrado!");
			return null;
		}
        return aut;
    }
    public boolean atualizarAutor(Autor a) {
		String sql = "update autor set id_autor=?,nome=? where id_autor=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, a.getId_autor());
			stmt.setString(2, a.getNome());
                        stmt.setInt(3, a.getId_autor());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Autor nao Atualizado!" + e.getMessage());
			return false;
		}
		System.out.println("Autor Atualizado!");
		return true;
	}
    
    public List<Autor> buscarTodosAutores(){
        List<Autor> autors = new ArrayList<Autor>();
            String sql = "select id_autor,nome from autor";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Autor pac = new Autor();
                        pac.setId_autor(rs.getInt(1));
                        pac.setNome(rs.getString(2));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
            return autors;
        }
    
    public Autor buscarAutorLike(String autor){
        Autor aut = null;
		String sql = "select id_autor,nome from autor where nome ilike ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, autor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new Autor();
				aut.setId_autor(rs.getInt(1));
                                aut.setNome(rs.getString(2));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Autor não encontrado!");
			return null;
		}
        return aut;
    }
}