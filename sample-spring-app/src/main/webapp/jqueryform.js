$(document).ready(function() {
  var score = 0;
  $("#submit").click(function() {
    var server = $("#server").val();
    var user = $("#user").val();
    var password = $("#password").val();
    if (user == '' || password == '') {
      alert("Please fill all fields.");
    } else {
      alert("done");
    }
  });

  
});

