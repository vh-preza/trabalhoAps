package projeto.servidor;

import org.json.JSONObject;


public abstract class AbstractValidatorService {


    public final String processarConsulta(String input) {

        if (!validarFormato(input)) {
            return "Formato invalido de " + getTipoDado();
        }

        try {

            JSONObject dados = consultarDados(input);

            if (dados != null) {

                return formatarSucesso(dados);
            } else {
                return getTipoDado() + " nao encontrado";
            }
        } catch (Exception e) {
            return "Erro ao consultar " + getTipoDado() + ": " + e.getMessage();
        }
    }




    protected abstract boolean validarFormato(String input);

    protected abstract String getTipoDado();


    protected abstract JSONObject consultarDados(String input) throws Exception;


    protected abstract String formatarSucesso(JSONObject dados);
}
