package projeto.servidor;

import javax.jws.WebService;
import org.json.JSONObject;
import java.io.IOException;

@WebService
public class ValidadorPlacaServiceImpl {

    public String validarPlaca(String placa) {
        try {
            JSONObject dados = ConsultaDados.consultarPlaca(placa);
            if (dados == null) {
                return "Placa não encontrada na base.";
            }
            // Retorna as informações formatadas do JSON
            return dados.toString(4);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao acessar a base de dados.";
        }
    }
}