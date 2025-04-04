package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants; 

public class Roller extends SubsystemBase{
    private final SparkMax rollerMotor;
    public Roller(){
        rollerMotor = new SparkMax(RollerConstants.ROLLER_MOTOR_ID, MotorType.kBrushless);
        rollerMotor.setInverted(false); //set true f motors spin the wrong way
    }
    
    
    public void runRoller(double foward, double reverse){
        rollerMotor.set(foward - reverse); //pos = intake neg = eject
            }

@Override
public void periodic(){
}
}
