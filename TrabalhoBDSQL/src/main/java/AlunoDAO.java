import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private ConexaoBD con;

    public void inserir(Object obj){
        Aluno a = (Aluno) obj;
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
