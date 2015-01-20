package org.usfirst.frc.team1747.robot.commands;

import org.usfirst.frc.team1747.robot.OI;
import org.usfirst.frc.team1747.robot.Robot;
import org.usfirst.frc.team1747.robot.SDController;
import org.usfirst.frc.team1747.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDrive extends Command {
	
	Drive drive;
    OI oi;
    SDController sd;
	
    public TeleopDrive() {
    	this.drive=Robot.drive;
    	this.oi=Robot.oi;
    	this.sd = Robot.sd;
        requires(drive);
    }
	
	protected void initialize() {
	
	}
    
	protected void execute() {
		if(sd.getDriveMode()){
			drive.tankDrive(oi.getRightJoyVert(), oi.getLeftJoyVert());
			sd.setLeftJoy(oi.getLeftJoyVert());
	    	sd.setRightJoy(oi.getRightJoyVert());
	    }
		else{
			drive.arcadeDrive(oi.getLeftJoyVert(), oi.getRightJoyHoriz(), sd.getDampeningConstant());
			sd.setLeftJoy(oi.getLeftJoyVert());
	    	sd.setRightJoy(oi.getRightJoyHoriz());
	    }
    }

    protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
