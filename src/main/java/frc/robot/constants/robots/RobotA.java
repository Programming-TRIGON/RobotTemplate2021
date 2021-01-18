package frc.robot.constants.robots;

import frc.robot.constants.RobotConstants;

/**
 * instantiates the robot constants
 */
public class RobotA extends RobotConstants {

    // TODO: Set Constants
    public RobotA() {
        // Limelight Constants
        limelightConstants.DISTANCE_CALCULATION_A_COEFFICIENT = 1;
        limelightConstants.DISTANCE_CALCULATION_B_COEFFICIENT = 1;
        limelightConstants.DISTANCE_CALCULATION_C_COEFFICIENT = 1;
        limelightConstants.LIMELIGHT_ANGLE_OFFSET = 1;
        limelightConstants.LIMELIGHT_OFFSET_X = 1;
        limelightConstants.LIMELIGHT_OFFSET_Y = 1;
        limelightConstants.DEFAULT_TABLE_KEY = "limelight";

        testerConstants.MOVE_POWER = 1;
        testerConstants.SECONDS_TO_WAIT = 3;
    }
}
