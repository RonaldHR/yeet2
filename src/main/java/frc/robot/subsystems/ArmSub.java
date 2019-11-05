/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ArmSub extends Subsystem {
  public Spark intake2 = new Spark(RobotMap.Intake2);
  public Spark intake1 = new Spark(RobotMap.Intake1);
  SpeedControllerGroup intake = new SpeedControllerGroup(intake1, intake2);

  public VictorSP Heis = new VictorSP(RobotMap.heis);

  DigitalInput highEndStop = new DigitalInput(RobotMap.HighEnd);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void RunIntake(double speed) {
    intake.set(speed);
  
  }

  public void RunHeis(double speed) {
    Heis.set(speed);
    
  }
  public boolean getHighEndstop() {
    return highEndStop.get();
  }

  private static ArmSub m_instance;
	public static synchronized ArmSub getInstance() {
		if (m_instance == null){
			m_instance = new ArmSub();
		}
		return m_instance;
  }

}
