package geotp;


/**
 *
 * @author jo
 */

/**
 * Write a description of class Segment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Segment extends ObjetGeom{

    private Point ext1;
    public Point getExt1(){return this.ext1;}

    public void setExt1(Point p)
    {
        testExtremite(p,getExt2(),"L'extrémité 1");
        this.ext1=p;
    }

    private Point ext2;
    public Point getExt2(){return this.ext2;}

    public void setExt2(Point p)
    {
        testExtremite(p,getExt1(),"L'extrémité 2");
        this.ext2=p;
    }

    /** 
     * Teste un point qui représente une nouvelle valeur pour une extrémité par rapport à l'autre extrémité
     * @param p le point à tester
     * @param autre l'autre extrémité du segment
     */
    private static void testExtremite(Point p,Point autre,String qui)
    {
        if(p==null)
            throw new RuntimeException(qui+" n'est pas définie");
        if(autre!=null&&p.equals(autre))
            throw new RuntimeException(qui+" est identique à l'autre extrémité.");
    }

    /**
     * Constructeur de clonage. Il crée de nouveaux points pour que le segment modèle
     * et le segment courant n'aient plus rien en commun
     * 
     * @param autre le segment qui sert de modèle
     */
    public Segment(Segment autre, String nom){
        this(autre.getExt1(), autre.getExt2(), nom);
    }

    public Segment(Point p1,Point p2, String nom){
        super(nom);
        setExt1(p1);
        setExt2(p2);
    }

    // calcule le milieu du segment comme le point médian entre ses deux extrémités
    public Point getMilieu()
    {
        return getExt1().getMedian(getExt2());
    }

    public double getLongueur()
    {
        return getExt1().getDistance(getExt2());
    }

    public String toString()
    {
        return super.toString() + "{"+this.getExt1()+","+this.getExt2()+"}"+"\n"+
        "  Milieu : "+this.getMilieu()+"\n"+
        "  Longueur : "+this.getLongueur();
    }

    private boolean isEqualStrict(Segment autre){
        return this.getExt1().equals(autre.getExt1())&& this.getExt2().equals(autre.getExt2());
    }

    public boolean equals(Segment autre){
        return isEqualStrict(autre)|| isEqualStrict(new Segment(autre.getExt2(),autre.getExt1(), "Segment"));
    }

}
