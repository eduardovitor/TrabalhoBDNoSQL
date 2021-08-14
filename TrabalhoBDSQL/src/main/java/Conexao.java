import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class Conexao {

    private MongoClient banco;

    public MongoClient conectar(){
        try{
            banco = new MongoClient("localhost", 27017);
            System.out.println("oi");
            return banco;
        }catch(MongoException e){
            e.printStackTrace();
        }
        return null;
    }

    public MongoDatabase getBanco(){
        return banco.getDatabase("trabalho");
    }

}
