package repositorio;

import java.util.List;
import bidi.Aluno;

/**
 * @author neto
 */
public interface RepositorioAluno {
    public boolean cadastrarAluno(Aluno a);
    public boolean removerAluno(Aluno a);
    public Aluno buscarAluno(String cpf);
    public boolean atualizarAluno(Aluno a);
    public List<Aluno> buscarTodosAlunos();
}
