
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Disque {
    private Point centre;
    private double rayon;

    public Point getCentre(){
        return this.centre;
    }

    public double getRayon(){
        return this.rayon;
    }

    public void setCentre(Point centre){
        this.centre = centre;
    }

    public void setRayon(double rayon){
        this.rayon = rayon;
    }

    public Disque(double rayon, Point centre) {
        this.centre = centre;
        this.rayon = rayon;
    }
    
    public double perimeter(){
        return 2*Math.PI*this.rayon;
    }
    
    public double aire(){
        return Math.PI*Math.pow(this.rayon, 2);
    }
    
    public boolean isIn(Point p){
        if(p.getDistance(this.centre) < this.rayon)
            return true;
        else 
            return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.centre);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.rayon) ^ (Double.doubleToLongBits(this.rayon) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disque other = (Disque) obj;
        if (Double.doubleToLongBits(this.rayon) != Double.doubleToLongBits(other.rayon)) {
            return false;
        }
        return Objects.equals(this.centre, other.centre);
    }

    @Override
    public String toString() {
        return "Disque{" + "centre=" + centre + ", rayon=" + rayon + '}';
    }
    
}
