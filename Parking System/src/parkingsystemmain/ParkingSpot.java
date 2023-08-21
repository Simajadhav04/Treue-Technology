package parkingsystemmain;

public class ParkingSpot {
	
	private int spotNumber;
	private Vehicle parkedVehicle;
	private boolean booked;
	
	public ParkingSpot(int spotNumber) {
		
		this.spotNumber=spotNumber;
		this.parkedVehicle = null;
		this.booked=false;
	
	}
	
	 public boolean isOccupied() {
	        return parkedVehicle != null;
	    }

	    public void parkVehicle(Vehicle vehicle) {
	        parkedVehicle =vehicle;
	    }
	    public boolean isBooked() {
	    	return booked;
	    }
	    public void book() {
	    	 booked=true;
	    }
	    public void unbook() {
	        booked = false;
	    }

	    public void removeVehicle() {
	        parkedVehicle = null;
	    }

	    public Vehicle getParkedVehicle() {
	        return parkedVehicle;
	    }

		public int getSpotNumber() {
			return spotNumber;
		}

		public void setSpotNumber(int spotNumber) {
			this.spotNumber = spotNumber;
		}

		
	}

	


