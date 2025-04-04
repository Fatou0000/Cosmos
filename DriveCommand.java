package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;
import java.util.function.DoubleSupplier;

public class DriveCommand extends Command{

    //command to run robot w joysticks input
    private final DoubleSupplier leftSpeed;
    private final DoubleSupplier rightSpeed;
    private final Drive driveSubsystem;
        
    //parameters for local variaables to use later
    public DriveCommand(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, Drive driveSubsystem){
            this.leftSpeed = leftSpeed;
            this.rightSpeed = rightSpeed;
            this.driveSubsystem = driveSubsystem;
            //declares Subsystem dependencies
            addRequirements(driveSubsystem);
        }

@Override
public void initialize(){}

@Override
public void execute(){
     // Get joystick values and pass them to the drive subsystem
     double left = leftSpeed.getAsDouble();
     double right = rightSpeed.getAsDouble();
     
     // Optionally, scale the speed
     double speedFactor = 1.0;  // Adjust if necessary (e.g., 0.8 for 80% speed)
     driveSubsystem.driveTank(left * speedFactor, right * speedFactor);
    
    //DriveCommand will pass the actual joystick values to your Drive subsystem, allowing for real-time control of the robot based on joystick input
    driveSubsystem.driveTank(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
}

@Override
public void end(boolean isInterrupted){
    // Stop the robot when the command ends
    driveSubsystem.driveTank(0.0, 0.0);
}

@Override
public boolean isFinished(){
    return false;
}
}
