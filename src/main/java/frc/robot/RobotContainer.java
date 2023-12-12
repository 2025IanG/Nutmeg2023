/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.AutoPaths;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Define subsystems here
  private final SwerveDriveSubsystem m_swerve = new SwerveDriveSubsystem();

  // Define Joysticks and Buttons here
  private final XboxController driveStick = new XboxController(0);
  private final XboxController subStick = new XboxController(1);

  private final JoystickButton driveA = new JoystickButton(driveStick, XboxController.Button.kA.value);
  private final JoystickButton driveB = new JoystickButton(driveStick, XboxController.Button.kB.value);
  private final JoystickButton driveX = new JoystickButton(driveStick, XboxController.Button.kX.value);
  private final JoystickButton driveY = new JoystickButton(driveStick, XboxController.Button.kY.value);
  private final JoystickButton driveLB = new JoystickButton(driveStick, XboxController.Button.kLeftBumper.value);
  private final JoystickButton driveRB = new JoystickButton(driveStick, XboxController.Button.kRightBumper.value);

  private final JoystickButton subA = new JoystickButton(subStick, XboxController.Button.kA.value);
  private final JoystickButton subB = new JoystickButton(subStick, XboxController.Button.kB.value);
  private final JoystickButton subX = new JoystickButton(subStick, XboxController.Button.kX.value);
  private final JoystickButton subY = new JoystickButton(subStick, XboxController.Button.kY.value);
  private final JoystickButton subLB = new JoystickButton(subStick, XboxController.Button.kLeftBumper.value);
  private final JoystickButton subRB = new JoystickButton(subStick, XboxController.Button.kRightBumper.value);
  

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the default commands
    configureDefaultCommands();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //left bumper switches from field orientated to robot oriented // has a fun lambda
    driveLB.onTrue(
        new InstantCommand(()-> {m_swerve.setFieldOriented(false);})
      ).onFalse(
        new InstantCommand(()-> {m_swerve.setFieldOriented(true);})
      );

    // Put brake mode on a button!
    driveRB.onTrue(
        new InstantCommand(m_swerve::setBrakeOff, m_swerve)
      ).onFalse(
        new InstantCommand(m_swerve::setBrakeOn, m_swerve)
      );
  }

  private void configureDefaultCommands() {
    // Using StartEnd commands because by default they do not have isFinished return true, unlike InsantCommands. Alternative is to use the perpetually() decorator.
    // default swerve drive is to read from joysticks
    m_swerve.setDefaultCommand(new DefaultSwerveCommand(m_swerve, driveStick));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand( String a) {

    Command autoCommand = new AutoPaths(m_swerve).Square();

    return autoCommand;
  }
}