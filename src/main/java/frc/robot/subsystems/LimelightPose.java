package frc.robot.subsystems;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class LimelightPose extends SubsystemBase {
    private final SwerveDrivePoseEstimator poseEstimator;

    public LimelightPose(SwerveDrivePoseEstimator poseEstimator) {
        this.poseEstimator = poseEstimator;
    }
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
    public void updatePose() {
        NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry botposeEntry = limelightTable.getEntry("botpose");

        double[] botpose = botposeEntry.getDoubleArray(new double[6]); // 獲取機器人的 (x, y, theta)
        
        if (botpose.length >= 6) {
            double x = botpose[0];   // X 位置（米）
            double y = botpose[1];   // Y 位置（米）
            double theta = botpose[5]; // 機器人旋轉角度（度）

            double timestamp = Timer.getFPGATimestamp() - (botpose[6] / 1000.0); // 延遲補償

            Pose2d visionPose = new Pose2d(x, y, Rotation2d.fromDegrees(theta));
            poseEstimator.addVisionMeasurement(visionPose, timestamp);
        }
    }
}
