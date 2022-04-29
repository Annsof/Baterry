package model;

public class RechargeableBattery extends Battery implements Irechargeable{

    public static final char BATTERY_LITIO = 'l';
    public static final char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_NIQUEL_CADIO=0.8;
    public final static double FACTOR_LITIO=0.92;
    private char type;
    private int chargerNumber;

    public char getType() {
        return this.type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getChargerNumber() {
        return this.chargerNumber;
    }

    public void setChargerNumber(int chargerNumber) {
        this.chargerNumber = chargerNumber;
    }

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){
        super(name, voltage, cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type=type;
    }
    @Override
    public double calculateUsefulLifeCost(){
        double out=0;
        if (type=='l'){
        out=((super.getCost()*super.getVoltage()*super.getCapacity())/(1000*chargerNumber*FACTOR_LITIO));
        } else if (type=='n'){
        out=((super.getCost()*super.getVoltage()*super.getCapacity())/(1000*chargerNumber*FACTOR_NIQUEL_CADIO));
        }
        return out;
    }
    @Override
    public String toString(){
        return "\nRechargeable battery\nName: "+super.getName()+"\nLifetime cost: "+calculateUsefulLifeCost()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}