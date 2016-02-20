package org.usfirst.frc.team5122.robot.commands.autoComponents;

import org.usfirst.frc.team5122.robot.Robot;
import org.usfirst.frc.team5122.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class A_DriveToRamp extends Command {
	
	double leftRotations;
	double rightRotations;
	boolean done = false;
	
    public A_DriveToRamp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (leftRotations > 5 && leftRotations < 10) {
    		done = true;
    	}
    	else {
    		Robot.drivetrain.drive(0.75, 0);
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
