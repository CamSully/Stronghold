package org.usfirst.frc.team5122.robot.commands;

import org.usfirst.frc.team5122.robot.OI;

import java.io.*;
import java.util.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Record extends Command {
	
	private ArrayList<Double> driveX = new ArrayList<Double>();
	private ArrayList<Double> driveY = new ArrayList<Double>();
	private ArrayList<Double> rotateY = new ArrayList<Double>();
	
    public Record() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Initialize");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Execute " + timeSinceInitialized());
    	double time = timeSinceInitialized() * 1000;
    	int realTime = (int)time;
    	if (realTime % 10 == 0) {
    		System.out.println("Add Data");
    		driveX.add(OI.getDriveX());
    		driveY.add(OI.getDriveY());
    		rotateY.add(OI.getRotateY());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("End");
    	PrintWriter writer;
		try {
			writer = new PrintWriter("/home/lvuser/ted.txt");
			writer.println(driveX.toString());
	    	writer.println(driveY.toString());
	    	writer.println(rotateY.toString());
	    	writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
