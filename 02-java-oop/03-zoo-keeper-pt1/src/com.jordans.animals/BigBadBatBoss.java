public class BigBadBatBoss extends Mammal {
    
    public BigBadBatBoss(int energyLevel){
        super(energyLevel);
    }

    public void fly(){
        System.out.println("The giant bat takes off into flight!");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("OM NOM. YUM!");
        this.energyLevel += 25;
    }
    
    public void attackTown(){
        System.out.println("snap crack pop! The town is on fire!");
        this.energyLevel -= 100;
    }
}
