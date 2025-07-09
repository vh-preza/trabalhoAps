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

        if (input == null || !input.matches("^[0-9]{11}$")) {
            return false;
        }
        return isCpfMatematicamenteValido(input);
    }

    private boolean isCpfMatematicamenteValido(String cpf) {

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int resto = soma % 11;
            int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;


            if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1) {
                return false;
            }


            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            resto = soma % 11;
            int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;

            if (Character.getNumericValue(cpf.charAt(10)) != digitoVerificador2) {
                return false;
            }
        } catch (Exception e) {

            return false;
        }

        return true;
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

        return "CPF valido e encontrado\nNome: " + nome + "\nApolices: " + apolicesFormatadas;
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