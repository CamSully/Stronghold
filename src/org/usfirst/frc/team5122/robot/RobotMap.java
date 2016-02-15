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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController leftMotorController1;
    public static SpeedController leftMotorController2;
    public static SpeedController rightMotorController1;
    public static SpeedController rightMotorController2;
    
    public static SpeedController shooterLeftRotator;
    public static SpeedController shooterRightRotator;
    
    public static SpeedController shooterLeftShooter;
    public static SpeedController shooterRightShooter;
    
    public static SpeedController liftLifter;
    
    public static DigitalInput rotatorBottomLimit;
    public static DigitalInput rotatorTopLimit;
    
    public static Solenoid shooterPusher;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	leftMotorController1 = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 1", (Talon) leftMotorController1);
        leftMotorController2 = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 2", (Talon) leftMotorController2);
        rightMotorController1 = new Talon(3);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 3", (Talon) rightMotorController1);
        rightMotorController2 = new Talon(4);
        LiveWindow.addActuator("Drivetrain", "Speed Controller 4", (Talon) rightMotorController2);
        
        shooterLeftShooter = new Talon(6);
        LiveWindow.addActuator("Shooter", "LeftShooter", (Talon) shooterLeftShooter);
        shooterRightShooter = new Talon(7);
        LiveWindow.addActuator("Shooter", "RightShooter", (Talon) shooterRightShooter);
        
        shooterLeftRotator = new Victor(0);
        LiveWindow.addActuator("Shooter", "LeftRotator", (Victor) shooterLeftRotator);
        shooterRightRotator = new Victor(8);
        LiveWindow.addActuator("Shooter", "RightRotator", (Victor) shooterRightRotator);
        
        liftLifter = new Talon(5);
        LiveWindow.addActuator("Lift", "Lifter", (Talon) liftLifter);
        
        rotatorBottomLimit = new DigitalInput(0);
        LiveWindow.addActuator("Shooter", "BottomLimit", rotatorBottomLimit);
        rotatorTopLimit = new DigitalInput(1);
        LiveWindow.addActuator("Shooter", "BottomLimit", rotatorBottomLimit);

        // shooterPusher = new Solenoid(0);
        // LiveWindow.addActuator("Shooter", "shooter pusher", shooterPusher);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
