/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stackadt;

/**
 *
 * @author introduccion02
 */
public class Unchecked extends RuntimeException{

    /**
     * Creates a new instance of
     * <code>Unchecked</code> without detail message.
     */
    public Unchecked() {
    }

    /**
     * Constructs an instance of
     * <code>Unchecked</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public Unchecked(String msg) {
        super(msg);
    }
}