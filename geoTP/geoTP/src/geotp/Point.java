package geotp;


/**
 * Un point dans l'espace 2D
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 

public class Point extends ObjetGeom{

    // coordonnée horizontale du point dans le repère
    private double absc;
    public double getAbsc(){return absc;}
    public void setAbsc(double x){this.absc=x;}

    // coordonnée verticale du point dans le repère
    private double ord;
    public double getOrd(){return ord;}
    public void setOrd(double x){this.ord=x;}

    public Point(double x,double y, String nom){
        super(nom);
        this.setAbsc(x);
        this.setOrd(y);
    }
    public Point(Point autre, String nom){
        this(autre.getAbsc(),autre.getOrd(),nom);
    }

    public static double getDistance(Point p1,Point p2)
    {
        double dx=p1.getAbsc()-p2.getAbsc();
        double dy=p1.getOrd()-p2.getOrd();
        return Math.sqrt(dx*dx+dy*dy);
    }
    public double getDistance(Point autre)
    {
        return getDistance(this,autre);
    }
    
    public Point getMedian(Point autre)
    {
        return new Point((this.getAbsc()+autre.getAbsc())/2,(this.getOrd()+autre.getOrd())/2, this.getNom());
    }

    @Override
    public String toString()
    {
        return ""+ super.toString() + '{'+this.getAbsc()+","+this.getOrd()+"}";
    }

    public boolean equals(Point autre)
    {
        return this.getAbsc()==autre.getAbsc()&&this.getOrd()==autre.getOrd();
    }
}