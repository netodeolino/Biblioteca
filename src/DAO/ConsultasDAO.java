package DAO;

import bidi.Conexao;
import consultas.Consul1;
import consultas.Consul2;
import consultas.Consul3;
import consultas.Consul4;
import consultas.Consul5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import repositorio.RepositorioConsultas;

public class ConsultasDAO implements RepositorioConsultas {
    private Connection connection;
    
    public ConsultasDAO() {
            this.connection = new Conexao().getConnection();
	}
    
    public List<Consul1> Consulta1(){
        List<Consul1> autors = new ArrayList<Consul1>();
            String sql = "select a.nome, l.titulo from autor a inner join livros_autores la on "
                    + "a.id_autor = la.id_autor inner join livros l on la.isbn = l.isbn";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Consul1 pac = new Consul1();
                        pac.setAutor(rs.getString(1));
                        pac.setTitulo(rs.getString(2));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
        return autors;
    }
    
    public List<Consul2> Consulta2(){
        List<Consul2> autors = new ArrayList<Consul2>();
            String sql = "select e.nome, count(l.isbn) as qtd_estoque from livros l, editoras e where " +
                "l.id_editora = e.id_editora group by l.id_editora, e.nome";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Consul2 pac = new Consul2();
                        pac.setEditora(rs.getString(1));
                        pac.setQuantidade(rs.getInt(2));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
        return autors;
    }
    
    public List<Consul3> Consulta3(){
        List<Consul3> autors = new ArrayList<Consul3>();
            String sql = "select a.nome from autor a where a.id_autor not in (select id_autor from livros_autores)";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Consul3 pac = new Consul3();
                        pac.setNome(rs.getString(1));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
        return autors;
    }
    
    public List<Consul4> Consulta4(){
        List<Consul4> autors = new ArrayList<Consul4>();
            String sql = "select e.nome from editoras e, livros l where e.id_editora = l.id_editora group by e.nome having count(l.id_editora) > 1";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Consul4 pac = new Consul4();
                        pac.setEditora(rs.getString(1));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
        return autors;
    }
    
    public List<Consul5> Consulta5(){
        List<Consul5> autors = new ArrayList<Consul5>();
            String sql = "select l.titulo, a.nome as nome_autor, e.nome as nome_editora from livros_autores "
                    + "la full outer join livros l on l.isbn = la.isbn full outer join autor a on "
                    + "la.id_autor = a.id_autor full outer join editoras e on l.id_editora = e.id_editora";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Consul5 pac = new Consul5();
                        pac.setTitulo(rs.getString(1));
                        pac.setAutor(rs.getString(2));
                        pac.setEditora(rs.getString(3));
                        
                        autors.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum autor encontrado!");
                return null;
                }
        return autors;
    }
}
