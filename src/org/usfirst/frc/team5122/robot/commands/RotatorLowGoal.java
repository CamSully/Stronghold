package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;
import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotatorLowGoal extends Command {
	
	boolean done;
	boolean emergency;
	
    public RotatorLowGoal(boolean emergency) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.shooter);
    	this.emergency = emergency;
    	
    	setTimeout(0.5);
    }

    // Called just before this Command runs the every time
    protected void initialize() {
    	 done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (emergency) {
    		done = true;
    	}
    	
    	if (isTimedOut()) {
    		done = true;
    	}
    	
    	else {
    		if ((RobotMap.rotatorEncoder.getDistance() < -3) && ((RobotMap.rotatorEncoder.getDistance() > -6))) {
    			done = true;
    		}
    		else if (RobotMap.rotatorEncoder.getDistance() > -3) {
    			Robot.shooter.Rotate(1);
    		}
    		else {     // Rotator is above threshold (over 75).
    			Robot.shooter.Rotate(-0.75);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopRotation();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
