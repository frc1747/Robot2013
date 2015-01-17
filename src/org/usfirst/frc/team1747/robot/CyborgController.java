package org.usfirst.frc.team1747.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class CyborgController {

	public static final int LEFT_JOY_HORIZ_AXIS = 0;
	public static final int LEFT_JOY_VERT_AXIS = 1;
	public static final int RIGHT_JOY_HORIZ_AXIS = 3;
	public static final int RIGHT_JOY_VERT_AXIS = 4;
	
	public static final int JOY_X_BUTTON = 1;
	public static final int JOY_Y_BUTTON = 2;
	public static final int JOY_A_BUTTON = 3;
    public static final int JOY_B_BUTTON = 4;
	
	Joystick controller;
	JoystickButton buttonA, buttonB, buttonX, buttonY;

	public CyborgController(int portNum) {
		controller = new Joystick(portNum);
		buttonX = new JoystickButton(controller, JOY_X_BUTTON);
		buttonY = new JoystickButton(controller, JOY_Y_BUTTON);
		buttonA = new JoystickButton(controller, JOY_A_BUTTON);
		buttonB = new JoystickButton(controller, JOY_B_BUTTON);
	}

	public double getLeftVert() {
		return controller.getRawAxis(OIMap.LEFT_JOY_VERT_AXIS);
	}

	public double getLeftHoriz() {
		return controller.getRawAxis(OIMap.LEFT_JOY_HORIZ_AXIS);
	}

	public double getRightVert() {
		return -controller.getRawAxis(OIMap.RIGHT_JOY_VERT_AXIS);
	}

	public double getRightHoriz() {
		return -controller.getRawAxis(OIMap.RIGHT_JOY_HORIZ_AXIS);
	}
	
	public JoystickButton getButtonA() {
		return buttonA;
	}

	public JoystickButton getButtonB() {
		return buttonB;
	}

	public JoystickButton getButtonX() {
		return buttonX;
	}

	public JoystickButton getButtonY() {
		return buttonY;
	}

	public static int getRightJoyHorizAxis() {
		return RIGHT_JOY_HORIZ_AXIS;
	}


	
}
