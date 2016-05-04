package org.usfirst.frc.team5122.robot.commands.autoComponents;

import org.usfirst.frc.team5122.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoEncoderDrive extends Command {

	double speed;
	double angle;
	double leftDistance;
	boolean done = false;
	
    public AutoEncoderDrive(double magnitude, double turn, double leftRotations) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	speed = magnitude;
    	angle = turn;
    	leftDistance = leftRotations;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (leftDistance > 0)
    		if (Robot.drivetrain.getLeftDistance() >= leftDistance) {
        		done = true;
    		}    	
    		else {
    			Robot.drivetrain.drive(speed, angle);
    		}
    	
    	else { //If distance is negative
    		if (Robot.drivetrain.getLeftDistance() <= leftDistance) {
        		done = true;
    		}    	
    		else {
    			Robot.drivetrain.drive(speed, angle);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stopDrivetrain();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
