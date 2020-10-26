package complex.szakdolgozat.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class AnalyzeService {
	List<String> framaCOutput = new ArrayList<>();
	List<String> simpleStaticAnalyzeOutput = new ArrayList<>();
	List<String> cycl = new ArrayList<>();
	String pmccabeOutput = "";
	List<String> differenceHalstead = new ArrayList<>();
	String lineString = "";
	List<Integer> linesWhereVariableHasIncorrectName = new ArrayList<>();
	private DecimalFormat df2 = new DecimalFormat("#.##");
	List<String> percentageDifferenceCyclomaticComplexity = new ArrayList<>();
	List<String> absoluteDifferenceCyclomaticComplexity = new ArrayList<>();
	String absDifferenceCyc = "";
	List<String> realCyclomaticComplexityList = new ArrayList<>();
	String realCyclomaticComplexity = "";

	public String getAbsDifferenceCyc() {
		return absDifferenceCyc;
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
		if(linesWhereVariableHasIncorrectName.isEmpty()) {
		this.lineString = "mindenhol teljesült."; }
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
	
	public void checkNamingConventions(String sourceFileName) {
		List<String> sourceCode = new ArrayList<>();
		try {
		      File file = new File("src" + File.separator + "main" + File.separator
						+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
		      Scanner scanner = new Scanner(file);
		      while (scanner.hasNextLine()) {
		    	  sourceCode.add(scanner.nextLine());
		      }
		      scanner.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }

		String[] lowercaseTypes = new String[] { "int ", "double ", "float ", "char "};
		String[] uppercaseTypes = new String[] { "struct ", "#define " };
		
		String lowercasePattern = "\\w* [a-z]+.*";
		String uppercasePattern = "(#|\\w)* ([A-Z]+|[A-Z][a-z]*).*";
		
		if(!linesWhereVariableHasIncorrectName.isEmpty()) {
			linesWhereVariableHasIncorrectName.clear();
		}
		
		if(!lineString.equals("")) {
			lineString = "";
		}
		
		 for(String line: sourceCode) {
		      for(String element: lowercaseTypes) {
		    	  if(line.contains(element)) {
		    		  System.out.println("Van egy lowercase-nek előírt változó.");
		    		  if(line.matches(lowercasePattern)) { 
		    			  System.out.println("És itt egyezik a mintával.");
		    		  } else {
		    			  System.out.println("Itt pedig NEM egyezik a mintával. Sor: " + (sourceCode.indexOf(line)+1));
		    			  linesWhereVariableHasIncorrectName.add(sourceCode.indexOf(line) + 1);	    			  
		    		  }
		    	  }  
		      }
		      
		      for(String element: uppercaseTypes) {
		    	  if(line.contains(element)) {
		    		  System.out.println("Van egy uppercase-nek előírt változó.");
		    		  if(line.matches(uppercasePattern)) { 
		    			  System.out.println("És itt egyezik a mintával.");
		    		  } else {
		    			  System.out.println("Itt pedig NEM egyezik a mintával. Sor: " + (sourceCode.indexOf(line)+1));
		    			  linesWhereVariableHasIncorrectName.add(sourceCode.indexOf(line) + 1);
		    		  }
		    	  }
		      }
		 }
		 
		 int i = 0;
		 while(!sourceCode.get(i).contains("int main(")) {
			 if(sourceCode.get(i).matches("[a-z]+\\s[a-z]+;")) {
				 linesWhereVariableHasIncorrectName.add(sourceCode.indexOf(sourceCode.get(i)) + 1);
		   	  }
			 i++;
		 }
		 
		if(linesWhereVariableHasIncorrectName.isEmpty()) {
			lineString = "mindenhol teljesült.";
		} else {
			lineString = "nem teljesült az alábbi sorokban: ";
		}
		 
		 for(int line : linesWhereVariableHasIncorrectName) {
			 lineString += (line + ", ");
		 }
	}
	
	public void calculateHalstead(String sourceFileName, String path) {
		if(!differenceHalstead.isEmpty()) {
			differenceHalstead.clear();
		}
		
		if(!framaCOutput.isEmpty()) {
			framaCOutput.clear();
		}
		
		try {
			Process halstead = Runtime.getRuntime().exec("frama-c -metrics -metrics-ast cabs src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(halstead.getInputStream());
			framaCOutput.add("Statikus kódelemzés - Halstead eredménye: \n");
			while (scanner.hasNextLine()) {
				framaCOutput.add(scanner.nextLine());
			}
			scanner.close();
			
			List<String> userHalstead = new ArrayList<>();

			String[] matches = new String[]
					{ "Total operators", "Distinct operators", "Total_operands", "Distinct operands", "Program length", 
						"Vocabulary size", "Program volume", "Effort", "Program level", "Difficulty level", "Time to implement", "Bugs delivered"};

			String[] units = new String[]
					{"", "", "", "", " characters", "", " bit", "", "", "", " sec", ""};

			String halsteadOutputString = "Halstead számok:\n";
			for (String element : framaCOutput) {
				for(String arrayElement: matches) {
					if(element.contains(arrayElement)) {
						userHalstead.add(element + "\n");
					}
				}
			}
			
			for(String element: userHalstead) {
				halsteadOutputString += element;
			}
			
			String[] halsteadArray = halsteadOutputString.split("(:)|\\n");

			List<Double> halsteadNumbers = new ArrayList<>();
			for(String element: halsteadArray) {
				if(isNumeric(element)) {
					halsteadNumbers.add(Double.parseDouble(element));
				}
			}
			halstead.destroy();
			
			List<Double> sampleHalsteadNumbers = new ArrayList<>();

			try {
		      File file = new File("src" + File.separator + "main" + File.separator
						+ "resources" + File.separator + "templates" + File.separator + "topics" + File.separator + path + "halstead_sample.txt");
		      Scanner sc = new Scanner(file);
		      while (sc.hasNextLine()) {
		    	  sampleHalsteadNumbers.add(Double.parseDouble(sc.nextLine()));
		      }
		      sc.close();
			} catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		
			for (int i = 0; i < halsteadNumbers.size(); i++) {
			//szazalekos elteres
		//	differenceHalstead.add(matches[i] + ": " + (df2.format((halsteadNumbers.get(i) - sampleHalstead.get(i))/(sampleHalstead.get(i))*100) + " %"));
			//elojeles kulonbseg
				differenceHalstead.add(matches[i] + ": " + (df2.format((halsteadNumbers.get(i) - sampleHalsteadNumbers.get(i)))) + units[i]);
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  }

	public void simpleStaticAnalyze(String sourceFileName) {
		if(!simpleStaticAnalyzeOutput.isEmpty()) {
			simpleStaticAnalyzeOutput.clear();
		}
		
		try {

			Process simple = Runtime.getRuntime().exec("cppcheck --enable=all src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(simple.getInputStream());
			simpleStaticAnalyzeOutput.add("Statikus kódelemzés (egyszerű) eredménye: \n");
			while (scanner.hasNextLine()) {
				simpleStaticAnalyzeOutput.add(scanner.nextLine());

			}
			scanner.close();
			simple.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void calculateCyclomaticComplexity(String sourceFileName, String path) {
		if(!cycl.isEmpty()) {
			cycl.clear();
		}
		if(!percentageDifferenceCyclomaticComplexity.isEmpty()) {
			percentageDifferenceCyclomaticComplexity.clear();
		}
		
		if(!absoluteDifferenceCyclomaticComplexity.isEmpty()) {
			absoluteDifferenceCyclomaticComplexity.clear();
		}
		
		if(!realCyclomaticComplexityList.isEmpty()) {
			realCyclomaticComplexityList.clear();
		}
		
		if(!pmccabeOutput.isEmpty()) {
			pmccabeOutput = "";
		}
		
		if(!realCyclomaticComplexity.isEmpty()) {
			realCyclomaticComplexity = "";
		}
		
		if(!absDifferenceCyc.isEmpty()) {
			absDifferenceCyc = "";
		}
		
		try {
			Process pmccabe = Runtime.getRuntime().exec("pmccabe src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "c_files" + File.separator + sourceFileName);
			Scanner scanner = new Scanner(pmccabe.getInputStream());

			while (scanner.hasNextLine()) {
				pmccabeOutput += scanner.nextLine() + "\n";
			}
			scanner.close();
			String[] cyclomaticNumbers = pmccabeOutput.split("\\n|\\t");

			List<String> userCyclomaticComplexityList = new ArrayList<>();
			
			for ( int i = 0; i < cyclomaticNumbers.length; i++) {
				if(cyclomaticNumbers[i].contains(".c")) {
					userCyclomaticComplexityList.add(cyclomaticNumbers[i-5]);
					userCyclomaticComplexityList.add(cyclomaticNumbers[i]); }
			}
			
			List<String> sampleCyclomaticComplexity = new ArrayList<>();

				try {
				      File file = new File("src" + File.separator + "main" + File.separator
								+ "resources" + File.separator + "templates" + File.separator + "topics" + File.separator + path + "cyc_sample.txt");
				      Scanner sc = new Scanner(file);
				      while (sc.hasNextLine()) {
				    	  sampleCyclomaticComplexity.add(sc.nextLine());
				      }
				      sc.close();      				      
				    } catch (FileNotFoundException e) {
				      e.printStackTrace();
				    }
				
				List<String> matches = new ArrayList<>();
				for(int i = 0; i < userCyclomaticComplexityList.size(); i++) {
						for(String line : sampleCyclomaticComplexity) {
							if(userCyclomaticComplexityList.get(i).contains(line)) {
								if(!isNumeric(line)) {
									if(!matches.contains(line)) {
										matches.add(line);
									}
								}
							}
						}
					}
		
		for(int i = 0, j = 0;  j < matches.size(); i++) {
			if(i%2 == 0) {
				percentageDifferenceCyclomaticComplexity.add(matches.get(j) + ": " + (((Double.parseDouble(userCyclomaticComplexityList.get(i)) - Double.parseDouble(sampleCyclomaticComplexity.get(i))) / Double.parseDouble(sampleCyclomaticComplexity.get(i)))*100 + "%"));
				absoluteDifferenceCyclomaticComplexity.add(matches.get(j) + ": " + (Integer.parseInt(userCyclomaticComplexityList.get(i)) - Integer.parseInt(sampleCyclomaticComplexity.get(i))));
				realCyclomaticComplexityList.add(matches.get(j) + ": " + Integer.parseInt(userCyclomaticComplexityList.get(i)));
				j++;
			}
		}
		
		pmccabeOutput = "";
		for(String element : percentageDifferenceCyclomaticComplexity) {
			pmccabeOutput += element + "\n";
		}
		
		absDifferenceCyc = "";
		for(String element : absoluteDifferenceCyclomaticComplexity) {
			absDifferenceCyc += element + "\n";
		}
		realCyclomaticComplexity = "";
		for(String element : realCyclomaticComplexityList) {
			realCyclomaticComplexity += element + "\n";
		}
			pmccabe.destroy();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
