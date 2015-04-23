/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author polo
 */
public class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;
    int prioridad;
    
    public Nodo(){
        siguiente=null;
    }
    
    public Nodo(T elem){
        elemento=elem;
        siguiente=null;
    }
    
    public Nodo(T elem,int prio){
        elemento=elem;
        siguiente=null;
        this.prioridad=prio;
    }
    public Nodo<T> getSig(){
        return siguiente;
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
    
    public void setSig(Nodo<T> sig){
        siguiente=sig;
    }
    
    public String toString(){
        StringBuilder cad=new StringBuilder();
        
        cad.append(elemento.toString()+"\n");
        
        return cad.toString();
    }
    
    public int compareTo(Nodo<T> otro){
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
