package analizador;

import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.Stack;
/**
 *
 * @author luis_
 */
public class Metodos {
    Stack<String> pila = new Stack<String>();
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
    
    public boolean esPalabraReservada(String token) {
    	int i;
    	String reservadas[] = {"main","abstract","assert","boolean","break","byte","case","catch","char","class","const",
        "continue","default","do","double","else","enum","extends","final","finally","float","for","goto","if",
        "implements","import","instanceof","int","interface","long","native","new","package","private","protected",
    	"public","return","short","static","super","switch","new","package","private","protected","synchronized","this",
    	"throw","throws","transient","try","void","volatile","while"};
 
    	for(i = 0;i < reservadas.length;i++) {
        	if(reservadas[i].equals(token)) 
               return true;
        }
    	return false;
    }
    
    public void operaciones(String cadena){
        String[] palabras = lecturaBACKpalabras(cadena);
        for (int i = 0; i < palabras.length; i++) {
            if(esPalabraReservada(palabras[i])){
                System.out.println(palabras[i]+"palabra reservada");
            }else
                System.out.println(palabras[i]+"no palabra reserfvada");
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
    
    public void agregarApila(String cadena){
        // adiciona un libro a la pila
        String[] palabras = lecturaBACKpalabras(cadena);
        for (int i = 0; i < palabras.length; i++) {
            pila.push(palabras[i]);
            //pila.push(Integer.toString(palabras[i]));
        }
        
        
    }
    
    public void sacarDEpila(){
        while (!pila.empty())
        System.out.println(pila.pop());
    }
}