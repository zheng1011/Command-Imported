// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.PrintStream;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.chassisID;

public class ExampleSubsystem extends SubsystemBase{
  public final WPI_VictorSPX Frontleft = new WPI_VictorSPX(chassisID.FL);
    public final WPI_VictorSPX Frontright = new WPI_VictorSPX(chassisID.FR);
      public final WPI_VictorSPX Rearleft = new WPI_VictorSPX(chassisID.RL);
        public final WPI_VictorSPX Rearright = new WPI_VictorSPX(chassisID.RR);

  public DifferentialDrive tank = new DifferentialDrive(Frontleft, Frontright);

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
  Frontleft.configFactoryDefault();
  Frontright.configFactoryDefault();
  Rearleft.configFactoryDefault();
  Rearleft.configFactoryDefault();

  Frontleft.setInverted(false);
  Frontright.setInverted(true);
    Rearleft.setInverted(false);
    Rearright.setInverted(true);

    Rearleft.follow(Frontleft);
    Rearright.follow(Frontright);
    }
  
  public void drive(double X, double Y){
    tank.arcadeDrive(-X, -Y);
  }

  public void moveAnimation(){
    double ID  = LimelightHelpers.getFiducialID("");
    double Tag_Area = LimelightHelpers.getTA("");
    
    System.out.println(Tag_Area);

    while (Tag_Area > 0 && Tag_Area < 5 ){
      Frontleft.set(0.2);
      Frontright.set(0.2);
        // tank.arcadeDrive(0.3, 0);
    }
  }
  
  /**
   * Example command factory method.                                                
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  public void forward(){
    Frontleft.set(0.3);
    Frontright.set(0.3);
    Rearleft.set(0.3);
    Rearright.set(0.3);
   

  }

  public void backward(){
    Frontleft.set(-0.3);
    Frontright.set(-0.3);
    Rearleft.set(-0.3);
    Rearright.set(-0.3);
    

  }
  public void right(){
    Frontleft.set(0.3);
    Frontright.set(-0.3);
    Rearleft.set(0.3);
    Rearright.set(-0.3);
  

  }
  public void left(){
    Frontleft.set(-0.3);
    Frontright.set(0.3);
    Rearleft.set(-0.3);
    Rearright.set(0.3);
 

  }

  public void stop(){
    Frontleft.set(0);
    Frontright.set(0);
    Rearleft.set(0);
    Rearright.set(0);
  }
  
  // public void start(){
    
    
  //   double Tag_Area = LimelightHelpers.getTA("");
  //   double Tag_X = LimelightHelpers.getTX("");
    
  //   // double AprilArea = SmartDashboard.getNumber("getA", AprilA);
  //   // double AprilY = SmartDashboard.getNumber("getYaw",AprilY );
  //   // double AprilP = SmartDashboard.getNumber("getPitch", AprilP);
  //   if (Tag_Area<3 && Tag_Area>0){ 
  //     forward();  
    
  //   if (Tag_Area>3||Tag_Area==0)stop();
      
  //   if (Tag_X >= 4) {
  //       right();     
  //   }
  //     else if (Tag_X<-4){
  //       left();
  //     }
      

   
    
  }


  
  


  


  
 