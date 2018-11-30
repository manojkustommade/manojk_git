function checkDetails(){
    var name = $("#Name").val();
    var email = $("#email").val();
    var phonenum = $("#Telephone").val();
    var flag=true;

	if(!isNaN(name) || name == ''){
			alert("Please enter the valid name");
			flag=false;
	}
	else if(email == '' || email.indexOf('@') < 0 || email.indexOf('@') < 0 || email.indexOf('@') > email.lastIndexOf('.')){
			alert("Enter valid emailId");
			flag=false;
	}
	else if(phonenum.length!=10 || phonenum == '' || isNaN(phonenum)){
			alert("Enter valid Mobile Number");
			flag=false;
	}
    if(flag==true){
        ajaxcalling();
    }
}
function ajaxcalling(){
    var name = $("#Name").val();
    var email = $("#email").val();
    var phonenum = $("#Telephone").val();
    var empdata={};
    empdata.uname=name;
    empdata.email=email;
    empdata.phonenum=phonenum;
    var posturl="/addemployee/";
    $.ajax({
        url:posturl,
        type:"POST",
        data: empdata,
        traditional: true,
        dataType: 'html',
        success: function(){
            alert('Details Successfully Added');
            window.location.assign('/addemployee/');
        },
        error: function(){
                alert('Sorry...You entered email already exist,please try another email');
        }
    });

}

function updatedata(){
     var name =$("#username").val();
    var email = $("#emailId").val();
    var phonenum = $("#mobilenum").val();
    var flag=true;
    if(name && email && phonenum){

		if(name.length<3){
			alert("Please enter the perfect name");
			flag=false;
		}
		else if(email.length<0){
			alert("Enter valid emailId");
			flag=false;
		}
		else if(phonenum.length!=10){
			alert("Enter valid Mobile Number");
			flag=false;
		}

	}
	else{
		alert("enter the details");
		flag=false;
	}
    if(flag==true){
        ajaxupdatecalling();

    }

}
function ajaxupdatecalling(){
    var name = document.getElementById("username").value;
    var email = document.getElementById("emailId").value;
    var phonenum = document.getElementById("mobilenum").value;
    var empdata={};
    empdata.uname=name;
    empdata.email=email;
    empdata.phonenum=phonenum;
    var posturl="/updateemployeedet/";
    $.ajax({
        url:posturl,
        type:"POST",
        data: empdata,
        traditional: true,
        dataType: 'html',
        success: function(){
            alert('success');
            window.location.assign('/viewemployee/');
        },
        error: function(){
          alert('failure');
        }
    });
}

function deleterecord(itemid){
    var rowid=itemid.id;
    var posturl="/deleteemployee/" + rowid;
    $.ajax({
        url:posturl,
        type:'DELETE',
        success:function(){
            alert("record deleted");
            window.location.assign("/viewemployee/");
        }

    });
}


