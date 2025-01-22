package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.LimelightConstants;


public class limelight extends SubsystemBase{
    
    NetworkTable table = NetworkTableInstance.getDefault().getTable(LimelightConstants.Name);

   // public double X;
   public double ID;
   public double TX;
   public double TA;

    public double getTag_X(){
        TX = LimelightHelpers.getTX("");
        return TX;
       // x = LimelightHelpers.getTX("");
      //  return x;
    }
    public double getTag_A(){
        TA = LimelightHelpers.getTA("");
        return TA;
    }
    public double getTag_ID(){
        ID = LimelightHelpers.getFiducialID("");
        return ID;
    }
    public void periodic(){
        getTag_A();
        getTag_ID();
        getTag_X();

        SmartDashboard.putNumber("TagA", TA);
        SmartDashboard.putNumber("TagID",ID);
        SmartDashboard.putNumber("TagX",TX);
    }
}

