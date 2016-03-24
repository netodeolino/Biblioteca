package repositorio;

import bidi.Emprestimo;
import java.util.Date;
import java.util.List;

public interface RepositorioEmprestimo {
    public boolean cadastrarEmprestimo(Emprestimo e);
    public boolean removerEmprestimo(Emprestimo e);
    public Emprestimo buscarEmprestimo(String cpf_pessoa, String isbn, Date data_empres);
    public boolean atualizarEmprestimo(Emprestimo e);
    public List<Emprestimo> buscarTodosEmprestimos();
}
