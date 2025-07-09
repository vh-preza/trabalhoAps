package projeto.servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.StringJoiner;

@WebService
public class ValidadorPlacaServiceImpl extends AbstractValidatorService {

    @WebMethod
    public String validarPlaca(String placa) {
        return processarConsulta(placa);
    }

    @Override
    protected boolean validarFormato(String input) {

        return input != null && input.matches("^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$");
    }

    @Override
    protected String getTipoDado() {
        return "Placa";
    }

    @Override
    protected JSONObject consultarDados(String input) throws IOException {
        return ConsultaDados.getInstance().consultarPlaca(input);
    }

    @Override
    protected String formatarSucesso(JSONObject dados) {
        String multas = formatarArray(dados.getJSONArray("historico_multas"));
        String ipva = formatarBoolean(dados.getBoolean("ipva_pago"), "Pago", "Nao Pago");
        String restricoes = formatarArray(dados.getJSONArray("restricoes"));
        String roubo = formatarBoolean(dados.getBoolean("roubo"), "Sim", "Nao");

        return "Placa encontrada\nMultas: " + multas + "\nIPVA: " + ipva + "\nRestricoes: " + restricoes + "\nRoubos: " + roubo;
    }


    private String formatarArray(JSONArray array) {
        if (array == null || array.length() == 0) {
            return "Nenhuma";
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < array.length(); i++) {
            joiner.add(array.getString(i));
        }
        return joiner.toString();
    }

    private String formatarBoolean(boolean valor, String seVerdadeiro, String seFalso) {
        return valor ? seVerdadeiro : seFalso;
    }
}