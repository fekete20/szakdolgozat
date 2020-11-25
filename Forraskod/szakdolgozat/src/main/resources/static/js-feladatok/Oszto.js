function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"\n" + 
			"int osztoSzamlal(int szam);\n" + 
			"\n" + 
			"int main() {\n" + 
			"     //egész szám bekérése és az eredmény kiírása\n" + 
			"     return 0;\n" + 
			" }\n" + 
			"\n" + 
			"int osztoSzamlal(int szam) {\n" + 
			"    //osztók megszámlálása\n" + 
			" }";
	
	} 
}