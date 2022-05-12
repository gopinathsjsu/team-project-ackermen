const form = document.querySelector("form");
//email, password
if (form) {
  form.addEventListener("submit", function (event) {
    // stop form submission
    event.preventDefault();

    const email = form.elements["email"].value;
    const password = form.elements["password"].value;
    if(email == '' || email == undefined || email == null){
      alert('Email cannot be empty ..!')
    } else if(password == '' || password == undefined || password == null) {
      alert('Password cannot be empty..!')
    } else {
      var settings = {
        url: "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/userLogin",
        method: "POST",
        timeout: 0,
        headers: {
          "Content-Type": "application/json",
          Cookie: document.cookie,
        },
        data: JSON.stringify({
          userName: email,
          password: password,
        }),
        error : function(xhr, error, thrown) {
          alert("Failed to Login, Invalid Credentials!")
        }
      };
  
      $.ajax(settings).done(function (response) {
        console.log(response);
        if (response.email == email) {
          localStorage.setItem("email", response.email);
          localStorage.setItem("userId", response.id);
          localStorage.setItem("user", JSON.stringify(response));
          window.location.href = "../searchHotels/hotels.html";
        } 
      });
    }
    
  });
}
