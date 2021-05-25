		//Validacion email

const form = document.getElementById('idForm');

function validateIndexEmail() {
    let acumErrores = 0;

    form.classList.remove('is-invalid');

    let inputEmail = document.forms['myForm']['inputEmail'];

    let inputEmail = document.getElementById('inputEmail');

    if(inputEmail.value == '') {
        inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "Campo obligatorio";
        acumErrores ++;
    } else if(!validar_email(inputEmail.value)){
		inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "No cumple el formato";
		acumErrores ++;
    }

    if (acumErrores > 0){
        return false;
    }else{
		return true;
	}
}

form.addEventListener('blur', (event) => {
	console.log(event);
	if(event.target.value!='') event.target.classList.remove('is-invalid');
    validateIndexEmail();
}, false);

function validar_email(email) {
	let regex = /^([ña-zA-Z0-9_\.\-])+\@(([ña-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email) ? true : false;
}