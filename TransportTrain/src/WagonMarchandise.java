public class WagonMarchandise extends Wagon{
    private double masseMax;
    private double masseMarchandise;
    private String texteDescriptif;

    public double getMasseMax(){
        return this.masseMax;
    }

    public double getMasseMarchandise(){
        return this.masseMarchandise;
    }

    public String getTexteDescriptif(){
        return this.texteDescriptif;
    }

    public void setMasseMax(double masseMax){
        this.masseMax = masseMax;
    }

    public void setMasseMarchandise(double masseMarchandise){
        this.masseMarchandise = masseMarchandise;
    }

    public void setTexteDescriptif(String texteDescriptif){
        this.texteDescriptif = texteDescriptif;
    }
    
    
}
