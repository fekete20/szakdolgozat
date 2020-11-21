function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
	"#include <math.h>\n" + 
	"\n" + 
	"//itt definiálja a tömb méretét\n" + 
	"\n" + 
	"double szamtaniAtlag(int tomb[]);\n" + 
	"double mertaniAtlag(int tomb[]);\n" + 
	"\n" + 
	"int main() {\n" + 
	"     //tömb elemeinek beolvasása és az eredmények kiírása\n" + 
	"\n" + 
	"     return 0;\n" + 
	"}\n" + 
	"double szamtaniAtlag(int tomb[]) {\n" + 
	"     //számtani átlag számítása\n" + 
	"}\n" + 
	"double mertaniAtlag(int tomb[]) {\n" + 
	"     //mértani átlag számítása\n" + 
	"}";
	
	} 
}