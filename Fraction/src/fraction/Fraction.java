/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fraction;

/**
 *
 * @author tm325716
 */
public class Fraction {
    private int n;
    private int d;
    
    public int getN(){
        return this.n;
    }
    
    public int getD(){
        return this.d;
    }
    
    private void setN(int n){
        if(d < 0)
            this.n = -n;
        else
            this.n = n;
    }
    
    private void setD(int d){
        if(d != 0)
            this.d = d;
        else
            System.out.println("Bah nan !");
    }
    
    public Fraction(int n, int d){
        setN(n);
        setD(d);
    }
    
    public Fraction(int n){
        this(n, 1);
    }
    
    public Fraction(Fraction n){
        setN(n.getN());
        setD(n.getD());
    }
    
    public double getValeur(){
        return (double)this.n/(double)this.d;
    }
    
    public double getFois(int x){
        return x*getValeur();
    }
    
    public double getPlus(Fraction n){
        return getValeur()+n.getValeur(); 
    }
    
    public double getMoins(Fraction n){
        return getValeur()-n.getValeur();
    }
    
    public double getInverse(){
        return 1/getValeur();
    }
    
    public static int getPgcd(int a, int b){
        int r, t;
        if ( b>a) {
            t = a;
            a = b;
            b = t;
        }
        do {
            r = a % b;
            a = b;
            b = r;
        } while(r !=0);
        return a; 
    }
    
    public int getSimplification(Fraction f){
        f.setN(f.getN()/getPgcd(this.n, this.d));
        f.setD(f.getD()/getPgcd(this.n, this.d));
        return f.getN()/f.getD();
    }
    
    public String toString(){
        if(this.d == 1)
            return ""+this.n;
        if(this.n == 0)
            return "0";
        
        return "";
    }
    
    public boolean equals(Fraction f){
        if(this.n == f.getN() && this.d == f.getD())
            return true;
        else
            return false;
    }
    
    public static void main(String[] args){
        // TODO code application logic here
    }
    
}
