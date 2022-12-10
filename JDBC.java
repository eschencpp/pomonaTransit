import java.sql.SQLException;
import java.util.Scanner;


public class JDBC {
    private static String mainMenu = "Welcome to Pomona Transit System\nSelect an option (1-8) \n1. Find Trip Schedules \n2. Edit Trip Offerings"
        +"\n3. Display trip stops\n4. Display Driver schedule\n5. Add a driver\n6. Add a bus\n7. Delete a bus\n8. Add Actual Trip Stop Info\n9. Exit Program";
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String option = "";
        while(!option.equals("9")){
            System.out.println(mainMenu);
            System.out.println("Choose your option: ");
            option = sc.next();
            switch (option) {
                case "1":
                    displayTripSchedules();
                    break;
                case "2":
                    System.out.println("Editing Trip Offer: ");
                    editTripOffer();
                    break;
                case "3":
                    showTripStops();
                    break;
                case "4":
                    showDriverSchedule();
                    break;
                case "5":
                    addDriver();
                    break;
                case "6":
                    addBus();
                    break;
                case "7":
                    deleteBus();
                    break;
                case "8":
                    addActualTripStopInfo();
                    break;
                case "9":
                    System.out.println("Program exiting.");
                    return;
                default:
                    System.out.println("Error invalid input. Try again.");
                    break;
            }
            if(returnToMenu() == 0){
                System.out.println("Program Exiting.");
                return;
            }
        }
    }

    private static void displayTripSchedules(){
        TripOfferingDao t = new TripOfferingDao();
        System.out.println("Please enter your trip query: ");
        String starta = sc.nextLine();
        System.out.println("Enter a starting location: ");
        String startL = sc.nextLine();
        System.out.println("Enter a destination: ");
        String dest = sc.nextLine();
        System.out.println("Enter a date: (YYYY-MM-DD)");
        String date = sc.nextLine();
        try {
            t.showOfferings(startL, dest, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editTripOffer(){
        System.out.println("Choose an option:\n1. Delete trip offering\n2. Add trip offering\n3. Change driver\n4. Change bus");
        TripOfferingDao tr = new TripOfferingDao();
        int option = sc.nextInt();
        int tripNumber;
        String date;
        String startTime;
        switch (option) {
            case 1: // Deleting a trip offering
                System.out.println("Deleting trip offering");
                System.out.println("Enter a trip number: ");
                tripNumber = sc.nextInt();
                System.out.println("Enter a date: (YYYY-MM-DD) ");
                date = sc.next();
                System.out.println("Enter a start time: ");
                startTime = sc.next();
                try {
                    tr.delete(tripNumber, date, startTime);
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                }
                break;
            case 2: //Adding a trip offering
                System.out.println("Adding trip offering");
                boolean flag = true;
                while(flag == true){
                    System.out.println("Enter a trip number: ");
                    tripNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter a date: (YYYY-MM-DD)");
                    date = sc.nextLine();
                    System.out.println("Enter the schedueled start time: ");
                    startTime = sc.nextLine();
                    System.out.println("Enter the schedueled arrival time: ");
                    String arrivalTime = sc.nextLine();
                    System.out.println("Enter the driver name: ");
                    String driver = sc.nextLine();
                    System.out.println("Enter the bus ID: ");
                    int busID = sc.nextInt();
                    TripOffering t = new TripOffering(tripNumber, date, startTime, arrivalTime, driver, busID);
                    try {
                        tr.add(t);
                        System.out.println("Trip offering added successfully");
                    } catch (SQLException e) {
                        System.out.println("Error. Offering could not be added.");
                        e.printStackTrace();
                        break;
                    }
                    sc.nextLine();
                    System.out.println("Would you like to add another trip offering?");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if(userAnswer.equals("y") || userAnswer.equals("yes")){
                        System.out.println("Adding another trip offering: ");
                    }else{
                        flag = false;
                    }
                }
                
                break;
            case 3: //Edit a driver
                System.out.println("Editing driver.");
                System.out.println("Enter a trip number: ");
                tripNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter a date: (YYYY-MM-DD) ");
                date = sc.nextLine();
                System.out.println("Enter a start time: ");
                startTime = sc.nextLine();
                System.out.println("Enter a the new driver name: ");
                String driverName = sc.nextLine();
                try {
                    tr.updateDriver(driverName, tripNumber, date, startTime);
                    System.out.println("Successfully updated driver.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                }
                break;

            case 4: //Edit bus
                System.out.println("Editing bus ID.");
                System.out.println("Enter a trip number: ");
                tripNumber = sc.nextInt();
                System.out.println("Enter a date: (YYYY-MM-DD) ");
                date = sc.next();
                System.out.println("Enter a start time: ");
                startTime = sc.next();
                System.out.println("Enter a the new bus ID: ");
                int bus = sc.nextInt();
                try {
                    tr.updateBus(bus, tripNumber, date, startTime);
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                }
                break;
            default:
                break;
        }


    }

    //Option 3
    private static void showTripStops(){
        TripOfferingDao t = new TripOfferingDao();
        System.out.println("Displaying trip stops");
        System.out.println("Enter the trip ID: ");
        int tripID = sc.nextInt();
        try {
            t.displayStops(tripID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Option 4
    private static void showDriverSchedule(){
        DriverDao d = new DriverDao();
        System.out.println("Displaying driver weekly schedule");
        System.out.println("Enter driver name: ");
        String driverName = sc.next();
        System.out.println("Enter date");
        String date = sc.next();
        try {
            d.showSchedule(driverName, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Option 5
    private static void addDriver(){
        DriverDao dr = new DriverDao();
        System.out.println("Adding a driver");
        System.out.println("Please enter the driver name: ");
        String driverName = sc.next();
        System.out.println("Enter the telephone number: ");
        String phoneNo = sc.next();
        Driver driver = new Driver(driverName);
        driver.setTelephone(phoneNo);

        try {
            dr.add(driver);
            System.out.println("Driver successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBus(){
        BusDao busDao = new BusDao();
        System.out.println("Adding a bus");
        System.out.println("Enter bus ID: ");
        String busid = sc.next();
        Bus bus = new Bus(busid);
        System.out.println("Enter plate");
        String plate = sc.next();
        bus.setPlate(plate);
        System.out.println("Enter year");
        String year = sc.next();
        bus.setYear(year);
        System.out.println("Enter make");
        String make = sc.next();
        bus.setMake(make);

        try {
            busDao.add(bus);
            System.out.println("Bus successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteBus(){
        BusDao busDao = new BusDao();
        System.out.println("Deleting bus");
        System.out.println("Enter Bus ID: ");
        String busid = sc.next();
        try {
            busDao.delete(busid);
            System.out.println("Deletion successful");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
    private static void addActualTripStopInfo(){
        ActualTripStopInfoDao ac = new ActualTripStopInfoDao();
        System.out.println("Adding actual trip stop info");

        System.out.println("Enter trip number: ");
        int tripN = sc.nextInt();
        System.out.println("Enter date: (YYYY-MM-DD) ");
        String date = sc.next();
        System.out.println("Enter start time: ");
        String startTime = sc.next();
        System.out.println("Enter stop number: ");
        int stopN = sc.nextInt();

        ActualTripStopInfo a = new ActualTripStopInfo(tripN, date, startTime, stopN);
        
        try {
            ac.add(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Ask for additional info
        System.out.println("Enter Scheduled Arrival Time: ");
        String ScheduledArrivalTime = sc.next();
        System.out.println("Enter Actual Start Time: ");
        String ActualStartTime = sc.next();
        System.out.println("Enter Actual Arrival Time: ");
        String ActualArrivalTime = sc.next(); 
        System.out.println("Enter Number of passengers in: ");
        int NumberOfPassengerIn = sc.nextInt();
        System.out.println("Enter Number of passengers out: ");
        int NumPassengerOut = sc.nextInt();

        a.setScheduledArrivalTime(ScheduledArrivalTime);
        a.setActualStartTime(ActualStartTime);
        a.setActualArrivalTime(ActualArrivalTime);
        a.setNumberOfPassengerIn(NumberOfPassengerIn);
        a.setNumPassengerOut(NumPassengerOut);

        try {
            ac.updateActualTripStopInfo(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int returnToMenu(){
        System.out.println("Would you like to return to the main menu? (Y/N)");

        String choice = sc.next().toLowerCase();

        int flag = 0;
        while(flag == 0){
            switch (choice) {
                case "y":
                    return 1;
                case "yes":
                    return 1;
                case "n":
                    return 0;
                case "no":
                    return 0;
                default:
                    flag = 1;
                    System.out.println("Invalid input. Please enter Y or N");
                    break;
            }
        }

        return 0;
    }
}

