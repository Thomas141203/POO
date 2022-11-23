
package geotp;

public class GeoTP{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Point p1=new Point(0.5,1.5, "Point");
        System.out.println(p1);System.out.println();
        Point p2=new Point(1.5,0.5, "Point");
        System.out.println(p2);System.out.println();
        Segment s=new Segment(new Point(p1, "Point"),p2, "Segment");
        System.out.println(s);System.out.println();
        Disque d1=new Disque(p1,0.5, "Disque");
        System.out.println(d1);System.out.println();
        Disque d2=new Disque(p2,0.5, "Disque");
        System.out.println(d2);System.out.println();
        Triangle t=new Triangle(p1,p2,new Point(0.5,0.5, "Point"), "Triangle");
        System.out.println(t);System.out.println();
    }
}
