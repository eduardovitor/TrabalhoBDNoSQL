import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConexaoBD{

    public static void main(String args[]){
        Aluno teste = new Aluno();
        teste.setId(24);
        teste.setCpf(42.42);
        teste.setNome("Arthur");
        teste.setData_matricula("04/02/2042");
        teste.setTurma("Guia");
        List<String> disciplinas = new ArrayList<>();
        disciplinas.add("Mochileiro");

        teste.setEndereco(new Endereco(
                "Coracão de Ouro", "Fim", "42", "Universo")
        );
        teste.setDisciplinas(disciplinas);
        AlunoDAO aux = new AlunoDAO();
        aux.inserir(teste);
        aux.mostrarTudo();
        aux.deletar(10);
        aux.mostrarTudo();

        Aluno t2 = teste;

        teste.setId(100);
        teste.setCpf(42.42);
        teste.setNome("Arthur");
        teste.setData_matricula("04/02/2042");
        teste.setTurma("Guia");

        teste.setEndereco(new Endereco(
                "Coracão de Ouro", "Fim", "42", "Universo")
        );
        teste.setDisciplinas(disciplinas);
        aux.alterar(t2, teste);
        aux.mostrarTudo();


        Professor test = new Professor();
        test.setId(24);
        test.setCpf(42.42);
        test.setNome("Arthur");
        test.setTurma("Guia");

        test.setEndereco(new Endereco(
                "Coracão de Ouro", "Fim", "42", "Universo")
        );
        test.setDisciplinas(disciplinas);
        ProfessorDAO aux2 = new ProfessorDAO();
        aux2.inserir(test);
        aux2.mostrarTudo();
        aux2.deletar(10);
        aux2.mostrarTudo();

        Professor test2 = test;
        test.setId(101);
        test.setCpf(42.42);
        test.setNome("Arthur");
        test.setTurma("Guia");

        test.setEndereco(new Endereco(
                "Coracão de Ouro", "Fim", "42", "Universo")
        );
        test.setDisciplinas(disciplinas);

        aux.alterar(t2, teste);
        aux2.mostrarTudo();
    }
}
