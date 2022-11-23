

/**
 *
 * @author Thomas
 */

public class Jeu{
    
    private Plateau plateau;
    private int difficulte;
    private int nbLig;
    private int nbCol;
    private int nbMines;
    private int coupL;
    private int coupC;
    private int cpt;
    private int cptDrap;
    private int drapeau;
    private boolean perdu;
    private boolean fini;
    private boolean drapDispo;
    private String drap;
    
    public Jeu(){
        this.cpt = 1;
        this.drapeau = 0;
        this.perdu = false;
        this.fini = false;
        this.drapDispo = false;
        this.drap = "";
    }
    public void optionsJeu(){
        do{
            System.out.println("Entrez la largeur de votre grille");
            this.nbLig = Lire.i();
        } while(this.nbLig < 0);
        do{
            System.out.println("Entrez la longueur de votre grille");
            this.nbCol = Lire.i();
        }while (this.nbCol < 0);
        do{
            System.out.println("Entrez une difficulté entre 1 et 9");
            this.difficulte = Lire.i();
        }while(this.difficulte < 1 || this.difficulte > 9);
    }
    
    public void initPlateau(){
        this.plateau = new Plateau(this.difficulte, this.nbLig, this.nbCol);
        this.cptDrap = this.plateau.getNbMine();
        this.nbMines = this.plateau.getNbMine();
    }
    
    public static int getColonnes(String s){
        return Integer.parseInt(s.charAt(2)+"");
    }
    
    public static int getLignes(String s){
        return Integer.parseInt(s.charAt(0)+"");
    }
    
    public void jeu(){
        String coup = "";
        System.out.println("Vous devez trouver "+this.nbMines+" mines.");
        System.out.println(this.plateau.toString());     
        do{
            do{
                System.out.println("Veuillez jouer pour le coup "+this.cpt);
                System.out.print("Choix d'une case sous le format <ligne:colonne> : ");
                coup = Lire.S();                
            }while(!this.plateau.verifCoupValide(coup));
            this.coupL = getLignes(coup)+1;
            this.coupC = getColonnes(coup)+1;
            if(!this.plateau.getCase(this.coupL, this.coupC).isDrapeau()){
                do{
                    do{
                        System.out.println("Voulez Vous mettre un drapeau ? (1)OUI  (2)NON");
                        this.drap = Lire.S();
                    }while(!this.plateau.choixDrap(this.drap));
                    this.drapeau = Integer.parseInt(this.drap);
                    if(this.drapeau == 1)
                        if(this.cptDrap>0){
                            this.cptDrap--;
                            this.drapDispo = true;
                        }else{
                            System.out.println("Il n'y a plus de drapeau, le coup à été annulé");
                            this.drapDispo = false;
                            this.cpt--;
                        }
                }while(this.drapeau!=1 && this.drapeau!=2);
                if(this.drapeau == 1){
                    if(this.drapDispo)
                        this.plateau.getCase(this.coupL, this.coupC).setDrapeau(true);
                }else{
                    perdu = this.plateau.getCase(this.coupL, this.coupC).getMine();
                    this.plateau.active(this.plateau.getCase(this.coupL, this.coupC));
                }
            }else{
                this.plateau.getCase(this.coupL, this.coupC).setDrapeau(false);
                this.cptDrap++;
                
            }
            if(this.perdu){
                System.out.println("Vous avez perdu !");
                this.fini = true;
                this.plateau.setFini(this.fini);
                System.out.println(this.plateau.toString());
            }else{
                fini = this.plateau.PartieFinie();
                this.plateau.setFini(this.fini);
                if(this.fini){
                    System.out.println("Vous avez gagné en "+this.cpt+" coups.");
                    System.out.println(this.plateau.toString());
                }else
                    System.out.println(this.plateau.toString());
            }
            this.cpt++;
            
            this.plateau.setFini(true);
            System.out.println(this.plateau.toString());
        }while(!this.fini);
    }
}
