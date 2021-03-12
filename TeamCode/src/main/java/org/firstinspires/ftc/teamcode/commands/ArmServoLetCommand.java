package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class ArmServoLetCommand extends CommandBase {

    private final ArmSubsystem arm;

    public ArmServoLetCommand(ArmSubsystem subsystem) {
        arm = subsystem;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.let();
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
