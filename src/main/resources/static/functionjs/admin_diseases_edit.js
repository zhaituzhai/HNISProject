//填充科室/类型
function append_disease(){
    $.ajax({
        async: false,
        type: "post",
        contentType: "application/json;charset=UTF-8",
        url: "http://localhost:8080/dise/getDeptList",
        success:function(result){
            if(result.success){
                $.each(result.value,function(){
                    var optionEle = $("<option></option>").append(this).attr("value",this);
                    optionEle.appendTo("#department");
                });
            }
        }
    });
    $.ajax({
        async: false,
        type: "post",
        contentType: "application/json;charset=UTF-8",
        url: "http://localhost:8080/dise/getTypeList",
        success:function(result){
            if(result.success){
                $.each(result.value,function(){
                    var optionEle = $("<option></option>").append(this).attr("value",this);
                    optionEle.appendTo("#diseaseType");
                });
            }
        }
    });
}
    
layui.use(['form', 'layer'], function() {
	$ = layui.jquery;
	var form = layui.form(),
	layer = layui.layer;
	
	//新增按钮
	form.on('submit(add)', function(data) {
        console.log(data);
        
        var disease = {
        		"diseaseId": ""+$("#diseaseId").val(),
        		"department": ""+$("#department").val(),
                "diseaseType": ""+$("#diseaseType").val(),
                "diseaseName": ""+$("#diseaseName").val(),
                "deseaseDescription": ""+$("#deseaseDescription").val(),
                "deseaseManifestation": ""+$("#deseaseManifestation").val(),
                "therapeuticMethod": ""+$("#therapeuticMethod").val(),
                "therapeuticMark": ""+$("#therapeuticMark").val(),
                "entryPerson": ""+$("#entryPerson").val()
         }
         $.ajax({
               type: "post",
               contentType: "application/json;charset=UTF-8",
               url: "http://localhost:8080/dise/creatDisease",
               data: JSON.stringify(disease),
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

      //监听提交
    form.on('submit(mod)', function(data) {
        console.log(data);
        
        var disease = {
        		"diseaseId": ""+$("#diseaseId").val(),
        		"department": ""+$("#department").val(),
                "diseaseType": ""+$("#diseaseType").val(),
                "diseaseName": ""+$("#diseaseName").val(),
                "deseaseDescription": ""+$("#deseaseDescription").val(),
                "deseaseManifestation": ""+$("#deseaseManifestation").val(),
                "therapeuticMethod": ""+$("#therapeuticMethod").val(),
                "therapeuticMark": ""+$("#therapeuticMark").val(),
                "entryPerson": ""+$("#entryPerson").val()
         }
         $.ajax({
               type: "post",
               contentType: "application/json;charset=UTF-8",
               url: "http://localhost:8080/dise/updateDisease",
               data: JSON.stringify(disease),
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
    //查看详情/并修改
    if(iframeOpt.method == 'seem'){
    	//append_disease();
    	$("#seem").css('display','inline-block');
        var data = iframeOpt.data;
        console.log(data);
        debugger;
        $("#diseaseId").val(data.diseaseId);
        $("#department").val(data.department);
        $("#diseaseType").val(data.diseaseType);
        $("#diseaseName").val(data.diseaseName);
        $("#deseaseDescription").val(data.deseaseDescription);
        $("#deseaseManifestation").val(data.deseaseManifestation);
        $("#therapeuticMethod").val(data.therapeuticMethod);
        $("#therapeuticMark").val(data.therapeuticMark);
        $("#entryTime").val(data.entryTime);
        $("#entryPerson").val(data.entryPerson);
        
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染

        
    }
    //新增病例库
    if(iframeOpt.method == 'save'){
    	//append_disease();
    	$("#save").css('display','inline-block');
    	form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染
    }
        
});