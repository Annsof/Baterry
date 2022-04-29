package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
    	int rechargeable=0,nonRechargeable=0;
        for (int i = 0; i < MAX_BATTERIES; i++) {
            if (batteries[i]!=null && batteries[i] instanceof RechargeableBattery) {
                rechargeable++;
            }else if (batteries[i]!=null){
                nonRechargeable++;
            }
        }
        return "The total of:\n   *Traditional batteries: "+nonRechargeable+"\n   *Rechargeable batteries:"+rechargeable;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for (int i = 0; i < MAX_BATTERIES; i++) {
            if (batteries[i]!=null) {
                str+=batteries[i].toString();
            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        int amount=0;
        double costRechargeableBatteries=0;
        for (int i = 0; i < MAX_BATTERIES; i++) {
            if (batteries[i]!=null && batteries[i] instanceof RechargeableBattery) {
                costRechargeableBatteries=((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();
                amount++;
            }
        }
        double average=(costRechargeableBatteries/amount);
		return average;
	}

}
