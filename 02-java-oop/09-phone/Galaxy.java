public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        String ringer = getRingTone();
        return ringer;
    }

    @Override
    public String unlock() {
        return "your phone is now unlocked";
    }

    @Override
    public void displayInfo() {
        System.out.println("Galaxy " + getVersionNumber() + " from " + getCarrier());     
    }
}