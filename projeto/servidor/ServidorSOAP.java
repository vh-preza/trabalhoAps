package projeto.servidor;

import javax.xml.ws.Endpoint;

public class ServidorSOAP {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/validarCPF", new ValidadorCPFServiceImpl());
        Endpoint.publish("http://localhost:8080/validarPlaca", new ValidadorPlacaServiceImpl());

        System.out.println("🟢 Serviços publicados:");
        System.out.println(" - http://localhost:8080/validarCPF?wsdl");
        System.out.println(" - http://localhost:8080/validarPlaca?wsdl");
    }
}