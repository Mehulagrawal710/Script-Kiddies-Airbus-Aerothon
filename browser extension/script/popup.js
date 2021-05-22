// var isExtensionOn = true;

// function disableButton() {
//     var disableButton = document.getElementById("disableButton");
//     if (disableButton.innerHTML === "Disable") {
//         isExtensionOn = false;
//     } else if (disableButton.innerHTML === "Enable") {
//         isExtensionOn = true;
//     } else {
//         alert("Error");
//     }
// }

// document.addEventListener('DOMContentLoaded', function () {
//     var disableButton = document.getElementById("disableButton");
//     var br1 = document.getElementById("br1");
//     var br2 = document.getElementById("br2");

// //Send message to event.js (background script) telling it to disable the extension.

//     chrome.extension.sendMessage({cmd: "setOnOffState", data: {value: isExtensionOn}});

//     chrome.extension.sendMessage({cmd: "getOnOffState"}, function (response) {
//         if (response !== undefined) {
//             if (response) {
//                 disableButton.innerHTML = "Disable";
//                 disableButton.className = "button button3";
//                 disableButton.style.display = "";
//                 br1.style.display = "";
//                 br2.style.display = "";
//             }
//             else {
//                 disableButton.innerHTML = "Enable";
//                 disableButton.className = "button button1";
//                 disableButton.style.display = "";
//                 br1.style.display = "";
//                 br2.style.display = "";
//             }
//         }
//     });
// });