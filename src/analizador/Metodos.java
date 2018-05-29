package analizador;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.Stack;
/**
 *
 * @author luis_
 */
public class Metodos {
    Queue<Integer> pila=new LinkedList<>();
    public Metodos() {
        
    }
    
    
    public String[] lecturaBACKpalabras(String cadena){
        /*El método toma como parámetro una expresión regular. Si se quiere utilizar un separador textual,
        se deben escapar los caracteres \ ^ $ . | ? * + ( ) [ { antecediéndolos con una \.
        String[] parts = string.split("\\|"); // Separar por "|"*/
        
        //String separador = Pattern.quote("\\ ^ $ . | ? * + ( ) [ {");
                
//        String separador = " ";
//        String[] parts = cadena.split(" ");
//        //int tamaño =parts.length;
//        for (int i = 0; i < parts.length; i++) {
//            System.out.println(""+parts[i]);
//        }

        
        String entrada1= cadena.replaceAll("\n"," ");
        int palabras=0,conteopalabras=0;
        
        StringTokenizer token1 = new StringTokenizer(entrada1, " ");
        StringTokenizer token2 = new StringTokenizer(entrada1," ");
        
        while (token1.hasMoreTokens()){
            palabras++;
            token1.nextToken();
            //System.out.println("No importante "+palabras);
        }
        //System.out.println("total: "+palabras);
        
        String[] arreglopalabras = new String[palabras];
        while (token2.hasMoreTokens()){
            arreglopalabras[conteopalabras] = token2.nextToken();
            conteopalabras++;
        }
        return arreglopalabras;
    }
    
    public void esPalabraReservada(String token) {
    	String reservadas[] = {"public","static", "void", "main()","int","string","bolean",
                                "if","else","double","while","=", "+=", "-=", "+", "-", "*", "/",
                                ">", "<", ">=", "<=","!=",";","(",")","{","}"};
        int idtoken[] = {200,201,202,203,204,205,206,207,208,209,210,300,301,302,400,401,402,403,404,
                        500,501,502,503,504,600,601,602,603,604};
        
        boolean bandera = true;
    	for(int i = 0;i < reservadas.length;i++) {
        	if(reservadas[i].equals(token)){
                   
                    agregarApila(idtoken[i]);
                    bandera = true;
                    break;
                }
                else
                    bandera = false;
        }//return 5;
        
        if(!bandera){
            char[] palabra = token.toCharArray();
            String inicio;
                if(String.valueOf(palabra[0]).equals("$")){
                    System.out.println("yaa we");
                }
            
        }
       
    }
    
    public boolean Abcedario(String letra){
        String abcedario[] = {"a", "b", "c", "b", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
        for (int i = 0; i < abcedario.length; i++) {
            if(letra.equalsIgnoreCase(abcedario[i]))
                return true;
        }
        return false;
    }
    
    public void operaciones(String cadena){
        String[] palabras = lecturaBACKpalabras(cadena);
        for (int i = 0; i < palabras.length; i++) {
            esPalabraReservada(palabras[i]);
        }
        int tamano = pila.size();
        for (int i = 0; i < tamano; i++) {
            System.out.println(sacarDepila()); 
        }
        
    }
    
    public boolean esPrincipal(String palabra){
        if(palabra.equals("Public"))
            return true;
        return false;
    }
    
    public boolean esIdentificador(){
        //es palabra reservada??
        return false;
    }
    
    public void agregarApila(int cadena){
        // adiciona un libro a la pila
        pila.add(cadena);
            //pila.push(Integer.toString(palabras[i]));
        }
        
        
    
    
    public int sacarDepila(){
            return pila.remove();
    }
}