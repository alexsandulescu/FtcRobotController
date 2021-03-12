package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem extends SubsystemBase {

    SimpleServo servo;
    Motor armMotor;
    public static double armSpeed = 1.0;

    public ArmSubsystem(final HardwareMap hMap, final Boolean isTeleop) {
        servo = new SimpleServo(hMap, "servoArm");

        armMotor = new Motor(hMap, "motorArm");
        if(isTeleop)
            armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void grab() {
        servo.setPosition(0.0);
    }

    public void let() {
        servo.setPosition(0.7);
    }

    public void moveArm(int direction) {
        armMotor.set(-direction * armSpeed);
    }

}
