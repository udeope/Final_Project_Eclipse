const form = document.getElementById('profile');

function profileValidate() {
	let acumErrores = 0;
	
	form.classList.remove('is-invalid');
	
    
	let inputEmail = document.getElementById('inputEmail');
	
	let inputEmail = document.forms["prof"]["inputEmail"];
	let inputPassword = document.forms["prof"]["inputPassword"];
	let inputNick = document.forms["prof"]["inputNick"];
	let inputName = document.forms["prof"]["inputName"];
	let inputLastName = document.forms["prof"]["inputLastName"];
	let inputDate = document.forms["prof"]["inputDate"];
	let inputCountry = document.forms["prof"]["inputCountry"];
	let inputCapital = document.forms["prof"]["inputCapital"];

    
	if(inputEmail.value == "") {
		inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "Campo obligatorio";
        acumErrores ++;
    }else if(!validar_email(inputEmail.value)){
		inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "No cumple el formato";
		acumErrores ++;
	}

    let lcl = /[a-z]/g;
	let ucl = /[A-Z]/g;
	let numbers = /[0-9]/g;

    if(inputPassword.value == "") {
		inputPassword.classList.add("is-invalid");
		document.getElementById("errorPassword").textContent = "Campo obligatorio";
		acumErrores ++;
	}else if(inputPassword.value.length < 6) {
		inputPassword.classList.add('is-invalid');
		document.getElementById('errorPassword').textContent = 'Minimo 6 caracteres';
		acumErrores ++; 
		} else if(!inputPassword.value.match(lcl)) {
			inputPassword.classList.add('is-invalid');
			document.getElementById('errorPassword').textContent = 'Minimo 1 minuscula';
			acumErrores ++; 
		} else if(!inputPassword.value.match(ucl)) {
			inputPassword.classList.add('is-invalid');
			document.getElementById('errorPassword').textContent = 'Minimo 1 mayuscula';
			acumErrores ++; 
		} else if(!inputPassword.value.match(numbers)) {
			inputPassword.classList.add('is-invalid');
			document.getElementById('errorPassword').textContent = 'Minimo 1 numero';
			acumErrores ++; 
		}

   if(inputNick.value == ""){
            inputNick.classList.add("is-invalid");
            document.getElementById("errorNick").textContent = "Campo obligatorio";
            acumErrores ++;
           }
	
   if(inputName.value == ""){
    inputName.classList.add("is-invalid");
    document.getElementById("errorName").textContent = "Campo obligatorio";
    acumErrores ++;
   }
   if(inputLastName.value == ""){
    inputLastName.classList.add("is-invalid");
    document.getElementById("errorLastName").textContent = "Campo obligatorio";
    acumErrores ++;
   }

   if(inputDate.value == ""){
    inputDate.classList.add("is-invalid");
    document.getElementById("errorDate").textContent = "Campo obligatorio";
    acumErrores ++;
   }

   
   if(inputCountry.value == ""){
    inputCountry.classList.add("is-invalid");
    document.getElementById("errorCountry").textContent = "Campo obligatorio";
    acumErrores ++;
   }
   
   if(inputCapital.value == ""){
    inputCapital.classList.add("is-invalid");
    document.getElementById("errorCapital").textContent = "Campo obligatorio";
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
   profileValidate();
}, true);

function validar_email(email) {
	let regex = /^([ña-zA-Z0-9_\.\-])+\@(([ña-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email) ? true : false;
}

function validarDate(date) {
    let date_regex = /^(0?[1-9]|[1-2][0-9]|3[01])[\/](0?[1-9]|1[0-2])[\/]\d{4}$/;
        return date_regex.test(date) ? true : false;
}