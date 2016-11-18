import lejos.hardware.Button;
import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

import lejos.hardware.motor.*;


// MOTOR C: RIGHT WHEEL
// MOTOR B: LEFT WHEEL

public class PIControl{
	public static void main(String[] args) throws Exception { 
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S3);
		LCD.clear();
		double correction;
		double integral = 0;
		while (!Button.ENTER.isDown()) 
		{
			int sampleSize = color.sampleSize();
			float[] redsample = new float[sampleSize];
			color.getRedMode().fetchSample(redsample, 0); //not sure if RedMode matters
			//added code
			double desired = 0.25;
			double Kp = 20000;
			double Ki = 100;
			
			double actual = redsample[0]; // not sure if sampleSize is the colour sensor value
			double error = desired - actual;
			integral = integral + error;
			correction = error*Kp + Ki*integral; //negative
			turn(correction);
			//end added code
			LCD.clear();
			//System.out.println(redsample[0]);
			System.out.println(correction);
		}
		color.close();
	}

	public static void turn(double direction) throws Exception {		
		if (direction > 0) {
			int speed = (int) direction;
			Motor.B.setSpeed(0);
			Motor.C.setSpeed(speed); // one wheel turns faster
		}
		else if (direction < 0) {
			int speed = (int) direction*(-1);			
			Motor.B.setSpeed(speed);
			Motor.C.setSpeed(0);
		}
		else {
			Motor.B.setSpeed(70);
			Motor.C.setSpeed(70);
		}
		Motor.B.rotate(5,true);
		Motor.C.rotate(5,true);
			Motor.B.setSpeed(10);
			Motor.C.setSpeed(10);
	}
}