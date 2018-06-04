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
        Nodo Rec,Rec1,Rec2;
        int ocurrencias=0;
        if(Inicio!=null)
            if(Inicio.nombre_palabra.equals(palabra))
                Inicio.idtoken=token;
        else{
                Rec=Inicio;
                while(!Rec.nombre_palabra.equals(palabra) && Rec.Siguiente!=null){
                    //System.out.print("nodos: "+Rec.nombre_palabra);
                    Rec=Rec.Siguiente;
                }
                if (Rec.nombre_palabra.equals(palabra)){
                    if(Rec.idtoken == 0){
                        Rec.idtoken=token;
                        System.out.print("rec: "+Rec.nombre_palabra +" token "+Rec.idtoken);
                    }else
                        if(Rec.idtoken != 0){
                            Rec1 = Rec.Siguiente;
                            while(!Rec1.nombre_palabra.equals(palabra) && Rec1.Siguiente!=null){
                                System.out.print("rec1: "+Rec1.nombre_palabra +" token "+Rec1.idtoken);
                                Rec1=Rec1.Siguiente;
                            }
                            if(Rec1.idtoken == 0)
                                Rec1.idtoken=token;
                            else
                                if(Rec1.idtoken != 0){
                                    Rec2 = Rec1.Siguiente;
                                    while(!Rec2.nombre_palabra.equals(palabra) && Rec2.Siguiente!=null){
                                        //System.out.print("nodos: "+Rec.nombre_palabra);
                                        Rec2=Rec2.Siguiente;
                                    }
                                    if(Rec2.idtoken == 0)
                                        Rec2.idtoken=token;
                                }
                        }
                    
                    //System.out.println("palabra: "+palabra+"    token: "+token);
                }
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
    
    
    public String[] segundoNODO()throws Exception{
        String[] aux= new String[2];
        if(Inicio != null){
            aux[0] = Inicio.Siguiente.nombre_palabra;
            aux[1] = ""+Inicio.Siguiente.idtoken;
            return aux;
        }else{
            throw new Exception ("cola vacia");
        }
    }
    
    public String[] NODOanterior()throws Exception{
        String[] aux= new String[2];
        if(Inicio != null){
            aux[0] = Inicio.Siguiente.nombre_palabra;
            aux[1] = ""+Inicio.Siguiente.idtoken;
            return aux;
        }else{
            throw new Exception ("cola vacia");
        }
    }
}
