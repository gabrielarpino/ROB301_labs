import lejos.hardware.motor.*;
import lejos.utility.Delay;
import lejos.hardware.Button;
import lejos.hardware.lcd.*;

public class curve {
	public static void main(String[] args) {
		boolean finish = false;
		while (!finish) {
			while (!Button.ENTER.isDown()) {
			}
			
			//Motor.C.rotate(698,true);
			//Motor.B.rotate(-698);
			//point_to_point();
			//int r1 = 360;
			//int r2 = (25*r1-(12/2)*r1)/(12/2)+25;
			int v1 = 300;
			int v2 = 330;
			
			
			Motor.C.setSpeed(v1);
			Motor.B.setSpeed(v2);
			
			
			
			Motor.C.forward();
			Motor.B.forward();
			Delay.msDelay(2300);
			Motor.C.stop(true);
			Motor.B.stop();
			
			
			
			while (Button.ENTER.isDown()){
			}
			while (Button.ENTER.isUp()){
					if (Button.UP.isDown()) {
						finish = true;
					}
			}
		}
	}
}