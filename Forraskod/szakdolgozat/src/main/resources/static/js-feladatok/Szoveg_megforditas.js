function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"#include <string.h>\n" + 
			"\n" + 
			"//tömb méretének definiálása\n" + 
			"\n" + 
			"char* megfordit(char szoveg[]);\n" + 
			"\n" + 
			"int main()\n" + 
			"{\n" + 
			"    //szöveg beolvasása és az eredmény kiírása\n" + 
			"    return 0;\n" + 
			"}\n" + 
			"\n" + 
			"char* megfordit(char szoveg[]) {\n" + 
			"    //szöveg megfordítása\n" + 
			"}";
	
	} 
}