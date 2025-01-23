package frc.robot.subsystems;

import java.lang.annotation.Target;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class PhotonVision extends SubsystemBase {
   
    PhotonCamera camera = new PhotonCamera("photonvision");
    private PhotonPipelineResult result = camera.getLatestResult();
    PhotonTrackedTarget target = result.getBestTarget();
    
    
    boolean hasTargets = result.hasTargets();
    public double Yaw ;
    public double Pitch;
    public double Area;
    
    
    
        
    public double getYaw(){
        Yaw = target.getYaw();
            return Yaw;
        }
    public double getPitch(){
        Pitch = target.getPitch();
            return Pitch;
        }
    public double getarea(){
         Area = target.getArea();
            return Area;
        }
        Transform3d pose = target.getBestCameraToTarget();
        
    @Override
        public void periodic(){
        getYaw();
        getPitch();
        getarea();
    System.out.println(hasTargets);
        SmartDashboard.putNumber("getY", Yaw);
        SmartDashboard.putNumber("getP",Pitch);
        SmartDashboard.putNumber("getA",Area);}
    public double cameraToRobot;
    public double kTargetHeight;
    public double kCameraPitch;
    public double kTargetPitch;
    public double kCameraHeight;
    int targetID = target.getFiducialId();//偵測到的基準標記的 ID
    double poseAmbiguity = target.getPoseAmbiguity();//目標的姿勢有多模糊
    Transform3d bestCameraToTarget = target.getBestCameraToTarget();//取得將相機空間（X = 向前、Y = 向左、Z = 向上）對應到物件/基準標記空間（X 向前、Y 向左、Z 向上）的變換
    Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();//取得將相機空間（X = 向前、Y = 向左、Z = 向上）對應到具有最高重投影誤差的物件/基準標記空間
        

// if (aprilTagFieldLayout.getTagPose(target.getFiducialId()).isPresent()) {
//     Pose3d robotPose = PhotonUtils.estimateFieldToRobot(target.getBestCameraToTarget(), aprilTagFieldLayout.getTagPose(target.getFiducialId()), cameraToRobot);
// }
// Pose2d robotPose = PhotonUtils.estimateFieldToRobot(
//   kCameraHeight, kTargetHeight, kCameraPitch, kTargetPitch, Rotation2d.fromDegrees(-target.getYaw()), gyro.getRotation2d(), targetPose, cameraToRobot);
 }



