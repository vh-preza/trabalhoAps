package projeto.servidor;

import javax.jws.WebService;

@WebService
public class ValidadorCPFServiceImpl {
    public boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
