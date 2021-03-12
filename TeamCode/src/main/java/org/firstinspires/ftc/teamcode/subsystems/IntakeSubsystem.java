package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSubsystem extends SubsystemBase {

    private final Motor motor;

    public IntakeSubsystem(final HardwareMap hMap)
    {
        motor = new Motor(hMap, "motorIntake");

    }

    public void on()
    {
        motor.set(1.0);
    }

    public void off()
    {
        motor.set(0.0);
    }

    public void inverse()
    {
        motor.set(-1.0);
    }

}
