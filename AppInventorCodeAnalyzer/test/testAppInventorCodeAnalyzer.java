/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import appinventorgrader.codigo.Codigo;
import appinventorgrader.conceitos.ControleFluxo;
import appinventorgrader.conceitos.Logica;
import appinventorgrader.conceitos.RepresentacaoDados;
import appinventorgrader.conceitos.Paralelismo;
import appinventorgrader.io.Descompactador;
import appinventorgrader.parse.XMLParse;

/**
 *
 * @author Matheus Demetrio
 */
public class testAppInventorCodeAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando a análise do seu código do App Inventor!");
        
        String projetoAIA = "projetos-recebidos\\teste.aia";
        String destinoBKY = "projetos-extraidos\\projeto";
        
        XMLParse parser = new XMLParse();
        Codigo codigo = new Codigo();
        
        //para cada tela do App é gerado um arquivo xml, cada arquivo é carregado enviado para a instancia de codigo:
        for(String caminho : Descompactador.unZip(projetoAIA, destinoBKY)){
            codigo.addCodigo(parser.carregarXML(caminho));
        }
        
        codigo.separarBlocosPorTipos();
        
        //Analisando Paralelismo
        Paralelismo paralelismo = new Paralelismo(codigo);
        paralelismo.avaliaCodigo();
        System.out.println("\nSua nota em paralelismo foi: " + paralelismo.getNota() + "\n" + paralelismo.getFeedback());
        
        //Analisando Lógica
        Logica logica = new Logica(codigo);
        logica.avaliaCodigo();
        System.out.println("\nSua nota em lógica foi: " + logica.getNota() + "\n" + logica.getFeedback());
        
        //Analisando Controle de Fluxo
        ControleFluxo contrFlux = new ControleFluxo(codigo);
        contrFlux.avaliaCodigo();
        System.out.println("\nSua nota em controle de fluxo foi: " + contrFlux.getNota() + "\n" + contrFlux.getFeedback());
        
        //Analisando Manipulação de Dados
        RepresentacaoDados dados = new RepresentacaoDados(codigo);
        dados.avaliaCodigo();
        System.out.println("\nSua nota em manipulação de dados foi: " + dados.getNota() + "\n" + dados.getFeedback());
        
        double notaFinal = (double)(paralelismo.getNota()+logica.getNota()+contrFlux.getNota()+dados.getNota())/4;
        System.out.println("\nSua nota final foi: " + notaFinal);
    }
    
}
