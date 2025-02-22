// package frc.robot.subsystems;

// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.math.VecBuilder;
// import edu.wpi.first.math.estimator.PoseEstimator;
// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.LimelightHelpers;
// import frc.robot.Constants.LimelightConstants;


// public class limelight extends SubsystemBase{
//     private final ExampleSubsystem mExampleSubsystem = new ExampleSubsystem();
//     private final poseEstimator m_poseEstimator = new poseEstimator();
//     NetworkTable table = NetworkTableInstance.getDefault().getTable(LimelightConstants.Name);

//    // public double X;
//    public double ID;
//    public double TX;
//    public double TA;

//     public double getTag_X(){
//         TX = LimelightHelpers.getTX("");
//         return TX;
//        // x = LimelightHelpers.getTX("");
//       //  return x;
//     }
//     public double getTag_A(){
//         TA = LimelightHelpers.getTA("");
//         return TA;
//     }
//     public double getTag_ID(){
//         ID = LimelightHelpers.getFiducialID("");
//         return ID;
//     }
//     public void periodic(){
//         getTag_A();
//         getTag_ID();
//         getTag_X();

//         SmartDashboard.putNumber("TagA", TA);
//         SmartDashboard.putNumber("TagID",ID);
//         SmartDashboard.putNumber("TagX",TX);
//     }
//     boolean doRejectUpdate = false;
//     LimelightHelpers.PoseEstimate mt1 = LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight");{

// if (mt1.tagCount == 1 && mt1.rawFiducials.length == 1) {
//     if (mt1.rawFiducials[0].ambiguity > 0.7) {
//         doRejectUpdate = true;
//     }
//     if (mt1.rawFiducials[0].distToCamera > 3) {
//         doRejectUpdate = true;
//     }
// }

// if (mt1.tagCount == 0) {
//     doRejectUpdate = true;
// }

// if (!doRejectUpdate) {
//     m_poseEstimator.setVisionMeasurementStdDevs(VecBuilder.fill(0, 0.5, 9999999));
//     m_poseEstimator.addVisionMeasurement(mt1.pose, mt1.timestampSeconds);
// }
// }
// }
