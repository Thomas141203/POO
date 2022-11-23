
/**
 * Classe pour gerer une liste d'objets quelconques (chaines, instances de classes construites par l'utilisateur,...)
 * 
 * @author (J.Savelli) 
 * @version (0.0)
 */
public class Liste
{
    // Variable d'instance contenu : un tableau qui reference des objets et qui represente le contenu de la liste (support)
    private Object[] contenu;

    /**
     * renvoie l'élément de rang « rang » de la liste (« rang » commence à 0)
     * @return la reference a une instance de type "Object" 
     */
    public Object getElement(int rang)
    {
        if(rang<0 || rang >= this.getTaille())return null; // renvoie une reference null si le rang ne correspond pas à un élément de la liste
        else return this.contenu[rang]; // renvoie la reference à l'élément cherché
    }

    /**
     * remplace l'élément de rang « rang » de la liste par l'objet référencé en paramètre
     * @param  objet   Nouvel objet a ajouter.
     */
    public void setElement(Object objet,int rang)
    {
        if(rang>=0 && rang < this.getTaille())
            this.contenu[rang]=objet; 
    }
    
    /**
     * renvoie le rang de la première occurrence de l'objet référencé en paramètre (-1 s'il ne fait pas partie de la liste)
     * @return le rang de l'élément désigné
     */
    public int getRang(Object element)
    {
        int i=0,rang=-1;
        while(i<this.getTaille() && rang == -1)
        {
            Object courant=this.getElement(i);
            if(courant!=null)
                if(courant.equals(element)) rang=i;
            i++;
        }
        return rang;
    }    

    /**
     * Ajoute une nouvelle instance de la classe Object en tete de liste
     * 
     * @param  nouveau   Nouvel objet a ajouter.
     */   
    public void ajouteTete(Object nouveau)
    {
        insere(nouveau,0);
    }

    /**
     * Ajoute une nouvelle instance de la classe Object en queue de liste
     * 
     * @param  nouveau   Nouvel objet a ajouter.
     */   
    public void ajouteQueue(Object nouveau)
    {
        insere(nouveau,getTaille());
    }

    /**
     * Insère une nouvelle instance de la classe Object à l'indice « rang »
     * 
     * @param  nouveau Nouvel objet a ajouter.
     * @param  rang Rang que devra avoir l'objet après l'insertion — en décalant les objets qui le suivent
     */   
    public void insere(Object nouveau,int rang)
    {
        if(rang >=0 && rang < this.getTaille()+1) // l'insertion n'est effectuée que si le rang est valide
        {
            Object[] temp=new Object[this.getTaille()+1]; // creation d'un nouveau support pour la liste, comportant un élément de plus
            for(int i=0;i<rang;i++)
                temp[i]=this.contenu[i]; // recopie la partie de l'ancien support jusqu'au rang « rang » non compris dans le nouveau support
            temp[rang]=nouveau;
            for(int i=rang;i<this.getTaille();i++)
                temp[i+1]=this.contenu[i]; // recopie la partie de l'ancien support au delà du rang « rang » dans le nouveau support            
            this.contenu=temp;
        }
    }

    /**
     * Supprime l'élément d'indice « rang »
     * @param  rang Rang de l'élément à supprimer
     */   
    public void supprime(int rang)
    {
        if(rang >=0 && rang < this.getTaille()) // suppression seulement quand le rang est valide
        {
            Object[] temp=new Object[this.getTaille()-1]; // creation d'un nouveau support pour la liste, comportant un élément de moins
            for(int i=0;i<rang;i++)
                temp[i]=this.contenu[i]; // recopie la partie de l'ancien support jusqu'au rang « rang » non compros dans le nouveau support
            for(int i=rang+1;i<this.getTaille();i++)
                temp[i-1]=this.contenu[i]; // recopie la partie de l'ancien support au delà du rang « rang » dans le nouveau support            
            this.contenu=temp;
        }
    }
    
    /**
     * Supprime la première occurrence (éventuelle) de l'élément de la liste qui
     * est équivalent à celui qui est référencé en paramètre
     * 
     * @param  element Objet dont il faut supprimer la première occurrence
     */   
    public void supprime(Object element)
    {
        int i=this.getRang(element);
        if(i!=-1) supprime(i);
    }

    /**
     * Supprime la tête de la liste
     */   
    public void supprimeTete()
    {
        supprime(0);
    }
    
    /**
     * Supprime la queue de la liste
     */   
    public void supprimeQueue()
    {
        supprime(getTaille()-1);
    }
    
    /**
     * indique si la liste est vide ou non
     * 
     * @return  "true" si la liste est vide ; "false" sinon
     */   
    public boolean isVide(){return getTaille()==0;}

    /**
     * renvoie la taille de la liste
     * 
     * @return  le nombre d'elements presents dans la liste
     */   
    public int getTaille()
    {
        return this.contenu.length;
    }

    /**
     * Constructeur des objets de la classe Liste. Uniquement le constructeur par défaut
     */
    public Liste()
    {
        this.contenu=new Object[0];// creation d'une liste vide
    }

    public String toString()
    {
        String affichage="";
        for(int i=0;i<getTaille();i++){affichage=affichage+contenu[i]+"\n";}
        return affichage;
    }
}
