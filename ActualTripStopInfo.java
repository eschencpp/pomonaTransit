public class ActualTripStopInfo {
    private int TripNumber; 
    private String Date;
    private String ScheduledStartTime; 
    private int StopNumber;
    private String ScheduledArrivalTime;
    
    private String ActualStartTime;
    private String ActualArrivalTime;
    private int NumberOfPassengerIn;
    private int NumPassengerOut;

    public ActualTripStopInfo(int tripN, String date, String start, int StopN){
        TripNumber = tripN;
        Date = date;
        ScheduledStartTime = start;
        StopNumber = StopN;
    }

    public int getTripNumber() {
        return TripNumber;
    }
    public void setTripNumber(int tripNumber) {
        TripNumber = tripNumber;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
    public String getScheduledStartTime() {
        return ScheduledStartTime;
    }
    public void setScheduledStartTime(String scheduledStartTime) {
        ScheduledStartTime = scheduledStartTime;
    }
    public int getStopNumber() {
        return StopNumber;
    }
    public void setStopNumber(int stopNumber) {
        StopNumber = stopNumber;
    }
    public String getScheduledArrivalTime() {
        return ScheduledArrivalTime;
    }

    public void setScheduledArrivalTime(String scheduledArrivalTime) {
        ScheduledArrivalTime = scheduledArrivalTime;
    }

    public String getActualStartTime() {
        return ActualStartTime;
    }

    public void setActualStartTime(String actualStartTime) {
        ActualStartTime = actualStartTime;
    }

    public String getActualArrivalTime() {
        return ActualArrivalTime;
    }

    public void setActualArrivalTime(String actualArrivalTime) {
        ActualArrivalTime = actualArrivalTime;
    }

    public int getNumberOfPassengerIn() {
        return NumberOfPassengerIn;
    }

    public void setNumberOfPassengerIn(int numberOfPassengerIn) {
        NumberOfPassengerIn = numberOfPassengerIn;
    }

    public int getNumPassengerOut() {
        return NumPassengerOut;
    }

    public void setNumPassengerOut(int numPassengerOut) {
        NumPassengerOut = numPassengerOut;
    }

}
