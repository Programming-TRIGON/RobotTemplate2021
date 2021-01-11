package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface MoveableSS extends Subsystem {
  public void move(double power);

  public void stop();
}
