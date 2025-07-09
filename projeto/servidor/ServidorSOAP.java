package projeto.servidor;

import javax.xml.ws.Endpoint;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServidorSOAP {
    public static void main(String[] args) throws IOException {
        String urlBase = "http://localhost:8080";
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        Endpoint.create(new ValidadorCPFServiceImpl()).publish(server.createContext("/validarCPF"));
        Endpoint.create(new ValidadorPlacaServiceImpl()).publish(server.createContext("/validarPlaca"));

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                String caminhoDoHtml = "WebContent/pages/index.html";
                Path path = Paths.get(caminhoDoHtml);
                byte[] response;
                
                if (Files.exists(path)) {
                    response = Files.readAllBytes(path);
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
                    exchange.sendResponseHeaders(200, response.length);
                } else {

                    String erroMsg = "<h1>Erro 404: Arquivo nao encontrado</h1>"
                                   + "<p>O servidor nao conseguiu encontrar o arquivo no caminho: " 
                                   + path.toAbsolutePath() + "</p>"
                                   + "<p>Verifique se voce executou o comando 'java' de dentro da pasta 'TRABAPS'.</p>";
                    response = erroMsg.getBytes();
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
                    exchange.sendResponseHeaders(404, response.length);
                }
                
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            }
        });

        server.setExecutor(null);
        server.start();
        System.out.println(" Servicos publicados:");
        System.out.println(" - http://localhost:8080/validarCPF?wsdl");
        System.out.println(" - http://localhost:8080/validarPlaca?wsdl");
        System.out.println("--- Servidor Iniciado ---");
        System.out.println("ACESSE: http://localhost:8080/");
        System.out.println("-------------------------");
    }
}