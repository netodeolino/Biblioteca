package repositorio;

import bidi.Autor;
import java.util.List;

public interface RepositorioAutor {
    public boolean cadastrarAutor(Autor a);
    public boolean removerAutor(Autor a);
    public Autor buscarAutor(int id_autor);
    public boolean atualizarAutor(Autor a);
    public List<Autor> buscarTodosAutores();
    public Autor buscarAutorLike(String autor);
}
