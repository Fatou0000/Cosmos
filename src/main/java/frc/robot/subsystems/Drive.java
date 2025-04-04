package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkBase.PersistMode;
//import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drive extends SubsystemBase{
    private final SparkMax leftLeader;
    private final SparkMax leftFollower;
    private final SparkMax rightLeader;
    private final SparkMax rightFollower;
    private final SparkMaxConfig leftConfig;
    private final SparkMaxConfig rightConfig;

    private final DifferentialDrive Drive;
    //Drive Constructor
    public Drive(){
        //reminder these r from 0-># so 5 is actually 6
        //double check spark max actual yk
        leftLeader = new SparkMax(1, MotorType.kBrushless);
        leftFollower = new SparkMax(2, MotorType.kBrushless);
        rightLeader = new SparkMax(3, MotorType.kBrushless);
        rightFollower = new SparkMax(4, MotorType.kBrushless);
        
        leftConfig = new SparkMaxConfig();
        rightConfig = new SparkMaxConfig();

        leftConfig.follow(leftLeader);
        rightConfig.follow(rightLeader);

        leftFollower.configure(leftConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
        rightFollower.configure(rightConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

        
    
        
        Drive = new DifferentialDrive(leftLeader, rightLeader);

    }
    //method to drive robot w tank control
    public void driveTank(double leftSpeed, double rightSpeed){


        Drive.tankDrive(leftSpeed, rightSpeed);

}

public Command auto(){
    return run(()->driveTank(1.0,1.0));



}

}
