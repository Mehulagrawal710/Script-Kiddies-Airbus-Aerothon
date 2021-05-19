console.log("hello beta");
var widget = document.createElement("div");

widget.innerText="K";
widget.style.cssText = "background-color: #3c4469;border-radius: 30px;height: 60px;width: 60px;display: block; position: fixed; bottom: 50px; right: 50px;text-align: center;vertical-align: middle;line-height: 60px;font-size:30px;font-weight: bold;color: #fff;cursor: pointer;z-index: 3;";
widget.addEventListener('click', function (event) {alert('Konnex Working!');});

document.body.appendChild(widget);