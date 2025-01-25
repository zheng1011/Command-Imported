package frc.robot.commands;

import java.lang.reflect.GenericSignatureFormatError;
import java.time.Period;
import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.targeting.PhotonPipelineResult;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PhotonVision;

 public class PhotonAprilTag extends Command  {
    
    private final ExampleSubsystem newExampleSubsystem2 = new ExampleSubsystem(); 
    private final PhotonVision newPhotonVision2 = new PhotonVision();
    public RobotContainer newRobotContainer;


//     public void start(){
    
//     if (Area<3 && Area>0){ 
//     newExampleSubsystem.forward();  
          
//         if (Area>3 || Area==0)
//         newExampleSubsystem.stop();
            
//     if (Yaw >= 4) {
//         newExampleSubsystem. right();
//         }
//         else if (Yaw<-4){
//             newExampleSubsystem.left();
//         }
//         else if (Yaw<4 && Yaw>-4)
//         newExampleSubsystem.stop();
            
//            }



    // 子系統和容器
    // private final ExampleSubsystem newExampleSubsystem = new ExampleSubsystem();
    // private final PhotonVision newPhotonVision = new PhotonVision();
    // public RobotContainer nRobotContainer

    // 儲存目標數據的屬性
    // private double Yaw;
    // private double Pitch;
    // private double Area;

    // 定期更新目標資訊的方法

        // 顯示調試資訊
  

    // 根據目標數據執行動作的方法
//     public void start() {
//         if (Area < 3 && Area > 0) {
//             newExampleSubsystem.forward(); // 如果目標的面積小於 3，向前移動

//             if (Area > 3 || Area == 0) {
//                 newExampleSubsystem.stop(); // 如果目標的面積大於 3 或無目標，停止
//             }

//             if (Yaw >= 4) {
//                 newExampleSubsystem.right(); // 如果目標在右邊，向右移動
//             } else if (Yaw < -4) {
//                 newExampleSubsystem.left(); // 如果目標在左邊，向左移動
//             } else if (Yaw < 4 && Yaw > -4) {
//                 newExampleSubsystem.stop(); // 如果目標居中，停止移動
//             }
//         } else {
//             newExampleSubsystem.stop(); // 如果未偵測到目標，停止所有行為
//         }
//     }
// }

 }





