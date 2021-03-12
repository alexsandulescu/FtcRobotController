package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.arcrobotics.ftclib.command.OdometrySubsystem;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveOdometry;
import com.arcrobotics.ftclib.purepursuit.Path;
import com.arcrobotics.ftclib.purepursuit.Waypoint;
import com.arcrobotics.ftclib.purepursuit.waypoints.GeneralWaypoint;
import com.arcrobotics.ftclib.purepursuit.waypoints.StartWaypoint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.vision.DetectedObject;
import org.firstinspires.ftc.teamcode.vision.WebcamVision;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import com.arcrobotics.ftclib.kinematics.Odometry;

@Autonomous
public class AutoDefault extends AutoOM {

    private DetectedObject detectedObject;

    MecanumDriveOdometry odo;
    private Motor motorFL, motorFR, motorBL, motorBR;
    private MecanumDrive mecanum;
    private Path m_path;

    @Override
    protected void setup() {

        motorFL = new Motor(hardwareMap, "motorFL");
        motorFR = new Motor(hardwareMap, "motorFR");
        motorBL = new Motor(hardwareMap, "motorBL");
        motorBR = new Motor(hardwareMap, "motorBR");

        mecanum = new MecanumDrive(true, motorFL, motorFR, motorBL, motorBR);

        RevIMU imu = new RevIMU(hardwareMap, "imu");
        imu.init();

        Translation2d m_frontLeftLocation =
                new Translation2d(0.165, 0.2175);
        Translation2d m_frontRightLocation =
                new Translation2d(0.165, -0.2175);
        Translation2d m_backLeftLocation =
                new Translation2d(-0.165, 0.2175);
        Translation2d m_backRightLocation =
                new Translation2d(-0.165, -0.2175);

        MecanumDriveKinematics kinematics = new MecanumDriveKinematics(
                m_frontLeftLocation,
                m_frontRightLocation,
                m_backLeftLocation,
                m_backRightLocation
        );

        Supplier<Rotation2d> rotation2D = () -> {
            return imu.getRotation2d();
        };

        odo = new MecanumDriveOdometry(kinematics, imu.getRotation2d());


        Waypoint p1 = new StartWaypoint(0, 0);
        Waypoint p2 = new GeneralWaypoint(0, 3);

        m_path = new Path(p1, p2);
        m_path.init();
    }

    @Override
    protected void run() {
//        OdometrySubsystem odometry = new OdometrySubsystem(odo);
//        m_path.followPath(mecanum, odometry);
//        DetectedObject object = webcamVision.getFrontDetection();
//
//        switch (object.objectCode) {
//            case NO_OBJECT: {
//                caseNoObject();
//                break;
//            }
//            case SINGLE: {
//                caseSingle();
//                break;
//            }
//            case QUAD: {
//                caseQuad();
//                break;
//            }
//        }


    }

    private void caseNoObject() {

    }

    private void caseSingle() {

    }

    private void caseQuad() {

    }
}
