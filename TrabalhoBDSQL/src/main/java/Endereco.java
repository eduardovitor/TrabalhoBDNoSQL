public class Endereco {

    private String rua;
    private String bairro;
    private String numero;
    private String cidade;

    public Endereco (String rua, String bairro, String numero, String cidade){
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
