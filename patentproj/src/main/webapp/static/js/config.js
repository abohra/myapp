var config = new Array();
var method = new Array();
var ids = new Array();
var errorMessage = new Array();
var watermarkText = new Array();
var requiredFieldClass = "required";
var mobileFieldClass = "mobileFieldValidate";
var emailFieldClass= "emailFieldValidate";
var pincodeFieldClass = "pincodeFieldValidate";

var firstname="firstname";
var lastname = "lastname";
var emailaddress= "emailaddress";
var mobilenumber = "mobilenumber";
var addressline1 = "addressline1";
var addressline2 = "addressline2";
var city = "city";
var state = "state";
var pincode="pincode";
var text = "text";
//Application Specific config information
config["appName"] = "";
config[""]="";

//URLs
var basURLCustomer = "baseURLCustomer";

var newCustomer = "newCustomer";
var editCustomer = "editCustomer";
var deleteCustomer = "deleteCustomer";
var getCustomer = "getCustomer";
var getCustomerList = "getCustomerList";


config[basURLCustomer]="http://localhost:8080/patent/rest/customer/";
config[newCustomer] =config[basURLCustomer]+method[newCustomer];
config[editCustomer] = config[basURLCustomer]+method[editCustomer];
config[deleteCustomer] = config[basURLCustomer]+method[deleteCustomer];
config[getCustomer] = config[basURLCustomer]+method[getCustomer];
config[getCustomerList] = config[basURLCustomer]+method[getCustomerList];

//==================================================================================================================================================

method[newCustomer]="";
method[editCustomer]="";
method[deleteCustomer]="";
method[getCustomer]="";
method[getCustomerList]="";


//==================================================================================================================================================

//==================================================================================================================================================

ids[firstname] = "firstname";
ids[lastname] = "lastname";
ids[emailaddress] ="emailaddress";
ids[mobilenumber]="mobilenumber";
ids[addressline1]="addressline1";
ids[addressline2]="addressline2";
ids[city]="city";
ids[state]="state";
ids[pincode]="pincode";

//==================================================================================================================================================


/*
 * When the fields are required and the text is empty these text go into the error message
 */
var reqSuffix = "Req";
errorMessage[ids[firstname]+reqSuffix] = "First name cant be empty";
errorMessage[ids[lastname]+reqSuffix] = "Last name cant be empty";
errorMessage[ids[emailaddress]+reqSuffix] ="Email address cant be empty";
errorMessage[ids[mobilenumber]+reqSuffix]="Mobile number cant be empty";
errorMessage[ids[addressline1]+reqSuffix]="Address line 1 cant be empty";
errorMessage[ids[city]+reqSuffix]="City cant be empty";
errorMessage[ids[state]+reqSuffix]="State cant be empty";
errorMessage[ids[pincode]+reqSuffix]="Pincode cant be empty";

/*
 * When the fields are not valid and the text is empty these text go into the error message
 */
var notValidSuffix = "NotValid";
errorMessage[ids[firstname]+notValidSuffix] = "Invalid first name";
errorMessage[ids[lastname]+notValidSuffix] = "Invalid last name";
errorMessage[ids[emailaddress]+notValidSuffix] ="Invalid email address";
errorMessage[ids[mobilenumber]+notValidSuffix]="Invalid mobile number";
errorMessage[ids[addressline1]+notValidSuffix]="Please enter a valid entry";
errorMessage[ids[city]+notValidSuffix]="Invalid city entry";
errorMessage[ids[state]+notValidSuffix]="Invalid State entry";
errorMessage[ids[pincode]+notValidSuffix]="Invalid pincode";


//==================================================================================================================================================


watermarkText[ids[firstname]] = "Firstname";
watermarkText[ids[lastname]] = "Lastname";
watermarkText[ids[emailaddress]] ="Email address";
watermarkText[ids[mobilenumber]]="Mobile number";
watermarkText[ids[addressline1]]="Address line 1";
watermarkText[ids[addressline2]]="Address line 2";
watermarkText[ids[city]]="City";
watermarkText[ids[state]]="State";
watermarkText[ids[pincode]]="Pincode";


//==================================================================================================================================================
var regex = new Array();
regex[ids[emailaddress]]= '';
regex[ids[mobilenumber]]="";
regex[ids[pincode]]="";
regex[text]="";


