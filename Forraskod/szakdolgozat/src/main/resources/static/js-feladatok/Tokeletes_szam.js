function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + 
			"\n" + 
			"int tokeletes(int szam);\n" + 
			"int kisebboszto_osszeg(int szam);\n" + 
			"\n" + 
			"int main()\n" + 
			"{\n" + 
			"    //egész szám bekérése és az eredmény kiírása\n" + 
			"}\n" + 
			"\n" + 
			"int tokeletes(int szam) {\n" + 
			"    //eldöntés, visszatérési érték 1, ha tökéletes, egyébként 0\n" + 
			"}\n" + 
			"\n" + 
			"int kisebboszto_osszeg(int szam) {\n" + 
			"    //a számnál kisebb osztói összegének kiszámítása\n" + 
			"}";
	
	} 
}