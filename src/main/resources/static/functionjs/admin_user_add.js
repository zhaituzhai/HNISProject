layui.use(['form', 'layer'], function() {
	$ = layui.jquery;
	var form = layui.form(),
	layer = layui.layer;

	//自定义验证规则
	form.verify({
		nikename: function(value) {
			if(value.length < 2) {
				return '昵称至少得2个字符啊';
			}
		},
		phone: [/[0-9]{11}$/, '电话是11位哦'],
		pass: [/(.+){2,12}$/, '密码必须2到12位'],
		repass: function(value) {
			if($('#password').val() != $('#repassword').val()) {
				return '两次密码不一致';
			}
		}
	});

	// 添加BEGIN
	//监听提交
	form.on('submit(add)', function(data) {
		console.log(data);
		//发异步，把数据提交给php
		var user = {
				"userName": ""+$("#userName").val(),
				"userPhone": ""+$("#userPhone").val(),
				"password": ""+$("#password").val(),
				"userType": ""+$("#usertype").val()
		}
		$.ajax({
			type: "post",
			contentType: "application/json;charset=UTF-8",
			url: "http://localhost:8080/sys/creatUser",
			data: JSON.stringify(user),
			success:function(result){
				if(result.success){
				}else{
					alert(result.message);
				}
			}
		});
		layer.alert("增加成功", {
			icon: 6
		}, function() {
			//刷新页面
			window.parent.location.reload();
			// 获得frame索引
			var index = parent.layer.getFrameIndex(window.name);
			//关闭当前frame
			parent.layer.close(index);
		});
		return false;
	});
	// 添加END


	// 保存BEGIN	
	}
	// 保存END
});
//验证重名   
$("#userName").change(function(){
	   $("#nameverify").text("*");
	   var name = {
			   "userName": ""+$("#userName").val()
	   }
	   $.ajax({
       type: "post",
       contentType: "application/json;charset=UTF-8",
       url: "http://localhost:8080/sys/verfiy",
       data: JSON.stringify(name),
       success:function(result){
           if(result.success){
               $("#nameverify").text("存在");
           }else{
               $("#nameverify").text("可用");
           }
       }
    });
});
$("#userPhone").change(function(){
    $("#phoneverify").text("*");
    var name = {
            "userPhone": ""+$("#userPhone").val()
    }
    $.ajax({
       type: "post",
       contentType: "application/json;charset=UTF-8",
       url: "http://localhost:8080/sys/verfiy",
       data: JSON.stringify(name),
       success:function(result){
           if(result.success){
               $("#phoneverify").text("存在");
           }else{
               $("#phoneverify").text("可用");
           }
       }
    });
});