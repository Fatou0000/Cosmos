// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0; //Adjust if necessary for controller
    public static final int OPERATOR_CONTROLLER_PORT = 1; //should correspond to the correct USB port numbers on robot’s control system.
  }
  public static final class DriveConstants {
    public static final int LEFT_MOTOR_ID = 1;
    public static final int RIGHT_MOTOR_ID = 2;
  }
  public static final class RollerConstants {
    public static final int ROLLER_MOTOR_ID = 3;
    //def gotta check these values
    public static final double ROLLER_EJECT_VALUE = 0.8;
    public static final double ROLLER_INTAKE_VALUE = -0.8;
  }
  public static final class AutoConstants {
    //might need to change i dont want us to crash
    public static final double AUTO_DRIVE_SPEED = 1.0;
    //might have to change 
    public static final double AUTO_TIME_SECONDS = 3.0;
}
}
