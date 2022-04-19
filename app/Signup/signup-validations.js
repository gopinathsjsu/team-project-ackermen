var fname = document.signup.first_name.value;
const lname = document.getElementById("last_name");
const bday = document.getElementById("birthday");
const gender = document.getElementById("gender");
const email = document.getElementById("email");
const password = document.getElementById("password");
const phone = document.getElementById("phone");
const user_type = document.getElementById("user_type");
const subject = document.getElementById("subject");
const city = document.getElementById("city");
const zip = document.getElementById("pin_code");

function signUpValidation() {
  if (fname == "") {
    alert("First name can't be empty");
  }
}

/*
form.addEventListener('submit', e => {
	e.preventDefault();

	signUpValidation();

});


const setError = (element, message) => {
	const inputControl = element.parentElement;
	const errorDisplay = inputControl.querySelector('.error');

	errorDisplay.innerText = message;
	inputControl.classList.add('error');
	inputControl.classList.remove('success');
}

const setSuccess = element =>{
	const inputControl = element.parentElement;
	const errorDisplay = inputControl.querySelector('.error');

	errorDisplay.innerText='';
	inputControl.classList.add('success');
	inputControl.classList.remove('error');
};

const isValidEmail = email => {
	const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@(( \[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return emailRegex.test(String(email).toLowerCase());
}

const formValidation = () =>
{	
	const fnameVal=fname.value.trim();
	const lnameVal=lname.value.trim();
	const emailVal=email.value.trim();
	const phoneVal=phone.value.trim();
	const genderVal=gender.value.trim();
	const marital_statusVal=marital_status.value.trim();
	const dobVal=dob.value.trim();
	const streetVal=street.value.trim();
	const cityVal=city.value.trim();
	const stateVal=state.value.trim();
	const zipVal=zip.value.trim();



	if (fnameVal === ''){
		setError(fname, 'Firstname is required');
	}
	else{
		setSuccess(fname);
	}

	if (lnameVal === ''){
		setError(lname, 'Lastname is required');
		
	}
	else{
		setSuccess(lname);
		

	}
	if (emailVal === ''){
		setError(email, 'Email is required');
		
	}
	else if (!isValidEmail(emailVal)){
		setError(email,'Provide a valid email address')
		
	}
	else{
		setSuccess(email);
		

	}
	
	if (genderVal===''){
		setError(gender, 'Select a gender');
	}
	else{
		setSuccess(gender);

	}
	if (marital_statusVal===''){
		setError(marital_status, 'Select a gender');
	}
	else{
		setSuccess(marital_status);

	}


	if (dobVal === ''){
		setError(dob, 'DOB is required');
		
	}
	else{
		setSuccess(dob);
		

	}

	if (phoneVal === ''){
		setError(phone, 'Phone number is required');
		
	}
	else{
		setSuccess(phone);
		

	}
	

	if (streetVal === ''){
		setError(street, 'Street address is required');
		
	}
	else{
		setSuccess(street);
		

	}

	if (cityVal === ''){
		setError(city, 'City is required');
		
	}
	else{
		setSuccess(city);
		

	}

	if (stateVal === ''){
		setError(state, 'State is required');
	
	}
	else{
		setSuccess(state);
	

	}
	if (zipVal === ''){
		setError(zip, 'Zipcode is required');
		
	}
	else{
		setSuccess(zip);
		
	}
	
}
*/
