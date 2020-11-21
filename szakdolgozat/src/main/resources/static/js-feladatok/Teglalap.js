function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"\n" + 
			"int keruletSzamol(int a, int b);\n" + 
			"int teruletSzamol(int a, int b);\n" + 
			"\n" + 
			"int main()\n" + 
			"{\n" + 
			"    // téglalap oldalanak bekérése és az eredmény kiíratása\n" + 
			"    return 0;\n" + 
			"}\n" + 
			"\n" + 
			"int keruletSzamol(int a, int b) {\n" + 
			"    //téglalap kerületének kiszámítása\n" + 
			"}\n" + 
			"\n" + 
			"int teruletSzamol(int a, int b) {\n" + 
			"    //téglalap területének kiszámítása\n" + 
			"}\n" + 
			"\n";
	
	} 
}