package geotp;

public class ObjetGeom{
    protected String nom;

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    
    public ObjetGeom(String s){
        setNom(s);
    }
    
    public String toString(){
        return "" + this.getClass().getSimpleName();
    }
}
