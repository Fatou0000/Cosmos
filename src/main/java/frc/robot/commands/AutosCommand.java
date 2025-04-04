package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;


public class AutosCommand extends Command {

  private final Drive driveSubsystem;
  private final Timer timer= new Timer();
  private final double duration = 15.0; //Auto duration
  private final double secounds = 1.0; //Tank full speed ahead?
 
  public AutosCommand(Drive driveSubsystem) {
    
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  } 
  

  @Override
  public void initialize(){
    timer.reset();
    timer.start();
  }

  @Override
  public void execute(){
//Left and right motor set to speed of 1
    driveSubsystem.driveTank(1.0, 1.0); //full speed ahead
  }

  @Override
  public void end(boolean isInterrupted){
    //same issue here
    driveSubsystem.driveTank(0.0,0.0);
  }

  @Override
  //returns true when time os over 1 secound
  public boolean isFinished(){
    return timer.get() >= duration;
  }

}