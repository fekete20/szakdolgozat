package complex.szakdolgozat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class ExecuteModel {
	private List<String> runLog = new ArrayList<>();
	private List<String> stdout = new ArrayList<>();
	private List<String> testRunLog = new ArrayList<>();
	int passedTestCaseCounter = 0;
	int failedTestCaseCounter = 0;

	public List<String> getRunLog() {
		return runLog;
	}

	public void addRunLog(String element) {
		runLog.add(element);
	}

	public List<String> getStdout() {
		return stdout;
	}

	public void addStdout(String element) {
		stdout.add(element);
	}

	public List<String> getTestRunLog() {
		return testRunLog;
	}

	public void addTestRunLog(String element) {
		testRunLog.add(element);
	}

	public int getPassedTestCaseCounter() {
		return passedTestCaseCounter;
	}

	public void incrementPassedTestCaseCounter() {
		passedTestCaseCounter++;
	}

	public int getFailedTestCaseCounter() {
		return failedTestCaseCounter;
	}

	public void incrementFailedTestCaseCounter() {
		failedTestCaseCounter++;
	}

	public void resetTestCaseCounters() {
		passedTestCaseCounter = 0;
		failedTestCaseCounter = 0;
	}

	public void deleteRunLog() {
		if (!runLog.isEmpty()) {
			runLog.clear();
		}
	}

	public void deleteTestRunLog() {
		if (!testRunLog.isEmpty()) {
			testRunLog.clear();
		}
	}

	public void deleteStdout() {
		if (!stdout.isEmpty()) {
			stdout.clear();
		}
	}
}
