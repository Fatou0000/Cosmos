// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutosCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.RollerCommand;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Roller;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive driveSubsystem = new Drive();
  private final Roller rollerSubsystem = new Roller();
  private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController operatorController = new CommandXboxController(OperatorConstants.OPERATOR_CONTROLLER_PORT);
      //autonomous chooser 
  private final SendableChooser<Command> autoChooser = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    //TankDrive command     driveSubsystem.setDefaultCommand(
      
    driveSubsystem.setDefaultCommand(
      new DriveCommand(
    () -> -driverController.getLeftY(),  // Left joystick Y (inverted)
    () -> -driverController.getRightY(), // Right joystick Y (inverted)
    driveSubsystem
)
      );
      //default auto command 
  autoChooser.setDefaultOption("Autonomous", new AutosCommand(driveSubsystem)); 
  }

  /**
   * 
   */
  private void configureBindings(){
    //set A Button to run Roller Command w a valve ejecting gamepiece while button is held
    operatorController.a().whileTrue(new RollerCommand(() -> RollerConstants.ROLLER_EJECT_VALUE, () -> 0, rollerSubsystem));
  driveSubsystem.setDefaultCommand(new DriveCommand(()-> -driverController.getLeftY(),-> -driverController.getRightY(),driveSubsystem));
  
  rollerSubsystem.setDefaultCommand(
    new RollerCommand(
        () -> operatorController.getRightTriggerAxis(),  // Forward input (right trigger)
        () -> operatorController.getLeftTriggerAxis(), // Reverse input (left trigger)
        rollerSubsystem
        )
        );
}

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoChooser.getSelected();
  }
  
  
}
