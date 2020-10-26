function validateInput() {
	var textarea = document.getElementById("solution").value;
	var input = document.forms["solutionSend"]["params"].value;
	if (textarea.includes("scanf") && input == "") {
		alert("A begépelt forráskód tartalmaz beolvasási utasítást, azonban a Paraméterek mezőben nem adott meg bemenetet. Kérem, pótolja!");
    return false;
  }
	if(textarea == '') {
		alert("Nem adott meg programkódot.");
		return false;
	}
}