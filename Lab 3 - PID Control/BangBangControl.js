import lejos.hardware.Button;
import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

import lejos.hardware.motor.*;


// MOTOR C: RIGHT WHEEL
// MOTOR B: LEFT WHEEL

public class BangBangControl{
	public static void main(String[] args) throws Exception { 
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S4);
		LCD.clear();
		while (!Button.ENTER.isDown()) {
			int sampleSize = color.sampleSize();
			float[] redsample = new float[sampleSize];
			color.getRedMode().fetchSample(redsample, 0); //not sure if RedMode matters
			//added code
			float desired = 0.5;
			float actual = sampleSize; // not sure if sampleSize is the colour sensor value
			float error = desired - actual;
			if (error < 0) {
				int correction = 1; //positive
			}
			else if (error > 0) {
				int correction = -1; //negative
			}
			else {
				correction = 0;
			}
			turn(correction)
			//end added code
			LCD.clear();
			System.out.println(redsample[0]);
		}
		color.close();
	}

	public static void turn(direction) throws Exception {
		if (direction == 1) {
			Motor.B.setSpeed(150);
			Motor.C.setSpeed(135); // one wheel turns faster
		}
		else if (direction == -1) {
			Motor.B.setSpeed(135);
			Motor.C.setSpeed(150);
		}
		else {
			Motor.B.setSpeed(135);
			Motor.C.setSpeed(135);
		}
			Motor.B.rotate(360,true);
			Motor.C.rotate(360);
	}
}

