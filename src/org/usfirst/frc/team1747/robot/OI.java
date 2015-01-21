package org.usfirst.frc.team1747.robot;

import org.usfirst.frc.team1747.robot.commands.Shoot;
import org.usfirst.frc.team1747.robot.commands.SpinUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick controller1;
	JoystickButton LeftTriggerButton;
	JoystickButton RightTriggerButton;
	
	public boolean getLeftBumper(){
		return controller1.getRawButton(OIMap.JOY_LEFT_BUMPER);
	}
	
	public double getLeftJoyVert(){
		return controller1.getRawAxis(OIMap.LEFT_JOY_VERT_AXIS);
	}
	
	public double getLeftJoyHoriz(){
		return controller1.getRawAxis(OIMap.LEFT_JOY_HORIZ_AXIS);
	}
	
	public double getRightJoyVert(){
		return controller1.getRawAxis(OIMap.RIGHT_JOY_VERT_AXIS);
	}
	
	public double getRightJoyHoriz(){
		return -controller1.getRawAxis(OIMap.RIGHT_JOY_HORIZ_AXIS);
	}
	

	public OI(){
		controller1 = new Joystick(0);
	}
	
	public void init(){
		LeftTriggerButton = new JoystickButton(controller1, 8);
		LeftTriggerButton.whileHeld(new SpinUp(0.9));
		LeftTriggerButton.whenReleased(new SpinUp(0.0));
		RightTriggerButton = new JoystickButton(controller1, 6);
		RightTriggerButton.whileHeld(new Shoot(0.65));
		RightTriggerButton.whenReleased(new Shoot(0.0));
	}
}

