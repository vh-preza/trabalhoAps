package projeto.servidor;

import javax.jws.WebService;

@WebService
public class ValidadorPlacaServiceImpl {
    public boolean validarPlaca(String placa) {
        return placa != null && placa.toUpperCase().matches("^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$");
    }
}