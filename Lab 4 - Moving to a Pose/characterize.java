import lejos.hardware.motor.*;
import lejos.utility.Delay;
import lejos.hardware.Button;
import lejos.hardware.lcd.*;

public class Characterize {
	public static void main(String[] args) {
		boolean finish = false;
		while (!finish) {
			while (!Button.ENTER.isDown()) {
			}
			Motor.C.setSpeed(240);
			Motor.B.setSpeed(240);
			//Motor.C.rotate(698,true);
			//Motor.B.rotate(-698);
			point_to_point();
			
			while (!Button.ENTER.isDown()) {
				if (Button.UP.isDown()) {
					finish = true;
				}
			}
		}
	}
	
	public static void point_to_point() {
		//start from [0 0 0] and move to [200cm 50cm 135 degrees]
		Motor.C.rotate(25,true);
		Motor.B.rotate(-25);
		Motor.C.rotate(4390,true);
		Motor.B.rotate(4390);
		Motor.C.rotate(235,true);
		Motor.B.rotate(-235);
	}
}
//16.65cm
//16.95
//17.05
//Avg_distance = 16.88cm/360 degree rotation
//Avg_rotation = 698 degrees for a full pivot rotation