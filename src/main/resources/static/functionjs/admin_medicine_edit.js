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
		price: [/^[0-9]+(.[0-9]{2})?$/, '只能是小数点后两位'],
		
	});
	//添加药品
	form.on('submit(add)', function(data) {
	    console.log(data);
	    
	    var medicine = {
	    		"medicineId": ""+$("#medicineId").val(),
	    		"medicineName": ""+$("#medicineName").val(),
	            "mainComponents": ""+$("#mainComponents").val(),
	            "userRange": ""+$("#userRange").val(),
	            "userWay": ""+$("#userWay").val(),
	            "userAttention": ""+$("#userAttention").val(),
	            "saveWay": ""+$("#saveWay").val(),
	            "specifications": ""+$("#specifications").val(),
	            "price": ""+$("#price").val()
	     }
	     $.ajax({
	           type: "post",
	           contentType: "application/json;charset=UTF-8",
	           url: "http://localhost:8080/medi/creatMedicine",
	           data: JSON.stringify(medicine),
	           success:function(result){
	              if(result.success){
	               }else{
	                  alert(result.message);
	               }
	           }
	     });
	});
	//监听提交 修改药品
	form.on('submit(mod)', function(data) {
	    console.log(data);
	    
	    var medicine = {
	    		"medicineId": ""+$("#medicineId").val(),
	    		"medicineName": ""+$("#medicineName").val(),
	            "mainComponents": ""+$("#mainComponents").val(),
	            "userRange": ""+$("#userRange").val(),
	            "userWay": ""+$("#userWay").val(),
	            "userAttention": ""+$("#userAttention").val(),
	            "saveWay": ""+$("#saveWay").val(),
	            "specifications": ""+$("#specifications").val(),
	            "price": ""+$("#price").val()
	     }
	     $.ajax({
	           type: "post",
	           contentType: "application/json;charset=UTF-8",
	           url: "http://localhost:8080/medi/updateMedicine",
	           data: JSON.stringify(medicine),
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
		$("#modify").css('display','inline-block');
	    var data = iframeOpt.data;
	    console.log(data);
	    debugger;
	    $("#medicineId").val(data.medicineId),
	    $("#medicineName").val(data.medicineName),
	    $("#mainComponents").val(data.mainComponents),
	    $("#userRange").val(data.userRange),
	    $("#userWay").val(data.userWay),
	    $("#userAttention").val(data.userAttention),
	    $("#saveWay").val(data.saveWay),
	    $("#specifications").val(data.specifications),
	    $("#price").val(data.price)
	    
	    form.render(); //更新全部
	    form.render('select'); //刷新select选择框渲染
	
	}
	if(iframeOpt.method == 'save'){
		$("#save").css('display','inline-block');
	}

});