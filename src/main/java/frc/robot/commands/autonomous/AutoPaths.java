package frc.robot.commands.autonomous;
 
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
//import jdk.vm.ci.code.InstalledCode;
// import sun.tools.tree.InstanceOfExpression;
// import jdk.vm.ci.code.InstalledCode;
import frc.robot.commands.*;
import frc.robot.subsystems.SwerveDriveModule;
 
/** 
 * Point all the wheels toward a given angle.  Don't drive anywhere or move the chassis at all.
 */
public class AutoPaths { // extends CommandBase {
 
    //private SwerveDriveSubsystem m_swerve;
    SwerveDriveSubsystem m_swerve;
 
    public AutoPaths(SwerveDriveSubsystem swerve) {
        m_swerve = swerve;
    }

    public Command Square() {

        return new SequentialCommandGroup(
            new DriveForDist(m_swerve, 0, 60, "0")
            // new SetPoseAngle(m_swerve, 90),
            // new DriveForDist(m_swerve, 60, 0, "0"), 
            // new SetPoseAngle(m_swerve, 180),
            // new DriveForDist(m_swerve, 0, -60, "0"),
            // new DriveForDist(m_swerve, -60, 0, "0"),
            // new SetPoseAngle(m_swerve, 90)
        );

    }

    public Command PlaceHolder() {
        return new WaitCommand(0.25);
    }
}
