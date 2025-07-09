package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONObject;

@WebService
public class ValidadorPlacaServiceImpl {

    public String validarPlaca(String placa) {

        if (!placa.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$")) {
            return "Formato invalido de placa";
        }

        try {
            JSONObject dados = ConsultaDados.consultarPlaca(placa);
            if (dados != null) {
                return "Placa encontrada\nMultas: " + dados.getJSONArray("historico_multas") +
                       "\nIPVA: " + dados.getBoolean("ipva_pago") +
                       "\nRestricoes: " + dados.getJSONArray("restricoes") +
                       "\nRoubos: " + dados.getBoolean("roubo");
            } else {
                return "Placa nao encontrada";
            }
        } catch (Exception e) {
            return "Erro ao consultar placa: " + e.getMessage();
        }
    }
}