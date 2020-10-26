package complex.szakdolgozat.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import complex.szakdolgozat.service.AnalyzeService;
import complex.szakdolgozat.service.CompilerService;
import complex.szakdolgozat.service.ExecuteService;
import complex.szakdolgozat.service.FileService;
import complex.szakdolgozat.service.TimerService;

@Controller
@Scope("session")
public class MainController {

	@Autowired
	private	FileService fileService = new FileService();
	@Autowired
	private	TimerService timerService = new TimerService();
	@Autowired
	private	CompilerService compilerService = new CompilerService();
	@Autowired
	private	ExecuteService executeService = new ExecuteService();
	@Autowired
	private	AnalyzeService analyzeService = new AnalyzeService();

	@GetMapping("/")
	public String showIndexPage() {
		return "selectTopic";
	}

	@PostMapping("/selectTopic")
	public String topicSelection(@RequestParam String topic, @RequestParam String level) {
		timerService.stop();
		timerService.setStart();
		if (topic.equals("ops") && level.equals("2")) {
			return "topics/operators/L2/Teglalap/teglalap";
		} else if (topic.equals("ops") && level.equals("3")) {
			return "topics/operators/L3/TwinPrime/twinPrime";
		} else if (topic.equals("ops") && level.equals("4")) {
			return "topics/operators/L4/Even/even";
		} else if (topic.equals("ops") && level.equals("5")) {
			return "topics/operators/L5/Factorial/factorial";
		} else if (topic.equals("arrays") && level.equals("2")) {
			return "404";
		} else if (topic.equals("arrays") && level.equals("3")) {
			return "404";
		} else if (topic.equals("arrays") && level.equals("4")) {
			return "404";
		} else if (topic.equals("arrays") && level.equals("5")) {
			return "404";
		} else if (topic.equals("strings") && level.equals("2")) {
			return "404";
		} else if (topic.equals("strings") && level.equals("3")) {
			return "404";
		} else if (topic.equals("strings") && level.equals("4")) {
			return "404";
		} else if (topic.equals("strings") && level.equals("5")) {
			return "404";
		} else if (topic.equals("structs") && level.equals("2")) {
			return "404";
		} else if (topic.equals("structs") && level.equals("3")) {
			return "404";
		} else if (topic.equals("structs") && level.equals("4")) {
			return "404";
		} else if (topic.equals("structs") && level.equals("5")) {
			return "404";
		} else {
			return "404";
		}
	}

	@RequestMapping("/practice")
	public ModelAndView showPracticeForm(String route) {
		timerService.setStart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("compileLog", compilerService.getCompileLog());
		mav.addObject("runLog", executeService.getRunLog());
		mav.addObject("stdout", executeService.getStdout());
		mav.addObject("solution", fileService.getSolution());
		mav.addObject("testRunLog", executeService.getTestRunLog());
		mav.addObject("simpleOut", analyzeService.getSimpleOut());
		mav.addObject("halsteadOut", analyzeService.getDifferenceHalstead());
		mav.addObject("cyc", analyzeService.getCy());
		mav.addObject("absDiffCyc", analyzeService.getAbsDifferenceCyc());
		mav.addObject("Ecyc", analyzeService.getCyc());
		mav.addObject("namingConventions", analyzeService.getLineString());
		mav.addObject("passedTestCaseCounter", executeService.getPassedTestCaseCounter());
		mav.addObject("failedTestCaseCounter", executeService.getFailedTestCaseCounter());
		mav.addObject("elapsedTime", timerService.getElapsedTime());
		mav.setViewName(route);
		return mav;
	}

	@GetMapping("/endOfTrying")
	public ModelAndView endOfTrying() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectTopic");
		timerService.stop();
		File sourceFileName = new File(fileService.getSourcePath() + fileService.getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(fileService.getCompiledPath() + fileService.getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(fileService.getTestSourcePath() + "test" + fileService.getSourceFileName());
		sourceFileName.delete();
		sourceFileName = new File(fileService.getCompiledTestPath() + "test" + fileService.getSourceFileName());
		sourceFileName.delete();
		return mav;
	}

	@PostMapping("/c_compile")
	public String cCompile(@RequestParam String solution, @RequestParam(required = false) String params, @RequestParam String route, @RequestParam String path) {
		timerService.setFinish();
		fileService.writeSolutionToFile(solution);
		timerService.setFinish();
		
		if(compilerService.compileCSource(fileService.getSourceFileName())) {
			return "redirect:/practice?route="+route;
		}
		executeService.executeCompiledCCode(fileService.getSourceFileName(), params);
		fileService.manageTestFile(fileService.getSourceFileName(), path);
		compilerService.compileTestSource("test" + fileService.getSourceFileName());
// teszt fordítási hiba esetére:	
/*		if(compilerService.compileTestSource("test" + fileService.getSourceFileName())) {
			return "redirect:/practice?route="+route;
		}
*/		
		executeService.executeTestCases("test" + fileService.getSourceFileName());
		analyzeService.simpleStaticAnalyze(fileService.getSourceFileName());
		analyzeService.calculateCyclomaticComplexity(fileService.getSourceFileName(), path);
		analyzeService.calculateHalstead(fileService.getSourceFileName(), path);
		analyzeService.checkNamingConventions(fileService.getSourceFileName());

		return "redirect:/practice?route="+route;
	}
}