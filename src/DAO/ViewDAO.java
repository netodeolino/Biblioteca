/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bidi.Conexao;
import bidi.Livros;
import bidi.View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import repositorio.RepositorioView;

/**
 *
 * @author neto
 */
public class ViewDAO implements RepositorioView {
    private Connection connection;
    
    public ViewDAO() {
            this.connection = new Conexao().getConnection();
	}
    
    public List<View> buscarTodosView(){
        List<View> vivi = new ArrayList<View>();
            String sql = "select titulo,nome,quantidade from minhaview";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        View viso = new View();
                        viso.setTitulo(rs.getString(1));
                        viso.setNome(rs.getString(2));
                        viso.setQuantidade(rs.getInt(3));
                        
                        vivi.add(viso);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhuma view encontrada!");
                return null;
                }
            return vivi;
        }
}
