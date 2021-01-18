package frc.robot.componants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

/**
 * This class stores the configuration of a motor
 */
public class MotorConfig {

    private double rampRate;
    private boolean isInverted;
    private boolean isSensorInverted;
    private NeutralMode neutralMode;
    private double voltageCompSaturation;
    private SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration;

    public MotorConfig() {
        this(0);
    }

    public MotorConfig(MotorConfig motorConfig, boolean isInverted) {
        this(motorConfig.getRampRate(), isInverted, motorConfig.getVoltageCompSaturation(),
                motorConfig.getSupplyCurrentLimitConfiguration());
    }

    public MotorConfig(MotorConfig motorConfig, boolean isInverted, boolean isSensorInverted) {
        this(motorConfig.getRampRate(), isInverted, isSensorInverted, motorConfig.getVoltageCompSaturation(),
                motorConfig.getSupplyCurrentLimitConfiguration());
    }

    /**
     * 
     * @param rampRate Minimum desired time to go from neutral to full throttle. A
     *                 value of '0' will disable the ramp.
     */
    public MotorConfig(double rampRate) {
        this(rampRate, false);
    }

    /**
     * 
     * @param rampRate   Minimum desired time to go from neutral to full throttle. A
     *                   value of '0' will disable the ramp.
     * @param isInverted Inverts the hbridge output of the motor controller.
     */
    public MotorConfig(double rampRate, boolean isInverted) {
        this(rampRate, isInverted, false);
    }

    /**
     * 
     * @param rampRate         Minimum desired time to go from neutral to full
     *                         throttle. A value of '0' will disable the ramp.
     * @param isInverted       Inverts the hbridge output of the motor controller.
     * @param isSensorInverted Sets the phase of the sensor. Use when controller
     *                         forward/reverse output doesn't correlate to
     *                         appropriate forward/reverse reading of sensor. Pick a
     *                         value so that positive PercentOutput yields a
     *                         positive change in sensor.
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted) {
        this(rampRate, isInverted, isSensorInverted, NeutralMode.Coast);
    }

    /**
     * 
     * @param rampRate    Minimum desired time to go from neutral to full throttle.
     *                    A value of '0' will disable the ramp.
     * @param neutralMode The desired mode of operation when the Controller output
     *                    throttle is neutral (ie brake/coast)
     */
    public MotorConfig(double rampRate, NeutralMode neutralMode) {
        this(rampRate, false, false, neutralMode);
    }

    /**
     * 
     * @param rampRate         Minimum desired time to go from neutral to full
     *                         throttle. A value of '0' will disable the ramp.
     * @param isInverted       Inverts the hbridge output of the motor controller.
     * @param isSensorInverted Sets the phase of the sensor. Use when controller
     *                         forward/reverse output doesn't correlate to
     *                         appropriate forward/reverse reading of sensor. Pick a
     *                         value so that positive PercentOutput yields a
     *                         positive change in sensor.
     * @param neutralMode      The desired mode of operation when the Controller
     *                         output throttle is neutral (ie brake/coast)
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted, NeutralMode neutralMode) {
        this(rampRate, isInverted, isSensorInverted, neutralMode, 0);
    }

    /**
     * 
     * @param rampRate              Minimum desired time to go from neutral to full
     *                              throttle. A value of '0' will disable the ramp.
     * @param voltageCompSaturation This is the max voltage to apply to the hbridge
     *                              when voltage compensation is enabled. For
     *                              example, if 10 (volts) is specified and a motor
     *                              controller is commanded to 0.5 (PercentOutput,
     *                              closed-loop, etc) then the motor controller will
     *                              attempt to apply a duty-cycle to produce 5V. A
     *                              value of 0 disables this feature.
     */
    public MotorConfig(double rampRate, double voltageCompSaturation) {
        this(rampRate, false, voltageCompSaturation);
    }

    /**
     * 
     * @param rampRate              Minimum desired time to go from neutral to full
     *                              throttle. A value of '0' will disable the ramp.
     * @param isInverted            Inverts the hbridge output of the motor
     *                              controller.
     * @param voltageCompSaturation This is the max voltage to apply to the hbridge
     *                              when voltage compensation is enabled. For
     *                              example, if 10 (volts) is specified and a motor
     *                              controller is commanded to 0.5 (PercentOutput,
     *                              closed-loop, etc) then the motor controller will
     *                              attempt to apply a duty-cycle to produce 5V. A
     *                              value of 0 disables this feature.
     */
    public MotorConfig(double rampRate, boolean isInverted, double voltageCompSaturation) {
        this(rampRate, isInverted, false, voltageCompSaturation);
    }

    /**
     * 
     * @param rampRate              Minimum desired time to go from neutral to full
     *                              throttle. A value of '0' will disable the ramp.
     * @param isInverted            Inverts the hbridge output of the motor
     *                              controller.
     * @param isSensorInverted      Sets the phase of the sensor. Use when
     *                              controller forward/reverse output doesn't
     *                              correlate to appropriate forward/reverse reading
     *                              of sensor. Pick a value so that positive
     *                              PercentOutput yields a positive change in
     *                              sensor.
     * @param voltageCompSaturation This is the max voltage to apply to the hbridge
     *                              when voltage compensation is enabled. For
     *                              example, if 10 (volts) is specified and a motor
     *                              controller is commanded to 0.5 (PercentOutput,
     *                              closed-loop, etc) then the motor controller will
     *                              attempt to apply a duty-cycle to produce 5V. A
     *                              value of 0 disables this feature.
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted, double voltageCompSaturation) {
        this(rampRate, isInverted, isSensorInverted, NeutralMode.Coast, voltageCompSaturation);
    }

    /**
     * 
     * @param rampRate              Minimum desired time to go from neutral to full
     *                              throttle. A value of '0' will disable the ramp.
     * @param neutralMode           The desired mode of operation when the
     *                              Controller output throttle is neutral (ie
     *                              brake/coast)
     * @param voltageCompSaturation This is the max voltage to apply to the hbridge
     *                              when voltage compensation is enabled. For
     *                              example, if 10 (volts) is specified and a motor
     *                              controller is commanded to 0.5 (PercentOutput,
     *                              closed-loop, etc) then the motor controller will
     *                              attempt to apply a duty-cycle to produce 5V. A
     *                              value of 0 disables this feature.
     */
    public MotorConfig(double rampRate, NeutralMode neutralMode, double voltageCompSaturation) {
        this(rampRate, false, false, neutralMode, voltageCompSaturation);
    }

    /**
     * 
     * @param rampRate              Minimum desired time to go from neutral to full
     *                              throttle. A value of '0' will disable the ramp.
     * @param isInverted            Inverts the hbridge output of the motor
     *                              controller.
     * @param isSensorInverted      Sets the phase of the sensor. Use when
     *                              controller forward/reverse output doesn't
     *                              correlate to appropriate forward/reverse reading
     *                              of sensor. Pick a value so that positive
     *                              PercentOutput yields a positive change in
     *                              sensor.
     * @param neutralMode           The desired mode of operation when the
     *                              Controller output throttle is neutral (ie
     *                              brake/coast)
     * @param voltageCompSaturation This is the max voltage to apply to the hbridge
     *                              when voltage compensation is enabled. For
     *                              example, if 10 (volts) is specified and a motor
     *                              controller is commanded to 0.5 (PercentOutput,
     *                              closed-loop, etc) then the motor controller will
     *                              attempt to apply a duty-cycle to produce 5V. A
     *                              value of 0 disables this feature.
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted, NeutralMode neutralMode,
            double voltageCompSaturation) {
        this(rampRate, isInverted, isSensorInverted, neutralMode, voltageCompSaturation,
                new SupplyCurrentLimitConfiguration(false, 0, 0, 0));
    }

    /**
     * 
     * @param rampRate                        Minimum desired time to go from
     *                                        neutral to full throttle. A value of
     *                                        '0' will disable the ramp.
     * @param voltageCompSaturation           This is the max voltage to apply to
     *                                        the hbridge when voltage compensation
     *                                        is enabled. For example, if 10 (volts)
     *                                        is specified and a motor controller is
     *                                        commanded to 0.5 (PercentOutput,
     *                                        closed-loop, etc) then the motor
     *                                        controller will attempt to apply a
     *                                        duty-cycle to produce 5V. A value of 0
     *                                        disables this feature.
     * @param supplyCurrentLimitConfiguration Supply-side current limiting. This is
     *                                        typically used to prevent breakers
     *                                        from tripping.
     */
    public MotorConfig(double rampRate, double voltageCompSaturation,
            SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this(rampRate, false, voltageCompSaturation, supplyCurrentLimitConfiguration);
    }

    /**
     * 
     * @param rampRate                        Minimum desired time to go from
     *                                        neutral to full throttle. A value of
     *                                        '0' will disable the ramp.
     * @param neutralMode                     The desired mode of operation when the
     *                                        Controller output throttle is neutral
     *                                        (ie brake/coast)
     * @param voltageCompSaturation           This is the max voltage to apply to
     *                                        the hbridge when voltage compensation
     *                                        is enabled. For example, if 10 (volts)
     *                                        is specified and a motor controller is
     *                                        commanded to 0.5 (PercentOutput,
     *                                        closed-loop, etc) then the motor
     *                                        controller will attempt to apply a
     *                                        duty-cycle to produce 5V. A value of 0
     *                                        disables this feature.
     * @param supplyCurrentLimitConfiguration Supply-side current limiting. This is
     *                                        typically used to prevent breakers
     *                                        from tripping.
     */
    public MotorConfig(double rampRate, NeutralMode neutralMode, double voltageCompSaturation,
            SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this(rampRate, false, false, neutralMode, voltageCompSaturation, supplyCurrentLimitConfiguration);
    }

    /**
     * 
     * @param rampRate                        Minimum desired time to go from
     *                                        neutral to full throttle. A value of
     *                                        '0' will disable the ramp.
     * @param isInverted                      Inverts the hbridge output of the
     *                                        motor controller.
     * @param neutralMode                     The desired mode of operation when the
     *                                        Controller output throttle is neutral
     *                                        (ie brake/coast)
     * @param voltageCompSaturation           This is the max voltage to apply to
     *                                        the hbridge when voltage compensation
     *                                        is enabled. For example, if 10 (volts)
     *                                        is specified and a motor controller is
     *                                        commanded to 0.5 (PercentOutput,
     *                                        closed-loop, etc) then the motor
     *                                        controller will attempt to apply a
     *                                        duty-cycle to produce 5V. A value of 0
     *                                        disables this feature.
     * @param supplyCurrentLimitConfiguration Supply-side current limiting. This is
     *                                        typically used to prevent breakers
     *                                        from tripping.
     */
    public MotorConfig(double rampRate, boolean isInverted, double voltageCompSaturation,
            SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this(rampRate, isInverted, false, voltageCompSaturation, supplyCurrentLimitConfiguration);
    }

    /**
     * 
     * @param rampRate                        Minimum desired time to go from
     *                                        neutral to full throttle. A value of
     *                                        '0' will disable the ramp.
     * @param isInverted                      Inverts the hbridge output of the
     *                                        motor controller.
     * @param isSensorInverted                Sets the phase of the sensor. Use when
     *                                        controller forward/reverse output
     *                                        doesn't correlate to appropriate
     *                                        forward/reverse reading of sensor.
     *                                        Pick a value so that positive
     *                                        PercentOutput yields a positive change
     *                                        in sensor.
     * @param voltageCompSaturation           This is the max voltage to apply to
     *                                        the hbridge when voltage compensation
     *                                        is enabled. For example, if 10 (volts)
     *                                        is specified and a motor controller is
     *                                        commanded to 0.5 (PercentOutput,
     *                                        closed-loop, etc) then the motor
     *                                        controller will attempt to apply a
     *                                        duty-cycle to produce 5V. A value of 0
     *                                        disables this feature.
     * @param supplyCurrentLimitConfiguration Supply-side current limiting. This is
     *                                        typically used to prevent breakers
     *                                        from tripping.
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted, double voltageCompSaturation,
            SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this(rampRate, isInverted, isSensorInverted, NeutralMode.Coast, voltageCompSaturation,
                supplyCurrentLimitConfiguration);
    }

    /**
     * 
     * @param rampRate                        Minimum desired time to go from
     *                                        neutral to full throttle. A value of
     *                                        '0' will disable the ramp.
     * @param isInverted                      Inverts the hbridge output of the
     *                                        motor controller.
     * @param isSensorInverted                Sets the phase of the sensor. Use when
     *                                        controller forward/reverse output
     *                                        doesn't correlate to appropriate
     *                                        forward/reverse reading of sensor.
     *                                        Pick a value so that positive
     *                                        PercentOutput yields a positive change
     *                                        in sensor.
     * @param neutralMode                     The desired mode of operation when the
     *                                        Controller output throttle is neutral
     *                                        (ie brake/coast)
     * @param voltageCompSaturation           This is the max voltage to apply to
     *                                        the hbridge when voltage compensation
     *                                        is enabled. For example, if 10 (volts)
     *                                        is specified and a motor controller is
     *                                        commanded to 0.5 (PercentOutput,
     *                                        closed-loop, etc) then the motor
     *                                        controller will attempt to apply a
     *                                        duty-cycle to produce 5V. A value of
     *                                        '0' disables this feature.
     * @param supplyCurrentLimitConfiguration Supply-side current limiting. This is
     *                                        typically used to prevent breakers
     *                                        from tripping.
     */
    public MotorConfig(double rampRate, boolean isInverted, boolean isSensorInverted, NeutralMode neutralMode,
            double voltageCompSaturation, SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this.rampRate = rampRate;
        this.isInverted = isInverted;
        this.isSensorInverted = isSensorInverted;
        this.voltageCompSaturation = voltageCompSaturation;
        this.supplyCurrentLimitConfiguration = supplyCurrentLimitConfiguration;
    }

    public double getRampRate() {
        return this.rampRate;
    }

    public void setRampRate(double rampRate) {
        this.rampRate = rampRate;
    }

    public boolean isInverted() {
        return this.isInverted;
    }

    public void setInverted(boolean isInverted) {
        this.isInverted = isInverted;
    }

    public boolean getSensorInverted() {
        return this.isSensorInverted;
    }

    public void isSensorInverted(boolean isSensorInverted) {
        this.isSensorInverted = isSensorInverted;
    }

    public NeutralMode getNeutralMode() {
        return this.neutralMode;
    }

    public void setNeutralMode(NeutralMode neutralMode) {
        this.neutralMode = neutralMode;
    }

    public SupplyCurrentLimitConfiguration getSupplyCurrentLimitConfiguration() {
        return this.supplyCurrentLimitConfiguration;
    }

    public void setSupplyCurrentLimitConfiguration(SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration) {
        this.supplyCurrentLimitConfiguration = supplyCurrentLimitConfiguration;
    }

    public double getVoltageCompSaturation() {
        return this.voltageCompSaturation;
    }

    public void setVoltageCompSaturation(double voltageCompSaturation) {
        this.voltageCompSaturation = voltageCompSaturation;
    }
}