import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {

    private MongoClient con;
    public CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    public void inserir(Aluno a){
        try{
            con = new MongoClient("localhost", 27017);
            System.out.println("Conectado ao Banco. Inserindo...");
            MongoDatabase bd = con.getDatabase("trabalho").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
            Document doc = new Document();
            doc.append("_id", a.getId());
            doc.append("nome", a.getNome());
            doc.append("cpf", a.getCpf());
            doc.append("data_matricula", a.getData_matricula());
            doc.append("turma", a.getTurma());
            doc.append("disciplinas", a.getDisciplinas());
            Document end = new Document();
            end.append("rua", a.getEndereco().getRua());
            end.append("bairro", a.getEndereco().getBairro());
            end.append("numero", a.getEndereco().getNumero());
            end.append("cidade", a.getEndereco().getCidade());
            doc.append("endereco", end);
            colecaoAluno.insertOne(doc);
            System.out.println("Aluno inserido com sucesso.");
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public void mostrarTudo(){
        try{
            MongoClient test = new MongoClient("localhost", 27017);
            MongoDatabase bd = test.getDatabase("trabalho");
            MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");

            MongoCursor cursor = colecaoAluno.find().cursor();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public void alterar(Aluno a, Aluno n){
        try{
            con = new MongoClient("localhost", 27017);
            System.out.println("Conectado ao Banco. Inserindo...");
            MongoDatabase bd = con.getDatabase("trabalho").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
            Document doc = new Document();
            doc.append("_id", a.getId());
            doc.append("nome", a.getNome());
            doc.append("cpf", a.getCpf());
            doc.append("data_matricula", a.getData_matricula());
            doc.append("turma", a.getTurma());
            doc.append("disciplinas", a.getDisciplinas());
            Document end = new Document();
            end.append("rua", a.getEndereco().getRua());
            end.append("bairro", a.getEndereco().getBairro());
            end.append("numero", a.getEndereco().getNumero());
            end.append("cidade", a.getEndereco().getCidade());
            doc.append("endereco", end);
            Document doc2 = new Document();
            doc2.append("_id", n.getId());
            doc2.append("nome", n.getNome());
            doc2.append("cpf", n.getCpf());
            doc2.append("data_matricula", n.getData_matricula());
            doc2.append("turma", n.getTurma());
            doc2.append("disciplinas", n.getDisciplinas());
            Document end2 = new Document();
            end2.append("rua", n.getEndereco().getRua());
            end2.append("bairro", n.getEndereco().getBairro());
            end2.append("numero", n.getEndereco().getNumero());
            end2.append("cidade", n.getEndereco().getCidade());
            doc2.append("endereco", end2);
            colecaoAluno.updateOne(doc, doc2);
            System.out.println("Aluno atualizado com sucesso.");
        }catch(MongoException e){
            e.printStackTrace();
        }
    }

    public void deletar(int id){
        try{
            MongoDatabase bd = con.getDatabase("trabalho");
            MongoCollection<Document> colecaoAluno = bd.getCollection("alunos");
            Document consulta = new Document();
            consulta.append("_id", id);
            DeleteResult resultado = colecaoAluno.deleteMany(consulta);
            System.out.println("N??mero de documentos deletados: " + resultado.getDeletedCount());
        }catch(MongoException e){
            e.printStackTrace();
        }

    }
}
