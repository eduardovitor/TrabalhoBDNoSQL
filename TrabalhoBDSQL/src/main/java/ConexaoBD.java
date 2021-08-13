import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import java.util.List;

public class ConexaoBD{

    public MongoClient conectar(){
        MongoClient mongoClient = null;
        try{
            mongoClient = new MongoClient("localhost", 27017);
            System.out.println("Conectado com sucesso.");
            return mongoClient;
        }catch(MongoException e){
            e.printStackTrace();
            return null;
        }finally{
            if(mongoClient!=null)
                mongoClient.close();
                return null;
        }
    }

    public static void main(String args[]){
        ConexaoBD bd = new ConexaoBD();
        bd.conectar();
    }
}
