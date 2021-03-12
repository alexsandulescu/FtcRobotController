package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.Timing;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeSubsystem extends SubsystemBase {

    Motor motor;
    SimpleServo servo;

    public OuttakeSubsystem(HardwareMap hMap) {
        motor = new Motor(hMap, "motorOuttake");
        servo = new SimpleServo(hMap, "servoOuttake");
        servo.setRange(0.0, 1.0);
    }

    public void on() {
        motor.set(1.0);
    }

    public void off() {
        motor.set(0.0);
    }

    public void launchServo() {
        servo.setPosition(1.0);
    }

    public double getServoPos() {
        return servo.getPosition();
    }

    public void retreatServo() {
        servo.setPosition(0.0);
    }

}
