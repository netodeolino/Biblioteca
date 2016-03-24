package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.Livros;
import repositorio.RepositorioLivro;

/**
 * @author neto
 */
public class LivroDAO implements RepositorioLivro {
    private Connection connection;
    
    public LivroDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarLivro(Livros l) {
        String sql = "insert into livros(isbn,quant_estoque,titulo,ano_publicacao,id_editora) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getISBN());
                        stmt.setInt(2, l.getQuant_estoque());
                        stmt.setString(3, l.getTitulo());
                        stmt.setInt(4, l.getAno_publicacao());
                        stmt.setInt(5, l.getId_editora());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Livro não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Livro cadastrado!");
        return true;
    }
    
    public boolean removerLivro(Livros l){
        String sql = "delete from livros where isbn=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getISBN());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Livro não removido!"+ e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Livro removido!");
        return true;
    }
    
    public Livros buscarLivro(String isbn){
        Livros liv = null;
		String sql = "select isbn,quant_estoque,titulo,ano_publicacao,id_editora from livros where isbn=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				liv = new Livros();
				liv.setISBN(rs.getString(1));
				liv.setQuant_estoque(rs.getInt(2));
                                liv.setTitulo(rs.getString(3));
                                liv.setAno_publicacao(rs.getInt(4));
                                liv.setId_editora(rs.getInt(5));
                                
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Livro não encontrado!");
			return null;
		}
        return liv;
    }
    public boolean atualizarLivro(Livros l) {
		String sql = "update livros set isbn=?,quant_estoque=?,titulo=?,ano_publicacao=?,id_editora=? where isbn=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getISBN());
                        stmt.setInt(2, l.getQuant_estoque());
                        stmt.setString(3, l.getTitulo());
                        stmt.setInt(4, l.getAno_publicacao());
                        stmt.setInt(5, l.getId_editora());
                        stmt.setString(6, l.getISBN());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Livro nao Atualizado!" + e.getMessage());
			return false;
		}
		System.out.println("Livro Atualizado!");
		return true;
	}
    
    public List<Livros> buscarTodosLivros(){
        List<Livros> pacis = new ArrayList<Livros>();
            String sql = "select isbn,quant_estoque,titulo,ano_publicacao,id_editora from livros";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Livros pac = new Livros();
                        pac.setISBN(rs.getString(1));
                        pac.setQuant_estoque(rs.getInt(2));
                        pac.setTitulo(rs.getString(3));
                        pac.setAno_publicacao(rs.getInt(4));
                        pac.setId_editora(rs.getInt(5));
                        
                        pacis.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum livro encontrado!");
                return null;
                }
            return pacis;
        }
}