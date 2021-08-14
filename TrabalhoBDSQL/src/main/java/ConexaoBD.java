import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

import java.util.List;

public class ConexaoBD{

    private MongoClient mongoClient;

    public MongoClient conectar(){

        try{
            this.mongoClient = new MongoClient("localhost", 27017);
            return mongoClient;
        }catch(MongoException e){
            e.printStackTrace();
            return null;
        }
    }

    public MongoDatabase getBanco(){
        return mongoClient.getDatabase("trabalho");
    }

    public static void main(String args[]){
        Aluno teste = new Aluno();
        teste.setId(42);
        teste.setCpf(42.42);
        teste.setNome("Arthur");
        teste.setData_matricula("04/02/2042");
        teste.setTurma("Guide");
        teste.setEndereco(new Endereco(
                42, "GoldHeart", "The End of The Universe", "42", "Galaxy")
        );
        teste.setDisciplinas(null);

        AlunoDAO aux = new AlunoDAO();
        aux.inserir(teste);
        aux.mostrarTudo();
    }
}
