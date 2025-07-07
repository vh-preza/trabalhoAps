package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONObject;
import java.io.IOException;

@WebService
public class ValidadorCPFServiceImpl {

    public String validarCPF(String cpf) {
        try {
            JSONObject dados = ConsultaDados.consultarCPF(cpf);
            if (dados == null) {
                return "CPF não encontrado na base.";
            } 

            return dados.toString(4); 
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao acessar a base de dados.";
        }
    }
}