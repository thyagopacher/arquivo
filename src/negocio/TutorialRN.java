/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Tutorial;
import java.util.List;
import persistencia.TutorialPers;

/**
 *
 * @author Thyago Pacher
 */
public class TutorialRN {
    
    public String inserir(Tutorial t){
         return new TutorialPers().inserir(t);
    }
    
    public String update(Tutorial t){
         return new TutorialPers().update(t);
    } 
    
    public String excluir(Tutorial t){
         return new TutorialPers().excluir(t);
    } 
    
    public Tutorial procura(int codigo){
         return new TutorialPers().procura(codigo);
    }   
    
    public List<Tutorial> procura(String nome){
         return new TutorialPers().procura(nome);
    }    
}
