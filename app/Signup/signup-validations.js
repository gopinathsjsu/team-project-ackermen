

const form = document.querySelector('form');

if(form){
form.addEventListener("submit", function (event) {
	// stop form submission
	event.preventDefault();

	// validate the form
//	let name = form.elements["first_name"];
//	let email = form.elements["email"];

	const fname = form.elements["first_name"].value;
    const lname = form.elements["last_name"].value;
    const bday = form.elements["birthday"].value;
    const gender = form.elements["gender"].value;
    const email = form.elements["email"].value;
    const password = form.elements["password"].value;
    const phone = form.elements["phone"].value;
    const user_type = 'c';
    const subject = form.elements["subject"].value;
    const city = form.elements["city"].value;
    const zip = form.elements["pin_code"].value;
    const address = form.elements["address"].value;
	// if valid, submit the form.
// console.log(fname + " type " +user_type);
// email, firstname mandatory
	if(fname == '' || fname == undefined || fname == null) {
		alert('First Name cannot be empty..!')
	} else if(email == '' || email == undefined || email == null){
		alert('Email cannot be empty ..!')
	} else if(password == '' || password == undefined || password == null) {
		alert('Password cannot be empty..!')
	} else if(address == '' || address == undefined || address == null) {
		alert('Address cannot be empty..!')
	} else if(city == '' || city == undefined || city == null) {
		alert('City cannot be empty..!')
	} else if(subject == '' || subject == undefined || subject == null) {
		alert('Country cannot be empty..!')
	} else if(zip == '' || zip == undefined || zip == null) {
		alert('Zip Code cannot be empty..!')
	} else {
		var settings = {
			"url": "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/createUser",
			"method": "POST",
			"timeout": 0,
			"headers": {
				"Content-Type": "application/json"
			},
			"data": JSON.stringify({
				"id": "989897",
				"firstName": fname,
				"lastName": lname,
				"email": email,
				"password": password,
				"country": subject,
				"city": city,
				"address": address,
				"zipcode": zip,
				"userType": user_type
			}),
			};
	
			$.ajax(settings).done(function (response) {
			console.log(response);
			if(response.includes("successful")){
				window.location.href = "../Login/login.html";
			}
			else {
				alert(response);
			}
			});
	}

	 

// 
});
}

