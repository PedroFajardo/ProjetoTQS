function fetchReservation(){
    const url = "http://localhost:8080/api/reservations/reservation"
    fetch(url,
        {
            mode: 'cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET",
            body: null
        })
        .then( data=>{return data.json()})
        .then(res=>{
        console.log(res);
        if(res.length != 0){
            var noReservations = document.getElementById("noReservations");
            noReservations.style.display = "none";
        }

        var postDiv = document.getElementById("reservations");

        for(var i = 0; i < res.length; i++){
            var reservation = res[i]
            var row = document.createElement('div')
            row.classList.add("row");
            row.classList.add("mb-3");
            row.classList.add("reservation");

            var servicesString = ''
            for( var j = 0; j < reservation.service.length; j++){
                if(j == reservation.service.length -1)
                    servicesString += reservation.service[j].type
                else
                    servicesString += reservation.service[j].type + ", ";
            }

            var startHour = new Date(reservation.startHour)
            var endHour = new Date(reservation.endHour)

            row.innerHTML = '<div class="row" id="'+ reservation.id +'"height="300">\
                                        <div class="col-md-5 col-sm-5 col-xs-5">\
                                            <div class="m-3">\
                                                <h5><strong>Service:</strong> '+ servicesString +'</h5>\
                                                <h5><strong>Availability:</strong> '+ startHour.getHours() +':'+(startHour.getMinutes()<10?'0':'') + startHour.getMinutes() +'-'+ endHour.getHours() +':'+(endHour.getMinutes()<10?'0':'') +endHour.getMinutes()+ ' h</h5>\
                                                <h5><strong>Price (per hour):</strong> '+ reservation.priceHour +' euros</h5>\
                                            </div>\
                                        </div>\
                                        <div class="col-md-7 col-sm-7 col-xs-7">\
                                            <div class="m-3">\
                                                <h5><strong>Description:</strong>'+reservation.description+'</h5>\
                                                <h5><strong>User:</strong>'+reservation.description+'</h5>\
                                                <hr>\
                                                <button type="button" class="btn btn-danger" onclick="requestReservation('+reservation.id+')">Request Service</button>\
                                            </div>\
                                        </div>\
                                    </div>'
            postDiv.appendChild(row);
        }
    })
}