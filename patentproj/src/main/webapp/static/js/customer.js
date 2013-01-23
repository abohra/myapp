var page = "customer";

$(document).ready(function(){
    
    $('.inputBox').focusin(function(){
        var idOfFocusedElement = $(this).attr('id');
        ClearTextBoxWaterMarkOnFocus(idOfFocusedElement);
    });
   
    $('.inputBox').focusout(function(){
        var idOfFocusedOutElement = $(this).attr('id');
        SetTextBoxIfEmpty(idOfFocusedOutElement, page);
    });
   
    $('#CreateAccountButton').click(function(){
        var TestCustomerJSONObject= {
            "firstname":"John",
            "lastname":"Johnson",
            "emailaddress":"John@Johnson.com",
            "addressline1":"Oslo West 555", 
            "addressline2":"Kazipet",
            "city":"warangal",
            "state":"andhra pradesh",
            "pincode":"506003",
            "mobile":"555 1234567"
        };
        ClearWaterMarkText();
        FillTextBoxWithCustomerData(TestCustomerJSONObject);
    });
});


function FillTextBoxWithCustomerData(customerJSON){
      $('#firstname').val(customerJSON.firstname);
      $('#lastname').val(customerJSON.lastname);
      $('#emailaddress').val(customerJSON.emailaddress);
      $('#addressline1').val(customerJSON.addressline1);
      $('#addressline2').val(customerJSON.addressline2);
      $('#city').val(customerJSON.city);
      $('#state').val(customerJSON.state);
      $('#pincode').val(customerJSON.pincode);
      $('#mobilenumber').val(customerJSON.mobile);
}