package frc.robot.utilities;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface MoveableSS extends Subsystem {
  public void move(double distance);

  public void stop();
}
