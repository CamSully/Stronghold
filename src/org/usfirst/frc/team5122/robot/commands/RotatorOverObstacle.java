package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;
import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotatorOverObstacle extends Command {
	
	boolean done;
	boolean emergency;
	
	// Boolean emergency is passed to tell if the driver's have pressed the shutoff button.
    public RotatorOverObstacle(boolean emergency) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.shooter);
    	this.emergency = emergency;
    	// SAFETY MEASURE: ROTATOR SHOULD MOVE FOR LESS THAN 1 SECOND.
    	setTimeout(1);
    }

    // Called just before this Command runs the every time
    protected void initialize() {
    	 done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// If there is an emergency, stop rotation immediately.
    	if (emergency) {
    		done = true;
    	}
    	
    	// IF ROTATOR HAS MOVED FOR 1 SECOND, STOP IT.
    	if (isTimedOut()) {
    		done = true;
    	}
    	
    	// If there isn't an emergency, drive the rotator.
    	else {
    		// If the rotator is in the proper position (~22.5), stop rotation.
    		if ((RobotMap.rotatorEncoder.getDistance() > 20) && ((RobotMap.rotatorEncoder.getDistance() < 25))) {
    			done = true;
    		}
    		// If the rotator is below position, rotate up.
    		else if (RobotMap.rotatorEncoder.getDistance() < 20) {
    			Robot.shooter.Rotate(1);
    		}
    		// If the rotator is above position, rotate down.
    		else {     
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
    	end();
    }
}
