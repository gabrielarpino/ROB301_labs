//Lab 3: Test for straight driving & left and right turns.
import lejos.hardware.Button;
import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.motor.*;
//for Thread.sleep use: import java.lang.*;

public class TestDriving {
	public static void main(String[] args) throws Exception { 
		Motor.B.setSpeed(135);
		Motor.C.setSpeed(135);
		Motor.B.rotate(720,true);
		Motor.C.rotate(720);
		turnleft();
		//Thread.sleep(2000);
		turnright();
	} 

	public static void turnleft(String[] args) throws Exception {
		Motor.B.setSpeed(135);
		Motor.C.setSpeed(135);
		Motor.B.rotate(360,true);
		Motor.C.rotate(-360);
	}
	public static void turnright(String[] args) throws Exception {
		Motor.B.setSpeed(135);
		Motor.C.setSpeed(135);
		Motor.B.rotate(-360,true);
		Motor.C.rotate(360);
	}
}
