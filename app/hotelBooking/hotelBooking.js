const form = document.getElementById('bookForm');

console.log(form)

if (form) {
    form.addEventListener("submit", function(event) {
        event.preventDefault();

        const adultCount = form.elements["adultCount"].value;
        const childrenCount = form.elements["childrenCount"].value;
        const checkinDate = form.elements["checkinDate"].value;
        const checkoutDate = form.elements["checkoutDate"].value;
        const singleroomsBooked = form.elements["singleroomsBooked"].value;
        const doubleroomsBooked = form.elements["doubleroomsBooked"].value;
        const suitesBooked = form.elements["suitesBooked"].value;
        //const bookingEmail = form.elements["bookingEmail"].value;
        const loggedInUserEmail = localStorage.getItem("email");
        console.log(loggedInUserEmail);
        var settings = {
            "url": "http://localhost:8090/createBooking",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json",
                "Cookie": "SESSION=ZWRkYzI0ZDctMzJmZS00ODRjLWJkZDgtN2RlMDU2ZmM3NThm"
            },
            "data": JSON.stringify({
                "hotelId": 5,
                "adultCount": adultCount,
                "childrenCount": childrenCount,
                "checkinDate": checkinDate,
                "checkoutDate": checkoutDate,
                "singleroomsBooked": singleroomsBooked,
                "doubleroomsBooked": doubleroomsBooked,
                "suitesBooked": suitesBooked,
                "bookingEmail": loggedInUserEmail
            }),
        };

        $.ajax(settings).done(function(response) {
            console.log(response);
            if (response.includes('successful')) {
                window.location.href('../hotelSearchResults/hotelSearchResults.html');
            } else {
                alert(response);
            }
        });

    });

}