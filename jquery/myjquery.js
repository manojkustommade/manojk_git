    var rowCount=0;
$(document).ready(function () {

    $("#submitbtn").click(function(){
            
            var uname = $("#uname").val();
            var email = $("#email").val();
            var password = $("#password").val();
            var confirmpassword =$("#confirm_password").val();
            var phonenum =$("#MobileNo").val();
            var flag=1;
            var tx=$("#temp").val();
        if(uname && email &&password && confirmpassword && phonenum){
        
                if(uname.length<3){
                    alert("enter valid username");
                    flag=0;
                } 
                else if(email.indexOf("@")<0 || email.indexOf(".")<0  || email.indexOf("@")>email.lastIndexOf(".")){
                    alert("Incorrect email");
                    flag=0;
                }
                
                else if(confirmpassword != password) {
                    alert("password didn't match");
                    flag=0;
                } 
                else if(phonenum.length!=10){
                    alert("enter valid mobile number");
                    flag=0;
                }
                 
                if(flag==1){
                    
                    if(tx=="-1"){
                        rowCount=rowCount+1;
                        var addrow="<tr id='"+rowCount+"'><td>"+uname+"</td><td>"+email+"</td><td>"+phonenum+"</td><td><button id='"+rowCount+"' onclick='deleteRow(this)'>Delete</button></td><td><button id='"+rowCount+"' onclick='updateRow(this)'>Update</button></td>";
                        $("#display").append(addrow);
                    
                        $("#uname").val('');
                        $("#email").val('');
                        $("#password").val('');
                        $("#confirm_password").val('');
                        $("#MobileNo").val('');
                        alert("Your successfully signed up");
                    }
                    else{

                        $("#display tr#"+tx+" td:eq(0)").text(uname);
                        $("#display tr#"+tx+" td:eq(1)").text(email);
                       
                        $("#display tr#"+tx+" td:eq(2)").text(phonenum);
                        $("#uname").val('');
                        $("#email").val('');
                        $("#password").val('');
                        $("#confirm_password").val('');
                        $("#MobileNo").val('');
                        $("#display tr#"+tx).css("background-color","green");
                        $("#temp").val('-1');

                    }    
                }
                
        } 
        else{
            alert("Enter the details");
        }       
            
    });
 
});
function deleteRow($this){
    var dt=$this.id;
    var data=$this.closest("tr").remove();
    alert(dt)
}
function updateRow($this){
    var dt=$this.id;
    $("#uname").val($("#display tr#"+dt+" td:eq(0)").text());
    $("#email").val($("#display tr#"+dt+" td:eq(1)").text());
    
    $("#MobileNo").val($("#display tr#"+dt+" td:eq(2)").text());
    $("#temp").val(dt);
}    
function validate(evt){

     var key = evt.keyCode;
     key = String.fromCharCode(key);

     if(isNaN(key))
        evt.returnValue=false;
}

