package frc.robot.subsystems.sparkShooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.RobotContainer;

public class SparkShooterCommands {
    public static Command getSetTargetStateCommand(SparkShooterConstants.SparkShooterState targetState) {
        return new StartEndCommand(
                () -> RobotContainer.SPARK_SHOOTER.setTargetState(targetState),
                RobotContainer.SPARK_SHOOTER::stop
        );
    }
}
