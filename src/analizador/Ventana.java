package analizador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
/**
 *
 * @author luis_
 */
public class Ventana extends JFrame{
    private Metodos metodos;
    private JLabel jLabel1,jLabel2;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem3,jMenuItem6;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1,jScrollPane2,jScrollPane3;
    private static JTextArea entrada,lineCounter,salidad;
    private JButton compilar,vertokens;
    
    public Ventana() {
        iniciarComponentes();
        //setLocationRelativeTo(null);
        this.setTitle("Compilador");
        setSize(810, 650);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
                            
    private void iniciarComponentes() {
        metodos = new Metodos();
        jLabel1 = new JLabel();
        compilar = new JButton();
        vertokens = new JButton();
        jScrollPane2 = new JScrollPane();
        salidad = new JTextArea();
        jLabel2 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jPanel1 = new JPanel();
        lineCounter = new JTextArea();
        jScrollPane1 = new JScrollPane();
        entrada = new JTextArea();
        jMenuBar1 = new JMenuBar();
        jMenu2 = new JMenu();
        jMenuItem3 = new JMenuItem();
        jMenuItem6 = new JMenuItem();

        jLabel1.setText("Compilador");
        compilar.setText("compilar");
        compilar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compilarActionPerformed(evt);
            }
        });
        vertokens.setText("ver tokens");
        vertokens.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                vertokensActionPerformed(evt);
            }
        });

        salidad.setColumns(20);
        salidad.setRows(5);
        salidad.setDisabledTextColor(new Color(0, 0, 0));
        salidad.setEnabled(false);
        jScrollPane2.setViewportView(salidad);

        jLabel2.setText("Salida:");

        lineCounter.setEditable(false);
        lineCounter.setColumns(2);
        lineCounter.setLineWrap(true);
        lineCounter.setRows(2);
        lineCounter.setTabSize(2);
        lineCounter.setText("1");
        lineCounter.setAutoscrolls(false);
        lineCounter.setCaretColor(new Color(51, 51, 255));
        lineCounter.setFocusable(false);

        entrada.setColumns(20);
        entrada.setLineWrap(true);
        entrada.setRows(5);
        entrada.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                jtxtAreaKeyPressed(evt);
            }
            public void keyReleased(KeyEvent evt) {
                jtxtAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(entrada);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lineCounter, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
            .addComponent(lineCounter)
        );

        jScrollPane3.setViewportView(jPanel1);


        jMenu2.setText("Accion");

        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
        jMenuItem3.setText("Compilar");
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Ver tokens");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(vertokens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(compilar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(compilar)
                    .addComponent(vertokens))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

        //pack();
    }                                                                                

    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        try {
            //Guardar();
//            Process p = Runtime.getRuntime().exec("../Proyecto1.exe " + dirNuevo);
//            p.waitFor();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line = reader.readLine();
//            String el[]=line.split("-");
//            while(el.length<2) {
//                line = reader.readLine();
//                el=line.split("-");
//            }
//            if(line!=null){
//                
//                if(el[0].equals("Exito")){
//                    output.setText("Compilado con exito.\nNumero de filas compiladas: "+el[1]);
//                }
//                else{
//                    output.setText("Error en la linea: "+el[1]);
//                }
//            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
        }
    }                       

    private void compilarActionPerformed(ActionEvent evt) {
        Automata a =new Automata();
        String cadenapila="";
        int[] tokens = metodos.operaciones(entrada.getText());
        int tam = tokens.length;
        for (int i = 0; i < tam; i++) {
            a.AutomataFinito(tokens[i]);
        }
        cadenapila += a.mostrarpila();
        salidad.setText(cadenapila);
    }
    private void vertokensActionPerformed(ActionEvent evt) {
        int[] tokens = metodos.operaciones(entrada.getText());
        Token ver_tabla_tokens = new Token(this, true,tokens);
        ver_tabla_tokens.setVisible(true);
        
    }
    public void contarFilas(){
        int totalfilas=entrada.getLineCount();
            lineCounter.setText("1\n");
            for(int i=2; i<=totalfilas;i++){
                lineCounter.setText(lineCounter.getText()+i+"\n");
            }
    }                                                            

    private void jtxtAreaKeyPressed(KeyEvent evt) {
        if(!this.getTitle().contains("*")){
            this.setTitle(this.getTitle()+"*");
        }
    }                                   

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
//        Token vtk=new Token(this, true, dirNuevo, this);
//        vtk.show();
    }

    private void jtxtAreaKeyReleased(java.awt.event.KeyEvent evt) {
        //codigos de teclas para contar lineas 
        if(evt.isControlDown() || evt.getKeyCode()==10 || evt.getKeyCode()==8 || evt.getKeyCode()==127){
            contarFilas();
        }
    }
}