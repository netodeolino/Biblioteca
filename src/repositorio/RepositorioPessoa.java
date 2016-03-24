package repositorio;

import java.util.List;
import bidi.Pessoa;

/**
 * @author neto
 */
public interface RepositorioPessoa {
    public boolean cadastrarPessoa(Pessoa p);
    public boolean removerPessoa(Pessoa p);
    public Pessoa buscarPessoa(String cpf);
    public boolean atualizarPessoa(Pessoa p);
    public List<Pessoa> buscarTodosPessoas();
}