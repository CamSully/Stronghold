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
	double rightDistance;
	boolean done = false;
	double error = 5;
	
    public AutoEncoderDrive(double magnitude, double turn, double leftRotations, double rightRotations) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	speed = magnitude;
    	angle = turn;
    	leftDistance = leftRotations;
    	rightDistance = rightRotations;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.drivetrain.getLeftDistance() > (leftDistance - error) && Robot.drivetrain.getLeftDistance() < (leftDistance + error)) {
    		if (Robot.drivetrain.getRightDistance() > (rightDistance - error) && Robot.drivetrain.getRightDistance() < (rightDistance + error)) {
        		done = true;
        	}
    		else {
    			Robot.drivetrain.drive(speed, -0.25);
    		} 
    	}
    	else if (Robot.drivetrain.getRightDistance() > (rightDistance - error) && Robot.drivetrain.getRightDistance() < (rightDistance + error)) {
    		if (Robot.drivetrain.getLeftDistance() > (leftDistance - error) && Robot.drivetrain.getLeftDistance() < (leftDistance + error)) {
    			done = true;
    		}
    		else {
    			Robot.drivetrain.drive(speed, 0.25);
    		}
    	}
    	
    	else {
    		Robot.drivetrain.drive(speed, angle);
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
