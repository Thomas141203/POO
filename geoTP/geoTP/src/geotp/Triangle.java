package geotp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

/**
 *
 * @author jo
 */

public class Triangle extends ObjetGeom{
    // le premier sommet
    private Point a;
    /**
     * modifie le premier sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setA(Point p)
    {
        testSommet(p,getB(),getC(),"A");
        this.a = p;
    }
    /**
     * retourne la référence au premier sommet (accesseur en lecture)
     * @return la référence au premier sommet
     */
    public Point getA()
    {
        return this.a;
    }

    // le second sommet
    private Point b;
    /**
     * modifie le deuxième sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setB(Point p)
    {
        testSommet(p,getA(),getC(),"B");
        this.b = p;
    }
    /**
     * retourne la référence au deuxième sommet (accesseur en lecture)
     * @return la référence au deuxième sommet
     */
    public Point getB()
    {
        return this.b;
    }

    // le troisième sommet
    private Point c;
    /**
     * modifie le troisième sommet (accesseur en écriture)
     * @param p le nouveau point pour représenter ce sommet
     */
    public void setC(Point p)
    {
        testSommet(p,getA(),getB(),"C");
        this.c = p;
    }
    /**
     * retourne la référence au troisième sommet (accesseur en lecture)
     * @return la référence au troisième sommet
     */
    public Point getC()
    {
        return this.c;
    }

    private static void testEgalite(Point p,Point autre, String qui)
    {
        if(autre!=null&&p.equals(autre))
            throw new RuntimeException(qui+" est identique à un sommet existant");
        
    }
    private static void testSommet(Point p,Point s1,Point s2,String qui)
    {
        if(p==null)
            throw new RuntimeException("Le sommet "+qui+" n'est pas défini");
        testEgalite(p,s1,qui);
        testEgalite(p,s2,qui);
    }

       
    /**
     * Constructeur du triangle à partir de ses sommets.
     * @param a le premier sommet du triangle
     * @param b le deuxième sommet du triangle
     * @param c le troisième sommet du triangle
     */
    public Triangle(Point a, Point b, Point c, String nom){
        super(nom);
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    /**
     * Constructeur du triangle à partir d'un segment de base et d'un sommet
     * 
     * @param s le segment support du triangle
     * @param p celui des sommets qui ne se situe pas sur le segment
     */
    public Triangle(Segment s,Point p, String nom)
    {
        this(s.getExt1(),s.getExt2(),p, nom);
    }

    /**
     * Constructeur de clonage (à partir d'un autre triangle)
     * @param autre le triangle pris pour modèle
     */
    public Triangle(Triangle autre, String nom)
    {
        // les new permettent de perdre la dépendance entre les triangles… ce qui n'est pas toujours ce que l'on veut
        this((autre.getA()), (autre.getB()), (autre.getC()), nom);
    }

    public Segment getAB()
    {
        return new Segment(this.getA(),this.getB(), "Segment");
    }

    public Segment getAC()
    {
        return new Segment(this.getA(),this.getC(), "Segment");
    }

    public Segment getBC()
    {
        return new Segment(this.getB(),this.getC(), "Segment");
    }

    public double getPerimetre()
    {
        return
                this.getAB().getLongueur()+
                this.getAC().getLongueur()+
                this.getBC().getLongueur();
    }
    /**
     * calcul de l'aire par la formule de Héron
     * @return l'aire du triangle
     */
    public double getAire()
    {
        double la=this.getAB().getLongueur();
        double lb=this.getAC().getLongueur();
        double lc=this.getBC().getLongueur();
        double s=(la+lb+lc)/2;

        return Math.sqrt(s*(s-la)*(s-lb)*(s-lc));
    }

    @Override
    public String toString()
    {
        return super.toString() + "{"+this.getA()+","+this.getB()+","+this.getC()+"}"+"\n"+
                "  Perimetre : "+this.getPerimetre()+"\n"+
                "  Aire : "+this.getAire();
    }
    
    private boolean isEqualStrict(Triangle autre)
    {
        return this.getA().equals(autre.getA()) && this.getBC().equals(autre.getBC());
    }
    /**
     * vérification que les deux triangles sont équivalents à la permutation près de leurs sommets
     * @return un booléen vrai si la condition est remplir
     */
    public boolean equals(Triangle autre){
        return isEqualStrict(autre) || isEqualStrict(new Triangle(autre.getAC(),autre.getB(), "Triangle")) || isEqualStrict(new Triangle(autre.getAB(),autre.getC(), "Triangle"));
    }
}
