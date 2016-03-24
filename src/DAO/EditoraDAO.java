package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import bidi.Editora;
import repositorio.RepositorioEditora;


/**
 * @author neto
 */
public class EditoraDAO implements RepositorioEditora {
    private Connection connection;
    
    public EditoraDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarEditora(Editora ed) {
        String sql = "insert into editoras(id_editora,nome) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ed.getId_editora());
                        stmt.setString(2, ed.getNome());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Editora não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Editora cadastrado!");
        return true;
    }
    
    public boolean removerEditora(Editora ed){
        String sql = "delete from editoras where id_editora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ed.getId_editora());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Editora não removido!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Editora removido!");
        return true;
    }
    
    public Editora buscarEditora(int id_editora){
        Editora aut = null;
		String sql = "select id_editora,nome from editoras where id_editora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id_editora);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new Editora();
				aut.setId_editora(rs.getInt(1));
                                aut.setNome(rs.getString(2));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Editora não encontrado!" + e.getMessage());
			return null;
		}
        return aut;
    }
    public boolean atualizarEditora(Editora ed) {
		String sql = "update editoras set id_editora=?,nome=? where id_editora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ed.getId_editora());
			stmt.setString(2, ed.getNome());
                        stmt.setInt(3, ed.getId_editora());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Editora nao Atualizado!");
			return false;
		}
		System.out.println("Editora Atualizado!");
		return true;
	}
    
    public List<Editora> buscarTodasEditoras(){
        List<Editora> edit = new ArrayList<Editora>();
            String sql = "select id_editora,nome from editoras";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Editora pac = new Editora();
                        pac.setId_editora(rs.getInt(1));
                        pac.setNome(rs.getString(2));
                        
                        edit.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum editora encontrado!");
                return null;
                }
            return edit;
        }
    public Editora buscarEditoraLike(String editora){
        Editora aut = null;
		String sql = "select id_editora,nome from editoras where nome ilike ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, editora);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aut = new Editora();
				aut.setId_editora(rs.getInt(1));
                                aut.setNome(rs.getString(2));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Editora não encontrado!");
			return null;
		}
        return aut;
    }
}