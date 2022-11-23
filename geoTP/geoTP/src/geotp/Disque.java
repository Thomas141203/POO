package geotp;

import java.lang.*;

public class Disque extends ObjetGeom{

    private Point centre;
    
    public void setCentre(Point centre)
    {
        if(centre==null) throw new RuntimeException("Centre du disque indéfini");
        this.centre = centre;
    }
    public Point getCentre()
    {
        return centre;
    }

    private double rayon;
    public void setRayon(double x)
    {
        if(x<=0) throw new RuntimeException("Le rayon doit être strictement positif");
        this.rayon = x;
    }
    public double getRayon()
    {
        return rayon;
    }

    public Disque(Disque autre, String nom){
        this(autre.getCentre(), autre.getRayon(), nom);
    }
    
    public Disque(Point p, double x, String nom){
        super(nom);
        this.setCentre(p);
        this.setRayon(x);
    }

    public double getPerimetre()
    {
        return 2*Math.PI*this.getRayon();
    }
    
    public void setPerimetre(double x)// acesseur virtuel en écriture
    {
        if(x<=0) throw new RuntimeException("Le diamètre doit être strictement positif");
        setRayon(x/(2*Math.PI));
    }

    public double getAire()
    {
        double rayon=this.getRayon();
        return Math.PI*rayon*rayon;
    }
    public void setAire(double x)// acesseur virtuel en écriture
    {
        if(x<=0) throw new RuntimeException("L'aire doit être strictement positive");
        setRayon(Math.sqrt(x/Math.PI));
    }
   
    // vérifie que le point est sur la surface du disque
    public boolean isSur(Point p)
    {
        if(p==null) throw new RuntimeException("Point non défini");
        return getCentre().getDistance(p)<=getRayon();
        // ou return Point.getDistance(getCentre(),getRayon());
    }
    
    @Override
    public String toString()
    {
        return
                super.toString()+"{"+this.getCentre()+","+this.getRayon()+"}\n"+
                "  Perimetre : "+this.getPerimetre()+"\n"+
                "  Aire : "+this.getAire();
    }

    public boolean equals(Disque autre)
    {
        return this.getRayon()==autre.getRayon() &&
               this.getCentre().equals(autre.getCentre());
        /*
         * ce n'est pas forcément le même point mais un point qui,
         * lui-même, est géométriquement équivalent
         */
    }

}
