package nodos;

import java.util.Iterator;
import java.util.Stack;

public class miListaDoble/*ordenada*/<T extends Comparable > implements Iterable<T>{
    NodoDoble<T> cabeza;
    int cont;
    
    public miListaDoble(){
        cabeza=new NodoDoble();
        cont=0;
    }
    
    public void imprimeLista(){
        NodoDoble<T> temp=cabeza.getSig();
        
        while(temp!=null){
            System.out.print(""+temp.toString());
            System.out.print("↓"+"\n");
            temp=temp.getSig();
        }
        System.out.println(""+"null");
    }
    
    public void inserta(T elem){
        NodoDoble<T> nuevo=new NodoDoble(elem);
        NodoDoble<T> actual=cabeza.getSig();
        if(elem==null){
            return;
        }
        NodoDoble<T> temp=cabeza;
        
        while(actual!= null && elem.compareTo(actual.getElemento())<0){//elem.ct(actual.getElem)
            temp=actual;
            actual=actual.getSig();
        }
        nuevo.setSig(actual);
        nuevo.setAnt(temp);
        temp.setSig(nuevo);
        if(actual!=null){
            actual.setAnt(nuevo);
        }
        cont++;
    }
    
    public void borrar(T elem){
        NodoDoble<T> actual=buscaprivado(elem);
        if(actual==null){
            return;
        }
        NodoDoble<T> temp=actual.getAnt();
        
        temp.setSig(actual.getSig());
        temp.getSig().setAnt(temp);
        cont--;
    }
    
    public T busca (T elem){
        NodoDoble<T> temp=buscaprivado(elem);
        if(temp==null){
            throw new Unchecked("No esta el objeto buscado.");
        }
        return temp.getElemento();
    }

    private NodoDoble<T> buscaprivado(T elem){
        NodoDoble<T> actual=cabeza.getSig();
        
        if(elem==null){
            return null;
        }
        while(!actual.getElemento().equals(elem) && actual!=(null)){
            actual=actual.getSig();
        }
        return actual;
    }
    
    public static void main(String[] args){
        miListaDoble list=new miListaDoble();
        
        list.inserta("Hola Mundo");
        list.imprimeLista();
        list.inserta(8);
        list.imprimeLista();
        list.inserta(3);
        list.inserta('g');
        list.inserta(10);
        list.imprimeLista();
    }

    @Override   
    public Iterator<T> iterator() {
        return new MiIteratorLista(cabeza);
    }
}