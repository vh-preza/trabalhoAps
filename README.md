# Plataforma Integrada de Serviços para Seguradoras

## Descrição do Sistema

O mercado de seguros requer integração das informações de vários sistemas, como seguradoras, corretores, clientes e órgãos públicos. Uma comunicação fragmentada entre esses sistemas gera problemas e dificuldades, necessitando de processos manuais, indo contra a automação e reduzindo a confiabilidade dos serviços.

Nesse contexto, apresentamos como solução a criação de uma **plataforma integrada de serviços para seguradoras**. A plataforma é baseada na **arquitetura orientada a serviços**, a fim de permitir que diferentes sistemas utilizem os serviços de forma padronizada, aumentando a integração, a segurança e a escalabilidade.

### Preocupações

- **Atendimento às funcionalidades**: É necessário garantir que a plataforma forneça os serviços solicitados e que estes sejam independentes, o que é endereçado pelo ponto de vista funcional, responsável pela descrição das partes funcionais do sistema.

- **Interoperabilidade**: É necessário garantir a interoperabilidade com diferentes sistemas clientes para que todos consigam acessar o serviço. Endereçado pelos pontos de vista funcionais e de implantação, que são responsáveis, respectivamente, pela descrição das funcionalidades do sistema e pelo ambiente no qual o sistema será implantado.

- **Desempenho**: É necessário que múltiplos usuários consigam utilizar o sistema simultaneamente e com boa performance, o que é endereçado principalmente pelos pontos de vista de concorrência, que descreve a estrutura de concorrência do sistema; e do ponto de vista de implantação.

---

## Diagramas

### Diagrama de Casos de Uso
![image](https://github.com/user-attachments/assets/a8e71672-97f3-4c81-bdda-9f0ab1e21dcb)


---

### Diagramas de Atividades

- **Diagrama de atividades para o caso de uso “Consultar perfil do cliente”**
  
  ![image](https://github.com/user-attachments/assets/736908e7-639f-4b8e-8727-6a6fd5609257)



- **Diagrama de atividades para o caso de uso “Consultar veículo”**
 ![image](https://github.com/user-attachments/assets/10cfa725-7ef3-4ddc-abf6-13e9c5e66cba)
 


---

### Diagrama de Implantação
  ![image](https://github.com/user-attachments/assets/b2f25450-39df-447d-bff4-7a343640aedb)



---

#### Execução do sistema

  comando: javac -cp ".;lib/*" -d bin projeto/servidor/*.java

  -Transformar os arquivos de código-fonte (.java) em bytecode que a Máquina Virtual do Java entende (.class)

  Após isso, rodar o comando : java -cp ".;lib/*;bin" projeto.servidor.ServidorSOAP

  -Inicia a Máquina Virtual do Java (JVM) e executa seu programa principal, que inicia o servidor.

  Com isso, é só abrir o servidor http://localhost:8080/ em um navegador.

  Utilizamos o JavaSE 8, e a ferramenta para compilar e rodar é o JDK 1.8.

  Além disto, para ler arquivos json foi utilizado a biblioteca json-20250517.jar.

  IMPORTANTE: JAX-WS (javax.xml.ws.*): A API de serviços web SOAP foi incluída por padrão no JDK 8. (Nota: a partir do JDK 11, ela foi removida e precisa ser adicionada como uma dependência externa).

