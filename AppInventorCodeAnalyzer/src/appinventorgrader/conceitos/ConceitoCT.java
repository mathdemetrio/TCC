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
public abstract class ConceitoCT {

    protected int nota;
    protected String feedback;
    protected Codigo codigo;

    public ConceitoCT(Codigo codigo) {
        this.codigo = codigo;
    }
   
    public int getNota(){
        return nota;
    }
    
    public String getFeedback(){
        return feedback;
    }
    
    public abstract void avaliaCodigo();
    
}
