
public class ZooKeeperTest {
    public static void main(String[] args) {
        Gorilla harambe = new Gorilla(100);
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
        BigBadBatBoss purplePeopleEater = new BigBadBatBoss(300);
        System.out.println("Purple People Eater:");
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.attackTown();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.attackTown();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.attackTown();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.eatHumans();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.eatHumans();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.fly();
        System.out.println(purplePeopleEater.displayEnergy());
        purplePeopleEater.fly();
        System.out.println(purplePeopleEater.displayEnergy());
    }
    
}
