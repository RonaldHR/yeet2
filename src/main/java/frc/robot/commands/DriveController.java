/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.subsystems.ArcadeDrive;

public class DriveController extends Command {
double speedlimit =1;
double driveDir = 1;
  private ArcadeDrive ssDrive;
	private OI oi;
  public DriveController() {
    ssDrive = ArcadeDrive.getInstance();
    	requires(ssDrive);
    	oi = OI.getInstance();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(oi.stick.getRawAxis(3) < 0){
      driveDir = 1;
    }
    else{
      driveDir =-1;
    }

ssDrive.Arcade(oi.stick.getRawAxis(1)*oi.stick.getRawAxis(3), oi.stick.getRawAxis(2)*oi.stick.getRawAxis(3)*driveDir*-1);


    
  
} 


  // Make this return true when this  Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
