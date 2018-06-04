/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.Frame;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis_
 */
public final class Token extends JDialog {
    JTable tabla_1 = new JTable();
    Ventana v = new Ventana();
    private JScrollPane jScrollPane1;
    private JTable tokens;
    Metodos m = new Metodos();
    String[][] datostabla = new String[200][5];
    
    public Token(Frame parent, boolean modal, Nodo inicio,int tamaño) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ver tokens");
        try {
            datos(inicio,tamaño);
            llenarTabla();
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
                "Id Token", "Palabra","Tipo","Valor","Pertenecen a"
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
    
    public void datos(Nodo inicio, int tam){
        int tamaño = tam;
        System.err.println("tamaño : "+tamaño);
        for (int i = 0; i < tamaño; i++) {
            datostabla[i][0] = inicio.nombre_palabra;
            datostabla[i][1] = ""+inicio.idtoken;
            datostabla[i][2] = inicio.valor;
            datostabla[i][3] = inicio.tipo;
            datostabla[i][4] = inicio.pertenece_a;
            inicio=inicio.Siguiente;
        }
    }
    
    private void llenarTabla(){
        //System.out.println("0: "+datostabla[0][0]+" 1: "+datostabla[0][1]);
        tokens.setModel(new javax.swing.table.DefaultTableModel(
            datostabla,
            new String [] {
                "Palabra","Id Token","Valor","Tipo","Pertenece a"
            }
        ));
        jScrollPane1.setViewportView(tokens);
    }
}
