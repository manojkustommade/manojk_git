function helperfunction(jsonArr,email,val){
	var dataExist=false;
	getStoredData();
	if(val=="adddata"){
		
	     jsonArr.forEach(function(arrayitem){
	        $.each( arrayitem, function( key, value ) {
					if( value==email){
	                    dataExist=true;
	                }
	        });
	     });
	}
	else{
		var count=1;
		var temp=$("#temp").val();

        jsonArr.forEach(function(arrayitem){
            if(count!=temp){

                $.each( arrayitem, function( key, value ) {

                    if( key=="email" && value==email){
                        dataExist=true;
                    }

                });
            }
               count+=1; 
        });
	} 
	return dataExist;    
}