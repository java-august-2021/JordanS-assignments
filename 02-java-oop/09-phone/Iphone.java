public class Iphone extends Phone implements Ringable {
    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring(){
        String ringtone = getRingTone();
        return ringtone;
    }

    @Override
    public String unlock(){
        return "Welcome to iPhone";
    }

    @Override
    public void displayInfo(){
        System.out.println("iPhone " + getVersionNumber() + " from " + getCarrier());
    }

}
