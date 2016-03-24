package repositorio;

import java.util.List;
import bidi.Professor;

/**
 * @author neto
 */
public interface RepositorioProfessor {
    public boolean cadastrarProfessor(Professor p);
    public boolean removerProfessor(Professor p);
    public Professor buscarProfessor(String cpf);
    public boolean atualizarProfessor(Professor p);
    public List<Professor> buscarTodosProfessores();
}