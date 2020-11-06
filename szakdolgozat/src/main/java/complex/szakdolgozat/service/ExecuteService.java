package complex.szakdolgozat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import complex.szakdolgozat.model.ExecuteModel;

@Component
@Scope("session")
public class ExecuteService {
	private ParamService paramService = new ParamService();
	private ExecuteModel executeModel = new ExecuteModel();

	public List<String> getRunLog() {
		return executeModel.getRunLog();
	}

	public List<String> getTestRunLog() {
		return executeModel.getTestRunLog();
	}

	public List<String> getStdout() {
		return executeModel.getStdout();
	}

	public int getPassedTestCaseCounter() {
		return executeModel.getPassedTestCaseCounter();
	}

	public int getFailedTestCaseCounter() {
		return executeModel.getFailedTestCaseCounter();
	}

	public void executeCompiledCCode(String sourceFileName, String params) {

		executeModel.deleteRunLog();
		executeModel.deleteStdout();

		try {
			String output;
			paramService.setParams(params);
			Process execution = Runtime.getRuntime().exec("./src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "compiled_c_files" + File.separator + sourceFileName);

			Scanner scanner = new Scanner(execution.getInputStream());
			if (!paramService.getParams().isEmpty()) {
				PrintWriter printWriter = new PrintWriter(execution.getOutputStream());
				for (String param : paramService.splitParams(paramService.getParams())) {
					printWriter.print(param);
				}
				printWriter.close();
			}
			try {
				if (!execution.waitFor(5, TimeUnit.SECONDS)) {
					executeModel.addStdout("Timeout!");
					executeModel.addRunLog("Timeout! (valószínűleg végtelen iteráció)");
					execution.destroyForcibly();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			while (scanner.hasNextLine()) {
				executeModel.addStdout(scanner.nextLine());
			}
			scanner.close();

			BufferedReader stdError = new BufferedReader(new InputStreamReader(execution.getErrorStream()));
			boolean error = false;

			while ((output = stdError.readLine()) != null) {
				executeModel.addRunLog(output);
				error = true;
				executeModel.addRunLog("\n");
			}
			if (!error)
				executeModel.addRunLog("sikeresen futtatva.");
			execution.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void executeTestCases(String testSourceFileName) {
		executeModel.resetTestCaseCounters();
		executeModel.deleteTestRunLog();

		try {
			Process testExecution = Runtime.getRuntime().exec("./src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "compiled_test_cases" + File.separator + testSourceFileName);
			Scanner sc = new Scanner(testExecution.getInputStream());

			while (sc.hasNextLine()) {
				executeModel.addTestRunLog(sc.nextLine());
			}
			sc.close();

			for (String line : executeModel.getTestRunLog()) {
				if (line.contains("passed")) {
					executeModel.incrementPassedTestCaseCounter();
				} else if (line.contains("FAILED")) {
					executeModel.incrementFailedTestCaseCounter();
				}
			}
			testExecution.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
