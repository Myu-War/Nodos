package nodos;

/**
 *
 * @author polo
 */
public class NodoDoble<T> {
    private T elemento;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
    int prioridad;
    
    public NodoDoble(){
        siguiente=null;
        anterior=null;
    }
    
    public NodoDoble(T elem){
        elemento=elem;
        siguiente=null;
        anterior=null;
    }
    
    public NodoDoble(T elem,int prio){
        elemento=elem;
        siguiente=null;
        anterior=null;
        this.prioridad=prio;
    }
    public NodoDoble<T> getSig(){
        return siguiente;
    }
    
    public NodoDoble<T> getAnt(){
        return anterior;
    }
    
    public int getPrioridad(){
        return prioridad;
    }
    
    public T getElemento(){
        return elemento;
    }
    
    public void setElem(T elem){
        elemento=elem;
    }
    
    public void setSig(NodoDoble<T> sig){
        siguiente=sig;
    }
    
    public void setAnt(NodoDoble<T> ant){
        anterior=ant;
    }
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        cad.append(elemento.toString()+"\n");
        
        return cad.toString();
    }
    
    public int compareTo(NodoDoble<T> otro){
        int res=-1;
        
        if(otro==null){
            
        }else 
        if(otro.getPrioridad()==getPrioridad()){
            res=0;
        }else
        if(getPrioridad()>otro.getPrioridad()){
            res=1;
        }
        
        return res;
    }
}