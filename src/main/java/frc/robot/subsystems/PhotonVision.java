package frc.robot.subsystems;

import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

import org.photonvision.*;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class PhotonVision extends SubsystemBase {
    public PhotonCamera camera = new PhotonCamera("limelight");
    private PhotonPipelineResult result = camera.getLatestResult();
    private ExampleSubsystem mExampleSubsystem = new ExampleSubsystem();
    PhotonTrackedTarget target; 
    private double yaw;
    private double pitch;
    private double area;
    private boolean hastarget;

    List<PhotonTrackedTarget> targets = result.getTargets();

    public void getvisionnum() {
        PhotonPipelineResult result = camera.getLatestResult();
        PhotonTrackedTarget target = result.getBestTarget();

        if (result.hasTargets()) {
            area = target.getArea();
            yaw = target.getYaw();
            pitch = target.getPitch();
            hastarget = true;}

            

    }

    // 提供 getter 方法
    public double getYaw() {
        return yaw;
    }

    // public double getPitch() {
    // return pitch;
    // }

    public double getArea() {
        return area;
    }

    public boolean hasTarget() {
        return result.hasTargets();
        // return hastarget;
    }

    

    

    

    public void getnumfromVision() {
        if (result.hasTargets()) {
            
            
            
            
            
            target = result.getBestTarget();
            yaw = target.getYaw();
            pitch = target.getPitch();
            area = target.getArea();
            hastarget = result.hasTargets();

            Transform3d bestCameraToTarget = target.getBestCameraToTarget();
        
            
        }

        
    }

    @Override
    public void periodic() {
        result = camera.getLatestResult();

        
        if (result.hasTargets()) {
            // getnumfromVision();
            SmartDashboard.putNumber("getY", result.getBestTarget().getYaw());
            SmartDashboard.putNumber("getP", result.getBestTarget().getPitch());
            SmartDashboard.putNumber("getA", result.getBestTarget().getArea());
            SmartDashboard.getNumber("getY", result.getBestTarget().getYaw());
            SmartDashboard.getNumber("getP", result.getBestTarget().getPitch());
            SmartDashboard.getNumber("getA",result.getBestTarget().getArea());
        }
            // double Yaw = SmartDashboard.getNumber("getY", 0);
            // double Pitch = SmartDashboard.getNumber("getP", 0);
            // double Area = SmartDashboard.getNumber("getA", 0);
        }


        public void start(){

            if (result.getBestTarget().getArea()<3 && result.getBestTarget().getArea()>1){
                mExampleSubsystem.forward();
            }
                else if (result.getBestTarget().getArea()<=1){
                mExampleSubsystem.backward();
                }
              
                else if (result.getBestTarget().getArea()>3 || result.getBestTarget().getArea()==0){
                mExampleSubsystem.stop();
                }
                
            if (result.getBestTarget().getYaw()> 13) {
                mExampleSubsystem.right();     
            }
                else if (result.getBestTarget().getYaw()<-14){
                    mExampleSubsystem.left();}
                else if (result.getBestTarget().getYaw()<13 && result.getBestTarget().getYaw()>-14 ){
                    mExampleSubsystem.stop();
                }
        
        }
    }

    