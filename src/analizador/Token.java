/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import static analizador.tokens.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis_
 */
public class Token extends JDialog {
    public Token(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Ver tokens");
    }

    public Token(java.awt.Frame parent, boolean modal, String dirNuevo, Ventana gui) {
        super(parent, modal);
        initComponents();
        this.setTitle("Ver tokens");
        this.setLocationRelativeTo(null);
        try {
            //gui.Guardar();
            Process p = Runtime.getRuntime().exec("../Proyecto1.exe " + dirNuevo);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            String el[]=line.split("-");
            while(line!=null && el.length<2) {
                int id=Integer.parseInt(line);
                Object ob[]=new Object[2];
                ob[0]=yytname[id];
                ob[1]=yytoknum[id];
                ((DefaultTableModel)tokens.getModel()).addRow(ob);
                line = reader.readLine();
                el=line.split("-");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tokens.setModel(new javax.swing.table.DefaultTableModel(
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
                   
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tokens;
}
