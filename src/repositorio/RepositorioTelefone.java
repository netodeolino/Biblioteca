package repositorio;

import bidi.Telefone;
import java.util.List;

public interface RepositorioTelefone {
    public boolean cadastrarTelefone(Telefone t);
    public boolean removerTelefone(Telefone t);
    public Telefone buscarTelefone(String cpf_pessoa);
    public boolean atualizarTelefone(Telefone t);
    public List<Telefone> buscarTodosTelefones();
}
