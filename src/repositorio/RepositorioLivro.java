package repositorio;

import bidi.Livros;
import java.util.List;

public interface RepositorioLivro {
    public boolean cadastrarLivro(Livros l);
    public boolean removerLivro(Livros l);
    public Livros buscarLivro(String isbn);
    public boolean atualizarLivro(Livros l);
    public List<Livros> buscarTodosLivros();
}
