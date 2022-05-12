let bookingHistory = JSON.parse(localStorage.getItem("bookingHistory"))

for(let i = 0 ; i < bookingHistory.length ; i++){
    if(bookingHistory[i].bookingStatus != "Deleted"){
        $("#bookings").append('<div class="col-md-6" style="margin-bottom: 10px;"><div class="card" style="background: #ffffff;"><div class="card-header"><p>Booking Id : <span id="bookingId-'+i+'"> ' + bookingHistory[i].bookingId + ' </span></p></div><div class="card-body"><ul><li>Booking Status : <span id="bookingStatus-'+i+'">'+bookingHistory[i].bookingStatus+'</span></li><li>Check In Date : <span id="checkInDate-'+i+'">'+bookingHistory[i].checkinDate+'</span></li><li>Check Out Date : <span id="checkOutDate-'+i+'">'+bookingHistory[i].checkoutDate+'</span></li>   <li>Number of Single Rooms : <span id="singleRooms'+i+'">'+bookingHistory[i].singleroomsBooked+'</span></li><li>Number of Double Rooms : <span id="doubleRooms'+i+'">'+bookingHistory[i].doubleroomsBooked+'</span></li><li>Number of Suites : <span id="suites'+i+'">'+bookingHistory[i].suitesBooked+'</span></li>  <address style="padding-top: 1%"><strong>Email ID: </strong><br /><p><span id="bookingEmail'+i+'">'+bookingHistory[i].bookingEmail+'</span></p></address><address><strong>Final Price: </strong><br /><p><span id="finalPrice'+i+'">$'+bookingHistory[i].finalPrice+'</span></p></address></ul><button class="btn btn-danger" onclick="deleteBooking(this)" id="deleteButton-'+i+'">Delete</button></div></div>')
    }



}



function reloadLocalStorage(){
    //localStorage.removeItem("bookingHistory");
    const userId = localStorage.getItem("userId");
    var settings = {
        "url": "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/getAllUserBookings/"+userId,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        localStorage.setItem("bookingHistory", JSON.stringify(response))
      });

      $("#hiddenButton").click();
}


function deleteBooking(elem){
    

    var settings = {
        "url": "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/deleteBooking/" + bookingHistory[elem.id.split("-")[1]].bookingId,
        "method": "DELETE",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (response) {
        reloadLocalStorage();
        
      });
    
}


function reloadPage(){
    location.reload(true);
}



function rewardPointDisplay(){
  const userId = localStorage.getItem("userId");
  let bookingHistory = JSON.parse(localStorage.getItem("bookingHistory"))
  var settings = {
    "url": "http://SpartanLoadBalancer-1460688251.us-east-1.elb.amazonaws.com/getRewards/"+userId,
    "method": "GET",
    "timeout": 0,
  };
  
  $.ajax(settings).done(function (response) {
    console.log(response);
    if(response.rewardPoints > 0 && response.rewardPoints <= 500 ){
      let latestRewardPoints = response.rewardPoints;
    $("#rewardPointSpan").html('Silver - ' + latestRewardPoints);
    $("#rewardPointButton").click(); 
    } else if (response.rewardPoints > 500 && response.rewardPoints <= 1000 ){
      let latestRewardPoints = response.rewardPoints;
    $("#rewardPointSpan").html('Gold - ' + latestRewardPoints);
    $("#rewardPointButton").click(); 
    } else if (response.rewardPoints > 1000 && response.rewardPoints <= 2000 ){
      let latestRewardPoints = response.rewardPoints;
    $("#rewardPointSpan").html('Platinum - ' + latestRewardPoints);
    $("#rewardPointButton").click(); 
    } else if (response.rewardPoints > 2000 ){
      let latestRewardPoints = response.rewardPoints;
    $("#rewardPointSpan").html('Spear Elite - ' + latestRewardPoints);
    $("#rewardPointButton").click(); 
    } else {
    $("#rewardPointSpan").html('You do not have any Reward Points');
    $("#rewardPointButton").click(); 
    }
    
    // if(response)
  });
  
  
}
