package analizador;

import java.util.Stack;

/**
 *
 * @author luis_
 */
public class Automata {
    Stack<String> pilaEstados=new Stack<>();

    public Automata() {
        agregarAcola("q00");
    }
    
    private String sacarDecola(){
        return pilaEstados.pop();
    }
    
    private void agregarAcola(String estado){
        pilaEstados.push(estado);
    }
    
    public String AutomataFinito(int token){
        String estado = pilaEstados.peek();
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
                else
                    if(estado.equals("q4"))
                        agregarAcola("q29");
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
                    else
                        if(estado.equals("q31"))
                            agregarAcola("q32");
            break;
            case 207:// if
                if(estado.equals("q22"))
                    agregarAcola("q17");
                else
                    if(estado.equals("q4"))
                        agregarAcola("q11");
                    else
                        if(estado.equals("q17"))
                            agregarAcola("q11");
            break;
            case 208:// else
                if(estado.equals("q4"))
                    agregarAcola("q11");
                else
                    if(estado.equals("q22"))
                        agregarAcola("q17");
                    else
                        if(estado.equals("q17"))
                            agregarAcola("q11");
            break;
            case 210:// while
                if(estado.equals("q4"))
                    agregarAcola("q11");
                else
                    if(estado.equals("q22"))
                        agregarAcola("q17");
                    else
                        if(estado.equals("q17"))
                            agregarAcola("q11");
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
            case 401:// +
            case 402:// -
            case 403:// *
            case 404:// /
                if(estado.equals("q10"))
                    agregarAcola("q6");
                else
                    if(estado.equals("q21"))
                        agregarAcola("q23");
            break;
            case 500:// >
            case 501:// <
            case 502:// >=
            case 503:// <=
            case 504:// !=
                if(estado.equals("q13"))
                    agregarAcola("q14");
            break;
            case 600:// ;
                if(estado.equals("q10") || estado.equals("q8"))
                    agregarAcola("q4");
                else
                    if(estado.equals("q21") || estado.equals("q19"))
                        agregarAcola("q22");
                    else
                        if(estado.equals("q25"))
                            agregarAcola("q4");
            break;
            case 601:// (
                if(estado.equals("q11"))
                    agregarAcola("q12");
                else
                    if(estado.equals("q23"))
                        agregarAcola("q24");
                    else
                        if(estado.equals("q30"))
                            agregarAcola("q31");
            break;
            case 602:// )
                if(estado.equals("q15"))
                    agregarAcola("q16");
                else
                    if(estado.equals("q24"))
                        agregarAcola("q25");
                    else
                        if(estado.equals("q31") || estado.equals("q33"))
                            agregarAcola("q34");
            break;
            case 603:// {
                if(estado.equals("q3"))
                    agregarAcola("q4");
                else
                    if(estado.equals("q16") || estado.equals("q34"))
                        agregarAcola("q17");
            break;
            case 605:// {
                if(estado.equals("q27"))
                    agregarAcola("q4");
            break;
            //****************************************************************** estado final
            case 604://}        ESTADO FINAL
                if(estado.equals("q4"))
                    agregarAcola("q100");
                else
                    if(estado.equals("q22"))
                        agregarAcola("q4");
//                    else
//                        if(estado.equals("q17"))
//                            agregarAcola("q4");
            break;
            case 700://id          $cualquier cosa :)
                if(estado.equals("q5"))
                    agregarAcola("q8");
                else
                    if(estado.equals("q9"))
                        agregarAcola("q10");
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
                                        else
                                            if(estado.equals("q24"))
                                                agregarAcola("q27");
                                            else
                                                if(estado.equals("q32"))
                                                    agregarAcola("q33");
                                                else
                                                    if(estado.equals("q6"))
                                                        agregarAcola("q10");
                                                    else
                                                        if(estado.equals("q23"))
                                                            agregarAcola("q21");
            break;
            case 701:// 
                if(estado.equals("q4"))
                    agregarAcola("q23");
                else
                    if(estado.equals("q5"))
                        agregarAcola("q30");
                    else
                        if(estado.equals("q29"))
                            agregarAcola("q30");
            break;
            case 800:// 999 es entero
            case 801:// abc es string
            case 802:// 9.99 es double
            case 803:// true
                if(estado.equals("q9"))
                    agregarAcola("q10");
                else
                    if(estado.equals("q6"))
                        agregarAcola("q10");
                    else
                        if(estado.equals("q12"))
                            agregarAcola("q13");
                        else
                            if(estado.equals("q20"))
                                agregarAcola("q21");
                            else
                                if(estado.equals("q14"))
                                    agregarAcola("q15");
                                else
                                    if(estado.equals("q24"))
                                        agregarAcola("q27");
                                    else
                                        if(estado.equals("q23"))
                                            agregarAcola("q21");
            break;
        }
        estado = pilaEstados.peek();
        return estado;
    }
    
    public String mostrarpila(){
        while (!pilaEstados.isEmpty()) { // mostrar pilaEstados completa
            //System.err.println("estado: "+pilaEstados.peek());
            return ""+pilaEstados.peek(); // extrae un elemento de la pilaEstados
        }
        return "";
    }
    
    public void mostrar(){
        while (!pilaEstados.isEmpty()) { // mostrar pilaEstados completa
            System.out.print("  "+pilaEstados.pop());
            //return ""+pilaEstados.pop(); // extrae un elemento de la pilaEstados
        }
        System.out.println("");
        pilaEstados.removeAllElements();
    }
}

