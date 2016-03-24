package bidi;

import java.util.Date;

/**
 * @author neto
 */
public class Emprestimo {
    private String cpf_pessoa;
    private String ISBN;
    private Date data_emprestimo;
    private Date data_devolucao;
    private float valor_multa;

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
     * @return the data_emprestimo
     */
    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    /**
     * @param data_emprestimo the data_emprestimo to set
     */
    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    /**
     * @return the data_devolucao
     */
    public Date getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    /**
     * @return the valor_multa
     */
    public float getValor_multa() {
        return valor_multa;
    }

    /**
     * @param valor_multa the valor_multa to set
     */
    public void setValor_multa(float valor_multa) {
        this.valor_multa = valor_multa;
    }

    /**
     * @return the cpf_pessoa
     */
    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    /**
     * @param cpf_pessoa the cpf_pessoa to set
     */
    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }
}
