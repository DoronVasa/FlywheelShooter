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
  public static class SubsystemsConstants{
    public static class ShooterSubsystemConstants{
      public static final int TALON_SUBSYSTEM_SHOOTER_ID = 1;
      public static final int INVERTED_TALON_SUBSYSTEM_SHOTTER_ID = 2;
      
      public static class ShooterSubsystemPIDConstants{
        // Quad imbeded classes pog
        public static final double KP = 1;
        public static final double KI = 1;
        public static final double KD = 1;
      }
    }
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}