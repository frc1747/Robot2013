package org.usfirst.frc.team1747.robot.subsystems;

import org.usfirst.frc.team1747.robot.RobotMap;
import org.usfirst.frc.team1747.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {

	CANJaguar topLeftJag, midLeftJag, botLeftJag;
	CANJaguar topRightJag, midRightJag, botRightJag;
	static double[] SIGMOIDSTRETCH = {0.0, 0.03, 0.06, 0.09, 0.1, 0.11, 0.12, 
        0.11, 0.1, 0.09, 0.06, 0.03, 0.0};
    double[] leftTargetDeltas, rightTargetDeltas;
    double pLeftCurrent, pRightCurrent;
    double prevLeftTarget, prevRightTarget;
    
	public Drive(){
		midRightJag = new CANJaguar(RobotMap.RIGHT_MID_JAG_ID);
		topRightJag = new CANJaguar(RobotMap.RIGHT_TOP_JAG_ID);
		botRightJag = new CANJaguar(RobotMap.RIGHT_BOT_JAG_ID);
		botLeftJag = new CANJaguar(RobotMap.LEFT_BOT_JAG_ID);
		midLeftJag = new CANJaguar(RobotMap.LEFT_MID_JAG_ID);
		topLeftJag = new CANJaguar(RobotMap.LEFT_TOP_JAG_ID);
		leftTargetDeltas = new double[SIGMOIDSTRETCH.length];
		rightTargetDeltas = new double[SIGMOIDSTRETCH.length];
        for(int j = 0; j < SIGMOIDSTRETCH.length - 1; j++){
            leftTargetDeltas[j] = 0;
            rightTargetDeltas[j] = 0;      
        }
        prevLeftTarget = 0;
        prevRightTarget = 0;
        pLeftCurrent = 0.0;
        pRightCurrent = 0.0;
		System.out.println("Jags Initialized");
	}
	
    public void smoothDrive(double targetLeftCurrent, double targetRightCurrent, double dampeningConstant){

        for(int i = leftTargetDeltas.length-1; i > 0; i--){
            leftTargetDeltas[i] = leftTargetDeltas[i-1];
            rightTargetDeltas[i] = rightTargetDeltas[i-1];
        }
        leftTargetDeltas[0] = targetLeftCurrent - prevLeftTarget;
        rightTargetDeltas[0] = targetRightCurrent - prevRightTarget;
        prevLeftTarget = targetLeftCurrent;
        prevRightTarget = targetRightCurrent;      
        for(int i = 0; i< SIGMOIDSTRETCH.length; i++){
            pLeftCurrent += leftTargetDeltas[i]*SIGMOIDSTRETCH[i];
            pRightCurrent += rightTargetDeltas[i]*SIGMOIDSTRETCH[i];
        }
        tankDrive(pLeftCurrent * dampeningConstant, pRightCurrent * dampeningConstant);
    }
	
	public void arcadeDrive(double forward, double turn, double dampeningConstant){
		double leftCurrent = forward-turn;
		double rightCurrent = forward+turn;
		smoothDrive(leftCurrent, rightCurrent, dampeningConstant);
	}

	public void tankDrive(double leftSpeed, double rightSpeed){
		topLeftJag.set(-leftSpeed);
		midLeftJag.set(-leftSpeed);
		botLeftJag.set(-leftSpeed);
		topRightJag.set(rightSpeed);
		midRightJag.set(rightSpeed);
		botRightJag.set(rightSpeed);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
}