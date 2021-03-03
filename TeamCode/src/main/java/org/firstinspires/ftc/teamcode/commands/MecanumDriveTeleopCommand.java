package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveTeleopSubsystem;

import java.util.function.DoubleSupplier;

public class MecanumDriveTeleopCommand extends CommandBase {
    private final MecanumDriveTeleopSubsystem m_drive;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_strafe;
    private final DoubleSupplier m_rotation;

    public MecanumDriveTeleopCommand(MecanumDriveTeleopSubsystem subsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn) {
        m_drive = subsystem;
        m_forward = forward;
        m_strafe = strafe;
        m_rotation = turn;

        addRequirements(m_drive);
    }

    @Override
    public void execute() {
        m_drive.move(m_forward.getAsDouble(), m_strafe.getAsDouble(), m_rotation.getAsDouble());
    }

}
