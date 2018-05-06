$(function (){
	getLogUser();
});
//得到登陆人的信息 并写入信息中
function getLogUser(){
	$.ajax({
        async: false,
        type: "get",
        contentType: "application/json;charset=UTF-8",
        url: "http://localhost:8080/sys/getLoginUser",
        success:function(result){
            //alert(result.success);
            if(result.success){
                debugger;
                /*if(result.value.doctor == null){
                	window.iframeOpt = {
    	                    method : 'new',
    	                    data : result.value
    	                }
                	x_admin_show('完善信息','http://localhost:8080/doctor_add','700','780');
                }else{
                }*/
                $("#loginName").text(result.value.userName);
            }else{
            	window.location.href = "http://localhost:8080/login";
            }
        }
        
    });
}