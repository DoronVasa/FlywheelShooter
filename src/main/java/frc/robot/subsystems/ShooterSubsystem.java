package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Subsystems.Shooter;

public class ShooterSubsystem extends SubsystemBase {
    private final TalonFX leftTalonFX = new TalonFX(Shooter.LEFT_TALONFX_ID);
    private final TalonFX rightTalonFX = new TalonFX(Shooter.RIGHT_TALON_ID);    

    private VelocityVoltage velocityVoltageObj;

    public ShooterSubsystem(){
        final Follower followerObj = new Follower(Shooter.RIGHT_TALON_ID, true); 
        leftTalonFX.setControl(followerObj);
    }

    public void SetSetPoint(double setPoint){
        velocityVoltageObj = new VelocityVoltage(setPoint); 
    }

    public void SetMotorTarget(){
        rightTalonFX.setControl(velocityVoltageObj);
    }

    public void MoveMotor(double speed){
        this.rightTalonFX.set(speed);
    }

    public void stopMotor(){
        this.rightTalonFX.set(0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Shooter RPS", rightTalonFX.getVelocity().getValueAsDouble() + leftTalonFX.getVelocity().getValueAsDouble() / 2);
    }
}
