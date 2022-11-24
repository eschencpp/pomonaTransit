public class Driver {

    private String driver_name;
    private String address;
    private String telephone;

    public Driver() {}
  
    public Driver(String name)
    {
        this.driver_name = name;
    }

    public String getDriver_id() {
        return driver_name;
    }

    public void setDriver_id(String driver_id) {
        this.driver_name = driver_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
