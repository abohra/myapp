var page = "user";

$(document).ready(function(){
    init();
    
    $('.inputBox').focusin(function(){
        var idOfFocusedElement = $(this).attr('id');
        ClearTextBoxWaterMarkOnFocus(idOfFocusedElement);
    });
   
    $('.inputBox').focusout(function(){
        var idOfFocusedOutElement = $(this).attr('id');
        SetTextBoxIfEmpty(idOfFocusedOutElement, page);
    });
   
    $('#CreateAccountButton').click(function(){
        //        if(false == ValidateInputs()){
        //            return false;
        //        }
        var data ={
            "customerId":"",
            "fName":$("#firstname").val(),
            "lName":$("#lastname").val(),
            "emailAddress":$("#emailaddress").val(),
            "contactNumber":$("#mobilenumber").val(),
            "address":$("#address").val(),
            "role":$("#role").val()
        }
        
    
    
        $.ajax({
            url:"http://localhost:8080/patent/rest/user/create",
            type:"POST",
            data:JSON.stringify(data),
            contentType:"application/json;",
            dataType:"applicaion/json",
            success: function(returnedData){
                alert("User Added Successfully\n"+"User Id"+ " " +returnedData);
            }
        })
    });
    
    
});

function init(){
    AttachHeader();
    //SetWaterMarks();
    //SetFieldsToBeValidated()
    //SetFormAttributes("newCustomerForm",config["newCustomer"],"POST");
}

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

function SetWaterMarks(){
    $(".inputBox").each(function(){
        var id = $(this).attr("id");
        $("#"+id).val(watermarkText[id]);
    });
}

function SetFieldsToBeValidated(){
    SetRequiredFields();
    SetEmailFields();
    SetMobileFields();
    SetPincodeFields();
}

function SetRequiredFields(){
    var requiredFields = new Array(firstname,lastname,mobilenumber,addressline1,emailaddress);//city,state,pincode
    for(field in requiredFields){
        $("#"+ids[requiredFields[field]]).addClass(requiredFieldClass);
    }
}

function SetEmailFields(){
    var emailFields = new Array(emailaddress);
    for(field in emailFields){
        $("#"+ids[emailFields[field]]).addClass(emailFieldClass);
    }
}

function SetMobileFields(){
    var mobileFields = new Array(mobilenumber);
    for(field in mobileFields){
        $("#"+ids[mobileFields[field]]).addClass(mobileFieldClass);
    }
}

function SetPincodeFields(){
    var pincodeFields = new Array(pincode);
    for(field in pincodeFields){
        $("#"+ids[pincodeFields[field]]).addClass(pincodeFieldClass);
    }
}

