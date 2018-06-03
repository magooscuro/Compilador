package analizador;

/**
 *
 * @author luis_
 */
public class Tabla_Simbolos {
    Nodo Inicio;

    public Tabla_Simbolos() {
        Inicio = null;
    }
    
    public void insertar_cola(String palabra, int idtoken, String valor, String tipo, String pertenece_a){
        Nodo R;
        if(Inicio == null){
            Inicio = new Nodo(palabra,idtoken,valor,tipo,pertenece_a);
        }else{
            R = Inicio;
            while(R.Siguiente != null){
                R = R.Siguiente;
            }
            R.Siguiente = new Nodo(palabra,idtoken,valor,tipo,pertenece_a);
        }
    }
    
    public void buscar_e_ingresar(String palabra, int token, String valor, String tipo, String pertenece_a) throws Exception{
        Nodo Rec;
        if(Inicio!=null)
            if(Inicio.nombre_palabra.equals(palabra))
                Inicio.idtoken=token;//fshbbbbbbbbbbbbbb
        else{
                Rec=Inicio;
                while(!Rec.nombre_palabra.equals(palabra) && Rec.Siguiente!=null){
                    Rec=Rec.Siguiente;
                }
                if (Rec.nombre_palabra.equals(palabra))
                    Rec.idtoken=token;//sfhbsfgb
            }else
            throw new Exception("Lista vacia");
    }
    
    public boolean buscar_si_existe(String palabra){
        Nodo Rec;
        if(Inicio!=null){
            if(Inicio.nombre_palabra.equals(palabra))
                return true;
            else{
                Rec=Inicio;
                while(!Rec.nombre_palabra.equals(palabra) && Rec.Siguiente!=null){
                    Rec=Rec.Siguiente;
                }
                if (Rec.nombre_palabra.equals(palabra))
                    return true;
            }
        }else
            if(Inicio == null)
                return false;
        return false;
    }
    
    public String[] recuperar_valores(String palabra){
        String[] aux= new String[5];
        Nodo Rec;
        if(Inicio!=null){
            if(Inicio.nombre_palabra.equals(palabra)){//devolver inicio
                aux[0] = Inicio.nombre_palabra;
                aux[1] = ""+Inicio.idtoken;
                aux[2] = Inicio.valor;
                aux[3] = Inicio.tipo;
                aux[4] = Inicio.pertenece_a;
                //return aux;
            }
        }else{
                Rec=Inicio;
                while(!Rec.nombre_palabra.equals(palabra) && Rec.Siguiente!=null){
                    Rec=Rec.Siguiente;
                }
                if (Rec.nombre_palabra.equals(palabra)){ //AQUI ESTA EL VALOR DEVOLVER VALORES
                    aux[0] = Rec.nombre_palabra;
                    aux[1] = ""+Rec.idtoken;
                    aux[2] = Rec.valor;
                    aux[3] = Rec.tipo;
                    aux[4] = Rec.pertenece_a;
                    //return aux;
                }
            }
        return aux;
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
    
    public Nodo inicio(){
        Nodo comienzo;
        if(Inicio!=null)
            comienzo = Inicio;
        else
            comienzo = null;
        return comienzo;
    }
    
    
    //DEPRICATE
    public void mostrar(){
        Nodo R;
        R = Inicio;
        
        if(Inicio != null)
            while(R != null){
                //ESTOS DATOS SE INGRESARAN A LA TABLA
                System.out.print("TABLA:    ");
                System.out.print(""+R.nombre_palabra+"   - "+R.idtoken);
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
    
}
