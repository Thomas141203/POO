
package demineur;


/**
 *
 * @author Thomas
 */

public abstract class Case{
    protected boolean mine;
    protected boolean visible;
    protected boolean drapeau;
    protected boolean fini;
    protected Position position;
    protected int nbMine;
   
    public boolean isDrapeau() {
        return this.drapeau;
    }

    public void setDrapeau(boolean drapeau) {
        this.drapeau = drapeau;
    }

    public int getNbMine() {
        return nbMine;
    }

    public void setNbMine(int nbMine) {
        this.nbMine = nbMine;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    
    public boolean getMine(){
        return this.mine;
    }
    public void setMine(boolean b){
        this.mine=b;
    }
    
    public Case(int x, int y, boolean b){
        this.position = new Position(x, y);
        this.mine=b;
        this.visible=false;
        this.drapeau=false;
        this.fini=false;
    }

    public boolean isFini() {
        return fini;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }
    
    public abstract String toString();
}
