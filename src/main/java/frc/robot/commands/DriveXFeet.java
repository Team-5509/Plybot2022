package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.driveTrain;

public class DriveXFeet extends PIDCommand{
  private final driveTrain Drivetrain;
    public DriveXFeet (double FeetToDrive, driveTrain Drivetrain) {
        super(new PIDController(.2, 0, 0),
         Drivetrain::distanceTraveledInFeet,
         FeetToDrive, 
         output->Drivetrain.drive(0, MathUtil.clamp(output, -.3, .3), 0),
         Drivetrain);
         this.Drivetrain=Drivetrain;
         
        
    }
    @Override
    public void initialize (){
      Drivetrain.ResetEncoders();
    }
    @Override
    public boolean isFinished() {
      // End when the controller is at the reference.
      return getController().atSetpoint();
    }
    @Override 
    public void execute(){
      super.execute();
      SmartDashboard.putNumber("DrivexFeetSetpoint", getController().getSetpoint());
      SmartDashboard.putNumber("DrivexFeetPositionError", getController().getPositionError());
      SmartDashboard.putNumber("DrivexFeetDistanceInFeet", m_measurement.getAsDouble());
      SmartDashboard.putNumber("DrivexFeetDesiredFeet", m_setpoint.getAsDouble());


    }
}
