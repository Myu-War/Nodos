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
public class myQueue<T> implements Queue<T>{
    Nodo<T> cabeza;
    int cont;
    
    public myQueue(){
        cabeza=new Nodo();
        cont=0;
    }
    
    public Nodo<T> deQueue(){
        Nodo<T> aux=cabeza.getSig();
        
        if(isEmpty()){
            throw new Unchecked("La pila esta vacia.");
        }
        cabeza.setSig(cabeza.getSig().getSig());
        cont--;
        
        return aux;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return cabeza.getSig().getElemento();
    }

    @Override
    public boolean isEmpty() {
        boolean res=false;
        
        if(cabeza.getSig()==null){
            res=true;
        }
        
        return res;
    }

    @Override
    public void enQueue(T elem,int prio) {
        Nodo<T> recorredor=cabeza;
        Nodo<T> nuevo=new Nodo(elem,prio);
        Nodo<T> aux=null;
        
        while(recorredor.getSig()!=(null) && recorredor.getSig().compareTo(nuevo)<=0){
            recorredor=recorredor.getSig();
        }
        aux=recorredor.getSig();
        recorredor.setSig(nuevo);
        nuevo.setSig(aux);
        cont++;
        }
    
    public void imprimeCola(){
        Nodo<T> temp=cabeza.getSig();
        
        while(temp!=null){
            System.out.print(""+temp.toString());
            System.out.print("↓"+"\n");
            temp=temp.getSig();
        }
        System.out.println(""+"null");
    }
    
    public static void main(String[] args){
        myQueue cola=new myQueue();
        
        cola.enQueue('A', 3);
        cola.enQueue('B', 2);
        cola.enQueue('C', 1);
        cola.enQueue('D', 1);
        cola.enQueue('F', 2);
        cola.enQueue('G', 3);
        cola.enQueue('H', 3);
        cola.enQueue('I', 3);
        cola.enQueue('J', 2);
        cola.enQueue('K', 2);
        cola.enQueue('L', 1);
        cola.enQueue('M', 2);
        cola.enQueue('X', -1);
        cola.enQueue('Z', 20);
        cola.imprimeCola();
    }
}
