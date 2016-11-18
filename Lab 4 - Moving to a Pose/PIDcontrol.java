import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

import lejos.hardware.motor.*;


// MOTOR C: RIGHT WHEEL
// MOTOR B: LEFT WHEEL

public class PIDControl
{
	public static void main(String[] args) throws Exception 
	{ 
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S3);
		LCD.clear();
		double correction;
		double integral = 0;
		double derivative;
		double lasterror = 0;
		double desired = 0.25;
		double Kp = 20000;
		double Ki = 250;
		double Kd = 100;
		int speed = 50;
		int angle = 10;

		while (!Button.ENTER.isDown()) 
		{
			int sampleSize = color.sampleSize();
			float[] redsample = new float[sampleSize];
			color.getRedMode().fetchSample(redsample, 0); //not sure if RedMode matters
			//added code
			double actual = redsample[0]; // not sure if sampleSize is the colour sensor value
			double error = desired - actual;
			integral = integral + error;
			derivative = error - lasterror;
			if (Button.UP.isDown())
			{
				integral = 0;
			}
			if (Button.DOWN.isDown())
			{
				Kp = 0;
			}
			if (Button.RIGHT.isDown())
			{
				Kp = Kp + 50;
			}
			if (Button.LEFT.isDown())
			{
				Kp = Kp - 50;
			}
			correction = Kp*error + Ki*integral+Kd*derivative; //negative
			turn(correction);
			//end added code
			LCD.clear();
			//System.out.println(redsample[0]);
			System.out.println(correction, speed, angle);
			System.out.println("Kp");
			System.out.println(Kp);
			lasterror = error;
			if (error*lasterror < 0)
			{
				integral = 0;
			}
		}
		color.close();
	}

	public static void turn(double direction, int speed, int angle) throws Exception 
	{		
		Motor.B.setSpeed(speed-direction);
		Motor.C.setSpeed(speed+direction);
		Motor.B.rotate(angle,true);
		Motor.C.rotate(angle,true);
	}
}