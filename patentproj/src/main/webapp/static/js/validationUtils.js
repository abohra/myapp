function RequiredField(className){
    var AreAllFieldsValid=true;
    $("."+className).each(function(){
        var value = $(this).val();
        var id = $(this).attr("id");
  
        if($(this).hasClass("watermarkText") && $(this).hasClass(className)){
            //if(value == "" || value == "undefined" || value == null){
                AreAllFieldsValid = false;
                ShowErrorMessage($(this),errorMessage[id+reqSuffix]);
            //}
        }
    }); 
    return AreAllFieldsValid;
}

function EmailValidation(className){
    var AreEmailFieldsValid= true;
    $("."+className).each(function(){
        var value = $(this).val();
        var id = $(this).attr("id");
        var regexResult = value.match(regex[ids[emailaddress]]);
        if(regexResult == null ||regexResult == undefined || regexResult== ""){
            AreEmailFieldsValid = false;
            ShowErrorMessage($(this),errorMessage[id+notValidSuffix]);
        }
    }); 
    return AreEmailFieldsValid;
}

function MobileValidation(className){
    var AreEmailFieldsValid= true;
    $("."+className).each(function(){
        var value = $(this).val();
        var id = $(this).attr("id");
        var regexResult = value.match(regex[ids[mobilenumber]]);
        if(regexResult == null ||regexResult == undefined || regexResult== ""){
            AreEmailFieldsValid = false;
            ShowErrorMessage($(this),errorMessage[id+notValidSuffix]);
        }
    }); 
    return AreEmailFieldsValid;
}

function PincodeValidation(className){
    var AreEmailFieldsValid= true;
    $("."+className).each(function(){
        var value = $(this).val();
        var id = $(this).attr("id");
        var regexResult = value.match(regex[ids[pincode]]);
        if(regexResult == null ||regexResult == undefined || regexResult== ""){
            AreEmailFieldsValid = false;
            ShowErrorMessage($(this),errorMessage[id+notValidSuffix]);
        }
    }); 
    return AreEmailFieldsValid;
}

function TextValidation(className){
    var AreEmailFieldsValid= true;
    $("."+className).each(function(){
        var value = $(this).val();
        var id = $(this).attr("id");
        var regexResult = value.match(regex[ids[text]]);
        if(regexResult == null ||regexResult == undefined || regexResult== ""){
            AreEmailFieldsValid = false;
            ShowErrorMessage($(this),errorMessage[id+notValidSuffix]);
        }
    }); 
    return AreEmailFieldsValid;
}

function ValidateInputs(){
    if(false == RequiredField(requiredFieldClass)){
        return false;
    }
//    if(false == EmailValidation("requiredValidation")){
//        return false;
//    }
//    if(false == MobileValidation("requiredValidation")){
//        return false;
//    }
//    if(false == PincodeValidation("requiredValidation")){
//        return false;
//    }
//    if(false == TextValidation("requiredValidation")){
//        return false;
//    }
    return true;
}

function HideErrorMessage(inputElement){
    inputElement.parent().parent().children(".requiredField").addClass("hide");
}

function ShowErrorMessage(inputElement,text){
    inputElement.parent().parent().children(".requiredField").removeClass("hide").html(text);
}