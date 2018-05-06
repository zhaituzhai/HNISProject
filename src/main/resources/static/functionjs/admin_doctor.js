layui.use(['form', 'layer'], function() {
		$ = layui.jquery;
		var form = layui.form(),
		layer = layui.layer;

	
	      //监听提交
        form.on('submit(mod)', function(data) {
            console.log(data);
            
            var doctor = {
            		"doctorId": ""+$("#doctorId").val(),
            		"userId": ""+$("#userId").val(),
                    "doctorName": ""+$("#doctorName").val(),
                    "doctorSex": ""+$("#doctorSex").val(),
                    "departementId": ""+$("#departementId").val(),
                    "doctorTitle": ""+$("#doctorTitle").val(),
                    "doctorHospital": ""+$("#doctorHospital").val(),
                    "doctorIcon": ""+$("#doctorIcon").val()
             }
             $.ajax({
                   type: "post",
                   contentType: "application/json;charset=UTF-8",
                   url: "http://localhost:8080/sys/updateDoctor",
                   data: JSON.stringify(doctor),
                   success:function(result){
                      if(result.success){
                       }else{
                          alert(result.message);
                       }
                   }
             });
            
            layer.alert("提交成功", {
                icon: 6
            }, function() {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
                
                window.parent.to_page(parent.currentPage);//访问父页面方法 
            });
            return false;
        });
        
        form.on('submit(cal)', function() {
             // 获得frame索引
             var index = parent.layer.getFrameIndex(window.name);
             //关闭当前frame
             parent.layer.close(index);
        });
        
        var iframeOpt = parent.iframeOpt;
        if(iframeOpt != null){
	        if(iframeOpt.method == 'seem'){
	            var data = iframeOpt.data;
	            console.log(data);
	            debugger;
	            $("#doctorId").val(data.doctorId);
	            $("#userId").val(data.userId);
	            $("#doctorName").val(data.doctorName);
	            $("#doctorSex").val(data.doctorSex);
	            $("#departementId").val(data.departementId);
	            $("#doctorTitle").val(data.doctorTitle);
	            $("#doctorHospital").val(data.doctorHospital);
	            $("#doctorIcon").val(data.doctorIcon);
	            form.render(); //更新全部
	            form.render('select'); //刷新select选择框渲染
	
	            
	        }
        }

});