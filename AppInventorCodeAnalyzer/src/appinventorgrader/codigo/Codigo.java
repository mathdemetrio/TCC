/**
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */
package appinventorgrader.codigo;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Matheus Demetrio <matheus.fdemetrio@gmail.com>
 */
public class Codigo {

    private int qtdFor, qtdIf, qtdIfElse, qtdScript, qtdSprite, qtdOpecacoesLogicas, qtdBlocos;

    private List<Node> forNodes, forEachNodes, whileNodes, ifNodes, funcoesNodes, 
            variaveisLocaisNodes, variaveisGlobaisNodes, eventosNodes, logicaNodes, elseIfNodes, manipulacaoArquivoNodes,
            bancoDeDadosNodes, listaNodes;

    private List<Document> codigosDeTelas;

    public Codigo() {
        this.funcoesNodes = new ArrayList<>();
        this.forEachNodes = new ArrayList<>();
        this.forNodes = new ArrayList<>();
        this.whileNodes = new ArrayList<>();
        this.ifNodes = new ArrayList<>();
        this.funcoesNodes = new ArrayList<>();
        this.variaveisLocaisNodes = new ArrayList<>();
        this.variaveisGlobaisNodes = new ArrayList<>();
        this.eventosNodes = new ArrayList<>();
        this.logicaNodes = new ArrayList<>();
        this.elseIfNodes = new ArrayList<>();
        this.manipulacaoArquivoNodes = new ArrayList<>();
        this.bancoDeDadosNodes = new ArrayList<>();
        this.listaNodes = new ArrayList<>();

        this.codigosDeTelas = new ArrayList<>();
    }

    public void addCodigo(Document codigo) {
        codigosDeTelas.add(codigo);
    }

    public List<Node> getBancoDeDadosNodes() {
        return bancoDeDadosNodes;
    }

    public List<Node> getListaNodes() {
        return listaNodes;
    }

    public List<Node> getForNodes() {
        return forNodes;
    }

    public List<Node> getForEachNodes() {
        return forEachNodes;
    }

    public List<Node> getWhileNodes() {
        return whileNodes;
    }

    public List<Node> getIfNodes() {
        return ifNodes;
    }

    public List<Node> getFuncoesNodes() {
        return funcoesNodes;
    }

    public List<Node> getVariaveisLocaisNodes() {
        return variaveisLocaisNodes;
    }

    public List<Node> getVariaveisGlobaisNodes() {
        return variaveisGlobaisNodes;
    }

    public List<Node> getEventosNodes() {
        return eventosNodes;

    }

    public List<Node> getLogicaNodes() {
        return logicaNodes;
    }

    public List<Node> getElseIfNodes() {
        return elseIfNodes;
    }

    public List<Node> getManipulacaoArquivoNodes() {
        return manipulacaoArquivoNodes;
    }

    public int getQtdBlocos() {
        return qtdBlocos;
    }

    public void separarBlocosPorTipos() {
        for (Document d : codigosDeTelas) {
            identificarBlocos(d.getFirstChild());
        }
    }

    private void identificarBlocos(Node elementoInicial) {
        //Laço para criar lista de elementos/blocos
        NodeList nodes = elementoInicial.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            if (node instanceof Element) {
                Element nodeAtual = (Element) node;
                String nomeTag = nodeAtual.getTagName();
                if (nomeTag.equals("block")) {
                    qtdBlocos++;
                    String nodeTipo = nodeAtual.getAttribute("type");
                    String id = nodeAtual.getAttribute("id");
                    //System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                    //System.out.println(nodeTipo);

                    //separando cada tipo de bloco em listas:
                    switch (nodeTipo) {
                        case "component_event":
                            this.eventosNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "procedures_callnoreturn":
                            //
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "procedures_defnoreturn":
                            this.funcoesNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "global_declaration":
                            this.variaveisGlobaisNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;
                            
                        case "local_declaration_statement":
                            this.variaveisLocaisNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;
                                    
                        case "local_declaration_expression":
                            this.variaveisLocaisNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;
                            
                        case "math_number":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "lexical_variable_set":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "lexical_variable_get":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "math_subtract":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "component_method":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "controls_if":
                            this.ifNodes.add(node);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "logic_compare":
                            this.logicaNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "text_compare":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "logic_false":
                            this.logicaNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "logic_true":
                            this.logicaNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "logic_boolean":
                            this.logicaNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "component_set_get":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "math_random_int":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "text_join":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "text":
                            //add nodo a lista de blocos eventos
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "controls_forRange":
                            this.forNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "controls_forEach":
                            this.forEachNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                        case "controls_while":
                            this.whileNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;
                        
                        case "lists_create_with":
                            this.listaNodes.add(nodeAtual);
                            System.out.println(nomeTag + ": " + nodeTipo + " id: " + id);
                            break;

                    }
                } else if (nomeTag.equals("mutation")) {
                    if (!(nodeAtual.getAttribute("else").equals("")) || !(nodeAtual.getAttribute("elseif").equals(""))) {
                        elseIfNodes.add(nodeAtual.getParentNode());
                        System.out.println(nomeTag + ": " + nodeAtual.getAttribute("else") + nodeAtual.getAttribute("elseif"));
                    } else if (nodeAtual.getAttribute("component_type").equalsIgnoreCase("File")) {
                        manipulacaoArquivoNodes.add(nodeAtual.getParentNode());
                    } else if (nodeAtual.getAttribute("component_type").equalsIgnoreCase("FirebaseDB")
                            || nodeAtual.getAttribute("component_type").equalsIgnoreCase("TinyWebDB")
                            || nodeAtual.getAttribute("component_type").equalsIgnoreCase("TinyDB")
                            || nodeAtual.getAttribute("component_type").equalsIgnoreCase("FusiontablesControl")) {
                        bancoDeDadosNodes.add(nodeAtual.getParentNode());
                    } 

                }

                identificarBlocos(node);
            }
        }
    }

}
