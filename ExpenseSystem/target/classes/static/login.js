function redirect() {
    let username = document.getElementById("userName").value;
    let password = document.getElementById("password").value;

    console.log(username);
    console.log(password);

    if (username === "KCastillo" && password === "password") {
        window.location.replace("../employeePortals/managerPage");
    }

    else {
        window.location.replace("../employeePortals/employeePage");
    }
}