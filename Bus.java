public class Bus {
    private String bus_id;
    private String plate;
    private String year;
    private String make;
  
    public Bus() {}
  
    public Bus(String busid)
    {
        this.bus_id = busid;
    }
  
    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
