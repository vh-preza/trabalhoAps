package projeto.servidor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;


public class ConsultaDados {


    private static ConsultaDados instance;


    private final JSONObject baseCpfs;
    private final JSONObject basePlacas;


    private ConsultaDados() throws IOException {
        System.out.println(">>> [SINGLETON] Iniciando. Lendo arquivos JSON do disco...");
        
        String conteudoCpfs = new String(Files.readAllBytes(Paths.get("projeto/data/cpfs.json")));
        this.baseCpfs = new JSONObject(conteudoCpfs);
        
        String conteudoPlacas = new String(Files.readAllBytes(Paths.get("projeto/data/placas.json")));
        this.basePlacas = new JSONObject(conteudoPlacas);
        
        System.out.println(">>> [SINGLETON] Instancia criada. Dados em memoria.");
    }


    public static synchronized ConsultaDados getInstance() throws IOException {
        if (instance == null) {
            instance = new ConsultaDados();
        }
        return instance;
    }

    public JSONObject consultarCPF(String cpf) {
        return baseCpfs.optJSONObject(cpf);
    }

    public JSONObject consultarPlaca(String placa) {
        return basePlacas.optJSONObject(placa);
    }
}