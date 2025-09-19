// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  // Get the motor declaration
  SparkMax wFL;
  SparkMax wFR;
  SparkMax wBL;
  SparkMax wBR;
  SparkMax hanger;
  SparkMax intake;
  /** Creates a new Motor. */
  public Motor() {
    // Get the motors to the type and their id (Use the rev program)

    // Wheel motors (4)
    wFL = new SparkMax(6, MotorType.kBrushless);
    wFR = new SparkMax(2, MotorType.kBrushless);
    wBL = new SparkMax(7, MotorType.kBrushless);
    wBR = new SparkMax(3, MotorType.kBrushless);
    intake = new SparkMax(1, MotorType.kBrushless);

    // Hanger motor (Activate once instaled)
    // hanger = new SparkMax(0, MotorType.kBrushless);
    
    // Intake Motor (Activate once instaled)
    // intake = new SparkMax(0, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
