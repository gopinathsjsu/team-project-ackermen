function getBooking() {
    const userId = localStorage.getItem("userId");
    var settings = {
        "url": "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/getAllUserBookings/"+userId,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        localStorage.setItem("bookingHistory", JSON.stringify(response))
        window.location.href = "../bookingHistory/bookingHistory.html";
      });
    
}