package complex.szakdolgozat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import complex.szakdolgozat.model.AnalyzeModel;

@Component
@Scope("session")
public class AnalyzeService {
	private DecimalFormat df2 = new DecimalFormat("#.##");
	private AnalyzeModel analyzeModel = new AnalyzeModel();

	public List<String> getSimpleOut() {
		return analyzeModel.getSimpleStaticAnalyzeOutput();
	}

	public List<String> getDifferenceHalstead() {
		return analyzeModel.getDifferenceHalstead();
	}

	public String getCy() {
		return analyzeModel.getPmccabeOutput();
	}

	public String getAbsDifferenceCyc() {
		return analyzeModel.getAbsDifferenceCyc();
	}

	public String getCyc() {
		return analyzeModel.getRealCyclomaticComplexity();
	}

	public String getLineString() {
		return analyzeModel.getLineString();
	}

	public void deleteSimpleOut() {
		analyzeModel.deleteSimpleStaticAnalyzeOutput();
	}

	public void deleteDifferenceHalstead() {
		analyzeModel.deleteDifferenceHalstead();
		}

	public void deletePmccabeOutput() {
		analyzeModel.deletePmccabeOutput();
	}

	public void deleteAbsDifferenceCyc() {
		analyzeModel.deleteAbsDifferenceCyc();
	}

	public void deleteRealCyclomaticComplexity() {
		analyzeModel.deleteRealCyclomaticComplexity();
	}

	public void deleteLineString() {
		analyzeModel.deleteLineString();
}

	public void checkNamingConventions(String sourceFileName) {
		List<String> sourceCode = new ArrayList<>();
		try {
			File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
					+ "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				sourceCode.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String[] lowercaseTypes = new String[] { "int ", "double ", "float ", "char " };
		String[] uppercaseTypes = new String[] { "struct ", "#define " };

		String lowercasePattern = "\\s*\\w+ [a-z]+.*"; // "\\w* [a-z]+.*";
		String uppercasePattern = "(#|\\w)* ([A-Z]+|[A-Z][a-z]*).*";

		analyzeModel.deleteLinesWhereVariableHasIncorrectName();
		analyzeModel.deleteLineString();

		int i = 0;
		while (!sourceCode.get(i).contains("int main(")) {
			if (sourceCode.get(i).matches("[a-z]+\\s[a-z]+;")) {
				analyzeModel.addLinesWhereVariableHasIncorrectName(sourceCode.indexOf(sourceCode.get(i)) + 1);
			}
			i++;
		}

		for (String line : sourceCode) {
			for (String element : lowercaseTypes) {
				if (line.contains(element)) {
					System.out.println("Van egy lowercase-nek előírt változó.");
					if (line.matches(lowercasePattern)) {
						System.out.println("És itt egyezik a mintával.");
					} else {
						System.out.println("Itt pedig NEM egyezik a mintával. Sor: " + (sourceCode.indexOf(line) + 1));
						analyzeModel.addLinesWhereVariableHasIncorrectName(sourceCode.indexOf(line) + 1);
					}
				}
			}

			for (String element : uppercaseTypes) {
				if (line.contains(element)) {
					System.out.println("Van egy uppercase-nek előírt változó.");
					if (line.matches(uppercasePattern)) {
						System.out.println("És itt egyezik a mintával.");
					} else {
						System.out.println("Itt pedig NEM egyezik a mintával. Sor: " + (sourceCode.indexOf(line) + 1));
						analyzeModel.addLinesWhereVariableHasIncorrectName(sourceCode.indexOf(line) + 1);
					}
				}
			}
		}

		if (analyzeModel.getLinesWhereVariableHasIncorrectName().isEmpty()) {
			analyzeModel.addLineString("mindenhol teljesült.");
		} else {
			analyzeModel.addLineString("nem teljesült az alábbi sor(ok)ban: ");
		}

		for (int line : analyzeModel.getLinesWhereVariableHasIncorrectName()) {
			analyzeModel.addLineString(line + ", ");
		}
	}

	public void calculateHalstead(String sourceFileName, String path) {
		analyzeModel.deleteDifferenceHalstead();
		analyzeModel.deleteFramaCOutput();

		try {
			Process halstead = Runtime.getRuntime()
					.exec("frama-c -metrics -metrics-ast cabs src" + File.separator + "main" + File.separator
							+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(halstead.getInputStream());
			analyzeModel.addDifferenceHalstead("Statikus kódelemzés - Halstead eredménye: \n");
			while (scanner.hasNextLine()) {
				analyzeModel.addFramaCOutput(scanner.nextLine());
			}
			scanner.close();

			List<String> userHalstead = new ArrayList<>();

			String[] matches = new String[] { "Total operators", "Distinct operators", "Total_operands",
					"Distinct operands", "Program length", "Vocabulary size", "Program volume", "Effort",
					"Program level", "Difficulty level", "Time to implement", "Bugs delivered" };

			String[] units = new String[] { "", "", "", "", " characters", "", " bit", "", "", "", " sec", "" };

			String halsteadOutputString = "Halstead számok:\n";
			for (String element : analyzeModel.getFramaCOutput()) {
				for (String arrayElement : matches) {
					if (element.contains(arrayElement)) {
						userHalstead.add(element + "\n");
					}
				}
			}

			for (String element : userHalstead) {
				halsteadOutputString += element;
			}

			String[] halsteadArray = halsteadOutputString.split("(:)|\\n");

			List<Double> halsteadNumbers = new ArrayList<>();
			for (String element : halsteadArray) {
				if (isNumeric(element)) {
					halsteadNumbers.add(Double.parseDouble(element));
				}
			}
			halstead.destroy();

			List<Double> sampleHalsteadNumbers = new ArrayList<>();

			try {
				File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
						+ "templates" + File.separator + "topics" + File.separator + path + "halstead_sample.txt");
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					sampleHalsteadNumbers.add(Double.parseDouble(sc.nextLine()));
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < halsteadNumbers.size(); i++) {
				analyzeModel.addDifferenceHalstead(matches[i] + ": " + halsteadNumbers.get(i) + units[i] + ", eltérés: "
						+ (df2.format((halsteadNumbers.get(i) - sampleHalsteadNumbers.get(i)))) + units[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void simpleStaticAnalyze(String sourceFileName) {
		analyzeModel.deleteSimpleStaticAnalyzeOutput();
		try {

			Process simple = Runtime.getRuntime().exec("cppcheck src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(simple.getInputStream());
			analyzeModel.addSimpleStaticAnalyzeOutput("Statikus kódelemzés (egyszerű) eredménye: \n");
			BufferedReader stdError = new BufferedReader(new InputStreamReader(simple.getErrorStream()));
			while (scanner.hasNextLine()) {
				analyzeModel.addSimpleStaticAnalyzeOutput(scanner.nextLine());
			}
			String temp;
			while ((temp = stdError.readLine()) != null) {
				analyzeModel.addSimpleStaticAnalyzeOutput(temp);
			}
			scanner.close();
			simple.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calculateCyclomaticComplexity(String sourceFileName, String path) {

		analyzeModel.deleteCycl();
		analyzeModel.deletePercentageDifferenceCyclomaticComplexity();
		analyzeModel.deleteAbsoluteDifferenceCyclomaticComplexity();
		analyzeModel.deleteRealCyclomaticComplexityList();
		analyzeModel.deletePmccabeOutput();
		analyzeModel.deleteRealCyclomaticComplexity();
		analyzeModel.deleteAbsDifferenceCyc();

		try {
			Process pmccabe = Runtime.getRuntime().exec("pmccabe src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(pmccabe.getInputStream());

			while (scanner.hasNextLine()) {
				analyzeModel.addPmccabeOutput(scanner.nextLine() + "\n");
			}
			scanner.close();

			String[] cyclomaticNumbers = analyzeModel.getPmccabeOutput().split("\\n|\\t");

			List<String> userCyclomaticComplexityList = new ArrayList<>();

			for (int i = 0; i < cyclomaticNumbers.length; i++) {
				if (cyclomaticNumbers[i].contains(".c")) {
					userCyclomaticComplexityList.add(cyclomaticNumbers[i - 5]);
					userCyclomaticComplexityList.add(cyclomaticNumbers[i]);
				}
			}

			List<String> sampleCyclomaticComplexity = new ArrayList<>();

			try {
				File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator
						+ "templates" + File.separator + "topics" + File.separator + path + "cyc_sample.txt");
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					sampleCyclomaticComplexity.add(sc.nextLine());
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			List<String> matches = new ArrayList<>();
			for (int i = 0; i < userCyclomaticComplexityList.size(); i++) {
				for (String line : sampleCyclomaticComplexity) {
					if (userCyclomaticComplexityList.get(i).contains(line)) {
						if (!isNumeric(line)) {
							if (!matches.contains(line)) {
								matches.add(line);
							}
						}
					}
				}
			}

			for (int i = 0, j = 0; j < matches.size(); i++) {
				if (i % 2 == 0) {
					analyzeModel.addPercentageDifferenceCyclomaticComplexity(matches.get(j) + ": "
							+ (((Double.parseDouble(userCyclomaticComplexityList.get(i))
									- Double.parseDouble(sampleCyclomaticComplexity.get(i)))
									/ Double.parseDouble(sampleCyclomaticComplexity.get(i))) * 100 + "%"));
					analyzeModel.addAbsoluteDifferenceCyclomaticComplexity(
							matches.get(j) + ": " + (Integer.parseInt(userCyclomaticComplexityList.get(i))
									- Integer.parseInt(sampleCyclomaticComplexity.get(i))));
					analyzeModel.addRealCyclomaticComplexityList(
							matches.get(j) + ": " + Integer.parseInt(userCyclomaticComplexityList.get(i)));
					j++;
				}
			}

			analyzeModel.deletePmccabeOutput();
			analyzeModel.deleteAbsDifferenceCyc();
			analyzeModel.deleteRealCyclomaticComplexity();
			for (String element : analyzeModel.getPercentageDifferenceCyclomaticComplexity()) {
				analyzeModel.addPmccabeOutput(element + "\n");
			}

			for (String element : analyzeModel.getAbsoluteDifferenceCyclomaticComplexity()) {
				analyzeModel.addAbsDifferenceCyc(element + "\n");
			}

			for (String element : analyzeModel.getRealCyclomaticComplexityList()) {
				analyzeModel.addRealCyclomaticComplexity(element + "\n");
			}
			pmccabe.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
