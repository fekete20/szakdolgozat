function fillTextarea() {
	if(document.getElementById("solution").value == '') {
	document.getElementById("solution").value = "#include <stdio.h>\n" + "\n" + "int main()\n" + "{\n" + "\n"
			+ "	printf(\"Hello World\");\n" + "\n" + "	return 0;\n" + "}";
	
	} 
	else {
		console.log("else ág");
	}
	
}

//var solution = document.getElementById("solution").value;