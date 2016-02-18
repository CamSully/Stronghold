// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5122.robot;

import org.usfirst.frc.team5122.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static JoystickButton jS1;
    public static JoystickButton jS2;
    public static JoystickButton jS3;
    public static JoystickButton jS4;
    public static JoystickButton jS5;
    public static JoystickButton jS6;
    public static Joystick driveJoystick;
    public static Joystick rotateJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        driveJoystick = new Joystick(1);
        rotateJoystick = new Joystick(0);
        
        jS1 = new JoystickButton(driveJoystick, 2);
        jS1.whileHeld(new Intake());
        
        jS2 = new JoystickButton(driveJoystick, 1);
        jS2.whenPressed(new PushFireBall());
        
        jS3 = new JoystickButton(rotateJoystick, 4);
        jS3.whileHeld(new LiftDown());
        
        jS4 = new JoystickButton(rotateJoystick, 5);
        jS4.whileHeld(new LiftUp());
        
        jS5 = new JoystickButton(rotateJoystick, 3);
        jS5.whenPressed(new RotatorToPosition());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("TeleopDrive", new TeleopDrive());

        SmartDashboard.putData("AutoDriveForward", new AutoDriveForward());
        
        SmartDashboard.putData("AutoDriveShoot", new AutoDriveShoot());
        
        SmartDashboard.putData("AutoOverObstacle", new AutoOverObstacle());

        SmartDashboard.putData("FireBall", new PushFireBall());

        SmartDashboard.putData("Intake", new Intake());

        SmartDashboard.putData("Rotate", new Rotate());
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return driveJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

