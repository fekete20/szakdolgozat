package complex.szakdolgozat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class CompilerModel {
	private List<String> compileLog = new ArrayList<>();
	private List<String> testCompileLog = new ArrayList<>();

	public List<String> getTestCompileLog() {
		return testCompileLog;
	}

	public void addTestCompileLog(String element) {
		testCompileLog.add(element);
	}

	public List<String> getCompileLog() {
		return compileLog;
	}

	public void addCompileLog(String element) {
		compileLog.add(element);
	}

	public void deleteCompileLog() {
		if (!compileLog.isEmpty()) {
			compileLog.clear();
		}
	}

	public void deleteTestCompileLog() {
		if (!testCompileLog.isEmpty()) {
			testCompileLog.clear();
		}
	}
}
