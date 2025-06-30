
package projeto.cliente1.ws.cpf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the projeto.cliente1.ws.cpf package. 
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

    private final static QName _ValidarCPF_QNAME = new QName("http://servidor.projeto/", "validarCPF");
    private final static QName _ValidarCPFResponse_QNAME = new QName("http://servidor.projeto/", "validarCPFResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: projeto.cliente1.ws.cpf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidarCPFResponse }
     * 
     */
    public ValidarCPFResponse createValidarCPFResponse() {
        return new ValidarCPFResponse();
    }

    /**
     * Create an instance of {@link ValidarCPF }
     * 
     */
    public ValidarCPF createValidarCPF() {
        return new ValidarCPF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarCPF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor.projeto/", name = "validarCPF")
    public JAXBElement<ValidarCPF> createValidarCPF(ValidarCPF value) {
        return new JAXBElement<ValidarCPF>(_ValidarCPF_QNAME, ValidarCPF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarCPFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor.projeto/", name = "validarCPFResponse")
    public JAXBElement<ValidarCPFResponse> createValidarCPFResponse(ValidarCPFResponse value) {
        return new JAXBElement<ValidarCPFResponse>(_ValidarCPFResponse_QNAME, ValidarCPFResponse.class, null, value);
    }

}
