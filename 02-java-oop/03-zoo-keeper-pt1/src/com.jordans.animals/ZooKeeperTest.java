
public class ZooKeeperTest {
    public static void main(String[] args) {
        Mammal whale = new Mammal();
        System.out.println();

        Gorilla harambe = new Gorilla();
        System.out.println(harambe.displayEnergy());
        harambe.throwSomething();
        System.out.println(harambe.displayEnergy());
        harambe.throwSomething();
        System.out.println(harambe.displayEnergy());
        harambe.throwSomething();
        System.out.println(harambe.displayEnergy());
        harambe.eatBananas();
        System.out.println(harambe.displayEnergy());
        harambe.eatBananas();
        System.out.println(harambe.displayEnergy());
        harambe.climb();
        System.out.println(harambe.displayEnergy());
    }
    
}
