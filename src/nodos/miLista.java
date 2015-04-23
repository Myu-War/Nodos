package nodos;

import java.util.Stack;

public class miLista<T> {
    Nodo<T> cabeza;
    int cont;
    
    public miLista(){
        cabeza=new Nodo();
        cont=0;
    }
    
    public void imprimeLista(){
        Nodo<T> temp=cabeza.getSig();
        
        while(temp!=null){
            System.out.print(""+temp.toString());
            System.out.print("↓"+"\n");
            temp=temp.getSig();
        }
        System.out.println(""+"null");
    }
    
    public void imprimeR(Nodo<T> actual){
        if(actual!=null){
             System.out.print(actual.getElemento()+"\n↓"+"\n");
             imprimeR(actual.getSig());
        }else{
            System.out.print("null");
        }
    }
    
    public void imprimeInverR(Nodo<T> actual){
        if(actual!=null){
             imprimeR(actual.getSig());
             System.out.print(actual.getElemento()+"->");
        }
    }
    
    public void insertaInicio(T elem){
        Nodo<T> nuevo=new Nodo(elem);
        Nodo<T> temp=cabeza.getSig();
        
        cabeza.setSig(nuevo);
        nuevo.setSig(temp);
        cont++;
    }
    
    public void insertaFinal(T elem){
        Nodo<T> temp=cabeza;
        Nodo<T> nuevo=new Nodo(elem);
        
        while(temp.getSig()!=(null)){
            temp=temp.getSig();
        }
        temp.setSig(nuevo);
        nuevo.setSig(null);
        cont++;
    }
    
    public void insertaFinalR(T elem,Nodo aux){
        if(aux.getSig()==(null)){
            aux.setSig(new Nodo(elem));
            cont++;
            return;
        }
        insertaFinalR(elem,aux.getSig());
    }
    
    public Nodo<T> borrar(T elem){
        Nodo<T> borrar = new Nodo(elem);
        Nodo<T> recorredor=cabeza.getSig();
        
        while(!recorredor.getSig().equals(borrar) && recorredor.getSig()!=(null)){
            recorredor=recorredor.getSig();
        }
        if(recorredor.getSig().equals(null)){
            throw new Unchecked("No esta el objeto buscado.");
        }
        else{
            recorredor.setSig(recorredor.getSig().getSig());
            cont--;
        }
        
        return borrar;
    }
    
    public void insertarI(int num, T elem){//num es la posicion tal cual queremos, para un mortal.
        Nodo<T> recorredor=cabeza.getSig();
        Nodo<T> nuevo=new Nodo(elem);
        
        if(num>cont){
            throw new Unchecked("No existe tal posición.");
        }
        for(int i=0; i<num-2; i++){
            recorredor=recorredor.getSig();
        }
        nuevo.setSig(recorredor.getSig());
        recorredor.setSig(nuevo);
    }
    
    public void invertirLista(){
        Stack<T> s=new Stack();
        Nodo<T> actual=cabeza.getSig();
        
        while(actual!=null){
            s.push(actual.getElemento());
            actual=actual.getSig();
        }
        actual=cabeza.getSig();
        while(!s.isEmpty()){
            actual.setElem(s.pop());
            actual=actual.getSig();
        }
    }
    
    public Nodo<T> invierteR(Nodo<T> actual){
        if(actual.getSig()!=null){
            Nodo<T> temp=invierteR(actual.getSig());
            temp.setSig(actual);
            actual.setSig(null);
        }
        else{
            cabeza.setSig(actual);
        }
        return actual;
    }
    
    public void borrarRep(){
        Nodo<T> actual=cabeza.getSig(),aux,anterior;
        T elem=actual.getElemento();
        
        while(actual.getSig()!=null){
            aux=actual.getSig();
            elem=actual.getElemento();
            anterior=actual;
            while(null!=aux){
                if(aux.getElemento()==elem){
                    anterior.setSig(aux.getSig());  
                    cont--;
                    anterior=anterior.getSig();
                }
                else{
                    anterior=aux;
                    aux=aux.getSig();
                }
            }
            actual=actual.getSig();
        }
    }
    
    public static void main(String[] args){
        miLista list=new miLista();
        
        list.insertaInicio("Hola Mundo");
        list.insertaInicio(3);
        list.invertirLista();
        list.imprimeR(list.cabeza.getSig());
    }
}