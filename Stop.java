public class Stop {
    
    private int stopNumber;
    private String stopAddress;

    public Stop(int stopN, String stopAddr){
        this.stopNumber = stopN;
        this.stopAddress = stopAddr;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public String getStopAddress() {
        return stopAddress;
    }

    public void setStopAddress(String stopAddress) {
        this.stopAddress = stopAddress;
    }
}
