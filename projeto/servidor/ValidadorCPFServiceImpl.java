package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.StringJoiner;

@WebService
public class ValidadorCPFServiceImpl {

    public String validarCPF(String cpf) {
        if (!cpf.matches("^[0-9]{11}$")) {
            return " Formato invalido de CPF";
        }

        try {
            JSONObject dados = ConsultaDados.consultarCPF(cpf);
            if (dados != null) {
                String apolicesFormatadas = formatarApolices(dados.getJSONArray("apolices"));
                
                return " CPF encontrado" +
                       "\nNome: " + dados.getString("nome") +
                       "\nApolices: " + apolicesFormatadas;
            } else {
                return " CPF nao encontrado";
            }
        } catch (Exception e) {
            return " Erro ao consultar CPF: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")";
        }
    }


    private String formatarApolices(JSONArray array) {
        if (array == null || array.length() == 0) {
            return "Nenhuma";
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < array.length(); i++) {

            JSONObject apoliceObj = array.getJSONObject(i);
            

            int ano = apoliceObj.getInt("ano");
            String seguro = apoliceObj.getString("seguro");
            

            joiner.add("Seguro " + seguro + " (" + ano + ")");
        }
        return joiner.toString();
    }
}