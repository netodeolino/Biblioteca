package bidi;
/**
 * @author neto
 */
public class Livros {
    private String ISBN;
    private int quant_estoque;
    private String titulo;
    private int ano_publicacao;
    private int id_editora;

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the quant_estoque
     */
    public int getQuant_estoque() {
        return quant_estoque;
    }

    /**
     * @param quant_estoque the quant_estoque to set
     */
    public void setQuant_estoque(int quant_estoque) {
        this.quant_estoque = quant_estoque;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the ano_publicacao
     */
    public int getAno_publicacao() {
        return ano_publicacao;
    }

    /**
     * @param ano_publicacao the ano_publicacao to set
     */
    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    /**
     * @return the id_editora
     */
    public int getId_editora() {
        return id_editora;
    }

    /**
     * @param id_editora the id_editora to set
     */
    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }
}
