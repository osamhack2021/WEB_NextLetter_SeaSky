function div_army() {
    document.getElementById("army").style.display = "block";

    document.getElementById("airforce").style.display = "none";
    
    document.getElementById("armySubmit").style.display = "block";
    document.getElementById("airforceSubmit").style.display = "none";
}

function div_airforce() {
    document.getElementById("army").style.display = "none";

    document.getElementById("airforce").style.display = "block";
    
    document.getElementById("armySubmit").style.display = "none";
    document.getElementById("airforceSubmit").style.display = "block";
}
