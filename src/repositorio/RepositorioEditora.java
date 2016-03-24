package repositorio;

import bidi.Editora;
import java.util.List;

public interface RepositorioEditora {
    public boolean cadastrarEditora(Editora ed);
    public boolean removerEditora(Editora ed);
    public Editora buscarEditora(int id_editora);
    public boolean atualizarEditora(Editora ed);
    public List<Editora> buscarTodasEditoras();
    public Editora buscarEditoraLike(String editora);
}
