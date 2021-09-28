function showRequests() {
    let url = 'http://localhost:42069/request/manager'
    let xhr = new XMLHttpRequest()
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let requests = JSON.parse(xhr.response)
            console.log(requests)
            for (let request of requests) {
                let request_container = document.getElementById("requests")

                let new_div = document.createElement('div')
                new_div.className = "request"

                let new_request_id = document.createElement('h2')
                new_request_id.innerHTML = request.reimburseID

                let new_name = document.createElement('h3')
                new_name.innerHTML = request.employeeName

                let new_amount = document.createElement('h3')
                new_amount.innerHTML = request.amount

                let new_reason = document.createElement('h3')
                new_reason.innerHTML = request.reason

                let approve_button = document.createElement('button')
                approve_button.innerHTML = "Approve"
                approve_button.onclick = function() {
                    console.log("start of approve")
                    let url2 = 'http://localhost:42069/request/approve'
                    let params = {
                        "id" : request.reimburseID,
                        "amount" : request.amount,
                        "employeeID" : request.employeeID,
                        "status" : "APPROVED"
                    }
                    let xhr2 = new XMLHttpRequest()
                    xhr2.onreadystatechange = function() {
                        new_div.remove()
                        window.location.href = "managerPage.html"
                    }
                    xhr2.open('POST', url2)
                    xhr2.send(JSON.stringify(params))
                    console.log("end of approve")
                }

                let deny_button = document.createElement('button')
                deny_button.innerHTML = "Deny"
                deny_button.onclick = function() {
                    let url3 = 'http://localhost:42069/request/deny'
                    let xhr3 = new XMLHttpRequest()
                    let params2 = {
                        "id" : request.reimburseID,
                        "status" : "DENIED"
                    }
                    xhr3.onreadystatechange = function() {
                        new_div.remove()
                        window.location.href = "managerPage.html"
                    }
                    xhr3.open('POST', url3)
                    xhr3.send(JSON.stringify(params2))
                }

                new_div.append(new_request_id)
                new_div.append(new_name)
                new_div.append(new_amount)
                new_div.append(new_reason)
                new_div.append(approve_button)
                new_div.append(deny_button)

                request_container.append(new_div)
            }
        }
    }
    xhr.open('GET', url)
    xhr.send()
}

function getStatistics(){
    console.log("start")
    let url = 'http://localhost:42069/statistics';
    let xhr = new XMLHttpRequest(); 
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let statistics = JSON.parse(xhr.response)
            for (let stat of statistics) {
                let stat_table = document.getElementById("table");
                let index = 1;
                let row =  stat_table.insertRow(index);
                index += 1;
                let cell1 =  row.insertCell(0);
                let cell2 =  row.insertCell(1);
                let cell3 =  row.insertCell(2);
                let cell4 =  row.insertCell(3);
                cell1.innerHTML = stat.employeeID;
                cell2.innerHTML = stat.timesSpent;
                cell3.innerHTML = stat.totalSpent;
                cell4.innerHTML = stat.averageSpent;
            }
        }
    }
    xhr.open('GET', url); 
    xhr.send();
}

window.onload = function(){
    this.getStatistics()
    this.showRequests()
}