



/**
 *
 * @author Thomas
 */

public class Vide extends Case{

    public Vide(){
        super(0,0,false);
    }

    public String toString(){
        String s = "";
        if(this.visible)
            if(this.nbMine != 0)
                s+="[ "+this.nbMine+" ]";
            else
                s+="[   ]";
        else
            if(this.drapeau)
                s+="[ O ]";
            else
                s+="["+(this.position.getX()-1)+":"+(this.position.getY()-1)+"]";
        return s;
    }
}
