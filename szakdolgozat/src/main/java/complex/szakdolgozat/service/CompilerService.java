package complex.szakdolgozat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class CompilerService {

	private List<String> compileLog = new ArrayList<>();
	List<String> testCompileLog = new ArrayList<>();

	public List<String> getTestCompileLog() {
		return testCompileLog;
	}

	public void setTestCompileLog(List<String> testCompileLog) {
		this.testCompileLog = testCompileLog;
	}

	public List<String> getCompileLog() {
		return compileLog;
	}

	public void setCompileLog(List<String> compileLog) {
		this.compileLog = compileLog;
	}

	public boolean compileCSource(String sourceFileName) {
		boolean error = false;
		
		if(!compileLog.isEmpty()) {
			compileLog.clear();
		}
		
		try {
			String compilerOutput;

			Process compiler = Runtime.getRuntime()
					.exec("gcc " + "src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "c_files" + File.separator + sourceFileName + " -o src" + File.separator + "main"
							+ File.separator + "resources" + File.separator + "compiled_c_files" + File.separator
							+ sourceFileName + " -lm");

			BufferedReader stdError = new BufferedReader(new InputStreamReader(compiler.getErrorStream()));
		
			while ((compilerOutput = stdError.readLine()) != null) {
				compileLog.add(compilerOutput);
				if(compilerOutput.contains("error")) {
					error = true;
				}
				compileLog.add("\n");
			}

			if (!error)
				compileLog.add("sikeresen fordítva.");
			compiler.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return error;
	}

	public boolean compileTestSource(String testSourceFileName) {
		boolean error = false;
		
		if(!testCompileLog.isEmpty()) {
			testCompileLog.clear();
		}
		try {
			String compilerOutput;
			
			Process testCompiler = Runtime.getRuntime()
					.exec("gcc " + "src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "c_test_cases" + File.separator +  testSourceFileName + " -o src" + File.separator + "main"
							+ File.separator + "resources" + File.separator + "compiled_test_cases" + File.separator
							 + testSourceFileName + " -lcunit");

			BufferedReader stdError = new BufferedReader(new InputStreamReader(testCompiler.getErrorStream()));

			while ((compilerOutput = stdError.readLine()) != null) {
				testCompileLog.add(compilerOutput);
				error = true;
				testCompileLog.add("\n");
			}

			if (!error)
				testCompileLog.add("Test esetek sikeresen fordítva.");

			testCompiler.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return error;
	}
	
}
