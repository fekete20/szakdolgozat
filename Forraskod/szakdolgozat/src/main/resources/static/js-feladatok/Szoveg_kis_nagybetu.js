function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"#include <ctype.h>\n" + 
			"\n" + 
			"//tömb méretének definiálása\n" + 
			"\n" + 
			"char *kisbetusit(char *szoveg);\n" + 
			"char *nagybetusit(char *szoveg);\n" + 
			"\n" + 
			"int main()\n" + 
			"{\n" + 
			"    //szöveg bekérése és az eredmények kiírása\n" + 
			"\n" + 
			"    return 0;\n" + 
			"}\n" + 
			"\n" + 
			"char *kisbetusit(char *szoveg) {\n" + 
			"    //kisbetűsítés\n" + 
			"}\n" + 
			"\n" + 
			"char *nagybetusit(char *szoveg) {\n" + 
			"    //nagybetűsítés\n" + 
			"}\n";
	
	} 
}