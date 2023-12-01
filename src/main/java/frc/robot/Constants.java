package frc.robot;

public final class Constants {
  
  /**
  * Contains the CAN IDs of the Drivetrian SparkMax motors
  */ 
  public static final class DrivetrainMotors {
    public static final int FRONT_LEFT_DRIVE = 25;
    public static final int FRONT_LEFT_ANGLE = 23;

    public static final int FRONT_RIGHT_DRIVE = 32;
    public static final int FRONT_RIGHT_ANGLE = 34;

    public static final int BACK_LEFT_DRIVE = 26;
    public static final int BACK_LEFT_ANGLE = 24;

    public static final int BACK_RIGHT_DRIVE = 31;
    public static final int BACK_RIGHT_ANGLE = 33;
  }

  public static final class DrivetrainConstants {
    // set for SwerveyJr 191207
    public static final double WHEELBASE = 27.5;
    public static final double TRACKWIDTH = 18.5;
    public static final double WIDTH = 25.75;
    public static final double LENGTH = 28;

    // PID constants for swerve modules
    public static final double ANGLE_kP = 1.0; //3.0;
    public static final double ANGLE_kI = 0.0;
    public static final double ANGLE_kD = 0.0;    

    // PID constants for whole-drivetrain strafe control
    public static final double STRAFE_kP = 0.01;
    public static final double STRAFE_kI = 0.0;
    public static final double STRAFE_kD = 0.0;

    // PID constants for whole-drivetrain strafe control
    public static final double FORWARD_kP = 0.01;
    public static final double FORWARD_kI = 0.0;
    public static final double FORWARD_kD = 0.0;

    // PID constants for whole-drivetrain strafe control.
    // 0.03, 0, 0.075 are from 2910's pose angle code
    public static final double ROTATION_kP = 0.03;
    public static final double ROTATION_kI = 0.0;
    public static final double ROTATION_kD = 0.0;

    // PID for controlling rotation in DriveForDist2910Command
    // they had set .02, 0, 0 
    public static final double DFD_ROTATION_kP = 0.01;//0.03; // for next test after 3/1, try drastically reducing from 0.03
    public static final double DFD_ROTATION_kI = 0.0;
    public static final double DFD_ROTATION_kD = 0.0;

    // PID for controlling pose angle in SetPoseAngle2910 and VisionAim* commands.
    public static final double POSE_ANGLE_kP = 0.15;//0.03;
    public static final double POSE_ANGLE_kI = 0.0;
    public static final double POSE_ANGLE_kD = 0.0;

    public static final boolean TUNE = false;
  }

  /** 
   * autonomous 
   */
  public static final class AUTO {
    public static final double DISTANCE_CHECK_TIME = 0.25;
    public static final boolean TUNE = false;
    public static final boolean LOG = true;
  }

}