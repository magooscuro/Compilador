package analizador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 *
 * @author luis_
 */
public class Metodos {
    Queue<Integer> pila=new LinkedList<>();
    //String[] arregloTokens;
    Palabras_tokens entrada = new Palabras_tokens();
    Palabras_tokens entrada2 = new Palabras_tokens();
    Tabla_Simbolos tabla_simbolos;
    
    public String[] arreglopalabras;
    int bandera2 =3;
    int banderaValor = 0;
    String nombreVariable;
    int identificador;
    
    public String[] lecturaBACKpalabras(String cadena){        
        String entrada1= cadena.replaceAll("\n"," ");
        int palabras=0,conteopalabras=0;
        StringTokenizer token1 = new StringTokenizer(entrada1, " ");
        StringTokenizer token2 = new StringTokenizer(entrada1," ");
        String a;
        while (token1.hasMoreTokens()){
            palabras++;
            a =token1.nextToken();
            entrada.insertar_cola(a, 0);
            entrada2.insertar_cola(a, 0);
        }
        
        arreglopalabras = new String[palabras];
        while (token2.hasMoreTokens()){
            arreglopalabras[conteopalabras] = token2.nextToken();
            conteopalabras++;
        }
        return arreglopalabras;
    }
    
    public void esPalabraReservada(String token) throws Exception {
    	String reservadas[] = {"public","static", "void", "main()","int","string","bolean",
                                "if","else","double","while","=", "+=", "-=", "+", "-", "*", "/",
                                ">", "<", ">=", "<=","!=",";","(",")","{","}",","};
        int idtoken[] = {200,201,202,203,204,205,206,207,208,209,210,300,301,302,401,402,403,404,
                        500,501,502,503,504,600,601,602,603,604,605};
        
        boolean bandera = true;
    	for(int i = 0;i < reservadas.length;i++) {
        	if(reservadas[i].equals(token)){
                    //MODIFICAR
                    agregarApila(idtoken[i]);
                    entrada.buscar_e_ingresar_token(token, idtoken[i]);
                    entrada2.buscar_e_ingresar_token(token, idtoken[i]);
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
                        entrada.buscar_e_ingresar_token(token, 100);
                        entrada2.buscar_e_ingresar_token(token, 100);
                        agregarApila(100);
                    }else{
                        for (int i = 1; i < palabra.length; i++) {
                            if(!Abcedario(String.valueOf(palabra[i]))){
                                System.out.println("Error lexico simbolo no valido");
                                bandera2 = 0;
                                entrada.buscar_e_ingresar_token(token, 100);
                                entrada2.buscar_e_ingresar_token(token, 100);
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
                                    if(bandera3==1){
                                        entrada.buscar_e_ingresar_token(token, 801);
                                        entrada2.buscar_e_ingresar_token(token, 801);
                                        agregarApila(801);
                                    }
                                else
                                    System.out.println("error");
                            }else{
                            if (!esString(String.valueOf(palabra[i]))){
                                System.out.println("Error lexico simbolo no valido--"+palabra[i]);
                                entrada.buscar_e_ingresar_token(token, 100);
                                entrada2.buscar_e_ingresar_token(token, 100);
                                agregarApila(100);
                                bandera3 = 0;
                                
                            }}
                            
                        }
                    }else{
                        if(palabra.length == 1){
                            if(Abcedario(String.valueOf(palabra[0]))){
                                entrada.buscar_e_ingresar_token(token, 701);
                                entrada2.buscar_e_ingresar_token(token, 701);
                                agregarApila(701);
                            }
                            else{
                                System.out.println("Eror no pertenece");
                                entrada.buscar_e_ingresar_token(token, 100);
                                entrada2.buscar_e_ingresar_token(token, 100);
                                agregarApila(100);
                                esIntBoolea(token);
                            }
                        }else{
                            esIntBoolea(token);
                            
                        }
                    }
                }
            if(bandera2 == 1){
                entrada.buscar_e_ingresar_token(token, 700);
                entrada2.buscar_e_ingresar_token(token, 700);
                agregarApila(700);
                System.out.println("token "+ token);
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
    
    public int[] operaciones(String cadena) throws Exception{
        String[] palabras = lecturaBACKpalabras(cadena);
        for (String palabra : palabras) {
            esPalabraReservada(palabra);
        }
        
        int tamano = pila.size();
        int[] tokens = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tokens[i] = sacarDepila();
            //System.out.print("  "+tokens[i]);
        }
        entrada.mostrar();
        tabla_simbolos = new Tabla_Simbolos();
        llenarTABLA_DE_SIMBOLOS();
        tabla_simbolos.mostrar();
        
        //entrada.mostrar();
        return tokens;
    }
    
    public boolean esPrincipal(String palabra){
        if(palabra.equals("Public"))
            return true;
        return false;
    }
    
    //*********************************************************************
    public boolean esReservada(String entrada){
        String reservada_palabra_u_otros[] = {"public","static", "void", "main()","if","else","while",
                                    ";","(",")","{","}",","};
        int idtoken[] = {200,201,202,203,207,208,210,
                        600,601,602,603,604,605};
        
        for (int i = 0; i <= 12 ; i++) {
            if(reservada_palabra_u_otros[i].equals(entrada)){
                //System.err.println("entrada: "+entrada+"      condicional: "+reservada_palabra_u_otros[i]+"      token: "+idtoken[i]);
                return true;
            }
        }
        return false;
    }
    //id
    public boolean esIdentificador(String entrada){

            if(entrada.startsWith("$"))//700
                return true;
       
        return false;
    }
    
    public boolean esFuncion(String entrada){
                String abcedario[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 

        if(entrada.length() == 1){
            for (int i = 0; i < abcedario.length; i++) {
                if(entrada.equalsIgnoreCase(abcedario[i])){
                    return true;
                }
            }
        }
        
        
        return false;
    }
    
    public boolean esCondicional(String entrada){
        String condicionales[] = {">", "<", ">=", "<=","!="};
        int idtoken[] = {500,501,502,503,504};
        
        for (int i = 0; i <= 4 ; i++) {
            if(condicionales[i].equals(entrada)){
                //System.err.println("entrada: "+entrada+"      condicional: "+condicionales[i]+"      token: "+idtoken[i]);
                return true;
            }
        }
        return false;
    }
    
    public boolean esOperador(String entrada){
        String operadores[] = {"+", "-", "*", "/"};
        int idtoken[] = {401,402,403,404};
        
        for (int i = 0; i <= 3 ; i++) {
            if(operadores[i].equals(entrada)){
                //System.err.println("entrada: "+entrada+"      condicional: "+operadores[i]+"      token: "+idtoken[i]);
                return true;
            }
        }
        return false;
    }
    
    public boolean esUnTipoDeDato(String entrada){
        String tiposDeDatos[] = {"int","string","bolean","double"};
        int idtoken[] = {204,205,206,209,202};
        
        for (int i = 0; i <= 3 ; i++) {
            if(tiposDeDatos[i].equals(entrada)){
                //System.err.println("entrada: "+entrada+"      condicional: "+tiposDeDatos[i]+"      token: "+idtoken[i]);
                return true;
            }
        }
        return false;
    }
    
    public boolean esAsignador(String entrada){
        String asignadores[] = {"=", "+=", "-="};
        int idtoken[] = {300,301,302};
        
        for (int i = 0; i <= 2 ; i++) {
            if(asignadores[i].equals(entrada)){
                //System.err.println("entrada: "+entrada+"      condicional: "+asignadores[i]+"      token: "+idtoken[i]);
                return true;
            }
        }
        return false;
    }
    
    public boolean esValor(String entrada){//si es un valor string "hola" o entero o decimal o booleano
        
        char[] numeros = entrada.toCharArray();
        
        if(String.valueOf(numeros[0]).equals("\"")){
            return true;
        }
        else{
        String numero[] = {"1","2","3","4","5","6","7","8","9","0"};
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
            return true;
        }else{
            if(bandera==3){
                return true;
            }else{
                if(error==1){
                    return false;}
            }
        }}
        return false;
    }
    public boolean esError(String entrada){//si el token le va a ingresar 100
        return false;
    }
    
    private int tipodato(String token){
        int tipo = 0;
        return tipo;
    }
    
    
    public Nodo regresaINICIO(){
        return tabla_simbolos.inicio();
    }
    public int regresaTAMAÑO() throws Exception{
        int tamaño = tabla_simbolos.tamaño();
        return tamaño;
    }
    
    public void llenarTABLA_DE_SIMBOLOS() throws Exception{
        //LLAMAR A TDA PALABRASTOKES Y PRELLENAR TABLA SIMBOLOS
        tabla = new ArrayList<>();
        int tamaño = entrada.tamaño();
        
        String[] primero;
        String[] tipoDatoGuardado = new String[2];
        String[] segundo;
        int contador=0;
        try {
            for (int p=1; p<=tamaño;p++) {
                contador = 0;
                primero = entrada.eliminar_cola();
                if(esUnTipoDeDato(primero[0])){
                    if(esIdentificador(entrada.Inicio.nombre_palabra)){
                        if(busqueda1(entrada.Inicio.nombre_palabra)){
                            tabla.add(entrada.Inicio.nombre_palabra);
                            tabla_simbolos.insertar_cola(entrada.Inicio.nombre_palabra, entrada.Inicio.idtoken, "", primero[0], "ID");
                        }else{
                            tabla_simbolos.insertar_cola(entrada.Inicio.nombre_palabra, entrada.Inicio.idtoken, "Error variable ya declarada", "", "ID");
                        }
                    }else{
                        if(esFuncion(entrada.Inicio.nombre_palabra)){
                            if(busqueda1(entrada.Inicio.nombre_palabra)){
                            tabla.add(entrada.Inicio.nombre_palabra);
                            String data = entrada.Inicio.nombre_palabra;
                            String tipo = primero[0];
                            primero = entrada.eliminar_cola();
                            while(!primero[0].equals(")")){
                                if(primero[0].equals(",")){
                                    contador++;
                                }
                                primero = entrada.eliminar_cola();
                            }
                            tabla_simbolos.insertar_cola(data, 701, "Parametros: "+(contador+1), tipo, "Funcion");
                        }else{
                            tabla_simbolos.insertar_cola(entrada.Inicio.nombre_palabra, entrada.Inicio.idtoken, "Error funcion ya declarada", "", "Funcion");
                        }
                        }
                    }
                }else if(esIdentificador(primero[0])){
                    if(!busqueda2(primero[0])){
                        tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "Error variable no declarada", "", "ID");
                    }
                }else if(esFuncion(primero[0])){
                    if(!busqueda2(primero[0])){
                        tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "Error funcion no declarada", "", "Funcion");
                    }
                }
                
                /*if(tabla_simbolos.buscar_si_existe(primero[0])){//ACTUALIZA EL VALOR.
                    //RECUPERAR VALORES
//                    System.out.println("----------1");
//                    String[] valores_recuperados = tabla_simbolos.recuperar_valores(primero[0]);
//                    System.out.println(""+valores_recuperados[0]);
//                    segundo =entrada.segundoNODO();
//                        if(esValor(segundo[0])){
//                            System.out.println(""+segundo[0]);
//                           tabla_simbolos.buscar_e_ingresar(valores_recuperados[0], Integer.parseInt(valores_recuperados[1]),segundo[0],valores_recuperados[3],valores_recuperados[4]); 
//                        }
                    
                    }else{//INGRESA LA PALABRA*/
                    //if(esReservada(primero[0])){
                        //tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "Palabra Reservada");
                    ///}else
                       // if(esIdentificador(primero[0])){
//                            nombreVariable = primero[0];
//                            identificador = Integer.parseInt(primero[1]);
//                            banderaValor = 1;
                         //   segundo =entrada.segundoNODO();
                           // if(esValor(segundo[0])){
                             //   if(esUnTipoDeDato(tipoDatoGuardado[0])){
                               //     tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), segundo[0], tipoDatoGuardado[0], "Identificador");
                                //}else{
                                  //  String[] valores_recuperados = tabla_simbolos.recuperar_valores(primero[0]);
        //                          System.out.println(""+valores_recuperados[0]);
                                    //tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), segundo[0], valores_recuperados[3], "Identificador");//""aqui poner tipo de una busqueda a la concurrencia anterior
                                //}
                            //}
                        //}else
                          //  if(esAsignador(primero[0])){
                                //tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "Asignador");
                            //}else
                              //  if(esValor(primero[0])){//los vvalores se insertan

                                    //if(banderaValor == 1){
                                //    tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "valor");
                                    //}

                                  //  if(banderaValor == 1){
                                    //    banderaValor = 0;
                                    //tabla_simbolos.insertar_cola(nombreVariable, identificador, primero[0], "", "variable");
                                    //}

                                //}else
                                  //  if(esCondicional(primero[0])){
                                        //tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "Condicional");
                                    //}else
                                      //  if(esOperador(primero[0])){
                                           // tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "Operador");
                                        //}else
                                          //  if(esUnTipoDeDato(primero[0])){
                                                //tabla_simbolos.insertar_cola(primero[0], Integer.parseInt(primero[1]), "", "", "Tipo de dato");
                                                //tipoDatoGuardado[0]=primero[0];
                                                //tipoDatoGuardado[1]=primero[1];
                                            //}//falta else de error
              //  }//FIN DEL ELSE
            }//FIN DEL WHILE
        } catch (Exception e) {
            System.err.println("ERROR AL LLENAR TABLA DE SIMBOLOS: "+e);
        }
    }
    //*****************************************************************
    
    ArrayList<String> tabla;
    
    public boolean busqueda1(String string){
        
        if(!tabla.isEmpty()){
            for (int i = 0; i < tabla.size(); i++) {
                if(string.equals(tabla.get(i))){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean busqueda2(String string){
        
        if(!tabla.isEmpty()){
            for (int i = 0; i < tabla.size(); i++) {
                if(string.equals(tabla.get(i))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void agregarApila(int cadena){
        pila.add(cadena);
    }
    
    public int sacarDepila(){
            return pila.remove();
    }
}