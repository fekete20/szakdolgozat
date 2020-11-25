package complex.szakdolgozat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class AnalyzeModel {
	private List<String> framaCOutput = new ArrayList<>();
	private List<String> simpleStaticAnalyzeOutput = new ArrayList<>();
	private List<String> cycl = new ArrayList<>();
	private String pmccabeOutput = "";
	private List<String> differenceHalstead = new ArrayList<>();
	private String lineString = "";
	private List<Integer> linesWhereVariableHasIncorrectName = new ArrayList<>();
	private List<String> percentageDifferenceCyclomaticComplexity = new ArrayList<>();
	private List<String> absoluteDifferenceCyclomaticComplexity = new ArrayList<>();
	private String absDifferenceCyc = "";
	private List<String> realCyclomaticComplexityList = new ArrayList<>();
	private String realCyclomaticComplexity = "";

	public void addLinesWhereVariableHasIncorrectName(int element) {
		linesWhereVariableHasIncorrectName.add(element);
	}

	public String getAbsDifferenceCyc() {
		return absDifferenceCyc;
	}

	public List<String> getSimpleStaticAnalyzeOutput() {
		return simpleStaticAnalyzeOutput;
	}

	public String getRealCyclomaticComplexity() {
		return realCyclomaticComplexity;
	}

	public List<String> getPercentageDifferenceCyclomaticComplexity() {
		return percentageDifferenceCyclomaticComplexity;
	}

	public List<String> getAbsoluteDifferenceCyclomaticComplexity() {
		return absoluteDifferenceCyclomaticComplexity;
	}

	public List<String> getRealCyclomaticComplexityList() {
		return realCyclomaticComplexityList;
	}

	public List<String> getFramaCOutput() {
		return framaCOutput;
	}

	public String getCyc() {
		return realCyclomaticComplexity;
	}

	public String getCy() {
		return pmccabeOutput;
	}

	public List<String> getDifferenceCyc() {
		return percentageDifferenceCyclomaticComplexity;
	}

	public String getLineString() {
		return lineString;
	}

	public void setLineString() {
		if (linesWhereVariableHasIncorrectName.isEmpty()) {
			this.lineString = "mindenhol teljesült.";
		}
	}

	public void addLineString(String str) {
		lineString += str;
	}

	public List<String> getDifferenceHalstead() {
		return differenceHalstead;
	}

	public List<String> getCycl() {
		return cycl;
	}

	public List<String> getSimpleOut() {
		return simpleStaticAnalyzeOutput;
	}

	public List<String> getHalsteadOut() {
		return framaCOutput;
	}

	public String getPmccabeOutput() {
		return pmccabeOutput;
	}

	public List<Integer> getLinesWhereVariableHasIncorrectName() {
		return linesWhereVariableHasIncorrectName;
	}

	public void addSimpleStaticAnalyzeOutput(String element) {
		simpleStaticAnalyzeOutput.add(element);
	}

	public void deleteSimpleStaticAnalyzeOutput() {
		if (!simpleStaticAnalyzeOutput.isEmpty()) {
			simpleStaticAnalyzeOutput.clear();
		}
	}

	public void deleteLinesWhereVariableHasIncorrectName() {
		if (!linesWhereVariableHasIncorrectName.isEmpty()) {
			linesWhereVariableHasIncorrectName.clear();
		}
	}

	public void deleteLineString() {
		if (!lineString.equals("")) {
			lineString = "";
		}
	}

	public void deleteDifferenceHalstead() {
		if (!differenceHalstead.isEmpty()) {
			differenceHalstead.clear();
		}
	}

	public void deleteFramaCOutput() {
		if (!framaCOutput.isEmpty()) {
			framaCOutput.clear();
		}
	}

	public void deleteCycl() {
		if (!cycl.isEmpty()) {
			cycl.clear();
		}
	}

	public void deletePercentageDifferenceCyclomaticComplexity() {
		if (!percentageDifferenceCyclomaticComplexity.isEmpty()) {
			percentageDifferenceCyclomaticComplexity.clear();
		}

	}

	public void deleteAbsoluteDifferenceCyclomaticComplexity() {
		if (!absoluteDifferenceCyclomaticComplexity.isEmpty()) {
			absoluteDifferenceCyclomaticComplexity.clear();
		}
	}

	public void deleteRealCyclomaticComplexityList() {
		if (!realCyclomaticComplexityList.isEmpty()) {
			realCyclomaticComplexityList.clear();
		}
	}

	public void deletePmccabeOutput() {
		if (!pmccabeOutput.isEmpty()) {
			pmccabeOutput = "";
		}
	}

	public void deleteRealCyclomaticComplexity() {
		if (!realCyclomaticComplexity.isEmpty()) {
			realCyclomaticComplexity = "";
		}
	}

	public void deleteAbsDifferenceCyc() {
		if (!absDifferenceCyc.isEmpty()) {
			absDifferenceCyc = "";
		}
	}

	public void addDifferenceHalstead(String element) {
		differenceHalstead.add(element);
	}

	public void addFramaCOutput(String element) {
		framaCOutput.add(element);
	}

	public void addPmccabeOutput(String str) {
		pmccabeOutput += str;
	}

	public void addPercentageDifferenceCyclomaticComplexity(String element) {
		percentageDifferenceCyclomaticComplexity.add(element);
	}

	public void addAbsoluteDifferenceCyclomaticComplexity(String element) {
		absoluteDifferenceCyclomaticComplexity.add(element);
	}

	public void addRealCyclomaticComplexityList(String element) {
		realCyclomaticComplexityList.add(element);
	}

	public void addAbsDifferenceCyc(String str) {
		absDifferenceCyc += str;
	}

	public void addRealCyclomaticComplexity(String str) {
		realCyclomaticComplexity += str;
	}
}
