/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.ArmSub;

public class ArmCmd extends Command {
  private ArmSub ssIntake;
  private ArmSub ssServo;
  private OI oi;
  double driveDir = 1;
  public ArmCmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    ssIntake = ArmSub.getInstance();
    requires(ssIntake);
    ssServo = ArmSub.getInstance();
    requires(ssServo);
    	oi = OI.getInstance();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  //RUn the arm
  protected void execute() {
    if(oi.stick.getRawAxis(3) < 0){
      driveDir = 1;
    }
    else{
      driveDir =-1;
    }
    if(oi.stick.getRawButton(1)){
      ssIntake.RunIntake(0.5);
    }else if(oi.stick.getRawButton(2)){
      ssIntake.RunIntake(-0.5);
    } else{
      ssIntake.RunIntake(0);
    }

    if(oi.stick.getPOV() == 180){
      ssIntake.RunHeis(1*oi.stick.getRawAxis(3)*driveDir);
    } else if (oi.stick.getPOV() == 0){
      ssIntake.RunHeis(1*oi.stick.getRawAxis(3)*-1*driveDir);
    } else{
      ssIntake.RunHeis(0);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
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
