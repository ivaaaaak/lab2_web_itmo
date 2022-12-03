const inputY = document.getElementById("input-y");
const warningElement = document.getElementById("y-warning");
const submitButton = document.getElementById("check-button");

inputY.addEventListener("input", function() {
    const y = parseFloat(inputY.value);
    if (Number.isNaN(y) || y < -5 || y > 3) {
        warningElement.hidden = false;
        submitButton.disabled = true;
    } else {
        warningElement.hidden = true;
        submitButton.disabled = false;
    }
});

