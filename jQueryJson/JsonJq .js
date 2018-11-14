var jsonArr=[];

window.onload = getStoredData();

function getStoredData(){
    var storeddata = localStorage.getItem("storedData");
    if (storeddata !== null) {
        jsonArr=JSON.parse(storeddata);

    }
}

$("#submitdata").submit(function(eve){
	eve.preventDefault();
	var jsonObj={};
	var form = $("#submitdata")[0]; 
    var formdata=new FormData(form);

    var name=formdata.get("uname");
    var email=formdata.get("email");
    var phonenum=formdata.get("mobilenum");
   if(checkDetails(name,email,phonenum)){
            if(!helperfunction(jsonArr,email,"adddata")){ 	
                	jsonObj.uname=name;
                	jsonObj.email=email;
                	jsonObj.mobilenum=phonenum;
                	console.log(jsonObj);
                	jsonArr.push(jsonObj);
                	localStorage.setItem("storedData",JSON.stringify(jsonArr));
                    document.getElementById("submitdata").reset();
                	alert("Data Inserted Successfully");
                   
                	
            }
            else{
                alert("Data Already Exist");
            }

		   
	}
	else{
		alert("Please enter the details");
	}

	return false;
});

function createtable(jsonArr){

	var text="<table border=1 id='mytable' align='center'><tr>";
	var rowcount=0;
	for (var index in jsonArr[0]) {
            text=text+"<th>"+index+"</th>";
    }
        text=text+"<th colspan=2>Action</th></tr>";
        jsonArr.forEach(function(arrayitem){
            rowcount +=1;
            text=text+"<tr id='"+rowcount+"'>";
            $.each( arrayitem, function( key, value ) {
               text=text+"<td>"+value+"</td>";
        });
        text=text+"<td><a onclick='deletedata(this);' id='"+rowcount+"'>delete</a></td><td><a onclick='setdata(this); return false;' data-reveal-id='myModal' "+
        "id='"+rowcount+"'>update</a></td></tr>";
        });
        text=text+"</table>";
        return text;
}

$("#viewbtn").click(function(){
	getStoredData();
	var text;
    console.log(jsonArr);
	if(jsonArr.length>0){
		text=createtable(jsonArr);
		$(showdata).html(text);
	}
	else{
        $(showdata).html('<center style="color:red">No Records Found</center>');
        $(viewbtn).trigger('click');    
		
	}

});

$("#searchbtn").click(function(){
    getStoredData();
    var data=$("#searchtxt").val();
    var tempdata=[];
     var flag=0;
     var text;
    for(i=0;i<jsonArr.length;i++){
            if(jsonArr[i].uname==data || jsonArr[i].email==data || jsonArr[i].mobilenum==data)
                {
                    tempdata.push(jsonArr[i]);
                    flag=1;
                }
        }
        if(flag==0)
            alert("nothing found");
        else{
            text=createtable(tempdata);
            $("#searchcnt").html(text);
        }
});

function setdata($this){
        $('#updateform').show();
        var data = $this.id;
        $('#temp').val(data);
        $('#username').val($("#mytable tr#"+data+" td:eq(0)").text());
        $('#emailid').val($("#mytable tr#"+data+" td:eq(1)").text());
        $('#phno').val($("#mytable tr#"+data+" td:eq(2)").text());

}

$("#updateform").submit(function(){

    getStoredData();
    var form = $("#updateform")[0]; 
    var formdata=new FormData(form);

    var name=formdata.get("name");
    var email=formdata.get("emailID");
    var phonenum=formdata.get("phonenum");
    var temp=$("#temp").val();
    if(checkDetails(name,email,phonenum)){
            if(!helperfunction(jsonArr,email,"update")){ 
            
                jsonArr[temp-1].uname=name;
                jsonArr[temp-1].email=email;
                jsonArr[temp-1].mobilenum=phonenum;
                console.log(JSON.stringify(jsonArr));
                localStorage.setItem("storedData",JSON.stringify(jsonArr));
                alert("Data updated Successfully");
                document.getElementById("updateform").reset();
                $("#updateform").hide();
                alert("Please view the data");
            }
            else{
                alert("Data Already Exist");
            }

        
    }
    

    return false;
});

function deletedata($this){
     getStoredData();
     var data=$this.id;
     data-=1;
     jsonArr.splice(data,1);
     console.log(JSON.stringify(jsonArr));
     localStorage.setItem("storedData",JSON.stringify(jsonArr));
     $('#viewbtn').trigger('click');
}

$(document).ready(function(){

    $("#searchtxt").keyup(function(){
        var data=$("#searchtxt").val();
        
        $('jsonArr:contains("'+data+'")').show();
    });
});