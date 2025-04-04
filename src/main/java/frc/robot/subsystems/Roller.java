package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants; 

public class Roller extends SubsystemBase{
    private static final double FORWARD_POWER = 0.3;

    private final SparkMax rollerMotor;
    public Roller(){
        rollerMotor = new SparkMax(5, MotorType.kBrushless);
        rollerMotor.setInverted(false); //set true if motors spin the wrong way
    }
    
    /**
     * Runs the rollers at a certain power
     * @param power A number from -1 to 1 representing the power for the roller. 1 is forward, -1 is backward.
     */
    public void runRoller(double power){
        //he idea here is that positive input for forward will make the motor spin in one direction
        //while a negative value for reverse will make the motor spin in the opposite direction
        rollerMotor.set(power); //pos = intake neg = eject
            }

    public Command runForward() {
        return run(() -> runRoller(FORWARD_POWER));
    }

@Override
public void periodic(){
}
}
