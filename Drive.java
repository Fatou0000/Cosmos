package frc.robot.subsystems;

// import com.revrobotics.spark.SparkBase.PersistMode;
//import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drive extends SubsystemBase{
    private final SparkMax leftLeader;
    private final SparkMax leftFollower;
    private final SparkMax rightLeader;
    private final SparkMax rightFollower;

    private final DifferentialDrive Drive;
    //Drive Constructor
    public Drive(){
        leftLeader = new SparkMax(1, MotorType.kBrushless);
        leftFollower = new SparkMax(2, MotorType.kBrushless);
        rightLeader = new SparkMax(3, MotorType.kBrushless);
        rightFollower = new SparkMax(4, MotorType.kBrushless);
    
        
        Drive = new DifferentialDrive(leftLeader, rightLeader);

    }
    //method to drive robot w tank control
    public void driveTank(double leftSpeed, double rightSpeed){
        leftFollower.set(1);
        rightFollower.set(1);

        Drive.tankDrive(1, 1);

}



}
