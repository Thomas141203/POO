/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fractions;

/**
 *
 * @author Thomas
 */
public class Fractions {
    private int n;
    private int d;
    
    private void setN(int n){
        this.n = n;
    }
    
    private void setD(int d){
        this.d = d;
    }
    
    public int getN(){
        return this.n;
    }
    
    public int getD(){
        return this.d;
    }
    
    public Fractions(int n, int d){
        setN(n);
        setD(d);
    }
    
    public Fractions(int n){
        this.n = n;
        this.d = 1;
    }
    
    public double getValeur(){
        return this.n/this.d;
    }
    
    public double getFois(int x){
        return x*getValeur();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fractions f1 = new Fractions(8,4);
        System.out.println(f1.getFois(5));
    }
    
}
