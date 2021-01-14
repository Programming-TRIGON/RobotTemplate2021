package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TestableSubsystem;

import java.util.HashMap;


public class TesterCommand extends CommandBase {

	HashMap<String, TestableSubsystem> subsystems;
	HashMap<String, String> initialValues;
	double initialTime;
	final int SECONDS_TO_WAIT = 2;
	final double MOVE_POWER = 1;
	boolean isFinished = false;

	public TesterCommand() {
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
			ss.move(MOVE_POWER);
		}
		initialTime = Timer.getFPGATimestamp();

	}

	@Override
	public void execute() {
		if (Timer.getFPGATimestamp() < initialTime + SECONDS_TO_WAIT)
			return;

		StringBuilder msg = new StringBuilder();
		for(String name : subsystems.keySet()) {
			TestableSubsystem ss = subsystems.get(name);
			ss.stopMoving();
			boolean success = ss.getValues().equals(initialValues.get(name));
			msg.append("The subsystem " + name + " is " + (success ? "" : "not ") + "working\n");
		}
		SmartDashboard.putString("Check", msg.toString());
		isFinished = true;
	}

	@Override
	public boolean isFinished(){
		return isFinished;
	}

	@Override
	public void end(boolean interrupted) {

	}

}
