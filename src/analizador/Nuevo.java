package analizador;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luis_
 */
public class Nuevo extends JDialog {
    private JButton jButton1, jButton2;
    private JLabel jLabel1, jLabel2;
    private JTextField txtNombre,  txtRuta;
    Ventana padre;
    
    
    public Nuevo(Frame parent, boolean modal) {
        super(parent, modal);
        iniciarComponents();
    }
    
    public Nuevo(Frame parent, boolean modal, Ventana padre) {
        super(parent, modal);
        iniciarComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Crear nuevo Archivo");
        this.padre=padre;
    }
    
    private void iniciarComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1 = new JLabel();
        txtRuta = new JTextField();
        jButton1 = new JButton();
        jLabel2 = new JLabel();
        txtNombre = new JTextField();
        jButton2 = new JButton();

        

        jLabel1.setText("Seleccionar ubicacion:");
        txtRuta.setName("txtRuta");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        txtNombre.setName("txtNombre");

        jButton2.setText("Examinar");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }
    
    
    private void jButton1ActionPerformed(ActionEvent evt) {
//        if(txtRuta.getText().equals("") && txtNombre.getText().equals("")){
//            JOptionPane.showMessageDialog(this, "Ingrese una ruta y un nombre");
//        }
//        else{
//            padre.habilitarCampo(txtRuta.getText(), txtNombre.getText());
//            dispose();
//        }
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {
        JFileChooser fc = new JFileChooser();
        /*Mostrar la ventana para abrir archivo y recoger la respuesta
        En el parámetro del showOpenDialog se indica la ventana al que estará asociado. Con el valor this se asocia a la ventana que la abre.*/
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fc.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Mostrar el nombre del archvivo en un campo de texto
            txtRuta.setText(fc.getSelectedFile().toString()+"\\");
        } 
    } 
    
}                                       
