
package demineur;

/**
 *
 * @author Thomas
 */

public class Mine extends Case{
    
    public Mine(){
        super(0,0,true);
    }
    
    public String toString(){
        String s="";
        if(this.visible)
            s+="[ * ]";
        else
            if(!this.fini){
                if(this.drapeau)
                    s+="[ O ]";
                else
                    s+="["+(this.position.getX()-1)+":"+(this.position.getY()-1)+"]";
            }else
                s+="[ m ]";
        return s;
    }
}
