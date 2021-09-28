function getRequests(){
    let url = 'http://localhost:42069/request/employee';
    let xhr = new XMLHttpRequest(); 
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            // console.log("Response = " + xhr.response)
            let requests = JSON.parse(xhr.response)
            for (let request of requests) {
                let request_table = document.getElementById("table");
                let index = 1;
                let row =  request_table.insertRow(index);
                index += 1;
                let cell1 =  row.insertCell(0);
                let cell2 =  row.insertCell(1);
                let cell3 =  row.insertCell(2);
                let cell4 =  row.insertCell(3);
                cell1.innerHTML = request.reimburseID;
                cell2.innerHTML = request.employeeName;
                cell3.innerHTML = request.amount;
                cell4.innerHTML = request.status;
            }
        }
    }
    xhr.open('GET', url); 
    xhr.send();
}

window.onload = function(){
    this.getRequests();
}
