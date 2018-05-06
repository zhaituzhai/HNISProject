        layui.use(['form', 'layer'], function() {
            $ = layui.jquery;
            var form = layui.form(),
            layer = layui.layer;

        
              //监听提交
            form.on('submit(mod)', function(data) {
                console.log(data);
                
                var doctor = {
                        "doctorName": ""+$("#doctorName").val(),
                        "doctorSex": ""+$("#doctorSex").val(),
                        "departementId": ""+$("#departementId").val(),
                        "doctorTitle": ""+$("#doctorTitle").val(),
                        "doctorHospital": ""+$("#doctorHospital").val()
                 }
                debugger;
                 $.ajax({
                       type: "post",
                       contentType: "application/json;charset=UTF-8",
                       url: "http://localhost:8080/sys/inserDoctor",
                       data: JSON.stringify(doctor),
                       success:function(result){
                          if(result.success){
                        	  layer.msg('完善信息成功！请重新登陆系统！',{time:500});
                        	  window.location.href = "http://localhost:8080/login";
                           }else{
                              alert(result.message);
                           }
                       }
                 });
            });
    });