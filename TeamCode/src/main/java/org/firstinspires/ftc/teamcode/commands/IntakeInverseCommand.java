package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class IntakeInverseCommand extends CommandBase {

    private final IntakeSubsystem intake;

    public IntakeInverseCommand(IntakeSubsystem subsystem) {
        intake = subsystem;
        addRequirements(intake);
    }


    @Override
    public void initialize() {
        intake.inverse();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        intake.off();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
