// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    private final static double TICKSPERFOOT= 532;
    private final static double FEETPERTICK= 1/TICKSPERFOOT;
    private WPI_TalonSRX FrontLeftMotor;
    private WPI_TalonSRX FrontRightMotor;
    private WPI_TalonSRX BackLeftMotor;
    private WPI_TalonSRX BackRightMotor;
    private MecanumDrive mecanumDrive;
    public driveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        FrontLeftMotor= new WPI_TalonSRX(6);
        FrontRightMotor= new WPI_TalonSRX(1);
        BackLeftMotor= new WPI_TalonSRX(8);
        BackRightMotor= new WPI_TalonSRX(13);
        FrontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        BackRightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        ResetEncoders();

        FrontRightMotor.setInverted(true);
        BackRightMotor.setInverted(true);

        mecanumDrive= new MecanumDrive(FrontLeftMotor,BackLeftMotor,FrontRightMotor,BackRightMotor);
        
    }

    public void ResetEncoders() {
        FrontLeftMotor.setSelectedSensorPosition(0);
        BackRightMotor.setSelectedSensorPosition(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        double ticks = FrontLeftMotor.getSelectedSensorPosition();
        SmartDashboard.putNumber("Front Left Ticks", ticks);
        ticks = BackRightMotor.getSelectedSensorPosition();
        SmartDashboard.putNumber("Back Right Ticks", ticks);

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public double distanceTraveledInFeet () {
    return BackRightMotor.getSelectedSensorPosition()*FEETPERTICK*-1;
}
    // Y is forwards, x is strafe
    public void drive(double x,double y,double rotation){
        mecanumDrive.driveCartesian(y, x, rotation);
    }
    public void stop(){
        drive(0,0,0);
    }

}

