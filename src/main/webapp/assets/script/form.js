/**
 * Created by jphamlett on 6/17/17.
 */


function solve() {
    var maze = document.getElementById("path").value;
    $.ajax("solve.do", {
        data: "&path=" + maze,
        method: "POST",
        success: function (data) {
            console.log(data);
        },
        error: function (err){
            console.log("ERROR" + err);
        },
        complete: function () {
            console.log("COMPLETE");
        }
    })

}
