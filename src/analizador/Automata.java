package analizador;

import java.util.Stack;

/**
 *
 * @author luis_
 */
public class Automata {
    Stack<String> pila=new Stack<>();

    public Automata() {
        agregarAcola("q00");
    }
    
    private String sacarDecola(){
        return pila.pop();
    }
    
    private void agregarAcola(String estado){
        pila.push(estado);
    }
    
    public String AutomataFinito(int token){
        String estado = pila.peek();
        switch(token){
            case 200://public
                if(estado.equals("q00"))
                    agregarAcola("q0");
            break;
            case 201://static
                if(estado.equals("q0"))
                    agregarAcola("q1");
            break;
            case 202://void 
                if(estado.equals("q1"))
                    agregarAcola("q2");
            break;
            case 203://main
                if(estado.equals("q2"))
                    agregarAcola("q3");
            break;
            case 204://int
            case 205://string
            case 206://boolean
            case 209://double
                if(estado.equals("q4"))
                    agregarAcola("q5");
                else
                    if(estado.equals("q17"))
                        agregarAcola("q18");
            break;
            case 207:// if
                if(estado.equals("q22"))
                    agregarAcola("q17");
                else
                    if(estado.equals("q4"))
                        agregarAcola("q11");
            break;
            case 208:// else
                //if(estado.equals("q22"))
                  //  agregarAcola("q17");
            break;
            case 210:// while
                if(estado.equals("q4"))
                    agregarAcola("q11");
                else
                    if(estado.equals("q22"))
                        agregarAcola("q17");
            break;
            case 700://id          $cualquier cosa :)
                if(estado.equals("q5"))
                    agregarAcola("q8");
                else
                    if(estado.equals("q12"))
                        agregarAcola("q13");
                    else
                        if(estado.equals("q14"))
                            agregarAcola("q15");
                        else
                            if(estado.equals("q4"))
                                agregarAcola("q8");
                            else
                                if(estado.equals("q17"))
                                    agregarAcola("q19");
                                else
                                    if(estado.equals("q18"))
                                        agregarAcola("q19");
            break;
            case 300://=
            case 301:// +=
            case 302:// -=
                if(estado.equals("q8"))
                    agregarAcola("q9");
                else
                    if(estado.equals("q19"))
                        agregarAcola("q20");
            break;
            case 800:// 999 es entero
            case 801:// abc es string
            case 802:// 9.99 es double
            case 803:// 999
                if(estado.equals("q9"))
                    agregarAcola("q10");
                else
                    if(estado.equals("q12"))
                        agregarAcola("q13");
                    else
                        if(estado.equals("q20"))
                            agregarAcola("q21");
            break;
            case 600:// ;
                if(estado.equals("q10") || estado.equals("q8"))
                    agregarAcola("q4");
                else
                    if(estado.equals("q21") || estado.equals("q19"))
                        agregarAcola("q22");
            break;
            case 601:// (
                if(estado.equals("q11"))
                    agregarAcola("q12");
            break;
            case 602:// )
                if(estado.equals("q15"))
                    agregarAcola("q16");
            break;
            case 603:// {
                if(estado.equals("q3"))
                    agregarAcola("q4");
                else
                    if(estado.equals("q16"))
                        agregarAcola("q17");
            break;
            //******************************************************************
            
            
            case 500:// >
            case 501:// <
            case 502:// >=
            case 503:// <=
            case 504:// !=
                if(estado.equals("q13"))
                    agregarAcola("q14");
            break;
            
            
            
            
            
            case 604://}        ESTADO FINAL
                if(estado.equals("q4"))
                    agregarAcola("q100");
                else
                    if(estado.equals("q22"))
                        agregarAcola("q4");
            break;
        }
        estado = pila.peek();
        return estado;
    }
    
    public String mostrarpila(){
        while (!pila.isEmpty()) { // mostrar pila completa
            return ""+pila.pop(); // extrae un elemento de la pila
        }
        return "";
    }
}

