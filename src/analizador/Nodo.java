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

    //AGREGA TABLA DE SIMBOLOS
    public Nodo(String _nombre_palabra, int _idtoken, String _valor, String _tipo, String _pertenece_a) {
        nombre_palabra = _nombre_palabra;
        idtoken = _idtoken;
        valor = _valor;
        tipo = _tipo;
        pertenece_a = _pertenece_a;
        Siguiente = null;
    }
    
    //AGREGA PALABRA RESERVADA Y TOKENS
    public Nodo(String _nombre_palabra, int _idtoken) {
        nombre_palabra = _nombre_palabra;
        idtoken = _idtoken;
        Siguiente = null;
    }
    

    
    
    
}
