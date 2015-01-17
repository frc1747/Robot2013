package org.usfirst.frc.team1747.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick joystick;
	
	public double getLeftJoyVert(){
		return joystick.getRawAxis(IOMap.LEFT_JOY_VERT_AXIS);
	}
	
	public double getLeftJoyHoriz(){
		return joystick.getRawAxis(IOMap.LEFT_JOY_HORIZ_AXIS);
	}
	
	public double getRightJoyVert(){
		return -joystick.getRawAxis(IOMap.RIGHT_JOY_VERT_AXIS);
	}
	
	public double getRightJoyHoriz(){
		return -joystick.getRawAxis(IOMap.RIGHT_JOY_HORIZ_AXIS);
	}
	

	public OI(){
		joystick = new Joystick(0);
	}




}

