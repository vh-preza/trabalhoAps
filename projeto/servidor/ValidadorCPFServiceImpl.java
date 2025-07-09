package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONObject;

@WebService
public class ValidadorCPFServiceImpl {

    public String validarCPF(String cpf) {
        if (!cpf.matches("^[0-9]{11}$")) {
            return " Formato invalido de CPF";
        }

        try {
            JSONObject dados = ConsultaDados.consultarCPF(cpf);
            if (dados != null) {
                return " CPF encontrado\nNome: " + dados.getString("nome") +
                       "\nApolices: " + dados.getJSONArray("apolices");
            } else {
                return " CPF nao encontrado";
            }
        } catch (Exception e) {
            return " Erro ao consultar CPF: " + e.getMessage();
        }
    }
}