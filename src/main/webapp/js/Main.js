const canvas = document.getElementById("graph");
const form = document.getElementById("graph-points-form");
const r_warning = document.getElementById("r-warning");

const dotsReceiver = new DotsReceiver();
const dotsSender = new DotsSender();
const drawer = new GraphDrawer(canvas);

dotsReceiver.getDotsFromServer().then(dots => {
    drawer.drawGraph(dots)
});

function convertX(x, r) {
    return ((x - drawer.width / 2) / drawer.R) * r;
}

function convertY(y, r) {
    return ((drawer.height - y - drawer.height / 2) / drawer.R) * r;
}

canvas.onmousedown = function (event) {
    const formData = new FormData(form);
    if (formData.get("r") == null) {
        r_warning.hidden = false;
    } else {
        r_warning.hidden = true;
        const r = parseFloat(formData.get("r").toString());
        const x = convertX(event.offsetX, r);
        const y = convertY(event.offsetY, r);
        dotsSender.sendDot(new Dot(x, y, r));
    }
};





