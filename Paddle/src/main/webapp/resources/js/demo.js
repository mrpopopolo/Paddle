function remplirForm(){
        document.getElementById('firstNameInput').value = "";
        document.getElementById('lastNameInput').value = "";
        document.getElementById('emailInput').value = "";
        document.getElementById('passwordInput').value = "";
        document.getElementById('confirmPasswordInput').value = "";
        document.getElementById('DateFin').value = new Date().toISOString().substring(0, 10);
        document.getElementById('CoproNameInput').value = "";
        document.getElementById('rueInput').value = "";
        document.getElementById('codePostalInput').value = "";
        document.getElementById('villeInput').value = "";
        document.getElementById('nbLogementsInput').value = "";
        document.getElementById('Tarif').value = 20;
    }