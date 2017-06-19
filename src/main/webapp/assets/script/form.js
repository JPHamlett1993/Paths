/**
 * Created by jphamlett on 6/17/17.
 */


function solve() {
    console.log("Running")
    var maze = document.getElementById("path").value;
    $.ajax("index.do", {
        data: "&path=" + maze,
        method: "POST",
        success: function (data) {
            console.log(data)
            document.getElementById("body").innerHTML = data;
        },
        error: function (err){
            console.log("ERROR" + err);
        },
        complete: function () {
            console.log("COMPLETE");
        }
    })

}
