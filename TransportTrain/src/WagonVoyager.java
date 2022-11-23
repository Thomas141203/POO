public class WagonVoyager extends Wagon{
    private int classe;
    private int nbPlace;
    private LesPassagers passagers;

    public int getClasse() {
        return classe;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public LesPassagers getPassagers() {
        return passagers;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setPassagers(LesPassagers passagers) {
        this.passagers = passagers;
    }
    
    
}
