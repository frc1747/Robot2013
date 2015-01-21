package org.usfirst.frc.team1747.robot.commands;

import org.usfirst.frc.team1747.robot.CyborgController;
import org.usfirst.frc.team1747.robot.OI;
import org.usfirst.frc.team1747.robot.Robot;
import org.usfirst.frc.team1747.robot.SDController;
import org.usfirst.frc.team1747.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDrive extends Command {
	
	Drive drive;
    SDController sd;
    CyborgController cyborg;
    
    public TeleopDrive() {
    	this.drive=Robot.getDrive();
    	this.cyborg=Robot.getOi().getCyborg();
    	this.sd = Robot.getSd();
        requires(drive);
    }
	
	protected void initialize() {
	
	}
    
	protected void execute() {
		if(sd.getDriveMode()){
			drive.tankDrive(cyborg.getRightVert(), cyborg.getLeftVert());
	    }
		else{
			drive.arcadeDrive(cyborg.getLeftVert(), cyborg.getRightHoriz(),
					sd.getDampeningConstant());
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
