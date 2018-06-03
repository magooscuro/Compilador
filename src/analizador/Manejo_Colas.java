package analizador;

/**
 *
 * @author luis_
 */
public class Manejo_Colas {
    Nodo Inicio;

    public Manejo_Colas() {
        Inicio = null;
    }
    
    public void insertar_cola(String palabra, int idtoken, String valor, String tipo,String pertenece_a, Nodo Siguiente, Nodo Anterior){
        Nodo R;
        if(Inicio == null){
            //VENTANILLA VACIA
            Inicio = new Nodo(palabra,idtoken,valor,tipo,pertenece_a,Siguiente,Anterior);
        }else{
            //VENTANILLA OCUPADA
            R = Inicio;
            while(R.Siguiente != null){
                R = R.Siguiente;
            }
            R.Siguiente = new Nodo(palabra,idtoken,valor,tipo,pertenece_a,Siguiente,Anterior);
        }
    }
    
    //DEPRICATE
    public void mostrar(){
        Nodo R;
        R = Inicio;
        
        if(Inicio != null)
            while(R != null){
                //ESTOS DATOS SE INGRESARAN A LA TABLA
                //System.err.println(""+R.NumeroCliente+"\t"+R.TiempoLlegada+"\t"+R.TiempoEnPasarAVentanilla);
                R = R.Siguiente;
            }
    }
    
    public String[] eliminar_cola()throws Exception{
        String[] aux= new String[5];
        if(Inicio != null){
            aux[0] = Inicio.nombre_palabra;
            aux[1] = ""+Inicio.idtoken;
            aux[2] = Inicio.valor;
            aux[3] = Inicio.tipo;
            aux[4] = Inicio.pertenece_a;
//            aux[5] = Inicio.Siguiente;
//            aux[6] = Inicio.Anterior;
                    
            Inicio = Inicio.Siguiente;
            return aux;
        }else{
            throw new Exception ("cola vacia");
        }
    }
    
}
