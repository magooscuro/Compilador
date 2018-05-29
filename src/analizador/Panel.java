package analizador;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis_
 */
public class Panel extends JPanel {
    JTextArea txtarea_1 = new JTextArea();
    JTextArea txtarea_2 = new JTextArea();
    JTable tabla_1 = new JTable();
    JScrollPane scroll = new JScrollPane();
    
    public Panel() {
        iniciar();
    }
    
    private void iniciar(){
        setLayout(null);
        setBounds(10, 80, 1000, 500);
        
        txtarea_1.setBounds(10, 0, 40, 500);
        txtarea_1.setEnabled(false);
        txtarea_2.setBounds(55, 0, 500, 500);
        tabla_1.setBounds(600, 0, 500, 500);
        
        tabla_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        tabla_1.setFont(new Font("Verdana", 0, 11));
        tabla_1.setModel(new DefaultTableModel(
            new String [][] {
                {"20", null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "hola", "mundo", "soy", "deadpool", "null"
            }
        ));
        //tabla_1.setEnabled(false);
        scroll.setViewportView(tabla_1);

        
        add(txtarea_1);
        add(txtarea_2);
        add(tabla_1);
        add(scroll);
        //scroll.setBounds(300, 160, 430, 320);
    }
}