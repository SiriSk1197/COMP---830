var counter = 10;
var interval = setInterval(function () {
    counter--;
    // Display 'counter' wherever you want to display it.
    if (counter <= 0) {
        clearInterval(interval);
        $('#timer').html("<h3>Count down complete</h3>");
        return;
    } else {
        $('#time').text(counter);
        console.log("Timer --> " + counter);
    }
}, 1000);