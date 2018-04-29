layui.use(['form', 'layer'], function() {
		$ = layui.jquery;
		var form = layui.form(),
		layer = layui.layer;

		//监听提交
        form.on('submit(mod)', function(data) {
            console.log(data);
            
            var user = {
            		"patientId": ""+$("#patientId").val(),
                    "userId": ""+$("#userId").val(),
                    "patientName": ""+$("#patientName").val(),
                    "patientSex": ""+$("#patientSex").val(),
                    "patientBorn": ""+$("#patientBorn").val(),
                    "patientNation": ""+$("#patientNation").val(),
                    "bloodtype": ""+$("#bloodtype").val(),
                    "patientOccupation": ""+$("#patientOccupation").val(),
                    "patientMarriage": ""+$("#patientMarriage").val(),
                    "patientIcon": ""+$("#patientIcon").val()
             }
             $.ajax({
                   type: "post",
                   contentType: "application/json;charset=UTF-8",
                   url: "http://localhost:8080/sys/updatePatient",
                   data: JSON.stringify(user),
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
        if(iframeOpt.method == 'seem'){
            var data = iframeOpt.data;
            console.log(data);
            debugger;
            $("#patientId").val(data.patientId);
            $("#userId").val(data.userId);
            $("#patientName").val(data.patientName);
            $("#patientSex").val(data.patientSex);
            $("#patientBorn").val(data.patientBorn);
            $("#patientNation").val(data.patientNation);
            $("#bloodtype").val(data.bloodtype);
            $("#patientOccupation").val(data.patientOccupation);
            $("#patientMarriage").val(data.patientMarriage);
            $("#patientIcon").val(data.patientIcon)
            form.render(); //更新全部
            form.render('select'); //刷新select选择框渲染

            
        }
});