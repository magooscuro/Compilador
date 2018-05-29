/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.awt.ScrollPane;


/**
 *
 * @author luis_
 */
public class scroll extends ScrollPane{
    Panel contenedor = new Panel();
    public scroll() {
        iniciarcomponentes();
    }
    
    private void iniciarcomponentes(){
        setBounds(10, 80, 500, 500);
        add(contenedor);
    }
}
