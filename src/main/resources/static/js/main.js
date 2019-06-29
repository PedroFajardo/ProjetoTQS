function validateLoginForm(){
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    console.log(email)
    console.log(password)

    /*var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", 'http://localhost:8080/api/users/login',true); // false for synchronous request
    xmlHttp.setRequestHeader("Access-Control-Allow-Origin","*");
    xmlHttp.setRequestHeader("Access-Control-Allow-Credentials", "true");
    xmlHttp.setRequestHeader("Access-Control-Allow-Headers", "Content-Type");

        var data = new FormData();
        data.append('email', email);
        data.append('passwordd', password);


    xmlHttp.send(data);

    console.log(xmlHttp.response);*/

    var data = fetch("http://localhost:8080/api/users/login",
    {
            mode: 'cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({'email': email, 'password': password})
        })
        .then( data=>{return data.json()})
        .then(res=>{

            sessionStorage.setItem("user_id",  res.user_id);
            sessionStorage.setItem("userType", res.userType);

            if(sessionStorage.getItem("userType") == "client")
                window.location.href = "client/client.html";

        })


}

function validateRegisterForm(){
    var userType = document.getElementById("userType").value;
    var firstName = document.getElementById("InputFirst").value;
    var lastName = document.getElementById("InputLast").value;
    var email = document.getElementById("InputEmail").value;
    var phone = document.getElementById("InputPhone").value;
    var birthday = document.getElementById("InputBirthday").value;
    var address = document.getElementById("InputAddress").value;
    var password = document.getElementById("InputPassword").value;
    var confPassword = document.getElementById("InputPasswordConfirm").value;

    if (password == confPassword){

        if(userType == "client")
            fetch("http://localhost:8080/api/clients/client",
            {
                mode: 'cors',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({'firstName' : firstName, 'lastName' : lastName, 'email': email, 'phone': phone, 'username': email, 'birthday': birthday, 'address': address, 'password': password})
            })
            .then(function(res){
                console.log(res);
                $('#registerModal').modal('hide');
            })
            .catch(function(res){ console.log(res) })
        else if (userType == "worker")
            fetch("http://localhost:8080/api/workers/worker",
            {
                mode: 'cors',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({'firstName' : firstName, 'lastName' : lastName, 'email': email, 'phone': phone, 'username': email, 'birthday': birthday, 'address': address, 'password': password})
            })
            .then(function(res){
                console.log(res);
                $('#registerModal').modal('hide');
            })
            .catch(function(res){ console.log(res) })
        else if (userType == "manager")
            fetch("http://localhost:8080/api/managers/manager",
            {
                mode: 'cors',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({'firstName' : firstName, 'lastName' : lastName, 'email': email, 'phone': phone, 'username': email, 'birthday': birthday, 'address': address, 'password': password})
            })
            .then(function(res){
                console.log(res);
                $('#registerModal').modal('hide');
            })
            .catch(function(res){ console.log(res) })
    }
}

function logout(){

    sessionStorage.clear();

    window.location.href = "index.html";
}