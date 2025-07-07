package projeto.servidor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class ConsultaDados {

    // Caminhos dos arquivos JSON
    private static final String CAMINHO_CPFS = "projeto/data/cpfs.json";
    private static final String CAMINHO_PLACAS = "projeto/data/placas.json";

    // Carrega um arquivo JSON e retorna como JSONObject
    public static JSONObject carregarJSON(String caminho) throws IOException {
        String conteudo = new String(Files.readAllBytes(Paths.get(caminho)));
        return new JSONObject(conteudo);
    }

    // Consulta por CPF (retorna objeto ou null)
    public static JSONObject consultarCPF(String cpf) throws IOException {
        JSONObject base = carregarJSON(CAMINHO_CPFS);
        return base.optJSONObject(cpf);
    }

    // Consulta por Placa (retorna objeto ou null)
    public static JSONObject consultarPlaca(String placa) throws IOException {
        JSONObject base = carregarJSON(CAMINHO_PLACAS);
        return base.optJSONObject(placa);
    }
}