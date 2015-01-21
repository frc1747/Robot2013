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
	
	private CyborgController cyborg;
	
	public OI(){
		cyborg = new CyborgController(0);
	}

	public CyborgController getCyborg() {
		return cyborg;
	}
	
	public void init(){
		cyborg.getLeftTrigger().whileHeld(new SpinUp(0.9));
		cyborg.getLeftTrigger().whenReleased(new SpinUp(0.0));
		cyborg.getRightTrigger().whileHeld(new Shoot(0.65));
		cyborg.getRightTrigger().whenReleased(new Shoot(0.0));
	}
}

