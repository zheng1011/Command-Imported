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
    private int ID;
    private boolean hastarget;

    List<PhotonTrackedTarget> targets = result.getTargets();

    public void getvisionnum() {
        PhotonPipelineResult result = camera.getLatestResult();
        PhotonTrackedTarget target = result.getBestTarget();

        if (result.hasTargets()) {
            area = target.getArea();
            yaw = target.getYaw();
            pitch = target.getPitch();
            ID = target.getFiducialId();
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
    public int getFiducialId(){
        return ID;
    }

    

    public boolean hasTarget() {
        return result.hasTargets();
        // return hastarget;
    }


    @Override
    public void periodic() {
        result = camera.getLatestResult();

        
        if (result.hasTargets()) {
            // getnumfromVision();
            SmartDashboard.putNumber("getY", result.getBestTarget().getYaw());
            SmartDashboard.putNumber("getP", result.getBestTarget().getPitch());
            SmartDashboard.putNumber("getA", result.getBestTarget().getArea());
            SmartDashboard.putNumber("getID", result.getBestTarget().getFiducialId());
                SmartDashboard.getNumber("getY", result.getBestTarget().getYaw());
                SmartDashboard.getNumber("getP", result.getBestTarget().getPitch());
                SmartDashboard.getNumber("getA",result.getBestTarget().getArea());
                SmartDashboard.getNumber("getID",result.getBestTarget().getFiducialId());
        }
            // double Yaw = SmartDashboard.getNumber("getY", 0);
            // double Pitch = SmartDashboard.getNumber("getP", 0);
            // double Area = SmartDashboard.getNumber("getA", 0);
        }
    
    public void start() {
        if (result != null && result.hasTargets()) {
            PhotonTrackedTarget bestTarget = result.getBestTarget();
            
            ID = result.getBestTarget().getFiducialId();
            area = result.getBestTarget().getArea();
            yaw = result.getBestTarget().getYaw();
                
                if (area < 3 && area > 1) {
                    mExampleSubsystem.forward();
                } else if (area <= 1) {
                    mExampleSubsystem.backward();
                } else if (area > 3 || area == 0) {
                    mExampleSubsystem.stop();
                }       
    
                if (yaw > 13) {
                    mExampleSubsystem.right();
                } else if (yaw < -14) {
                    mExampleSubsystem.left();
                } else if (yaw >= -14 && yaw <= 13) {
                    mExampleSubsystem.stop();
                }
            }
        } 
    }

    

    