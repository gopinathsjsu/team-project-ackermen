const rowClass = document.querySelector(".row")

let searchResult = JSON.parse(localStorage.getItem('infoReceived'));

console.log(searchResult)

for (let i = 0; i < searchResult.length; i++) {

    let div = document.createElement('div');

    div.classList.add('childDiv' + i.toString())
    //div.classList.add('card-style')
    div.setAttribute('style','border-style: double;padding: 20px;margin: 20px;border-radius: 15px;')

   // style="border-style: double;padding: 20px;margin: 20px;border-radius: 15px;"

    let img = document.createElement('img');
    img.src = "../StaticResources/img-"+i+".jpg"
    console.log(img)
    img.setAttribute('width', '450px');
    img.setAttribute('height', '230px');

    let h2 = document.createElement('h2');
    h2.textContent = '' + searchResult[i]["hotelName"];

    let p1 = document.createElement('p');
    p1.textContent = 'Starting from : $' + searchResult[i]["singlePrice"] + '/night';


    let p2 = document.createElement('p');
    p2.textContent = 'Location : ' + searchResult[i]["address"];

    let button = document.createElement("button")
    button.setAttribute("type", "submit")
    button.setAttribute("font-size", "15px")
    button.textContent = "Select Hotel"
    button.setAttribute('id', "button" + i.toString())
    button.setAttribute('data-hotelid', searchResult[i]["hotelId"].toString())

    button.style.cssText = "background-color: white; border-radius: 8px; border: 2px solid #4CAF50"
        // button.cla

    div.appendChild(img)
    div.appendChild(h2)
    div.appendChild(p1)
    div.appendChild(p2)
    div.appendChild(button)

    rowClass.appendChild(div)

    console.log(searchResult[i])
}


const btns = document.querySelectorAll('button[id^=button]')

btns.forEach(btn => {

    btn.addEventListener('click', event => {
        localStorage.setItem("hotelId", "" + event.target.getAttribute('data-hotelid'))
        window.location.href = "../hotelBooking/hotelBooking.html";
    });

})