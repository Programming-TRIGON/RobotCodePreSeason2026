// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.CollectingCommands;
import frc.robot.commands.GeneralCommands;
import frc.robot.constants.OperatorConstants;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.IntakeCommands;
import frc.robot.subsystems.intake.IntakeConstants;
import frc.robot.subsystems.sparkShooter.SparkShooter;
import frc.robot.subsystems.sparkShooter.SparkShooterCommands;
import frc.robot.subsystems.sparkShooter.SparkShooterConstants;
import frc.robot.subsystems.tank.Tank;
import frc.robot.subsystems.transporter.Transporter;
import frc.robot.subsystems.transporter.TransporterCommands;
import frc.robot.subsystems.transporter.TransporterConstants;

public class RobotContainer {
    public static final Intake INTAKE = new Intake();
    //   public static Shooter SHOOTER = new Shooter();
    public static SparkShooter SPARK_SHOOTER = new SparkShooter();
    public static Transporter TRANSPORTER = new Transporter();
    public static final Tank TANK = new Tank();

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        bindDefaultCommands();
        bindControllerCommands();
    }

    private void bindDefaultCommands() {
        TANK.setDefaultCommand(GeneralCommands.getTankDefaultCommand());
        INTAKE.setDefaultCommand(IntakeCommands.getSetTargetStateCommand(IntakeConstants.IntakeState.REST));
        //     SHOOTER.setDefaultCommand(ShooterCommands.getSetTargetStateCommand(ShooterConstants.ShooterState.REST));
        SPARK_SHOOTER.setDefaultCommand(SparkShooterCommands.getSetTargetStateCommand(SparkShooterConstants.SparkShooterState.REST));
        TRANSPORTER.setDefaultCommand(TransporterCommands.getSetTargetStateCommand(TransporterConstants.TransporterState.REST));
    }

    private void bindControllerCommands() {
        OperatorConstants.COLLECT.whileTrue(CollectingCommands.CollectTennisBall());
    }


    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}