/**
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package appinventorgrader.conceitos;

import appinventorgrader.codigo.Codigo;

/**
 *
 * @author Matheus Demetrio <matheus.fdemetrio@gmail.com>
 */
public class ControleFluxo extends ConceitoCT{

    public ControleFluxo(Codigo codigo) {
        super(codigo);
    }

    @Override
    public void avaliaCodigo() {
        nota = 0;
        if (codigo.getQtdBlocos() > 5){
            nota = 4;
            feedback = "Você já tem uma sequência lógica de blocos, experiemente controlar a execução com blocos de controle, como laços.";
        }
        if (codigo.getWhileNodes().size() > 0 && codigo.getForNodes().isEmpty() && codigo.getForEachNodes().isEmpty() ){
            nota = 7;
            feedback = "Você já sabe criar estruturas de repetições com condicionais, experimente criar outras estruturas com incremento e intervalos de dados! :D";
        }
        if (codigo.getForNodes().size() > 0 && codigo.getForEachNodes().isEmpty()){
            nota = 9;
            feedback = "Você já sabe criar repetições em intervalos de dados, experiemnte iterar com cada elemento de uma lista! ;)";
        }
        if (codigo.getForEachNodes().size() > 0 && codigo.getForNodes().size() > 0){
            nota = 10;
            feedback = "Você já compreendeu como as estrutras de controle de fluxo e laços funcionam. Parabéns!";
        }
    }
    
    

}
