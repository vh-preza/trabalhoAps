package projeto.servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.StringJoiner;

@WebService
public class ValidadorCPFServiceImpl extends AbstractValidatorService {


    @WebMethod
    public String validarCPF(String cpf) {
        return processarConsulta(cpf);
    }

    @Override
    protected boolean validarFormato(String input) {
        return input != null && input.matches("^[0-9]{11}$");
    }

    @Override
    protected String getTipoDado() {
        return "CPF";
    }

    @Override
    protected JSONObject consultarDados(String input) throws IOException {

        return ConsultaDados.getInstance().consultarCPF(input);
    }

    @Override
    protected String formatarSucesso(JSONObject dados) {
        String nome = dados.getString("nome");
        String apolicesFormatadas = formatarApolices(dados.getJSONArray("apolices"));
        return "CPF encontrado\nNome: " + nome + "\nApolices: " + apolicesFormatadas;
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