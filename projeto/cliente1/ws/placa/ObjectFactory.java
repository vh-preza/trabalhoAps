
package projeto.cliente1.ws.placa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the projeto.cliente1.ws.placa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidarPlaca_QNAME = new QName("http://servidor.projeto/", "validarPlaca");
    private final static QName _ValidarPlacaResponse_QNAME = new QName("http://servidor.projeto/", "validarPlacaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: projeto.cliente1.ws.placa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidarPlacaResponse }
     * 
     */
    public ValidarPlacaResponse createValidarPlacaResponse() {
        return new ValidarPlacaResponse();
    }

    /**
     * Create an instance of {@link ValidarPlaca }
     * 
     */
    public ValidarPlaca createValidarPlaca() {
        return new ValidarPlaca();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarPlaca }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor.projeto/", name = "validarPlaca")
    public JAXBElement<ValidarPlaca> createValidarPlaca(ValidarPlaca value) {
        return new JAXBElement<ValidarPlaca>(_ValidarPlaca_QNAME, ValidarPlaca.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarPlacaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor.projeto/", name = "validarPlacaResponse")
    public JAXBElement<ValidarPlacaResponse> createValidarPlacaResponse(ValidarPlacaResponse value) {
        return new JAXBElement<ValidarPlacaResponse>(_ValidarPlacaResponse_QNAME, ValidarPlacaResponse.class, null, value);
    }

}
