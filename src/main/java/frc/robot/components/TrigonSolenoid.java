package frc.robot.components;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * This class attaches booleans values to the enum values from WPILib's double
 * solenoid class
 */
public class TrigonSolenoid extends DoubleSolenoid {
    public TrigonSolenoid(final int forwardChannel, final int reverseChannel) {
        super(forwardChannel, reverseChannel);
    }

    /**
     * Sets state of solenoid with a boolean
     * 
     * @param state true=forward false=reverse
     */
    public void setSolenoid(boolean state) {
        if (state) {
            set(Value.kForward);
        } else {
            set(Value.kReverse);
        }
    }

    public boolean isOn() {
        return get() != Value.kOff;
    }

    public boolean isPushed() {
        return get() == Value.kForward;
    }

    public void off() {
        set(Value.kOff);
    }
}
