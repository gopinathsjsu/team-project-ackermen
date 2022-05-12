const form = document.getElementById("bookForm");

console.log(form);

if (form) {
  form.addEventListener("submit", function (event) {
    event.preventDefault();
    //email, fname, adultcount, either of the rooms should be present, 
    const adultCount = form.elements["adultCount"].value;
    const childrenCount = form.elements["childrenCount"].value;
    const checkinDate = form.elements["checkinDate"].value;
    const checkoutDate = form.elements["checkoutDate"].value;
    const singleroomsBooked = form.elements["singleroomsBooked"].value;
    const doubleroomsBooked = form.elements["doubleroomsBooked"].value;
    const suitesBooked = form.elements["suitesBooked"].value;
    //const bookingEmail = form.elements["bookingEmail"].value;
    const loggedInUserEmail = localStorage.getItem("email");
    const hotelId = localStorage.getItem("hotelId");
    const pool = $("#pool").is(":checked") ? 1 : 0;
    const gym = $("#gym").is(":checked") ? 1 : 0;
    const parking = $("#parking").is(":checked") ? 1 : 0;
    const meals = $("#meals").is(":checked") ? 1 : 0;
    const breakfast = $("#breakfast").is(":checked") ? 1 : 0;
    //console.log(loggedInUserEmail);

    

    var settings = {
      url: "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/createBooking",
      method: "POST",
      timeout: 0,
      headers: {
        "Content-Type": "application/json",
        Cookie: "SESSION=ZWRkYzI0ZDctMzJmZS00ODRjLWJkZDgtN2RlMDU2ZmM3NThm",
      },
      data: JSON.stringify({
        newBooking: {
          userId: localStorage.getItem("userId"),
          hotelId: hotelId,
          adultCount: adultCount,
          childrenCount: childrenCount,
          checkinDate: checkinDate,
          checkoutDate: checkoutDate,
          singleroomsBooked: singleroomsBooked,
          doubleroomsBooked: doubleroomsBooked,
          suitesBooked: suitesBooked,
          bookingEmail: loggedInUserEmail,
          pool: pool,
          gym: gym,
          parking: parking,
          meals: meals,
          breakfast: breakfast,
        },
        user: JSON.parse(localStorage.getItem("user")),
      }),
    };

    $.ajax(settings).done(function (response) {
      console.log(response);
      if (response.statusMessage == "Booking successful.") {
        localStorage.setItem("bookingSummary", JSON.stringify(response));
        window.location.href = "../bookingSummary/bookingSummary.html";
      } else if(response.statusMessage.includes('duration')){
                alert(response.statusMessage)
        }
        else if(response.statusMessage.includes('mandatory')){
          alert(response.statusMessage)
        }
        else if(response.statusMessage.includes('duration')){
          alert(response.statusMessage)
        }
        else {
          alert(response.statusMessage)
        }
    });
  });
}
