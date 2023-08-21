package parkingsystemmain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot{
	
	 private List<ParkingSpot> spots;
	 private Map<String, User> users;
	 
	    public ParkingLot(int volume) {
	    	
	        spots = new ArrayList<>();
	        
	        for (int i = 0; i < volume; i++) {
	            spots.add(new ParkingSpot(i + 1));
	        }
	        users=new HashMap<>();
	    }
	    
	    public void registerUser(String username, String password) {
	        users.put(username, new User(username, password));
	    }

	    public User getUser(String username) {
	        return users.get(username);
	    }

	    public boolean parkVehicle(Vehicle vehicle,User user) {
	        for (ParkingSpot spot : spots) {
	            if (!spot.isOccupied() && !spot.isBooked()) {
	                spot.parkVehicle(vehicle);
	                spot.book();
	                System.out.println("Vehicle parked successfully in spot " + spot.getSpotNumber());
	                return true;
	            }
	        }
	        System.out.println("No available spots.");
	        return false;
	    }
	    
	    public void searchSpot(User user) {
	        for (ParkingSpot spot : spots) {
	            if (!spot.isOccupied() && !spot.isBooked()) {
	                System.out.println("Spot " + spot.getSpotNumber() + " is available.");
	            }
	        }
	    }
	    
	
	    
	    public void confirmBooking(User user, int spotNumber) {
	        ParkingSpot spot = spots.get(spotNumber - 1);
	        if (!spot.isOccupied() && !user.equals(spot)) {
	            spot.unbook();
	            System.out.println("Booking confirmed for spot " + spot.getSpotNumber());
	        } else {
	            System.out.println("Spot " + spot.getSpotNumber() + " is not available for confirmation.");
	        }
	    }
	

	    public void removeVehicle(Vehicle vehicle) {
	        for (ParkingSpot spot : spots) {
	            if (spot.isOccupied() && spot.getParkedVehicle().equals(vehicle)) {
	                spot.removeVehicle();
	                break;
	            }
	        }
	    }

	    public void displayParkingStatus() {
	        for (ParkingSpot spot : spots) {
	            if (spot.isOccupied()) {
	                System.out.println("Spot " + spot.getSpotNumber() + ": Occupied by " + spot.getParkedVehicle().getNumberPlate());
	            } else {
	                System.out.println("Spot " + spot.getSpotNumber() + ": Vacant");
	            }
	        }
	    }
	}


