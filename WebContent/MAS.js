var lists = new Array();
 
//**************LANGUAGE*************
//State-andhrapradesh
lists['andhrapradesh']    = new Array();
lists['andhrapradesh'][0] = new Array(
    
	'Hyderabad',
	'Visakhapatnam',
	'Vijayawada'
);
 lists['andhrapradesh'][1] = new Array(
	    
		'Hyderabad',
		'Visakhapatnam',
		'Vijayawada'
	  );
//***********************************
//State-Assam
lists['assam']    = new Array();
lists['assam'][0] = new Array(
	
	'Guwahati',
	'Silchar'
);
lists['assam'][1] = new Array(
	
	'Guwahati',
	'Silchar'
);
//************************************
//State-gujarat
lists['gujarat']    = new Array();
lists['gujarat'][0] = new Array(
	
	'Ahmedabad',
	'GandhiNagar',
	'Surat'
);
lists['gujarat'][1] = new Array(
	
	'Ahmedabad',
	'GandhiNagar',
	'Surat'
);

//State-Madhyapradesh
lists['madhyapradesh']    = new Array();
lists['madhyapradesh'][0] = new Array(
	
	'Bhopal',
	'Jabalpur',
	'Indore'
);
lists['madhyapradesh'][1] = new Array(
		
		'Bhopal',
		'Jabalpur',
		'Indore'
	);

//State-Maharashtra
lists['maharashtra']    = new Array();
lists['maharashtra'][0] = new Array(
	
	'Mumbai',
	'Pune',
	'Nagpur',
	'Aurangabad'
);
lists['maharashtra'][1] = new Array(
		
		'Mumbai',
		'Pune',
		'Nagpur',
		'Aurangabad'
	);


//State-Punjab
lists['punjab']    = new Array();
lists['punjab'][0] = new Array(
	
	'Ludhiana',
	'Amritsar',
	'Jalandhar'
);
lists['punjab'][1] = new Array(
		
		'Ludhiana',
		'Amritsar',
		'Jalandhar'
	);
//************Function**************

//********dropdown link function***************
function changeCity( box ) 
{
	
	list = lists[box.options[box.selectedIndex].value];
	emptyList( box.form.city );
	fillList( box.form.city, list );
}



function emptyList( box )
{
	while ( box.options.length ) box.options[0] = null;
}




function fillList( box, arr ) 
{
	for ( i=0; i < arr[0].length; i++ ) {
		option = new Option( arr[0][i], arr[1][i] );
		box.options[box.length] = option;
	}
	box.selectedIndex=0;
}



//****************Validation function************************
function validateForm()
{ 
	
	var fnameelmt=document.getElementById('firstName');
	var fnameValid= onlyalphaNew(fnameelmt);
	
	var fnameFill=onlynull(fnameelmt);
	if(!fnameFill)
	{
		alert('Please enter your first name');
		fnameelmt.focus();
		return false;
	}
	if(!fnameValid)
	{
		alert('First name should have alphabets only');
		fnameelmt.focus();
		return false;	
	}

	
	var mnameelmt=document.getElementById('middleName');
	if(mnameelmt.value.length!=0)
	{
	var mnameValid=onlyalphaNew1(mnameelmt);
	if(!mnameValid)
	{
		alert('middle name should have alphabets only');
		mnameelmt.focus();
		return false;	
	}
	}
	
	var lnameelmt=document.getElementById('lastName');
	var lnameValid=onlyalphaNew(lnameelmt);
	var lnameFill=onlynull(lnameelmt);
	if(!lnameFill)
	{
		alert('Please enter your last name');
		lnameelmt.focus();
		return false;
	}
	if(!lnameValid)
	{
		alert('Last name should have alphabets only');
		lnameelmt.focus();
		return false;	
	}
	//alert('Last name should have alphabets only');

	var addelmt=document.getElementById('address');
	var addValid=onlyalphaNewnum(addelmt);



	var dob=document.getElementById('date').value;
	//var dobpattern= /^[0-9]+(\-[12])(\-[1995])*$/;
	//var dobpattern=/^[12-12-1995]$/;
	//alert(dobpattern);
	if(dob=="")

	{
	alert('Please enter your date of birth');
	return false;
	}
	
 	var emailelmt=document.getElementById('email');
 	var emailvalid=onlyemail(emailelmt);
 	var emailFill=onlynull(emailelmt);
	if(!emailFill)
	{
		alert('Please enter your emial-id');
		 emailelmt.focus();
		return false;
	}
 	if(!emailvalid)
 	{
 	 	
 		alert('Enter valid email id');
 		 emailelmt.focus();
		return false;

 	 }
 	var mobelmt=document.getElementById('mobile');
	var mobValid=onlynum(mobelmt);
	var mobstart=numstart(mobelmt);
	var mobl=mobelmt.value.length;
	var mobFill=onlynull(mobelmt);
	if(!mobFill)
	{
		alert('Please enter your mobile no.');
		mobelmt.focus();
		return false;
	}
	if(!mobValid)
	{
		alert('Please enter valid Mobile number');
		mobelmt.focus();
		return false;
	}
	if(mobl!=10)
	{
		alert('Please enter 10 digit mobile number');
		mobelmt.focus();
		return false;
	}
	if(!mobstart)
	{

	alert('Please enter valid mobile no');
	return false;
	}


	var stateelmt=document.getElementById('state');
	if(stateelmt.value=="Select State")
	{
		alert('Please select your state');
		stateelmt.focus();
		return false;
	}

	var check1elmt=document.getElementById('check1');
	if(check1elmt.checked==true)
	{
		
		check1elmt.value="yes";
	}
	else
	{
		check1elmt.value="no";
	}


	var check2elmt=document.getElementById('check2');
	if(check2elmt.checked==true)
	{
		
		check2elmt.value="yes";
	}
	else
	{
		check2elmt.value="no";
	}
	
	
	 var check3=document.getElementById('check3');
      if(check3.checked==false)
      {
		alert('Please accept the terms and conditions');
		check3.focus();
		return false;
      }
      
	
	var con=confirm('Are you sure?');
	if(con==true)
	{
	return true;
	}
	else return  false;
	
}





//**************end validation function*******************

//******************sub functions***********************




function onlyalphaNew(elmt)
{
	
	var alphapattern=/^[A-Za-z]+$/; 
	var elementV=elmt.value;
	if(!elementV)
		{
		return false;
		}
	if(alphapattern.test(elementV))
	   {
		return true;
		
		}
	
	return false;
	
	
}

function onlyalphaNew1(elmt)
{
	
	var alphapattern= /^[A-Za-z]+[ ]*$/; 
	var elementV=elmt.value;
	if(alphapattern.test(elementV))
	   {
		return true;

		}
	return false;
	
	
}




function DateFormat(date,month,year)   
{ 
 
 if(((date.value=="30") && (month.value=="February")) || ((year.value%4!=0) && (date.value=="29")) || ((month.value=="April") && (date.value=="31")) || ((month.value=="February") && (date.value=="31")) || ((month.value=="June") && (date.value=="31"))|| ((month.value=="September") && (date.value=="31")) || ((month.value=="November") && (date.value=="31"))) 
{ 
        return true; 
}
return false;
}
function onlynum(elmt)
{ 	
	var numpattern= /^[0-9]+$/;
	var elementV=elmt.value;
	
	if(numpattern.test(elementV))
	   { 
		   
		return true;

		}
	
	return false;
}

function onlyalphaNewnum(elmt)
{
	var addpattern=/^[0-9 -\/A-Za-z]+$/;
	var elementV=elmt.value;
	if(addpattern.test(elementV))
	{
		return true;

	}
	return false;
	
}


function onlyemail(elmt)
{
	//var emailpat=/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	//var emailpat=/^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[com]*[co])*$/;
	var emailpat= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
	var elementV=elmt.value;
	if(emailpat.test(elementV))
	{
	return true;
	}
	return false;
}

function onlynull(elem)
{


var elementValue=elem.value;


if(elementValue)

{
	

	return true;
}

return false;

}
function numstart(elmt)
{ 
var elementV=elmt.value;
if(elementV.charAt(0)!=9 && elementV.charAt(0)!=8 && elementV.charAt(0)!=7)
{
	return false;
}
return true;
}
//**********************end sub functions****************************