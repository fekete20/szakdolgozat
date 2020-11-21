package complex.szakdolgozat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import complex.szakdolgozat.model.CompilerModel;

@Component
@Scope("session")
public class CompilerService {

	private CompilerModel compilerModel = new CompilerModel();

	public List<String> getCompileLog() {
		return compilerModel.getCompileLog();
	}

	public boolean compileCSource(String sourceFileName) {
		boolean error = false;
		compilerModel.deleteCompileLog();

		try {
			String compilerOutput;

			Process compiler = Runtime.getRuntime()
					.exec("gcc " + "src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "c_files" + File.separator + sourceFileName + " -o src" + File.separator + "main"
							+ File.separator + "resources" + File.separator + "compiled_c_files" + File.separator
							+ sourceFileName + " -lm");

			BufferedReader stdError = new BufferedReader(new InputStreamReader(compiler.getErrorStream()));

			while ((compilerOutput = stdError.readLine()) != null) {
				compilerModel.addCompileLog(compilerOutput);
				if (compilerOutput.contains("error")) {
					error = true;
				}
				compilerModel.addCompileLog("\n");
			}

			if (!error)
				compilerModel.addCompileLog("sikeresen fordítva");
			compiler.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return error;
	}

	public boolean compileTestSource(String testSourceFileName) {
		boolean error = false;

		compilerModel.deleteTestCompileLog();

		try {
			String compilerOutput;

			Process testCompiler = Runtime.getRuntime()
					.exec("gcc " + "src" + File.separator + "main" + File.separator + "resources" + File.separator
							+ "c_test_cases" + File.separator + testSourceFileName + " -o src" + File.separator + "main"
							+ File.separator + "resources" + File.separator + "compiled_test_cases" + File.separator
							+ testSourceFileName + " -lm -lcunit");

			BufferedReader stdError = new BufferedReader(new InputStreamReader(testCompiler.getErrorStream()));

			while ((compilerOutput = stdError.readLine()) != null) {
				compilerModel.addTestCompileLog(compilerOutput);
				error = true;
				compilerModel.addTestCompileLog("\n");
			}

			if (!error)
				compilerModel.addTestCompileLog("Test esetek sikeresen fordítva.");
			
			System.out.println(compilerModel.getTestCompileLog());
			testCompiler.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return error;
	}

}
