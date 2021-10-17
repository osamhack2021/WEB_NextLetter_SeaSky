function div_army() {
    document.getElementById('army').style.display = 'block';

    
    document.getElementById('Submit').style.display = 'none';
    document.getElementById('armySubmit').style.display = 'unset';
    document.getElementById('airforceSubmit').style.display = 'none';
}

function div_airforce() {
    document.getElementById('army').style.display = 'none';
    
    document.getElementById('Submit').style.display = 'none';
    document.getElementById('armySubmit').style.display = 'none';
    document.getElementById('airforceSubmit').style.display = 'unset';
}
