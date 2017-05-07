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
public class Paralelismo extends ConceitoCT {

    final String F_ZERO = "Você deve inserir eventos que executam em pararelo no seu código, como objetos animados, temporizadores, espera por toque na tela!"; 
    final String F_CINCO = "Muito bem, você entá no caminho certo. Você deve inserir mais eventos que executam em pararelo no seu código!"; 
    final String F_DEZ = "Parabéns, você atingiu a nota máxima no conceito paralelismo!"; 

    int qtdEventos;

    public Paralelismo(Codigo codigo) {
        super(codigo);
    }

    @Override
    public void avaliaCodigo() {
        
        qtdEventos = codigo.getEventosNodes().size();
        
        if (qtdEventos == 0) {
            nota = 0;
            feedback = F_ZERO;
        } else if (qtdEventos == 1) {
            nota = 5;
            feedback = F_CINCO;
        } else if (qtdEventos > 1) {
            nota = 10;
            feedback = F_DEZ;
        }
    }

}