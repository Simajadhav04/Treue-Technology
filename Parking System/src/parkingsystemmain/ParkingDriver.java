package parkingsystemmain;

import java.util.Scanner;

public class ParkingDriver {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parking lot Volume: ");
        int volume = scanner.nextInt();
        scanner.nextLine(); 

        ParkingLot parkingLot = new ParkingLot(volume);

        while (true) {
        	System.out.print("***********************************");
            System.out.println("\n1. Register User");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Search Available Spots");
            System.out.println("4. Confirm Booking");
            System.out.println("5. Exit");
            System.out.println("***********************************");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    parkingLot.registerUser(username, password);
                    System.out.println("User registered successfully.");
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    String parkUsername = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String parkPassword = scanner.nextLine();
                    User parkUser = parkingLot.getUser(parkUsername);
                    
                    if (parkUser != null && parkUser.getPassword().equals(parkPassword)) {
                        System.out.print("Enter Vehicle Number plate: ");
                        String numberPlate = scanner.nextLine();
                        System.out.print("Enter Vehicle type : ");
                        String vehicleType = Vehicle.valueOf(scanner.nextLine().toUpperCase());

                        Vehicle vehicle = new Vehicle(numberPlate, vehicleType);
                        parkingLot.parkVehicle(vehicle, parkUser);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your username: ");
                    String searchUsername = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String searchPassword = scanner.nextLine();
                    User searchUser = parkingLot.getUser(searchUsername);
                    
                    if (searchUser != null && searchUser.getPassword().equals(searchPassword)) {
                        parkingLot.searchSpot(searchUser);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 4:
                    System.out.print("Enter your username: ");
                    String confirmUsername = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String confirmPassword = scanner.nextLine();
                    User confirmUser = parkingLot.getUser(confirmUsername);
                    if (confirmUser != null && confirmUser.getPassword().equals(confirmPassword)) {
                        System.out.print("Enter spot number to confirm booking: ");
                        int spotNumber = scanner.nextInt();
                        scanner.nextLine(); 
                        parkingLot.confirmBooking(confirmUser, spotNumber);
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
	

