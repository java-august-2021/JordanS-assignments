
public class Mammal {

    protected int energyLevel;

    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public Mammal(){
        this.energyLevel = 100;
    }

    public int getEnergyLevel(){
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public int displayEnergy(){
        return this.energyLevel;
    }
}