package repositorio;

import bidi.LivrosAutor;
import java.util.List;

public interface RepositorioLivrosAutor {
    public boolean cadastrarLivrosAutor(LivrosAutor a);
    public boolean removerLivrosAutor(LivrosAutor a);
    public LivrosAutor buscarLivrosAutor(int id_autor);
    public boolean atualizarLivrosAutor(LivrosAutor a);
    public List<LivrosAutor> buscarTodosLivrosAutores();
}
