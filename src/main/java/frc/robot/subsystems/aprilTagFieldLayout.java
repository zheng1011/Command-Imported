package frc.robot.subsystems;

import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.targeting.PhotonPipelineResult;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class aprilTagFieldLayout extends SubsystemBase {
    final Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); //Cam mounted facing forward, half a meter forward of center, half a meter up from center.
    PhotonCamera cam = new PhotonCamera("testCamera");
    AprilTagFieldLayout AprilTagFieldLayoutO = AprilTagFieldLayout.loadField(AprilTagFields.kDefaultField);  //找出最近距離                                                                                             //找出最近距離
    PhotonPoseEstimator photonPoseEstimator = new PhotonPoseEstimator(AprilTagFieldLayoutO, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, robotToCam);
                     //估算機器人在場地中的位置與方向                    //識別AprilTag的ID找出找出場地上的絕對位置                       //將目標位置從「相機坐標系」轉換到「機器人坐標系」
    public aprilTagFieldLayout() {}
                                                              

    public static Object getTagPose(int fiducialId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTagPose'");
    }    
     
    public Optional<EstimatedRobotPose> getEstimatedGlobalPose(Pose2d prevEstimatedRobotPose, PhotonPipelineResult latestResult) {
        photonPoseEstimator.setReferencePose(prevEstimatedRobotPose);
        return photonPoseEstimator.update(latestResult);
    }

    





}