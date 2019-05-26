
/* Validation for change of password-    1) Checks for empty fields
 *                            				  	a) Password field should not be empty
 *                             					b) Re-Enter Password field should not be empty
 *                      				 2) Checks if password contains less than 7 characters
 *                      				 3)	Checks if password contains more than 12 characters
 *                      				 4) Checks if password entered in both the fields match
 *                      				 5) Checks if password entered contains blank space
 */


function Validation()
{

	var PassElement1=document.getElementById('password1');

	var PassElement2=document.getElementById('password2');

	var isEmptyCheck=checkEmptyPass1(PassElement1);

	var isEmptyCheck1=checkEmptyPass1(PassElement2);

	var PassLength1=document.getElementById('password1').value.length;

	var correctMinLength=checkMinPassLength(PassLength1);

	var correctMaxLength=checkMaxPassLength(PassLength1);

	var isCorrectMatch=matchPasswords(PassElement1,PassElement2);

	var containsBlankSpace=checkForBlankSpaces(PassElement1);

	var containsBlankSpace=checkForBlankSpaces(PassElement2);
	
	
	//throws alert if password field is empty
	if(!isEmptyCheck)
	{
		alert("Choose a password");
		PassElement1.focus();
		return false;

	}
		
	//Throws alert if re-enter password field is empty
	if(!isEmptyCheck1)
	{
		alert("Enter the password again");
		PassElement2.focus();
		return false;

	}
	
	//Throws alert if password entered in both the fields don't match
	if(!isCorrectMatch)
	{
		alert("Passwords don't match");
	  	return false;

	}
	
	//Throws alert if password is less than 7 characters
	if(!correctMinLength)
	{
		alert("Password should have atleast 7 characters");
		PassElement1.focus();
		return false;
	}

	//Throws alert if password contains more than 12 characters
	if(!correctMaxLength)
	{
		alert("Password should not have more than 12 characters");
		PassElement1.focus();
		return false;
	}

	//Throws alert if password field contains blank space
	if(!containsBlankSpace)
	{
		alert("Password should not contain any blank spaces");
		PassElement1.focus();
		return false;

	}
	

	return true;
}


//Function to check if password field is empty
function checkEmptyPass1(elem)
{

var elementValue=elem.getAttribute('value');

if(elementValue!="")

{

	return true;
}

return false;

}

//Function to check if Re-Enter password field is empty
function checkEmptyPass2(elem)
{

var elementValue=elem.getAttribute('value');

if(elementValue!="")

{

	return true;
}

return false;

}

//Function to check if password entered in both the fields match
function matchPasswords(elem1,elem2)
{
	var elemValue1=elem1.getAttribute('value');
	
	var elemValue2=elem2.getAttribute('value');
	
	if(elemValue1!=elemValue2)
	{
		return false;
	}
	return true;
}

//Function to check if password contains less than 7 characters
function checkMinPassLength(length)
{

	if(length<7)
	{
		return false;
	}

	return true;
	
}

//Function to check if password contains more than 12 characters
function checkMaxPassLength(length)
{

	if(length>12)
	{
		return false;
	}

	return true;
	
}

//Function to check if password contains blank spaces
function checkForBlankSpaces(element)
{
	if(element.value.match(/\s/g))
		{
			return false;
		}
	return true;

		
}

