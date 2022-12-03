const table = document.getElementById("result-table");
const clearAnimation = document.getElementById("clear-animation");

$("#clear-button").on("click", function () {
    $.ajax({
        url:"./controller",
        type: "DELETE",
        data: { clearFlag: 1 },
        success: function () {
            table.innerHTML = " <tr>\n" +
                "                <th>№</th>\n" +
                "                <th>X</th>\n" +
                "                <th>Y</th>\n" +
                "                <th>R</th>\n" +
                "                <th>Result</th>\n" +
                "            </tr>"
        }
    });
    clearAnimation.hidden = false;
    setTimeout(function () {
        clearAnimation.hidden = true
    }, 5000)
});



