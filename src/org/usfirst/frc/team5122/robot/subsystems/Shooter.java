// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5122.robot.subsystems;

import org.usfirst.frc.team5122.robot.RobotMap;
import org.usfirst.frc.team5122.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftRotator = RobotMap.shooterLeftRotator;
    SpeedController rightRotator = RobotMap.shooterRightRotator;
    
    SpeedController leftShooter = RobotMap.shooterLeftShooter;
    SpeedController rightShooter = RobotMap.shooterRightShooter;
    
    DigitalInput rotatorBottomLimit = RobotMap.rotatorBottomLimit;
    DigitalInput rotatorTopLimit = RobotMap.rotatorTopLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static boolean wheelsOn = false;
    public static boolean intakeOn = false;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void intakeOn() {
    	if (!wheelsOn) {
    		wheelsOn = true;
    		intakeOn = true;
    		leftShooter.set(.5);
    		rightShooter.set(-.5);
    		SmartDashboard.putBoolean("Wheels On", true);
    		SmartDashboard.putBoolean("Intake On", true);
    	}
    }
    
    public void intakeOff() {
    	wheelsOn = false;
    	intakeOn = false;
    	leftShooter.set(0);
    	rightShooter.set(0);
    	SmartDashboard.putBoolean("Wheels On", false);
    	SmartDashboard.putBoolean("Intake On", false);
    }
    
    public void fire() {
    	if (!wheelsOn && !intakeOn) {
    		wheelsOn = true;
    		leftShooter.set(-1);
    		rightShooter.set(1);
    		SmartDashboard.putBoolean("Wheels On", true);
    	}
    }
    
    public void rotate(Joystick js) {
    	 // while (!rotatorBottomLimit.get() && !rotatorTopLimit.get())
    	leftRotator.set(-js.getRawAxis(1));	    // Negative so both spin in same direction.
    	rightRotator.set(js.getRawAxis(1));
    }
    
    public void stopRotation() {
    	leftRotator.set(0);
    	rightRotator.set(0);
    }
    
    public boolean wheelsAreOn () {
    	return wheelsOn;
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Rotate());
    }
}

