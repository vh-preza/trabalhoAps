package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.StringJoiner; 
@WebService
public class ValidadorPlacaServiceImpl {

    public String validarPlaca(String placa) {

        if (!placa.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$")) {
            return "Formato invalido de placa";
        }

        try {
            JSONObject dados = ConsultaDados.consultarPlaca(placa);
            if (dados != null) {

                String multasFormatadas = formatarArray(dados.getJSONArray("historico_multas"));
                String ipvaFormatado = formatarBoolean(dados.getBoolean("ipva_pago"), "Pago", "Nao Pago");
                String restricoesFormatadas = formatarArray(dados.getJSONArray("restricoes"));
                String rouboFormatado = formatarBoolean(dados.getBoolean("roubo"), "Sim", "Nao");

                return "Placa encontrada" +
                       "\nMultas: " + multasFormatadas +
                       "\nIPVA: " + ipvaFormatado +
                       "\nRestricoes: " + restricoesFormatadas +
                       "\nRoubos: " + rouboFormatado;
            } else {
                return "Placa nao encontrada";
            }
        } catch (Exception e) {
            return "Erro ao consultar placa: " + e.getMessage();
        }
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