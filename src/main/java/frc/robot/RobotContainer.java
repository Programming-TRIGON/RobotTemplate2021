package frc.robot;

import frc.constants.fields.HomeField;
import frc.constants.robots.RobotA;

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
}
