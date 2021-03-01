/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Categoria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Thyago Pacher
 */
public class CategoriaPers {
    
    Conexao cx  = new Conexao();
    String  msg = "";
    
    public String inserir(Categoria c){
        try{
            cx.conectar();
            cx.s.save(c);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao inserir causado por:\n" + ex;
        }
       return msg;
    }
    
    public String update(Categoria c){
        try{
            cx.conectar();
            cx.s.update(c);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update causado por:\n" + ex;
        }
       return msg;        
    }
    
    public String excluir(Categoria c){
        try{
            cx.conectar();
            cx.s.delete(c);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao excluir causado por:\n" + ex;
        }
       return msg;        
    }    
   
    public Categoria procura(int codigo){
        cx.conectar();
        String    query = "from Categoria where codigo = " + codigo;
        Categoria c     = new Categoria();          
        Iterator  it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Categoria)it.next();
        }
        cx.desconectar();
        return c;          
    }
    
    public List<Categoria> procura(String nome){
        String            query = "from Categoria where nome like '%" + nome + "%'";
        return cx.s.createQuery(query).list();      
    }
}
