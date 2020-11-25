function loadTemplate() {
	var timeSpan = document.getElementById("timeSpan");
	var time = document.getElementById("time");

	var compileH4 = document.getElementById("compileH4");
	var compileLog = document.getElementById("compilelog");

	var runH4 = document.getElementById("runH4");
	var runLog = document.getElementById("runlog");

	var outputH4 = document.getElementById("outputH4");
	var output = document.getElementById("output");

	var testCaseSpan = document.getElementById("testCaseSpan");
	var testCases = document.getElementById("testCases");

	var staticCodeAnalyzeH4 = document.getElementById("staticCodeAnalyzeH4");
	var staticCodeAnalyze = document.getElementById("staticCodeAnalyze");

	var halsteadH4 = document.getElementById("halsteadH4");
	var halstead = document.getElementById("halstead");

	var namingConventionsH4 = document.getElementById("namingConventionsH4");
	var namingConventionsSpan = document
			.getElementById("namingConventionsSpan");

	var cycH4 = document.getElementById("cycH4");
	var cycValue = document.getElementById("cycValue");
	var cycValueSpan = document.getElementById("cycValueSpan");
	var cycAbsDiff = document.getElementById("cycAbsDiff");
	var cycAbsDiffSpan = document.getElementById("cycAbsDiffSpan");
	var cycPerDiff = document.getElementById("cycPerDiff");
	var cycPerDiffSpan = document.getElementById("cycPerDiffSpan");

	if (!timeSpan.textContent) {
		time.remove();
	}
	if (!compileLog) {
		compileH4.remove();
	}

	if (!runLog) {
		runH4.remove();
	}
	if (!output) {
		outputH4.remove();
	}

	if (!testCaseSpan.textContent) {
		testCases.remove();
	}
	if (!staticCodeAnalyze) {
		staticCodeAnalyzeH4.remove();
	}
	if (!halstead) {
		halsteadH4.remove();
	}
	if (!namingConventionsSpan.textContent) {
		namingConventionsH4.remove();
	}

	if (!cycValueSpan.textContent) {
		cycValue.remove();
	}

	if (!cycAbsDiffSpan.textContent) {
		cycAbsDiff.remove();
	}

	if (!cycPerDiffSpan.textContent) {
		cycPerDiff.remove();
	}
	if (!cycValueSpan.textContent && !cycAbsDiffSpan.textContent
			&& !cycPerDiffSpan.textContent) {
		cycH4.remove();
	}
}
