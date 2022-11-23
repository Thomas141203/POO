/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Thomas
 */
public class Geometrie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3.5, 2.5);
        Point p3 = new Point(3, 0.5);
        Disque d1 = new Disque(1, p1);
        Disque d2 = new Disque(1, p2);
        Segment s = new Segment(p1, p2);
        System.out.println(s.getLongueur());
    }
}
