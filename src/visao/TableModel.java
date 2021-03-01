/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author Thyago
 */
import javax.swing.table.AbstractTableModel;
 
public class TableModel extends AbstractTableModel {
        private Object[]   tituloColunas;
        private Object[][] data;
        private int        linhas;
        private int        colunas;
       
        /**
         * Construtor que recebe o n�mero de linhas e colunas e um vetor com o nome das colunas
         * @param tituloColunas vetor com o t�tulo das colunas
         * @param numLinhas n�mero de linhas da table
         * @param numColunas n�mero de colunas da table
         */
        public TableModel(Object[] tituloColunas, int numLinhas, int numColunas){
                this.tituloColunas = tituloColunas;
                this.data          = new Object[numLinhas][numColunas];
                linhas             = numLinhas;
                colunas            = numColunas;
        }
        /**
         * @param col ind�ce da coluna a ser retornado o t�tulo da coluna
         * @return Retorna o nome da coluna no index col
         */
    @Override
        public String getColumnName(int col){
                return tituloColunas[col].toString();
        }
       
        /**
         * @return retorna o n�mero de colunas da table
         */
        @Override
        public int getColumnCount() {
                return colunas;
        }
 
        /**
         * @return retorna o n�mero de linhas da table
         */
        @Override
        public int getRowCount() {
                return linhas;
        }
 
        /**
         * @return retorna o objeto na que est� na posi��o linha x coluna passados como par�metro
         */
        @Override
        public Object getValueAt(int linha, int coluna) {
                return data[linha][coluna];
        }
       
        /**
         * seta o valor o da linha x coluna com o objeto passado
         */
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
            data[linha][coluna]=valor.toString();
            fireTableCellUpdated(linha, coluna);
    }

    /* Remove a linha especificada. */
    public void removeLinha(int indiceLinha) {
            // Remove o sócio da linha especificada.    
        for(int j = 0; j < getColumnCount(); j++){
            data[indiceLinha][j] = "";
        }

            // Reporta a mudança. O JTable recebe a notificação
            // e se redesenha permitindo que visualizemos a atualização.
            fireTableRowsDeleted(indiceLinha, indiceLinha);
    }    
  
    /**tabela fica não-editável**/
    @Override
    public boolean isCellEditable(int row, int column) {  
        return false;  
    }  

}