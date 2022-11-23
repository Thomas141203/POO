


/**
 *
 * @author Thomas
 */

public class Plateau {
    private Case[][] cases;
    private int dif;
    private int nbMine;
    private int nblig;
    private int nbcol;
    
    public Plateau(int d, int l, int c){
        this.cases = new Case[l+2][c+2];
        this.nblig = l+2;
        this.nbcol = c+2;
        this.dif = d;
        this.nbMine = ((l*c*d)/10);
        if(this.nbMine == 0)
            this.nbMine = 1;
        initPlateau();
        melange();
        initCases();
    }
    
    public void melange(){
        for(int i=0; i<1000; i++){
            int l1=(int)(Math.random()*(this.nblig-2)+1);
            int c1=(int)(Math.random()*(this.nbcol-2)+1);
            int l2;
            int c2;
            do{
                l2=(int)(Math.random()*(this.nblig-2)+1);
                c2=(int)(Math.random()*(this.nbcol-2)+1);
            }while(l1==l2 && c1==c2);
            
            Case temp=this.cases[l1][c1];          
            this.cases[l1][c1]=this.cases[l2][c2];
            this.cases[l2][c2]=temp;
        }
    }
    
    public void initCases(){
        for(int i=1; i<this.nblig-1; i++)
            for(int j=1; j<this.nbcol-1;j++){
                    this.cases[i][j].position.setX(i);
                    this.cases[i][j].position.setY(j);
                    if(!this.cases[i][j].getMine())
                        this.cases[i][j].setNbMine(getNbMineAutour(this.cases[i][j]));
             
            }
    }
    
    public void initPlateau(){
        int cpt=0;
        for(int i=0; i<this.nblig; i++)
            for(int j=0; j<this.nbcol;j++){
                if(i==0 || i==this.nblig-1 ||j==0 || j==this.nbcol-1)
                    this.cases[i][j]=null;
                else{
                    if(cpt<this.nbMine)
                        this.cases[i][j]=new Mine();
                    else
                        this.cases[i][j]=new Vide();
                    cpt++;
                }
            }
    }
    
    public boolean verifCoupValide(String s){
        boolean valide=false;
        if(s.length()==3){
            String c0=""+s.charAt(0);
            String c1=""+s.charAt(1);
            String c2=""+s.charAt(2);
            int x=Integer.parseInt(c0)+1;
            int y=Integer.parseInt(c2)+1;
            if(x>0 && x<this.nblig-1)
                if(c1.equals(":"))
                    if(y>0 && y<this.nbcol-1)
                        if(!this.cases[x][y].isVisible())
                            valide=true;
        }
        return valide;
    }
    
    
    public String toString(){
        String s="";
        for(int i=1; i<this.nblig-1;i++){
            for(int j=1; j<this.nbcol-1;j++)
                s+=this.cases[i][j].toString();
            s+="\n";
        }
        return s;
    }
    
    public int getNbMineAutour(Case c){
        int cpt=0;
        if(this.cases[c.position.getX()-1][c.position.getY()]!=null)
            if(this.cases[c.position.getX()-1][c.position.getY()].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()-1][c.position.getY()+1]!=null)
            if(this.cases[c.position.getX()-1][c.position.getY()+1].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()][c.position.getY()+1]!=null)
            if(this.cases[c.position.getX()][c.position.getY()+1].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()+1][c.position.getY()+1]!=null)
            if(this.cases[c.position.getX()+1][c.position.getY()+1].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()+1][c.position.getY()]!=null)
            if(this.cases[c.position.getX()+1][c.position.getY()].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()+1][c.position.getY()-1]!=null)
            if(this.cases[c.position.getX()+1][c.position.getY()-1].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()][c.position.getY()-1]!=null)
            if(this.cases[c.position.getX()][c.position.getY()-1].getMine())
                cpt+=1;
        if(this.cases[c.position.getX()-1][c.position.getY()-1]!=null)
            if(this.cases[c.position.getX()-1][c.position.getY()-1].getMine())
                cpt+=1;
    return cpt;
    }
        
    public boolean PartieFinie(){
        boolean fini=true;
        int cptDrap=0;
        for(int i=1; i<this.nblig-1; i++)
            for(int j=1; j<this.nbcol-1;j++)
                if(this.cases[i][j].getMine())
                    if(this.cases[i][j].isDrapeau())
                        cptDrap++;
        if(cptDrap!=this.nbMine){
            for(int i=1; i<this.nblig-1; i++)
                for(int j=1; j<this.nbcol-1;j++)
                    if(!this.cases[i][j].getMine() && !this.cases[i][j].isVisible())
                        fini=this.cases[i][j].isVisible();
        }
        return fini;
    }
    
    public void active(Case c){
        if(!c.isDrapeau()){
            c.setVisible(true);
            if(c.getNbMine()==0){
                if(this.cases[c.position.getX()-1][c.position.getY()]!=null)
                    if(!this.cases[c.position.getX()-1][c.position.getY()].getMine() && !this.cases[c.position.getX()-1][c.position.getY()].isVisible())
                        active(this.cases[c.position.getX()-1][c.position.getY()]);
                if(this.cases[c.position.getX()-1][c.position.getY()+1]!=null)
                    if(!this.cases[c.position.getX()-1][c.position.getY()+1].getMine() && !this.cases[c.position.getX()-1][c.position.getY()+1].isVisible())
                        active(this.cases[c.position.getX()-1][c.position.getY()+1]);
                if(this.cases[c.position.getX()][c.position.getY()+1]!=null)    
                        active(this.cases[c.position.getX()][c.position.getY()+1]);
                if(this.cases[c.position.getX()+1][c.position.getY()+1]!=null)    
                    if(!this.cases[c.position.getX()+1][c.position.getY()+1].getMine() && !this.cases[c.position.getX()+1][c.position.getY()+1].isVisible())
                        active(this.cases[c.position.getX()+1][c.position.getY()+1]);
                if(this.cases[c.position.getX()+1][c.position.getY()]!=null)    
                    if(!this.cases[c.position.getX()+1][c.position.getY()].getMine() && !this.cases[c.position.getX()+1][c.position.getY()].isVisible())
                        active(this.cases[c.position.getX()+1][c.position.getY()]);
                if(this.cases[c.position.getX()+1][c.position.getY()-1]!=null)    
                    if(!this.cases[c.position.getX()+1][c.position.getY()-1].getMine() && !this.cases[c.position.getX()+1][c.position.getY()-1].isVisible())
                        active(this.cases[c.position.getX()+1][c.position.getY()-1]);
                if(this.cases[c.position.getX()][c.position.getY()-1]!=null)    
                    if(!this.cases[c.position.getX()][c.position.getY()-1].getMine() && !this.cases[c.position.getX()][c.position.getY()-1].isVisible())
                        active(this.cases[c.position.getX()][c.position.getY()-1]);
                if(this.cases[c.position.getX()-1][c.position.getY()-1]!=null)    
                    if(!this.cases[c.position.getX()-1][c.position.getY()-1].getMine() && !this.cases[c.position.getX()-1][c.position.getY()-1].isVisible())
                        active(this.cases[c.position.getX()-1][c.position.getY()-1]);             
            }
        }
    }
    
   public boolean choixDrap(String s){
       if(s.length()==1){
           int x=s.charAt(0);
           return (x==49 || x==50);
       }else
           return false;
   }
    
    public void setFini(boolean b){
        for(int i=1; i<this.nblig-1; i++)
            for(int j=1; j<this.nbcol-1;j++)
                this.cases[i][j].setFini(b);
    }
    
    public int getNblig(){
        return nblig;
    }

    public void setNblig(int nblig){
        this.nblig = nblig;
    }

    public int getNbcol(){
        return nbcol;
    }

    public void setNbcol(int nbcol){
        this.nbcol = nbcol;
    }

    public int getNbMine(){
        return nbMine;
    }

    public void setNbMine(int nbMine){
        this.nbMine = nbMine;
    }

    public Case[][] getCases(){
        return cases;
    }

    public void setCases(Case[][] cases){
        this.cases = cases;
    }

    public int getDif(){
        return dif;
    }

    public void setDif(int dif){
        this.dif = dif;
    }
    
    public Case getCase(int l, int c){
        return this.cases[l][c];
    }
    
    public void setCase(int l, int c, Case ca){
        this.cases[l][c]=ca;
    }
}
