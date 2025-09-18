// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public double sensitivity;
  private final Motor motors = new Motor();
  // Place all the variables that you want to get from the controlers Here
  double D1LY;
  double D1RX;
  double D1RY;
  double D1RT;
  double D2RT;
  double D2LT;
  double sensitivityMin = .2;
  double sensitivityMax = .5;
  Joystick D1 = new Joystick(0);
  Joystick D2 = new Joystick(1);

  public Robot() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    controlerInput();
    driveControl();
  
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}

  public void controlerInput()
  {
    // place all the inputs that you want to get from the controlers here
    D1LY = -D1.getRawAxis(1);
    D1RX = D1.getRawAxis(4);
    D1RT = D1.getRawAxis(3);
    D1RY = -D1.getRawAxis(5);
    //. D2 INPUTS
    D2RT = D2.getRawAxis(3);
    D2LT = D2.getRawAxis(2);
    
  }
  public void driveControl()
  {
    sensitivity = sensitivityMin + (sensitivityMax - sensitivityMin) * D1RT;
    SmartDashboard.putNumber("Speed", sensitivity);
    // Normal FTC control (Not Cool)
    /*
    SmartDashboard.putNumber("Left", (D1LY * .5 + D1RX * .5));
    SmartDashboard.putNumber("Right", (D1LY * .5 - D1RX * .5));
    motors.wFL.set((D1LY * .5 + D1RX * .5) * sensitivity);
    motors.wBL.set((D1LY * .5 + D1RX * .5) * sensitivity);
    motors.wFR.set(-(D1LY * .5 - D1RX * .5) * sensitivity);
    motors.wBR.set(-(D1LY * .5 - D1RX * .5) * sensitivity);
    */

    // The cooler FRC tank control
    motors.wFL.set(D1LY * sensitivity);
    motors.wBL.set(D1LY * sensitivity);
    motors.wFR.set(-D1RY * sensitivity);
    motors.wBR.set(-D1RY * sensitivity);
    SmartDashboard.putNumber("Left Motor Power", D1LY * sensitivity);
    SmartDashboard.putNumber("Right Motor Power", D1RY * sensitivity);
  }
  public void hangerControl()
  {
    
  }
  public void intakeControl()
  {
    if (D2RT > 0) {
      motors.intake.set(1);
    }
    else if (D2LT > 0) {
      motors.intake.set(-1);
    }
    else {
      motors.intake.set(0);
    }

  }
} 