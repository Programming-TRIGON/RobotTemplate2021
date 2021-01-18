package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.RobotConstants;
import frc.robot.subsystems.TestableSubsystem;

import java.util.HashMap;


public class TesterCommand extends CommandBase {

	HashMap<String, TestableSubsystem> subsystems;
	HashMap<String, double[]> initialValues;
	double initialTime;
	RobotConstants.TesterConstants constants;

	public TesterCommand(RobotConstants.TesterConstants constants) {
		subsystems = new HashMap();
		initialValues = new HashMap<>();
	}

	public TesterCommand addSS(TestableSubsystem ss, String name){
		subsystems.put(name, ss);
		addRequirements(ss);
		return this;
	}

	@Override
	public void initialize() {
		for(String name : subsystems.keySet()){
			TestableSubsystem ss = subsystems.get(name);
			initialValues.put(name, ss.getValues());
			ss.move(constants.MOVE_POWER);
		}
		initialTime = Timer.getFPGATimestamp();
	}

	@Override
	public boolean isFinished(){
		return Timer.getFPGATimestamp() < initialTime + constants.SECONDS_TO_WAIT;
	}

	@Override
	public void end(boolean interrupted) {
		StringBuilder msg = new StringBuilder();
		for(String name : subsystems.keySet()) {
			TestableSubsystem ss = subsystems.get(name);
			ss.stopMoving();
			double[] values = ss.getValues();
			boolean success = true;
			for (int i = 0; i < values.length; i++) {
				if(values[i] == initialValues.get(name)[i])
					success = false;
			}
			msg.append("The subsystem " + name + " is " + (success ? "" : "not ") + "working\n");
		}
		SmartDashboard.putString("Check", msg.toString());
	}

}
