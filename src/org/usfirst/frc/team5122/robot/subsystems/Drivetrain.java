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


/**
 *
 */
public class Drivetrain extends Subsystem {
    SpeedController leftMotorController1 = RobotMap.leftMotorController1;
    SpeedController leftMotorController2 = RobotMap.leftMotorController2;
    SpeedController rightMotorController1 = RobotMap.rightMotorController1;
    SpeedController rightMotorController2 = RobotMap.rightMotorController2;
    
    Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    
         // Ultrasonic distanceSensor = RobotMap.distanceSensor;

    private RobotDrive driveBase;
    
    public Drivetrain() {
    	driveBase = new RobotDrive(leftMotorController1, leftMotorController2, rightMotorController1, rightMotorController2);
    	driveBase.setSafetyEnabled(false);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void jsDrive(Joystick js) {
    	driveBase.arcadeDrive(-js.getRawAxis(1), -js.getRawAxis(0));	//(Forward/Back, Left/Right)
    }
    
    public void drive(double magnitude, double angle) {
    	driveBase.arcadeDrive(magnitude, angle);
    }
    
    public void stopDrivetrain() {
    	driveBase.arcadeDrive(0, 0);
    }
    
    
    public double getLeftDistance() {
    	return leftEncoder.getDistance();
    }
    
    public double getRightDistance() {
    	return rightEncoder.getDistance();
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopDrive());
    }
}

