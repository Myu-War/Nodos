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
public interface Queue<T> {
    
    public void enQueue(T elem, int prio);
    
    public Nodo<T> deQueue();
    
    public T peek();
    
    public boolean isEmpty();
    
}
