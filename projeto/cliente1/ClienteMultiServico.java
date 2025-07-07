package projeto.cliente1;


import java.util.Scanner;

import projeto.cliente1.ws.cpf.ValidadorCPFServiceImpl;
import projeto.cliente1.ws.cpf.ValidadorCPFServiceImplService;
import projeto.cliente1.ws.placa.ValidadorPlacaServiceImpl;
import projeto.cliente1.ws.placa.ValidadorPlacaServiceImplService;

public class ClienteMultiServico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int escolha = 1;

        while(escolha !=0){

        System.out.println("insira os valor \n 1 - info cpf \n 2 - info placa \n 0 - sair do programa");

        escolha = sc.nextInt();
        sc.nextLine(); 

            switch(escolha){
                case 1: 
                    System.out.print("Digite um CPF (somente numeros): ");
                    String cpf = sc.nextLine();

                    ValidadorCPFServiceImplService cpfService = new ValidadorCPFServiceImplService();
                    ValidadorCPFServiceImpl cpfPorta = cpfService.getValidadorCPFServiceImplPort();
                    String cpfValido = cpfPorta.validarCPF(cpf);
                    System.out.println(" CPF valido? " + cpfValido);
                    break;

                case 2:
                    System.out.print("Digite uma placa de carro (ex: ABC1D23): ");
                    String placa = sc.nextLine();

                    ValidadorPlacaServiceImplService placaService = new ValidadorPlacaServiceImplService();
                    ValidadorPlacaServiceImpl placaPorta = placaService.getValidadorPlacaServiceImplPort();
                    String placaValida = placaPorta.validarPlaca(placa);
                    System.out.println(" Placa valida? " + placaValida);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        
        }
        sc.close();
    }
}
