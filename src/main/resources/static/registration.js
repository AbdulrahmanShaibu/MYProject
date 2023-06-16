window.scroll = function () {
  scrollFunction();
};
function scrollFunction() {
  document.getElementById("navbar").style.background = "#fff";
}

const ForWelcome=document.querySelector("#knowledge");

  setInterval(function() {
    ForWelcome.innerHTML="Free courses are here. Please get enrolled for the available courses now...";
  }, 3000);




