package frc.robot;

import frc.robot.constants.fields.HomeField;
import frc.robot.constants.robots.RobotA;

public class RobotContainer {
    private RobotA robotConstants;
    private HomeField fieldConstants;

    /**
     * Add classes here
     */
    public RobotContainer() {
        robotConstants = new RobotA();
        fieldConstants = new HomeField();
    }

    /**
     * initializes all commands
     */
    public void initializeCommands() {

    }
}
