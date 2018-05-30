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
    int bandera2 =3;
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
        int idtoken[] = {200,201,202,203,204,205,206,207,208,209,210,300,301,302,401,402,403,404,
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
                if(String.valueOf(palabra[0]).equals("$")){bandera2 = 1;
                    if(palabra.length<2){
                        System.out.println("Error lexico Variable no esta bien definids");
                        agregarApila(100);
                    }else{
                        for (int i = 1; i < palabra.length; i++) {
                            if(!Abcedario(String.valueOf(palabra[i]))){
                                System.out.println("Error lexico simbolo no valido");
                                bandera2 = 0;
                                agregarApila(100);
                            }
                        }
                    }
                }else{
                    if(String.valueOf(palabra[0]).equals("\"")){
                        int bandera3 = 1;
                        for (int i = 1; i < palabra.length; i++) {
                            if(i==(palabra.length-1))
                            {
                                if(String.valueOf(palabra[(palabra.length-1)]).equals("\""))
                                    if(bandera3==1)
                                    agregarApila(801);
                                else
                                    System.out.println("error");
                            }else{
                            if (!esString(String.valueOf(palabra[i]))){
                                System.out.println("Error lexico simbolo no valido--"+palabra[i]);
                                agregarApila(100);
                                bandera3 = 0;
                                
                            }}
                            
                        }
                    }else{
                        if(palabra.length == 1){
                            if(Abcedario(String.valueOf(palabra[0]))){
                                agregarApila(701);
                            }
                            else{
                                System.out.println("Eror no pertenece");
                                agregarApila(100);
                                esIntBoolea(token);
                            }
                        }else{
                            esIntBoolea(token);
                            
                        }
                    }
                }
            if(bandera2 == 1){
                agregarApila(700);
            bandera2=3;}
        }
       
    }
    
    public boolean esIntBoolea(String token){
        String numero[] = {"1","2","3","4","5","6","7","8","9","0"};
        char[] numeros = token.toCharArray();
        int bandera = 0;
        boolean bandera2 =false;
        int error =0;
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numero.length; j++) {
                if(String.valueOf(numeros[i]).equals(numero[j])){
                    if(bandera != 5 && bandera!=3)
                    bandera = 1;                    
                }                
            }
            /*if(bandera == 0){
                System.out.println("puede serpunto");*/
                if(String.valueOf(numeros[i]).equals(".")){
                    if(bandera==3){
                        bandera=5;
                        error = 1;
                    }
                    if(i<(numeros.length-1)){
                        bandera=3;
                    }
                }
                
            }
            
        //}
        if(bandera==1){
            agregarApila(800);
            return true;
        }else{
            if(bandera==3){
                agregarApila(802);
                return true;
            }else{
                if(error==1){
                    agregarApila(100);
                    return false;}
            }
        }
        return false;
    }
    
    public boolean Abcedario(String letra){
        String abcedario[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
        for (int i = 0; i < abcedario.length; i++) {
            if(letra.equalsIgnoreCase(abcedario[i]))
                return true;
        }
        return false;
    }
    public boolean esString(String letra){
        String abcedario[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
        "1","2","3","4","5","6","7","8","9","0","ñ","?","¿","!","¡"}; 
        for (int i = 0; i < abcedario.length; i++) {
            if(letra.equalsIgnoreCase(abcedario[i])){
                return true;
            }
        }
        return false;
    }
    
    public int[] operaciones(String cadena){
        String[] palabras = lecturaBACKpalabras(cadena);
        
        for (int i = 0; i < palabras.length; i++) {
            esPalabraReservada(palabras[i]);
        }
        int tamano = pila.size();
        int[] tokens = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tokens[i] = sacarDepila();
            System.out.println(tokens[i]);
        }
        return tokens;
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