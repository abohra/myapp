$(document).ready(function(){
    
    init();
    $("#searchOption").change(function(){
        switch(dropDownValue){
            case '0':
                ShowOnlyCustomerRelatedData();
                break;
            case '1':
                ShowOnlyUserRelatedData();
                break;
        }
    });
    
    $("#search").click(function(){
        var dataForSearch = $("#searchValue").val();
        var dropDownValue = $("#searchOption").val();
        switch(dropDownValue){
            case '0':
                $.ajax({
                    headers: { 
                        Accept : "application/json"
                    },
                    url:"http://localhost:8080/patent/rest/customer/fetch/"+dataForSearch,
                    type:"GET"
                //contentType:"application/json;"
                //success: function(){
                //alert("adasj");
                // alert(JSON.parse(returnedData));
                //if(returnedData != null || returnedData != '' || returnedData!='undefined'){
                //ShowOnlyCustomerRelatedData();
                //   FillCustomerData(returnedData);
                //}else{
                //
                //    alert("Invalid search");
                //}
                
                }).done(function( msg ) {
                    ShowOnlyCustomerRelatedData();
                    //alert(JSON.parse(msg));
                    FillCustomerData(msg);
                //alert( "Data Saved: " + msg[0].address );
                });
                break;
            case '1':
                $.ajax({
                    headers: { 
                        Accept : "application/json"
                    },
                    url:"http://localhost:8080/patent/rest/user/fetch/"+dataForSearch,
                    type:"GET",
                    contentType:"application/json;",
                    dataType:"applicaion/json"
                }).done(function( msg ) {
                    ShowOnlyUserRelatedData();
                    //alert(JSON.parse(msg));
                    FillUserData(msg);
                //alert( "Data Saved: " + msg[0].address );
                });
                break;
        }
    });
    
    $("#editBTN").click(function(){
        var dropDownValue = $("#searchOption").val();
        var data = GetDataFromFields(dropDownValue);
        alert(data.toString());
        switch(dropDownValue){
            case '0':
                $.ajax({
                    url:"http://localhost:8080/patent/rest/customer/update",
                    type:"POST",
                    data:JSON.stringify(data),
                    contentType:"application/json;",
                    dataType:"applicaion/json",
                    success: function(returnedData){
                        alert(returnedData);
                    }
                }).done(function( msg ) {
                    alert("Customer Updated Successfully" + msg.toString())
                });
                break;
            case '1':
                $.ajax({
                    url:"http://localhost:8080/patent/rest/user/update",
                    type:"POST",
                    data:JSON.stringify(data),
                    contentType:"application/json;",
                    dataType:"applicaion/json",
                    success: function(returnedData){
                        alert(returnedData);
                    }
                }).done(function( msg ) {
                    alert("User Updated Successfully" + msg.toString())
                });
                break;
        }
    });
    
    $("#deleteBTN").click(function(){
        var dataForSearch = $("#searchValue").val();
        var dropDownValue = $("#searchOption").val();
        switch(dropDownValue){
            case '0':
                $.ajax({
                    headers: { 
                        Accept : "application/json"
                    },
                    url:"http://localhost:8080/patent/rest/customer/delete/"+dataForSearch,
                    type:"GET"
                
                }).done(function( msg ) {
                    alert(msg);
                });
                break;
            case '1':
                $.ajax({
                    headers: { 
                        Accept : "application/json"
                    },
                    url:"http://localhost:8080/patent/rest/user/delete/"+dataForSearch,
                    type:"GET",
                    contentType:"application/json;",
                    dataType:"applicaion/json"
                }).done(function( msg ) {
                    alert(msg);
                });
                break;
        }
    });
})

function init(){
    //DisableAllTextFields();
    AttachHeader();
    ShowOnlyUserRelatedData();
    
}

function FillCustomerData(customerJSON){
    $("#name").val(customerJSON.customerName);
    $("#emailaddress").val(customerJSON.emailAddress);
    $("#mobilenumber").val(customerJSON.contactNumber);
    $("#address").val(customerJSON.address);
}

function FillUserData(userJSON){
    $("#firstname").val(userJSON.fName);
    $("#lastname").val(userJSON.lName);
    $("#emailaddress").val(userJSON.emailAddress);
    $("#mobilenumber").val(userJSON.contactNumber);
    $("#address").val(userJSON.address);
    $("#role").val(userJSON.role);
}

function ShowOnlyCustomerRelatedData(){
    $(".commonData").show();
    $(".customerData").show();
    $(".userData").hide();
}

function ShowOnlyUserRelatedData(){
    $(".commonData").show();
    $(".userData").show();
    $(".customerData").hide(); 
}

function GetDataFromFields(dropDownValue){
    var data;
    switch(dropDownValue){
        case '0':
            data ={
                "customerId":$("#searchValue").val(),
                "customerName":$("#name").val(),
                "emailAddress":$("#emailaddress").val(),
                "contactNumber":$("#mobilenumber").val(),
                "address":$("#address").val()
            }
            break;
        case '1':
            data ={
                "customerId":$("#searchValue").val(),
                "fName":$("#firstname").val(),
                "lName":$("#lastname").val(),
                "emailAddress":$("#emailaddress").val(),
                "contactNumber":$("#mobilenumber").val(),
                "address":$("#address").val(),
                "role":$("#role").val()
            }
            break;
    }
    return data;
}