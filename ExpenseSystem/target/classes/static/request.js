function getRequest() {
    let url = 'http://localhost:42069/request';
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let id = document.getElementById("EmployeeID").value;
            let amount = document.getElementById("amount").value;
            let reason = document.getElementById("reason").value;
            console.log(id);
            console.log(amount);
            console.log(reason);
        }
    }

    xhr.open("POST", url)
    xhr.send();
}
