package frc.robot.constants;

import frc.robot.utilities.PIDCoefs;

/**
 * All the constants to be uses for the robot
 */
public abstract class RobotConstants extends RobotMap {
    public LimelightConstants limelightConstants = new LimelightConstants();
    public VisionConstants visionConstants = new VisionConstants();

    public class LimelightConstants {
        public double DISTANCE_CALCULATION_A_COEFFICIENT;
        public double DISTANCE_CALCULATION_B_COEFFICIENT;
        public double DISTANCE_CALCULATION_C_COEFFICIENT;
        public double LIMELIGHT_ANGLE_OFFSET;
        public double LIMELIGHT_OFFSET_X;
        public double LIMELIGHT_OFFSET_Y;
        public String DEFAULT_TABLE_KEY;
    }

    public static class VisionConstants {
        public PIDCoefs VISION_ROTATION_SETTINGS;
        public double TARGET_NOT_FOUND_WAIT_TIME;
    }

}
