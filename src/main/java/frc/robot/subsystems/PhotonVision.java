package frc.robot.subsystems;

import java.lang.annotation.Target;
import java.time.Period;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import com.fasterxml.jackson.databind.EnumNamingStrategies.CamelCaseStrategy;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class PhotonVision extends SubsystemBase {
   public RobotContainer newRobotContainer;
    PhotonCamera camera = new PhotonCamera("photonvision");
    private PhotonPipelineResult result ;
    PhotonTrackedTarget target ;
    private final ExampleSubsystem newExampleSubsystem = new ExampleSubsystem();
    
    boolean hasTargets;
    public double Yaw;
    public double Pitch;
    public double Area;
    
    
     
    public double getYaw(){
        periodic();
        Yaw = target.getYaw();
            return Yaw;
        }
    public double getPitch() {
        periodic();
        Pitch = target.getPitch();
            return Pitch;
        }
    public double getarea(){
        periodic();
         Area = target.getArea();
            return Area;
        }
        { if (target == null){
                double target = -1;
            }
            else if(target!=null){
                Transform3d pose = target.getBestCameraToTarget();}
         }
       
            
        
    @Override
    public void periodic(){
        getYaw();
        getPitch();
        getarea();
        
        
    
        System.out.println(hasTargets);
        SmartDashboard.putNumber("getY", Yaw);
        SmartDashboard.putNumber("getP",Pitch);
        SmartDashboard.putNumber("getA",Area);
        double Yaw = SmartDashboard.getNumber("getY", 0);
        double Pitch= SmartDashboard.getNumber("getP", 0);
        double Area = SmartDashboard.getNumber("getA", 0);
     
    }
    public void start() {
        periodic();
        if ( Area < 2 && Area > 0) {
            newExampleSubsystem.forward(); // 如果目標的面積小於 3，向前移動

            if (Area > 3 || Area == 0) {
                newExampleSubsystem.stop(); // 如果目標的面積大於 3 或無目標，停止

                
            }

         if (Yaw >= 13) {
                newExampleSubsystem.right(); // 如果目標在右邊，向右移動
            } else if (Yaw < -14) {
                newExampleSubsystem.left(); // 如果目標在左邊，向左移動
            } 
        } 
    }
        
    public double cameraToRobot;
    public double kTargetHeight;
    public double kCameraPitch;
    public double kTargetPitch;
    public double kCameraHeight;
 
  
    
    int targetID = target.getFiducialId();//偵測到的基準標記的 ID
    { if (target == null){
        double target = -1;
    }
    else if(target!=null){
       int targetID = target.getFiducialId();}
 }
    double poseAmbiguity = target.getPoseAmbiguity();
    { if (target == null){
        double target = -1;
    }
    else if(target!=null){
        double poseAmbiguity = target.getPoseAmbiguity();}
 }//目標的姿勢有多模糊
    Transform3d bestCameraToTarget = target.getBestCameraToTarget();
    { if (target == null){
        double target = -1;
    }
    else if(target!=null){
        Transform3d bestCameraToTarget = target.getBestCameraToTarget();}}//取得將相機空間（X = 向前、Y = 向左、Z = 向上）對應到物件/基準標記空間（X 向前、Y 向左、Z 向上）的變換
    Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();
    { if (target == null){
        double target = -1;
    }
    else if(target!=null){
        Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();}}}
//取得將相機空間（X = 向前、Y = 向左、Z = 向上）對應到具有最高重投影誤差的物件/基準標記空間
   

// if (aprilTagFieldLayout.getTagPose(target.getFiducialId()).isPresent()) {
//     Pose3d robotPose = PhotonUtils.estimateFieldToRobot(target.getBestCameraToTarget(), aprilTagFieldLayout.getTagPose(target.getFiducialId()), cameraToRobot);
// }
// Pose2d robotPose = PhotonUtils.estimateFieldToRobot(
//   kCameraHeight, kTargetHeight, kCameraPitch, kTargetPitch, Rotation2d.fromDegrees(-target.getYaw()), gyro.getRotation2d(), targetPose, cameraToRobot);
//  cam = new PhotonCamera("testCamera");
// Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); //Cam mounted facing forward, half a meter forward of center, half a meter up from center.
// public double aprilTagFieldLayout;
// // Construct PhotonPoseEstimator
// PhotonPoseEstimator photonPoseEstimator = new PhotonPoseEstimator(aprilTagFieldLayout, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, Cam, robotToCam);

