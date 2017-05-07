/**
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */
package appinventorgrader.conceitos;

import appinventorgrader.codigo.Codigo;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Matheus Demetrio <matheus.fdemetrio@gmail.com>
 */
public class Logica extends ConceitoCT {

    final String F_ZERO = "Você deve inserir eventos que executam em pararelo no seu código, como objetos animados, temporizadores, espera por toque na tela!";
    final String F_CINCO = "Muito bem, você entá no caminho certo. Você deve inserir mais eventos que executam em pararelo no seu código!";
    final String F_DEZ = "Parabéns, você atingiu a nota máxima no conceito paralelismo!";

    public Logica(Codigo codigo) {
        super(codigo);
    }

    @Override
    public void avaliaCodigo() {
        int qtdOpLogicas = codigo.getLogicaNodes().size();
        int qtdIfs = codigo.getIfNodes().size();
        int qtdIfElses = codigo.getElseIfNodes().size();
        
        if (qtdOpLogicas > 0 && qtdIfs == 0) {
            nota = 4;
            feedback = "Você está no caminho certo, utilize mais operadores lógicos e blocos condicionais!";
        } else if (qtdIfs > 0 && qtdIfElses == 0) {
            nota = 7;
            feedback = "Você está no caminho certo, porém utilizou os blocos condicionais de forma simples, elabore mais o seu código de condicionais.";
        } else if (qtdIfElses > 0 && qtdOpLogicas > 0) {
            nota = 10;
            feedback = "Parabéns, você atingiu a pontuação máxima! Você já é proficiente em operações lógicas e condicionais!";
        } else {
            nota = 0;
            feedback = "Melhore seu desempenho neste conceito utilizando mais operações lógicas e condicionais na sua aplicação!";
        }

    }


    
}
    

