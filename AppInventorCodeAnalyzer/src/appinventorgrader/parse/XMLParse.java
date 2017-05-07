/**
 * Código baseado em: https://www.java-tips.org/java-se-tips-100019/46-org-w3c-dom/437-reading-a-dom-tree-from-xml-document.html
 */
package appinventorgrader.parse;

import appinventorgrader.codigo.Codigo;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Matheus Demetrio <matheus.fdemetrio@gmail.com>
 */
public class XMLParse {

    Codigo estatisticas;

    public XMLParse() {
    }
   
    public Document carregarXML(String filePath) {
        Document documento = null;
        try {

            // Instanciamos uma nova implementação DOM:
            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            
            // temos que criar o document-loader:
            DocumentBuilder loader = factory.newDocumentBuilder();

            // Carregando árvore DOM:
            System.out.println("--------- " + filePath + " ---------" );
            documento = loader.parse(filePath);
            
            // Pegamos o elemento root do xml:
            Node nodoInicial = documento.getFirstChild();
            System.out.println("--------- " + nodoInicial.getNodeName() + " ---------" );

            //geramos as estatísticas do código carregado:
            //geraEstatisticas(nodoInicial);
            
            
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
        
        return documento;

    }    
    
    

    public void handleError(Throwable ex) {
        System.out.println("\n\n+++++ Problema ao montar árvore DOM! +++++\n" + ex);
    }
}
