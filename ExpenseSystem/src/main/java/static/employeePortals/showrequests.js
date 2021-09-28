function showRequests() {
    let url = 'http://localhost:42069/request/manager'
    let xhr = new XMLHttpRequest()
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log(xhr.response)
            let requests = JSON.parse(xhr.response)
            for (let request of requests) {
                let request_container = document.getElementById("requests")

                let new_div = document.createElement('div')
                new_div.className = "request"

                let new_id = document.createElement('h3')
                new_id.innerHTML = request.reimburseID

                let new_name = document.createElement('h3')
                new_name.innerHTML = request.name

                let new_amount = document.createElement('p')
                new_name.innerHTML = request.amount

                let new_reason = document.createElement('p')
                new_name.innerHTML = request.reason

                let approve_button = document.createElement('button')
                approve_button.innerHTML = "Approve"
                approve_button.onclick = function() {
                    let url2 = 'http://localhost:42069/request/approve'
                    let params = {
                        "id" : new_id,
                        "status" : "APPROVED"
                    }
                    let xhr2 = new XMLHttpRequest()
                    xhr2.onreadystatechange = function() {
                        new_div.remove()
                        window.location.href = "managerPage.html"
                    }
                    xhr2.open('POST', url2)
                    xhr2.send(JSON.stringify(params))
                }

                let deny_button = document.createElement('button')
                deny_button.innerHTML = "Deny"
                deny_button.onclick = function() {
                    let url3 = 'http://localhost:42069/request/deny'
                    let xhr3 = new XMLHttpRequest()
                    let params2 = {
                        "id" : new_id,
                        "status" : "DENIED"
                    }
                    xhr3.onreadystatechange = function() {
                        new_div.remove()
                        window.location.href = "managerPage.html"
                    }
                    xhr3.open('POST', url3)
                    xhr3.send(JSON.stringify(params2))
                }

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

window.onload = function(){
    this.showRequests()
}