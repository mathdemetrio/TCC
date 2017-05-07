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
public class RepresentacaoDados extends ConceitoCT{

    public RepresentacaoDados(Codigo codigo) {
        super(codigo);
    }

    @Override
    public void avaliaCodigo() {
        nota = 0;
        feedback = "Estranhamente sua aplicação usa pouquissimos dados (variáveis), experimente utilizar mais informações, crie varáveis úteis, listas, ou qualquer estrutura de dados.";
        
        int varGlob = codigo.getVariaveisGlobaisNodes().size();
        int varLoc = codigo.getVariaveisLocaisNodes().size();
        int bd = codigo.getBancoDeDadosNodes().size();
        int arq = codigo.getManipulacaoArquivoNodes().size();
        int list = codigo.getListaNodes().size();
        
        if(varGlob + varLoc  > 0 && bd == 0 && arq == 0 && list == 0){
            nota = 4;
            feedback = "Você guarda os seus dados em vaviáveis locais e globais, experimente guarda-las em listas, arquivos ou bancos de dados.";
        }else if (bd == 0 && arq == 0 && list > 0){
            nota = 7;
            feedback = "Muito bem! Você guarda alguns dos seus dados em listas, isso é muito inteligente, se predisar salvar seus dados para execuções futuras da sua aplicações, experimente usar bancos de dados ou salvar arquivos.";
        }else if (bd == 0 && arq > 0){
            nota = 9;
            feedback = "Parabéns, sua aplicação tem persistencia de dados, quer dizer que você não perde informações quando fecha o aplicativo. se desejar, para uma melhor performance, utilize um dos bancos de dados disponíveis no App Inventor.";
        }else if (bd > 0){
            nota = 10;
            feedback = "Exelente! Você utiliza a forma mais eficiente de guardar dados, num banco de dados!";
        }
    }

}
