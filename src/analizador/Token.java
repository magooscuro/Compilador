/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis_
 */
public class Token extends JDialog {
    JTable tabla_1 = new JTable();
    private JScrollPane jScrollPane1;
    private JTable tokens;
    DefaultTableModel dtm;

    public Token(Frame parent, boolean modal,int[] idtoken) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ver tokens");
        try {
            //int id=Integer.parseInt(line);
            Object ob[]=new Object[2];
            ob[0]=idtoken;
            //ob[1]=yytoknum[id];
            //tokens.addRowSelectionInterval(1, 1);

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tokens.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Token", "Token"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tokens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    
    
    /*tabla_1.setBounds(600, 0, 500, 500);
        
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
        scroll.setViewportView(tabla_1);*/
}
