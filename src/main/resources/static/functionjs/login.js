function login(){
		    	var userName = $("#logname").val();
		    	var password = $("#logpass").val();
		    	//alert(userName + password);
		    	var logUser = {
		    			"userName":userName,
		    			"password":password
		    	}
		    	//alert(logUser.username + logUser.password);
		    	$.ajax({
		    		async: false,
		    		type: "post",
		    		contentType: "application/json;charset=UTF-8",
		    		url: "http://localhost:8080/sys/login",
		    		data: JSON.stringify(logUser),
		    		success:function(result){
		    			//alert(result.success);
		    			if(result.success){
		    				debugger;
		    				if(result.value.userType == "1"){
			    				window.location.href = "http://localhost:8080/index";
		    				}else if(result.value.userType == "2"){
		    					if(null == result.value.doctor){
		    						//x_admin_show('修改疾病信息','http://localhost:8080/doctor_add','700','780');
		    						window.location.href = "http://localhost:8080/doctor_add";
		    					}else{
		    						window.location.href = "http://localhost:8080/doctor_index";
		    					}
		    					
		    				}
		    			}else{
		    				$('.alert').html(result.message).addClass('alert-info').show().delay(1500).fadeOut();
		    			}
		    		}
		    		
		    	});
		    }
		    
		    var info_prompt = function(message, time)
		    {
		        prompt(message, 'alert-info', time);
		    };
		    
		    var prompt = function (message, style, time)
		    {
		        style = (style === undefined) ? 'alert-success' : style;
		        time = (time === undefined) ? 1200 : time;
		        $('<div>').appendTo('body').addClass('alert ' + style).html(message).show().delay(time).fadeOut();
		    };