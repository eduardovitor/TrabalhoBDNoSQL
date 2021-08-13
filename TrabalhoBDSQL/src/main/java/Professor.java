import java.util.List;

public class Professor {

    private int id;
    private double cpf;
    private String nome;
    private Endereco endereco;
    private String turma;
    private List<String> disciplinas;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getCpf() {
        return this.cpf;
    }

    public void setCpf(double cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTurma() {
        return this.turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<String> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
