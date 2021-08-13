import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import java.util.List;

public class ConexaoBD{

    private MongoClient mongoClient = null;

    public MongoClient conectar(){

        try{
            this.mongoClient = new MongoClient("localhost", 27017);
            return mongoClient;
        }catch(MongoException e){
            e.printStackTrace();
            return null;
        }finally{
            if(this.mongoClient!=null)
                this.mongoClient.close();
                return null;
        }
    }

    public DB getBanco(){
        return mongoClient.getDB("trabalho");
    }

    public static void main(String args[]){
        ConexaoBD bd = new ConexaoBD();
        bd.conectar();
    }
}
