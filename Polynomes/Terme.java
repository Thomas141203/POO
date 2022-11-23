
/**
 * Write a description of class Terme here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terme
{
    private double coefficient;
    public double getCoefficient(){return this.coefficient;}
    public void setCoefficient(double nCoeff){this.coefficient=nCoeff;}
    
    private int puissance;
    public int getPuissance(){return this.puissance;}
    public void setPuissance(int nPuiss){this.puissance=nPuiss;}
    
    public double getValeur(double x){return getCoefficient()*Math.pow(x,getPuissance());}
        
    public Terme getFois(double facteur)
    {
        return new Terme(this.getCoefficient()*facteur,this.getPuissance());
    }
    
    public Terme getFois(Terme autre)
    {
        return new Terme(
                            this.getCoefficient()*autre.getCoefficient(),
                            this.getPuissance()+autre.getPuissance()
                        );
    }
    
    public Terme(double coefficient,int puissance)
    {
        this.setCoefficient(coefficient);
        this.setPuissance(puissance);
    }
    public Terme(double coefficient)
    {
        this(coefficient,0);
    }
    
    public String toString()
    {
        char signe;
        if(getCoefficient()<0) signe = '-';
        else signe = '+';
        
        double coeff=Math.abs(getCoefficient());
        String coeffChaine;
        if(coeff==1) coeffChaine="";
        else
            if(coeff==(int)coeff) coeffChaine=""+(int)coeff;
            else coeffChaine=""+coeff;
        
        String puissChaine; 
        int puiss=getPuissance();
        if(puiss==0) puissChaine="";
        else if(puiss==1) puissChaine="x";
        else puissChaine="x^"+puiss;
        
        if(coeffChaine.equals("")&&puissChaine.equals("")) coeffChaine="1";

        return ""+signe+coeffChaine+puissChaine;
    }
}
