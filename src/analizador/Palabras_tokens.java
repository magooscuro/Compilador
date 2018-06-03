package analizador;

/**
 *
 * @author luis_
 */
public class Palabras_tokens {
    Nodo Inicio;

    public Palabras_tokens() {
        Inicio = null;
    }
    
    public void insertar_cola(String palabra, int idtoken){
        Nodo R;
        if(Inicio == null){
            Inicio = new Nodo(palabra,idtoken);
        }else{
            R = Inicio;
            while(R.Siguiente != null){
                R = R.Siguiente;
            }
            R.Siguiente = new Nodo(palabra,idtoken);
        }
    }
    
    public void buscar_e_ingresar_token(String palabra, int token) throws Exception{
        Nodo Rec;
        if(Inicio!=null)
            if(Inicio.nombre_palabra.equals(palabra))
                Inicio.idtoken=token;
        else{
                Rec=Inicio;
                while(!Rec.nombre_palabra.equals(palabra) && Rec.Siguiente!=null){
                    Rec=Rec.Siguiente;
                }
                if (Rec.nombre_palabra.equals(palabra))
                    Rec.idtoken=token;
            }else
            throw new Exception("Lista vacia - no se inserto token");
    }
    
    //DEPRICATE
    public void mostrar(){
        Nodo R;
        R = Inicio;
        System.out.print("ENTRADA:    ");
        if(Inicio != null)
            while(R != null){
                System.out.print(""+R.nombre_palabra+" - "+R.idtoken+"  |  ");
                R = R.Siguiente;
            }
    }
    
    public String[] eliminar_cola()throws Exception{
        //REGRESA LOS DATOS DEL NODO QUE ACABA DE ELIMINAR 
        //SACA AL PRIMERO QUE INGRESO
        String[] aux= new String[2];
        if(Inicio != null){
            aux[0] = Inicio.nombre_palabra;
            aux[1] = ""+Inicio.idtoken;
                    
            Inicio = Inicio.Siguiente;
            return aux;
        }else{
            throw new Exception ("cola vacia");
        }
    }
    
    public boolean estaVACIA(){
        boolean estado;
        if(Inicio!=null)
            estado = false;
        else
            estado = true;
        return estado;
    }
    
    public int tamaño() throws Exception{
        Nodo Rec;
        int tamaño=0;
        if(Inicio!=null){
            Rec=Inicio;
            while(Rec.Siguiente != null){
                Rec=Rec.Siguiente;
                tamaño++;
            }
            tamaño++;
        }else
                throw new Exception("Lista vacia");
        return tamaño;
    }
}
