import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private ConexaoBD con;

    public void inserir(Aluno a){
        try{
            if(con.conectar()!=null){
                System.out.println("Conectado ao Banco. Inserindo...");
                MongoDatabase bd = con.getBanco();
                MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
                Document doc = new Document();
                doc.append("id", a.getId());
                doc.append("nome", a.getNome());
                doc.append("cpf", a.getCpf());
                doc.append("data_matricula", a.getData_matricula());
                doc.append("turma", a.getTurma());
                doc.append("disciplinas", a.getDisciplinas());
                doc.append("endereco", a.getEndereco());
                colecaoAluno.insertOne(doc);
                System.out.println("Aluno inserido com sucesso.");
            }else
                System.out.println("Não foi possível conectar ao Banco de Dados.");
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public void mostrarTudo(){
        try{
            con.conectar();
            MongoDatabase bd = con.getBanco();
            MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");

            MongoCursor cursor = colecaoAluno.find().cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public void alterar(Aluno a){
        MongoDatabase bd = con.getBanco();
        MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
        Document doc = new Document();
        doc.append("id", a.getId());
        doc.append("nome", a.getNome());
        doc.append("cpf", a.getCpf());
        doc.append("data_matricula", a.getData_matricula());
        doc.append("turma", a.getTurma());
        doc.append("disciplinas", a.getDisciplinas());
        doc.append("endereco", a.getEndereco());
        bd.getCollection("alunos");
    }

    public void deletar(int id){
        MongoDatabase bd = con.getBanco();
        MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
        Document consulta = new Document();
        consulta.put("id", id);
        DeleteResult resultado = colecaoAluno.deleteMany(consulta);
        System.out.println("Número de documentos deletados: " + resultado.getDeletedCount());
    }
}
