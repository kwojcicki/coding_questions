package solutions;

public class design_parking_system {
	class ParkingSystem {

	    int[] max;
	    int[] curr;
	    public ParkingSystem(int big, int medium, int small) {
	        max = new int[]{big, medium, small};
	        curr = new int[]{ 0, 0, 0};
	    }
	    
	    public boolean addCar(int carType) {
	        if(curr[carType - 1] == max[carType - 1]) return false;
	        curr[carType - 1]++;
	        return true;
	    }
	}

}
