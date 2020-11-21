function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"\n" + 
			"//Datum típus definiálása\n" + 
			"\n" + 
			"void beolvas(Datum * d);\n" + 
			"void kiir(Datum d);\n" + 
			"Datum regebbi_datum(Datum d1, Datum d2);\n" + 
			"\n" + 
			"int main() {\n" + 
			"     //dátumok bekérése és az eredmény kiírása\n" + 
			"}\n" + 
			"\n" + 
			"void beolvas(Datum * d) {\n" + 
			"     //dátum beolvasása\n" + 
			"     return ;\n" + 
			"}\n" + 
			"void kiir(Datum d) {\n" + 
			"     //dátum kiírása\n" + 
			"     return ;\n" + 
			"}\n" + 
			"Datum regebbi_datum(Datum d1, Datum d2) {\n" + 
			"     //régebbi dátum megállapítása\n" + 
			"}";
	
	} 
}