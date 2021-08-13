import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

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
        }catch

    }

    public List<Aluno> selecionar(){
        List<Aluno> alunos;
        Aluno a;
        try{
            con.conectar();
            alunos = new ArrayList<Aluno>();
            
        }
    }
}
