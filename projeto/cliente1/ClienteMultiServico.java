package projeto.cliente1;


import java.util.Scanner;

import projeto.cliente1.ws.cpf.ValidadorCPFServiceImpl;
import projeto.cliente1.ws.cpf.ValidadorCPFServiceImplService;
import projeto.cliente1.ws.placa.ValidadorPlacaServiceImpl;
import projeto.cliente1.ws.placa.ValidadorPlacaServiceImplService;

public class ClienteMultiServico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CPF
        System.out.print("Digite um CPF (somente numeros): ");
        String cpf = sc.nextLine();

        ValidadorCPFServiceImplService cpfService = new ValidadorCPFServiceImplService();
        ValidadorCPFServiceImpl cpfPorta = cpfService.getValidadorCPFServiceImplPort();
        boolean cpfValido = cpfPorta.validarCPF(cpf);
        System.out.println(" CPF valido? " + cpfValido);

        // Placa
        System.out.print("Digite uma placa de carro (ex: ABC1D23): ");
        String placa = sc.nextLine();

        ValidadorPlacaServiceImplService placaService = new ValidadorPlacaServiceImplService();
        ValidadorPlacaServiceImpl placaPorta = placaService.getValidadorPlacaServiceImplPort();
        boolean placaValida = placaPorta.validarPlaca(placa);
        System.out.println(" Placa valida? " + placaValida);

        sc.close();
    }
}
