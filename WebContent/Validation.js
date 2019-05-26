
	// Function to validate details

	function validateForm()
	{
	
		var AdminIdElement=document.getElementById('adminId');

		var isAdminIdCheck=checkEmptyField(AdminIdElement);

		var isAdminIdValid=validateOnlyNumbers(AdminIdElement);
		
		var isAdminIdLength= checkLength(AdminIdElement);		

		
		if(!isAdminIdCheck)
		{
			alert('Admin Id Field should not be empty');
			AdminIdElement.focus();
			return false;
		}
		
		if(!isAdminIdValid)
		{
			alert('Admin Id Field should have only numbers');
			AdminIdElement.focus();
			return false;
		}
		
		if(!isAdminIdLength)
		{
			alert('Admin Id field should be equal to or less than 7 digits');
			AdminIdElement.focus();
			return false;
		}
		
		return true;
	}
		//Function to check field is empty or not
	
		function checkEmptyField(elem)
		{
	
		
		var elementValue=elem.getAttribute('value');
	
		if(elementValue!="")

		{
		
			return true;
		}
	
		return false;
		
		}
	

		//Function to check field contains only numbers or not
		
	function validateOnlyNumbers(elem){
	
		var onlyNumberPattern = /^[0-9]+$/; 
		var elementValue=elem.getAttribute('value');
	
		if(onlyNumberPattern.test(elementValue)){
		
			return true;
		}
	
		return false;
		
	}
	
	function checkLength(elem){
		
		var onlyNumberPattern = /^\d{1,7}$/; 
		var elementValue=elem.getAttribute('value');
		if(onlyNumberPattern.test(elementValue)){
			
			return true;
		}
	
		return false;
		
	}
	
	
	