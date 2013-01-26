function ClearTextBoxWaterMarkOnFocus(id){
    $("#"+id).removeClass("watermarkText");
    $("#"+id).val('');
}

function SetTextBoxIfEmpty(id,page){
    var valueOfTextBox = $("#"+id).val();
    if(valueOfTextBox == null || valueOfTextBox == undefined || valueOfTextBox == ""){
        if(page == "customer"){
            var defaultWaterMarkText = GetWaterMarkTextForCustomer(id);
        }
        $("#"+id).val(defaultWaterMarkText);
        $("#"+id).addClass("watermarkText");
    }
}

function ClearWaterMarkText(){
    $('.inputBox').removeClass("watermarkText");
}

function GetWaterMarkTextForCustomer(id){
    switch(id){
        case "firstname":
            return "Firstname";
        case "lastname":
            return "Lastname";
        case "emailaddress":
            return "Email address";
        case "mobilenumber":
            return "Mobile";
        case "addressline1":
            return "Address line 1";
        case "addressline2":
            return "Address line 2";
        case "city":
            return "City";
        case "state":
            return "State";
        case "pincode":
            return "Pincode";
    }
}

function AttachHeader(){
    var headerSection = document.createElement('header');
    headerSection.setAttribute('class','mainHeader');
    $(document).prepend(headerSection);
    return;
}

function AttachFooter(){
    var footerSection = document.createElement('header');
    footerSection.setAttribute('class','mainHeader');
    $(document).append(footerSection);
    return;
}

function ChangeText(id,textValue){
    document.getElementById(id).innerHTML = textValue;
}

function AlertBox(txt){
    alert(txt);
}

function SetFormAttributes(formId,method,url){
    $('#'+formId).attr({"action":url,"method":method});
}

function ShowNotification(msg){
    alert(msg);
}
