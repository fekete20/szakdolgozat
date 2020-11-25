function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
	"\n" + 
	"//itt definiálja a tömb méretét\n" + 
	"\n" + 
	"int keres(int keresett, int tomb[]);\n" + 
	"\n" + 
	"int main() {\n" + 
	"     //tömb inicializálása, a keresett érték beolvasása és az eredmény kiírása     \n" + 
	"\n" + 
	"     return 0;\n" + 
	"}\n" + 
	"\n" + 
	"int keres(int keresett, int tomb[]) {\n" + 
	"    //lineáris keresés implementálása\n" + 
	"}";
	
	} 
}