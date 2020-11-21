package complex.szakdolgozat.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class FileService {
	Random random = new Random();

	private String sourceFileName;
	private String solutionString;
	private final String sourcePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+ "c_files" + File.separator;
	private final String compiledPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+ "compiled_c_files" + File.separator;
	private final String testSourcePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+ "c_test_cases" + File.separator;
	private final String compiledTestPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+ "compiled_test_cases" + File.separator;

	
	public String getCompiledPath() {
		return compiledPath;
	}

	public String getTestSourcePath() {
		return testSourcePath;
	}

	public String getCompiledTestPath() {
		return compiledTestPath;
	}

	public void setSourceFileName() {
		sourceFileName = random.nextInt() + "main.c";
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public String getSourcePath() {
		return sourcePath;
	}
	
	public String getSolution() {
		return solutionString;
	}
	
	public int generateRandomInt() {
		return random.nextInt();
	}

	public void writeSolutionToFile(String solution) {
		try {
			solutionString = solution;
			setSourceFileName();
			File file = new File(getSourcePath() + getSourceFileName());

			if (file.createNewFile()) {
				FileWriter fileWriter = new FileWriter(getSourcePath() + getSourceFileName());
				fileWriter.write(solution);
				fileWriter.close();

			} else {
				System.err.println("A fájl már létezik.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTemporaryFiles() {
		File sourceFileName = new File(getSourcePath() + getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(getCompiledPath() + getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(getTestSourcePath() + "test" + getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(getCompiledTestPath() + "test" + getSourceFileName());
		sourceFileName.delete();
	}
	
	public void deleteSourceFile() {
		File sourceFileName = new File(getSourcePath() + getSourceFileName());
		sourceFileName.delete();
	}
	
	public void manageTestFile(String sourceFileName, String path) {
		List<String> testSource = new ArrayList<>();
		
		try {
			File file = new File("src/main/resources/templates/topics" + path + "test.c");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				testSource.add(sc.nextLine());
			}
			sc.close();
						
			for(String line : testSource) {
				if(line.contains("#include \"main.c")) {
					testSource.set(testSource.indexOf(line), "#include \"../c_files/"+sourceFileName+"\"");
				}
			}
			
			String testSourceString = "";
			for(String line: testSource) {
				testSourceString += line + "\n";
			}

			File testCase = new File("src/main/resources/c_test_cases/" + "test" + sourceFileName);

			if (testCase.createNewFile()) {
				FileWriter fileWriter = new FileWriter("src/main/resources/c_test_cases/" + "test" + sourceFileName);
				fileWriter.write(testSourceString);
				fileWriter.close();

			} else {
				System.err.println("A fájl már létezik.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
