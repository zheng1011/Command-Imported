package frc.robot.subsystems;

import java.lang.annotation.Target;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class PhotonVision extends SubsystemBase {
    
    PhotonCamera camera = new PhotonCamera("photonvision");
    private PhotonPipelineResult result;
    PhotonTrackedTarget target = result.getBestTarget();
    
    
    boolean hasTargets = result.hasTargets();
    public double Yaw ;
    public double Pitch;
    public double Area;

    int targetID = target.getFiducialId();
    double poseAmbiguity = target.getPoseAmbiguity();
    Transform3d bestCameraToTarget = target.getBestCameraToTarget();
    Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();

        
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
        public void periodic(){
        getYaw();
        getPitch();
        getarea();

        SmartDashboard.putNumber("getY", Yaw);
        SmartDashboard.putNumber("getP",Pitch);
        SmartDashboard.putNumber("getA",Area);
    }

if (aprilTagFieldLayout.getTagPose(target.getFiducialId()).isPresent()) {
    Pose3d robotPose = PhotonUtils.estimateFieldToRobotAprilTag(target.getBestCameraToTarget(), aprilTagFieldLayout.getTagPose(target.getFiducialId()), cameraToRobot);
  }
}



