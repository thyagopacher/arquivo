/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Categoria;
import java.util.List;
import persistencia.CategoriaPers;

/**
 *
 * @author Thyago Pacher
 */
public class CategoriaRN {
    
    public String inserir(Categoria c){
         return new CategoriaPers().inserir(c);
    }
    
    public String update(Categoria c){
         return new CategoriaPers().update(c);
    } 
    
    public String excluir(Categoria c){
         return new CategoriaPers().excluir(c);
    } 
    
    public Categoria procura(int codigo){
         return new CategoriaPers().procura(codigo);
    }   
    
    public List<Categoria> procura(String nome){
         return new CategoriaPers().procura(nome);
    }    
}
