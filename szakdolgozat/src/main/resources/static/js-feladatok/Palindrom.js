function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"#include <string.h>\n" + 
			"#include <ctype.h>\n" + 
			"\n" + 
			"//tömb méretének definiálása\n" + 
			"\n" + 
			"int palindroma(char* szoveg);\n" + 
			"\n" + 
			"int main() {\n" + 
			"     //szöveg beolvasása és az eredmény kiírása\n" + 
			"     return 0;\n" + 
			"}\n" + 
			"int palindroma(char* str) {\n" + 
			"    //annak megállapítása, hogy a szöveg palindróm-e\n" + 
			"    //visszatérési érték: 1, ha palindróm, egyébként 0\n" + 
			"}";
	
	} 
}