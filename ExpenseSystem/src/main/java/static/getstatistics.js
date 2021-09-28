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
    console.log("end")
}

console.log("before onload")
window.onload = function(){
    console.log("statistics onload")
    this.getStatistics();
}
