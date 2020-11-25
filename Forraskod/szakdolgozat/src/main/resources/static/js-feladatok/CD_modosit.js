function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"\n" + 
			"//CD típus definiálása\n" + 
			"\n" + 
			"void beolvas(CD * lemez);\n" + 
			"void kiir(CD lemez);\n" + 
			"CD modosit(CD * lemez);\n" + 
			"\n" + 
			"int main() {\n" + 
			"     //beolvasó, kiíró és módosító függvények megfelelő alkalmazása\n" + 
			" return 0;\n" + 
			"}\n" + 
			"\n" + 
			"void beolvas(CD * lemez) {\n" + 
			"     //CD adatainak beolvasása\n" + 
			" return ;\n" + 
			"}\n" + 
			"\n" + 
			"void kiir(CD lemez) {\n" + 
			"     //CD adatainak kiírása\n" + 
			" return ;\n" + 
			"}\n" + 
			"\n" + 
			"CD modosit(CD* lemez) {\n" + 
			"     //CD adatainak módosítása\n" + 
			"}";
	
	} 
}