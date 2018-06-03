package analizador;

/**
 *
 * @author luis_
 */

public class Nodo {
    String nombre_palabra; //es la palabra que se ingresa por ejemplo $fed o main
    int idtoken; //700 o 701 #
    String valor; //la variable fue declarada en esta variable string valor
    String tipo; //
    String pertenece_a; //es identificador o palabra reservada
    Nodo Siguiente;
    Nodo Anterior;

    public Nodo(String _nombre_palabra, int _idtoken, String _valor, String _tipo, String pertenece_a, Nodo Siguiente, Nodo Anterior) {
        this.nombre_palabra = _nombre_palabra;
        this.idtoken = _idtoken;
        this.valor = _valor;
        this.tipo = _tipo;
        this.pertenece_a = pertenece_a;
        this.Siguiente = Siguiente;
        this.Anterior = Anterior;
    }

    
    
    
}
