/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author polo
 */
class MiIteratorLista<T> implements Iterator<T> {
    ArrayList<T> list;
    int pos;
    
    public MiIteratorLista() {
        
    }
    
    public MiIteratorLista(NodoDoble<T> cabeza){
        this.list=new ArrayList();
        
        NodoDoble<T> recor=cabeza.getSig();
        while(recor!=null){
            list.add(recor.getElemento());
            recor=recor.getSig();
        }
        pos=0;
    }

    @Override
    public boolean hasNext() { 
        return pos<list.size();
    }

    @Override
    public T next() {
        T res;
        
        if(!hasNext()){
            throw new Unchecked("No ha siguiente.");
        }
        res=list.get(pos);
        pos++;
        return res;
    }

    @Override
    public void remove() {
        list.remove(pos);
        pos--;
    }
    public static void main(String[] args){
        miListaDoble<Integer> list=new miListaDoble();
        Iterator<Integer> it;
        
        list.inserta(3);
        list.inserta(8);
        list.inserta(1);
        it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        list.inserta(43);
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }   
}
