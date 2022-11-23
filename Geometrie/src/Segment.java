
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thomas
 */
public class Segment {
    private Point ext1;
    private Point ext2;

    public Point getExt1(){
        return this.ext1;
    }

    public Point getExt2(){
        return this.ext2;
    }

    public void setExt1(Point ext1){
        this.ext1 = ext1;
    }

    public void setExt2(Point ext2){
        this.ext2 = ext2;
    }

    public Segment(Point ext1, Point ext2) {
        this.ext1 = ext1;
        this.ext2 = ext2;
    }

    public double getLongueur(){
        return this.ext1.getDistance(this.ext2);
    } 
    
    public double getMiddle(){
        return getLongueur()/2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ext1);
        hash = 97 * hash + Objects.hashCode(this.ext2);
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
        final Segment other = (Segment) obj;
        if (!Objects.equals(this.ext1, other.ext1)) {
            return false;
        }
        if (!Objects.equals(this.ext2, other.ext2)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Segment[" + "ext1=" + ext1 + ", ext2=" + ext2 + ']';
    }
    
    
}
