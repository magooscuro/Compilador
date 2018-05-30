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
    
    public String sacarDecola(){
        return pila.pop();
    }
    
    public void agregarAcola(String estado){
        pila.push(estado);
    }
    
    public String AutomataFinito(int token){
        String estado = pila.peek();
        System.err.println(""+estado);
        switch(token){
            case 200://public
                if(estado.equals("q00"))
                    agregarAcola("q0");
            break;
            case 201://static
                if(estado.equals("q0"))
                    agregarAcola(estado="q1");
            break;
            case 202://void 
                if(estado.equals("q1"))
                    agregarAcola(estado="q2");
            break;
            case 203://main
                if(estado.equals("q2"))
                    estado="q3";
            break;
            case 603://{
                if(estado.equals("q3"))
                    estado="q4";
            break;
            case 604://}
                if(estado.equals("q4"))
                    estado="q100";
            break;
        }
        return estado;
    }
    
    private void iniciales(int token){
        
    }
}
