package complex.szakdolgozat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class ExecuteService {
	ParamService paramService = new ParamService();

	List<String> runLog = new ArrayList<>();
	List<String> stdout = new ArrayList<>();

	List<String> testRunLog = new ArrayList<>();
	
	int passedTestCaseCounter = 0;
	int failedTestCaseCounter = 0;
	
	public int getPassedTestCaseCounter() {
		return passedTestCaseCounter;
	}

	public int getFailedTestCaseCounter() {
		return failedTestCaseCounter;
	}

	public List<String> getTestRunLog() {
		return testRunLog;
	}

	public List<String> getRunLog() {
		return runLog;
	}

	public List<String> getStdout() {
		return stdout;
	}

	public void executeCompiledCCode(String sourceFileName, String params) {
		paramService.setParams(params);
		
		if(!runLog.isEmpty()) {
			runLog.clear();
		}
		
		if(!stdout.isEmpty()) {
			stdout.clear();
		}
		
		try {
			String output;
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

			while (scanner.hasNextLine()) {
				stdout.add(scanner.nextLine());
			}
			scanner.close();

			BufferedReader stdError = new BufferedReader(new InputStreamReader(execution.getErrorStream()));
			boolean error = false;

			while ((output = stdError.readLine()) != null) {
				runLog.add(output);
				error = true;
				runLog.add("\n");
			}
			if (!error)
				runLog.add("sikeresen futtatva.");
			execution.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void executeTestCases(String testSourceFileName) {
		passedTestCaseCounter = 0;
		failedTestCaseCounter = 0;
		
		if(!testRunLog.isEmpty()) {
			testRunLog.clear();
		}
			
		try {
			Process testExecution = Runtime.getRuntime().exec("./src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "compiled_test_cases" + File.separator + testSourceFileName);
			Scanner sc = new Scanner(testExecution.getInputStream());

			while (sc.hasNextLine()) {
				testRunLog.add(sc.nextLine());
			}
			sc.close();

			for (String line : testRunLog) {
				if(line.contains("passed")) {
					passedTestCaseCounter++;
				} else if(line.contains("FAILED")) {
					failedTestCaseCounter++;
				}
			}
			testExecution.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
