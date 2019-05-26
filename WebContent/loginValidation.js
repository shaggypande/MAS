
/* Validation for login- 1) Checks for empty fields
 *                             a) User ID field should not be empty
 *                             b) Password field should not be empty
 *                       2) Checks if User ID contains only numbers
 */

function formValidation()   
{ 

	var userIdElement=document.getElementById('userId');

	var isUserIdEmptyCheck=checkEmptyUserId(userIdElement);

	var PasswordElement=document.getElementById('password');

	var isPasswordEmptyCheck=checkEmptyPassword(PasswordElement);

	var isAllnum=checkifAllnum(userIdElement);

	//Throws alert if User ID field is empty
	if(!isUserIdEmptyCheck)
	{
		alert('User ID Field should not be empty');
		userIdElement.focus();
		return false;
	}
	
	
	//Throws alert if Password field is empty
	if(!isPasswordEmptyCheck)
	{
		alert('Password Field should not be empty');
		PasswordElement.focus();
		return false;
	}
	
	
	//Throws alert if User Id does not contain only numbers
	if(!isAllnum)
	{
		alert("Id should contain only numbers");
		userIdElement.focus();
		return false;
	}
	
	return true;
}

	//Function to check if User ID contains only numbers
	function checkifAllnum(element)
	{
	var numpattern= /^[0-9]+$/;
	
	var elementValue=element.getAttribute('value');
	
	if(numpattern.test(elementValue))
		
	{
		
		return true;
	}
	
	return false;
	
	}
	
	
	//Function to check if User ID field is left empty
	function checkEmptyUserId(elem)
	{
	
	var elementValue=elem.getAttribute('value');

	if(elementValue!=null)

	{
	
		return true;
	}

	return false;
	
	}

                                                          
	//Function to check if Password field is left empty
	function checkEmptyPassword(elem)
	{
	
	var elementValue=elem.getAttribute('value');

	if(elementValue!=null)

	{
	
		return true;
	}

	return false;
	
	}


	