package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.Robot;
import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotatorToLine extends Command {
	
	boolean done;
	double position;
	
    public RotatorToLine() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.shooter);
    }

    // Called just before this Command runs the every time
    protected void initialize() {
    	 done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// ROTATOR MUST BE AT BOTTOM FOR THIS TO WORK!
    	if ((RobotMap.rotatorEncoder.getDistance() > 65) && ((RobotMap.rotatorEncoder.getDistance() < 70))) {
    		done = true;
    	}
    	else {
    		Robot.shooter.Rotate(1);
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
