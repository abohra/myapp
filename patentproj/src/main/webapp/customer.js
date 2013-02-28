// Immediate function
(function () {
    "use strict";
    
    var restfulWebServiceURI, getEmployees, ajaxCallFailed, colorRows, parseResponse;
    
    restfulWebServiceURI = "http://localhost:8080/patent/customer/allCustomers/";
    
    // Execute after the DOM is fully loaded
    $(document).ready(function () {
        alert('Inside');
        getEmployees();
    });

    // Retrieve Employee List as JSONP
    getEmployees = function () {
        $.ajax({
            cache: true,
            url: http://localhost:8080/patent/customer/allCustomers/,
            data: "{}",
            type: "GET",
            jsonpCallback: "parseResponse",
            contentType: "application/javascript",
            dataType: "jsonp",
            error: ajaxCallFailed,
            failure: ajaxCallFailed,
            success: parseResponse
        });          
    };
    
    // Called if ajax call fails
    ajaxCallFailed = function (jqXHR, textStatus) { 
        console.log("Error: " + textStatus);
        console.log(jqXHR);
        $("#employeeList").empty();
        $("#employeeList").append("Error: " + textStatus);
    };
            
    // Called if ajax call is successful
    parseResponse = function (data) {
        var customer = data.vEmployee;   
        
        var employeeList = "";
        
        employeeList = employeeList.concat("<ul>" +
            
            "</ul>"); 
        
        $.each(customer, function(index, employee) {
            employeeList = employeeList.concat("<li>" +
                "<span class='listdisp'> <img src='images/edit2.gif' title='Edit Customer' alt='Edit Customer'> </span>" +
                "<span class='listdisp'> <img src='images/garbage.gif' title='Edit Customer' alt='Edit Customer'> </span>"+
                "<span class='listdisp'>"+customer.customerName+"</span>"  +
                "<span class='listdisp'>"+customer.emailAddress + "</span>" +
                "<span class='listdisp'>"+customer.contactNumber + "</span>" +
                "<span class='listdisp'>"+customer.address + "</span>" +
                "</li>");
        });
        
        $("#employeeList").empty();
        $("#employeeList").append(employeeList);
        colorRows();
    };
    
    // Styles the Employee List
    colorRows = function(){
        $("#employeeList .employee:odd").addClass("odd");
        $("#employeeList .employee:even").addClass("even");
        $("#employeeList .employee:last").addClass("last");
    };
} ());
