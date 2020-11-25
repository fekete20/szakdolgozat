function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"#include <math.h>\n" + 
			"\n" + 
			"//Valosgyok és Komplexgyok típusok definiálása\n" + 
			"\n" + 
			"Valosgyok valosgyokSzamitas(int, int, int, double);\n" + 
			"Komplexgyok komplexgyokSzamitas(int, int, int, double);\n" + 
			"\n" + 
			"int main() {\n" + 
			"     //konstansok bekérése\n" + 
			"     //egyenlet megoldásainak kiírása\n" + 
			"\n" + 
			" return 0;\n" + 
			"}\n" + 
			"\n" + 
			"Valosgyok valosgyokSzamitas(int a, int b, int c, double d) {\n" + 
			"     //egyenlet valós gyökeinek kiszámítása\n" + 
			"}\n" + 
			"\n" + 
			"Komplexgyok komplexgyokSzamitas(int a, int b, int c, double d) {\n" + 
			"     //egyenlet komplex gyökeinek kiszámítása\n" + 
			"}";
	
	} 
}