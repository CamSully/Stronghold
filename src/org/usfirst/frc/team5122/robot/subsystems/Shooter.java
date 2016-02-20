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

import org.usfirst.frc.team5122.robot.OI;
import org.usfirst.frc.team5122.robot.RobotMap;
import org.usfirst.frc.team5122.robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // SpeedController leftRotator = RobotMap.shooterLeftRotator;
    SpeedController Rotator = RobotMap.shooterRotator;
    
    SpeedController leftShooter = RobotMap.shooterLeftShooter;
    SpeedController rightShooter = RobotMap.shooterRightShooter;
    
    DigitalInput rotatorBottomLimit = RobotMap.rotatorBottomLimit;
    DigitalInput rotatorTopLimit = RobotMap.rotatorTopLimit;
    
    Solenoid Pusher = RobotMap.shooterPusher;
    
    Encoder rotatorEncoder = RobotMap.rotatorEncoder;
    
    double speed;
    
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    // FIRE BALL METHODS
    
    public void intakeOn() {
    	if (!OI.jS2.get()) {
    		leftShooter.set(-.75);
    		rightShooter.set(.75);
    	}
    }
    
    public void intakeOff() {
    		leftShooter.set(0);
    		rightShooter.set(0);
    }
    
    public void fire() {
    	if (!OI.jS1.get()) {
    		leftShooter.set(1);
    		rightShooter.set(-1);
    	}
    }
    
    // ROTATOR METHODS
    
    public void rotate(Joystick js) {
    	
    	// If rotator is at bottom, only let it go up.
    	if (rotatorBottomLimit.get()) {
    		rotatorEncoder.reset();
    		if (js.getRawAxis(1) > 0) {
    			moveRotator(js);
    		}
    		else {
    			stopRotation();
    		}
    	}
    	
    	// If rotator is not at the bottom, let it do whatever.
    	else {
        	moveRotator(js);
    	}
    }
    
    private void moveRotator (Joystick js) {
    	if (js.getRawAxis(1) < -0.05) {     // Going down (0.05 requirement eliminates joystick noise).
			Rotator.set(1*js.getRawAxis(1));
			speed = (1*js.getRawAxis(1));
			
    	}
    	else if (js.getRawAxis(1) > 0.05) {     // Going up
    		Rotator.set(1*js.getRawAxis(1));
			speed = (1*js.getRawAxis(1));
		}
    	else {
    		stopRotation();
    	}
    }
    
    public void stopRotation() {

// SLOWING DOWN CODE- ADD LATER?
//    	if (speed > 0) {
//    		speed -= 0.1;
//    		leftRotator.set(rotatorSpeed);
//			rightRotator.set(-rotatorSpeed);
//    	}
    	
    	Rotator.set(0);
    	speed = 0;
    }
    
    // Used for autonomously moving the rotator (see Command RotatorToPosition)
    public void Rotate(double velocity) {
    	Rotator.set(velocity);
    	speed = velocity;
    }
    
    // GETTER METHODS FOR SMARTDASHBOARD
    
    public double getSpeed() {
    	return speed;
    }
    
    public boolean getBottomLimit() {
    	return rotatorBottomLimit.get();
    }
    
    public void resetEncoder() {
    	rotatorEncoder.reset();
    }
    
    public double getDistance() {
    	return rotatorEncoder.getDistance();
    }
    
    // PUSHER METHODS
    
    public void push() {
    	Pusher.set(true);
    }
    
    public void restractPusher() {
    	Pusher.set(false);
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Rotate());
    }
}

