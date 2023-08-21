package parkingsystemmain;

public class Vehicle {
	
	private String numberPlate;
	private String vehicleType;
	
	public Vehicle(String numberPlate, String vehicleType) {
		super();
		this.numberPlate = numberPlate;
		this.vehicleType = vehicleType;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType =vehicleType;
	}

	public static String valueOf(String vehicleType) {
		// TODO Auto-generated method stub
		return vehicleType;
	}

	
	

}
