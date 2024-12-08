package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class ShooterSubsystem {
    private final TalonFX talonFX = new TalonFX(Constants.SubsystemsConstants.ShooterSubsystemConstants.TALON_SUBSYSTEM_SHOOTER_ID);
    private final TalonFX invertedTalonFX = new TalonFX(Constants.SubsystemsConstants.ShooterSubsystemConstants.INVERTED_TALON_SUBSYSTEM_SHOTTER_ID);    

    private final PIDController pid = new PIDController(Constants.SubsystemsConstants.ShooterSubsystemConstants.ShooterSubsystemPIDConstants.KP, Constants.SubsystemsConstants.ShooterSubsystemConstants.ShooterSubsystemPIDConstants.KI, Constants.SubsystemsConstants.ShooterSubsystemConstants.ShooterSubsystemPIDConstants.KD); // mhm great names very readable 👍

    public ShooterSubsystem(){
        this.talonFX.setInverted(false);
        this.invertedTalonFX.setInverted(true);
        this.pid.setSetpoint(3000);
    }

    public double GetSpeedInRPM(){
        return this.talonFX.getVelocity().getValueAsDouble() * 60;
    }

    public double CalculatePID(){
        return pid.calculate(GetSpeedInRPM());
    }

    public void MoveMotor(double speed){
        this.talonFX.set(speed);
        this.invertedTalonFX.set(speed);
    }
}
