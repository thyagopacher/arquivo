/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Tutorial;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Thyago Pacher
 */
public class TutorialPers {
    
    Conexao cx  = new Conexao();
    String  msg = "";
    
    public String inserir(Tutorial t){
        try{
            cx.conectar();
            cx.s.save(t);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao inserir causado por:\n" + ex;
        }
       return msg;
    }
    
    public String update(Tutorial t){
        try{
            cx.conectar();
            cx.s.update(t);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update causado por:\n" + ex;
        }
       return msg;        
    }
    
    public String excluir(Tutorial t){
        try{
            cx.conectar();
            cx.s.delete(t);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao excluir causado por:\n" + ex;
        }
       return msg;        
    }    
   
    public Tutorial procura(int codigo){
        cx.conectar();
        String    query = "from Tutorial where codigo = " + codigo;
        Tutorial c     = new Tutorial();          
        Iterator  it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (Tutorial)it.next();
        }
        cx.desconectar();
        return c;          
    }
    
    public List<Tutorial> procura(String nome){
        String            query = "from Tutorial where titulo like '%" + nome + "%'";
        return cx.s.createQuery(query).list();       
    }
}
