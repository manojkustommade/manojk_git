function myfunction(){

	var username=document.getElementById("uname").value;
	var email=document.getElementById("mail").value;
	var password=document.getElementById("pwd").value;
	var confmpassword=document.getElementById("cpwd").value;
	var phonenum=document.getElementById("Mnum").value;
    var flag=1;
    var regemail="[\\w]@?[a-z]{5}.?[a-z]{3}";
	if(username && email &&password && confmpassword && phonenum){
        
        if(username.length<3){
        	alert("ente valid username");
        	flag=0;
        }
		
		if(confmpassword != password || password<8 || confmpassword<8) {
	    	alert("password didn't match");
	    	flag=0;
	  	} 
	  	/*if((regemail.test(email))
	  		alert("Incorrect email");*/
	  		var len=email.indexOf();
	    if(email.indexOf("@")<0 || email.indexOf(".")<0  || email.indexOf("@")>email.lastIndexOf(".")){
	    	alert("Incorrect email");
	    	flag=0;
	    }
	    if(phonenum.length!=10){
			alert("enter valid mobile number");
			flag=0;
		}
		if(flag==1){
			 /*var out=document.getElementById("display").innerHTML;
			 out=out+username+"&nbsp;&nbsp;"+email+"&nbsp;&nbsp;"+"&nbsp;&nbsp;"+phonenum+"<br>";
			 document.getElementById("display").innerHTML=out;*/
			var table = document.getElementById("display");
		    var row = table.insertRow(-1);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    cell1.innerHTML = username;
		    cell2.innerHTML = email;
		    cell3.innerHTML = phonenum;
		     alert("you are successfully signed up");
		}
	}
	else{


		window.alert("Please enter details");
	}
}
function myFunction() {
    document.getElementById("reset").reset();
}
function validate(evt){

	 var key = evt.keyCode;
     key = String.fromCharCode(key);

     if(isNaN(key))
     	evt.returnValue=false;
}