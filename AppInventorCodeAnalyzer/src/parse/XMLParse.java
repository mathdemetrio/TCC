/**
 * Código baseado em: https://www.java-tips.org/java-se-tips-100019/46-org-w3c-dom/437-reading-a-dom-tree-from-xml-document.html
 */
package parse;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Matheus Demetrio <matheus.fdemetrio@gmail.com>
 */
public class XMLParse {

    public void carregarXML() {
        try {
            // first of all we request out 
            // DOM-implementation:
            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            // then we have to create document-loader:
            DocumentBuilder loader = factory.newDocumentBuilder();

            // loading a DOM-tree...
            Document document = loader.parse("sample.xml");
            // at last, we get a root element:
            Element tree = document.getDocumentElement();

            // ... do something with document element ...
        } catch (IOException ex) {
            // any IO errors occur:
            handleError(ex);
        } catch (SAXException ex) {
            // parse errors occur:
            handleError(ex);
        } catch (ParserConfigurationException ex) {
            // document-loader cannot be created which,
            // satisfies the configuration requested
            handleError(ex);
        } catch (FactoryConfigurationError ex) {
            // DOM-implementation is not available 
            // or cannot be instantiated:
            handleError(ex);
        }
    }

    public void handleError(Throwable ex) {

    }
}
