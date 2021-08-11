
public class Gorilla extends Mammal {

    public Gorilla(int energyLevel){
        super(energyLevel);
    }

    public void throwSomething(){
        System.out.println("The gorilla just threw something!");
        this.energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("The gorilla just ate a banana.");
        this.energyLevel += 10;
    }

    public void climb(){
        System.out.println("The gorilla just climbed a tree!");
        this.energyLevel -= 10;
    }

}

