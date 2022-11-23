
package geotp;

public abstract class ObjetPlan extends ObjetGeom{
    public ObjetPlan(String nom){
        super(nom);
    }
    public abstract double getPerimetre();
    public abstract double getAire();

}
