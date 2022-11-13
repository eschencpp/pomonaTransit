public class TripOffering {
    private int tripNumber;
    private String date;
    private String scheduledStart;
    private String scheduledArrival;
    private String driverName;
    private int busID;

    public TripOffering(int tripNum, String dateString, String start, String arrivalTime, String driver, int busID){
        this.tripNumber = tripNum;
        this.date = dateString;
        this.scheduledStart = start;
        this.scheduledArrival = arrivalTime;
        this.driverName = driver;
        this.busID = busID;
    }

    public int getTripNumber() {
        return tripNumber;
    }
    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getScheduledStart() {
        return scheduledStart;
    }
    public void setScheduledStart(String scheduledStart) {
        this.scheduledStart = scheduledStart;
    }
    public String getScheduledArrival() {
        return scheduledArrival;
    }
    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public int getBusID() {
        return busID;
    }
    public void setBusID(int busID) {
        this.busID = busID;
    }

}
