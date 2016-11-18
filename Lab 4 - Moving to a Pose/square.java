import lejos.hardware.motor.*;
import lejos.utility.Delay;
import lejos.hardware.Button;
import lejos.hardware.lcd.*;

public class square {
	public static void main(String[] args) {
		boolean finish = false;	
		while (!finish) {
			msg_given = false;
			
			while (!Button.ENTER.isDown()) {
			}
			Motor.C.setSpeed(240);
			Motor.B.setSpeed(240);
			//Motor.C.rotate(698,true);
			//Motor.B.rotate(-698);
			point_to_point();
			
			while (Button.ENTER.isDown()){
			}
			while (Button.ENTER.isUp()){
					if (Button.UP.isDown()) {
						finish = true;
					}
			}
		}
	}
	
	public static void point_to_point() {
		//start from [0 0 0] and move to [200cm 50cm 135 degrees]
		int straight = 2133;
		int turn = 200;
		
		while (!Button.ENTER.isDown()) {
		Motor.C.rotate(straight,true);
		Motor.B.rotate(straight);
		Motor.C.rotate(turn,true);
		Motor.B.rotate(-turn);
		if (Button.ENTER.isDown()) {
			break;
		}
		Motor.C.rotate(straight,true);
		Motor.B.rotate(straight);
		Motor.C.rotate(turn,true);
		Motor.B.rotate(-turn);
		if (Button.ENTER.isDown()) {
			break;
		}
		Motor.C.rotate(straight,true);
		Motor.B.rotate(straight);
		Motor.C.rotate(turn,true);
		Motor.B.rotate(-turn);
		if (Button.ENTER.isDown()) {
			break;
		}
		Motor.C.rotate(straight,true);
		Motor.B.rotate(straight);
		Motor.C.rotate(195,true);
		Motor.B.rotate(-195);
		}
	}
}
//16.65cm
//16.95
//17.05
//Avg_distance = 16.88cm/360 degree rotation
//Avg_rotation = 698 degrees for a full pivot rotation