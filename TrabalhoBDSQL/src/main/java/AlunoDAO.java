import com.mongodb.*;
import com.mongodb.client.MongoCollection;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private ConexaoBD con;

    public boolean inserir(Object obj){
        Aluno a = (Aluno) obj;
        try{
            if(con.conectar()!=null){
                System.out.println("Conectado ao Banco. Inserindo...");
                DB bd = con.getBanco();
                DBCollection colecaoAluno = bd.getCollection("alunos");
                BasicDBObject doc = new BasicDBObject();
                doc.put("id", a.getId());
                doc.put("nome", a.getNome());
                doc.put("cpf", a.getCpf());
                doc.put("data_matricula", a.getData_matricula());
                doc.put("turma", a.getTurma());
                doc.put("disciplinas", a.getDisciplinas());
                doc.put("endereco", a.getEndereco());
                colecaoAluno.insert(doc);
                return true;
            }else
                System.out.println("Não foi possível conectar ao Banco de Dados.");
                return false;
        }catch(MongoException e){
            e.printStackTrace();
            return false;
        }
    }

    public void mostrarTudo(){
        try{
            con.conectar();
            DB bd = con.getBanco();
            DBCollection colecaoAluno = bd.getCollection("alunos");

            DBCursor cursor = colecaoAluno.find();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }
}
