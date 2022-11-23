
/**
 * Représente le modèle d'un polynome sous forme d'une suite de termes non nuls maintenus ordonnés par puissances croissantes.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Polynome
{
    private Liste contenu=new Liste();


    private Terme getTerme(int rang)
    {
        return (Terme)contenu.getElement(rang);
    }

    private double getCoefficient(int puissance,int rangMin, int rangMax) // recherche dichotomique du rang correspondant à une puissance et restitution de son coefficient
    {
        int rangMedian=(rangMin+rangMax)/2;
        Terme termeMedian=getTerme(rangMedian);
        if(rangMin==rangMax)
            if(puissance==termeMedian.getPuissance())
                return termeMedian.getCoefficient(); // le terme correspondant à la puissance cherchée est trouvé ; on restitue son coefficient
            else
                return 0.0; // la puissance cherchée n'est pas dans le polynome ; son coefficient est nul
        else
            if(puissance<=termeMedian.getPuissance())
                return getCoefficient(puissance,rangMin,rangMedian); // la puissance cherchée est inférieure à la puissance médiane, on cherche avant
            else
                return getCoefficient(puissance,rangMedian+1,rangMax); // la puissance cherchée est supérieure à la puissance médiane, on cherche après
    }
    
    public double getCoefficient(int puissance)
    {
        if(getTaille()==0) return 0;
        else return getCoefficient(puissance,0,getTaille()-1);
    }
    
    public double getValeur(double x)
    {
        double valeurTotale=0;
        for(int i=0;i<getTaille();i++)valeurTotale=valeurTotale+getTerme(i).getValeur(x);
        return valeurTotale;
    }

    private int getTaille()
    {
        return contenu.getTaille();
    }

    public void plus(Terme t)
    {
        if(t!=null)
            if(t.getCoefficient()!=0)
            {
                int puissance=t.getPuissance();
                int i=getTaille()-1;
                boolean traite=false;
                Terme courant=null;
                while(i>=0 && !traite)
                {
                    courant=getTerme(i);
                    int puissanceCourante=courant.getPuissance();
                    if(puissance>puissanceCourante) // insertion juste après
                    {
                        contenu.insere(t,i+1);
                        traite=true;
                    }
                    else
                    if(puissance==puissanceCourante) // fusion avec le terme courant
                    {
                        double nouveauCoefficient = courant.getCoefficient()+t.getCoefficient();
                        if(nouveauCoefficient==0.0) contenu.supprime(i); // suppression du terme s'il vaut 0
                        else courant.setCoefficient(nouveauCoefficient);
                        traite=true;
                    }
                    else i--;
                }
                if(!traite) contenu.insere(t,0); // insertion au début si pas d'insertion possible avant
            }
    }

    public Polynome getPlus(Polynome autre)
    {
        Polynome resultat = new Polynome();
        for(int i=0;i<this.getTaille();i++) resultat.plus(this.getTerme(i));
        for(int i=0;i<autre.getTaille();i++) resultat.plus(autre.getTerme(i));
        return resultat;
    }

    public Polynome getFois(double facteur)
    {
        Polynome resultat = new Polynome();
        for(int i=0;i<this.getTaille();i++) resultat.plus(this.getTerme(i).getFois(facteur));
        return resultat;
    }

    public Polynome getFois(Polynome autre)
    {
        Polynome resultat = new Polynome();
        for(int i=0;i<this.getTaille();i++)
            for(int j=0;j<autre.getTaille();j++)
                resultat.plus(this.getTerme(i).getFois(autre.getTerme(j)));
        return resultat;
    }

    public Polynome() // crée le polynôme nul
    {
        this.contenu=new Liste();
    }

    public String toString()
    {
        String affichage="";
        for(int i=contenu.getTaille()-1;i>=0;i--)
        {
            affichage=affichage+getTerme(i);
        }
        if(affichage.equals(""))affichage="0";
        return affichage;
    }
}
