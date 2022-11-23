public class Train{
    private int id;
    private Date date;
    private Ligne ligne;
    private Locomotive loco;
    private LesWagons wagons;

    public int getId(){
        return id;
    }

    public Date getDate(){
        return date;
    }

    public Ligne getLigne(){
        return ligne;
    }

    public Locomotive getLoco(){
        return loco;
    }

    public LesWagons getWagons(){
        return wagons;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setLigne(Ligne ligne){
        this.ligne = ligne;
    }

    public void setLoco(Locomotive loco){
        this.loco = loco;
    }

    public void setWagons(LesWagons wagons){
        this.wagons = wagons;
    }
    
}
