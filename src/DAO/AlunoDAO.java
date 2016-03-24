package DAO;

import bidi.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bidi.Conexao;
import repositorio.RepositorioAluno;


/**
 * @author neto
 */
public class AlunoDAO implements RepositorioAluno {
    private Connection connection;
    
    public AlunoDAO() {
            this.connection = new Conexao().getConnection();
	}

    public boolean cadastrarAluno(Aluno a) {
        String sql = "insert into aluno(cpf_pessoa,matricula) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf());
                        stmt.setInt(2, a.getMatricula());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Aluno não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
        return true;
    }
    
    public boolean removerAluno(Aluno a){
        String sql = "delete from aluno where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Aluno não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Aluno removido!");
        return true;
    }
    
    public Aluno buscarAluno(String cpf){
        Aluno aluno = null;
		String sql = "select cpf_pessoa,matricula from aluno where cpf_pessoa=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aluno = new Aluno();
                                aluno.setCpf(rs.getString(1));
				aluno.setMatricula(rs.getInt(2));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
			return null;
		}
        return aluno;
    }
    public boolean atualizarAluno(Aluno a) {
		String sql = "update aluno set cpf_pessoa=?,matricula=? where matricula=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getCpf());
			stmt.setInt(2, a.getMatricula());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Aluno nao Atualizado!");
			return false;
		}
		System.out.println("Paciente Atualizado!");
		return true;
	}
    
    public List<Aluno> buscarTodosAlunos(){
        List<Aluno> pacis = new ArrayList<Aluno>();
            String sql = "select cpf_pessoa,matricula from aluno";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                    //stmt.setString(1, nome);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()){
                        Aluno pac = new Aluno();
                        pac.setCpf(rs.getString(1));
                        pac.setMatricula(rs.getInt(2));
                        
                        pacis.add(pac);
                    }
                    stmt.close();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado!");
                return null;
                }
            return pacis;
        }
}