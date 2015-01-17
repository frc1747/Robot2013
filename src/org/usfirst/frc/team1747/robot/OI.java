package org.usfirst.frc.team1747.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick controller1;
	
	public double getLeftJoyVert(){
		return controller1.getRawAxis(OIMap.LEFT_JOY_VERT_AXIS);
	}
	
	public double getLeftJoyHoriz(){
		return controller1.getRawAxis(OIMap.LEFT_JOY_HORIZ_AXIS);
	}
	
	public double getRightJoyVert(){
		return -controller1.getRawAxis(OIMap.RIGHT_JOY_VERT_AXIS);
	}
	
	public double getRightJoyHoriz(){
		return -controller1.getRawAxis(OIMap.RIGHT_JOY_HORIZ_AXIS);
	}
	

	public OI(){
		controller1 = new Joystick(0);
	}




}

