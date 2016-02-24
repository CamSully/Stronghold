package org.usfirst.frc.team5122.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5122.robot.*;

/**
 *
 */
public class LiftUp extends Command {

	boolean done;
	
    public LiftUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!RobotMap.liftTopLimit.get()) {     // Limit is pressed.
    		done = true;
    	}
    	else {
    		Robot.lift.lifterUp();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    // Runs when button is released.
    public void cancel() {
    	super.cancel();
    	// Turn lift off.
    	end();
    }
}
