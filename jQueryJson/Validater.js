
function checkDetails(name,email,phonenum){

	
	var flag=true;
	if(name && email && phonenum){

		if(name.length<3){
			alert("Please enter the perfect name");
			flag=false;
		}
		else if(email.lastIndexOf('@')<0 || email.lastIndexOf('.')<0 || email.lastIndexOf('.')<email.lastIndexOf('@') ||email.lastIndexOf('.') >= (email.length-1)){
			alert("Enter valid emailId");
			flag=false;
		}
		else if(phonenum.length!=10){
			alert("Enter valid Mobile Number");
			flag=false;
		}
		return flag;

	}	

}