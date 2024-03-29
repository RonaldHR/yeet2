/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ArcadeDrive extends Subsystem {

  private static ArcadeDrive m_instance;
	public static synchronized ArcadeDrive getInstance() {
		if (m_instance == null){
			m_instance = new ArcadeDrive();
		}
		return m_instance;	
  }
  WPI_TalonSRX frontRightSpx = new WPI_TalonSRX(RobotMap.RIGTHMOTOR1);
  WPI_TalonSRX backRightSpx = new WPI_TalonSRX(RobotMap.RIGTHMOTOR2);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRightSpx, backRightSpx);

  WPI_TalonSRX frontLeftSPX = new WPI_TalonSRX(RobotMap.LEFTMOTOR1);  
  WPI_TalonSRX backLeftSPX = new WPI_TalonSRX(RobotMap.LEFTMOTOR2);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeftSPX, backLeftSPX);


  DifferentialDrive allDrive = new DifferentialDrive(leftMotors, rightMotors);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  

  public void Arcade (double moveValue, double rotateValue) {
    allDrive.arcadeDrive(moveValue, rotateValue);
  }
  



}
