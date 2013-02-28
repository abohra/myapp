$(document).ready(function() {
    $('#userid').focus();

    $('#sub').click(function() {

       // event.preventDefault(); // prevent PageReLoad
      //  $('.error').css('display', 'none'); // hide error msg

        var ValEmail = $('#email').val('admin@admin.com'); // Email Value
        var ValUser = $('#userid').val('admin'); // User Value

        if (!(ValEmail === false && ValUser === false)) { // if ValEmail & ValPass are as above
          //  alert('valid!'); // alert valid!
            window.location.href = "landing.html?userid=" + $('#userid').val() ; // go to home.html
        }
        else {
            alert('not valid!'); // alert not valid!
            $('.error').css('display', 'block'); // show error msg
        }
    });
});

function getUrlParams() {
  var params = {};
  window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str,key,value) {
    params[key] = value;
  });
 
  return params;
}

getEmployees = function () {
    $.ajax({
        cache: true,
        url: "http://localhost:8080/patent/customer/allCustomers/",
        data: "{}",
        type: "GET",
        jsonpCallback: "parseResponse",
        contentType: "application/javascript",
        dataType: "json",
        error: ajaxCallFailed,
        failure: ajaxCallFailed,
        success: parseResponse
    });
};