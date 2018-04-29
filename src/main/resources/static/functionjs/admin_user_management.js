var totalRecord,currentPage,queryUser;
var num = 1;
//1、页面初次加载      
$(function(){
	to_page(1);
});
  
function selectByChoose(){
	to_page(1);
}
  //查看详情
$(document).on("click",".seem_btn",function(){
	//拿到修改的id
	var userId = {
		"userId": parseInt($(this).attr("seem-id"))
	}
	  //请求后台 拿到相相关信息
	$.ajax({
		async: false,
		type: "post",
		contentType: "application/json;charset=UTF-8",
		url:"http://localhost:8080/sys/getUser/"+parseInt($(this).attr("seem-id")),
		data: JSON.stringify(userId),
		success:function(result){
			if(result.success){
	        //医生
	        	if(result.value.userType == 2 && (result.value.doctor != null || result.value.patient != null)){
	        		window.iframeOpt = {
	                	method: 'seem',
	                	data: result.value.doctor
	            	}
	        		x_admin_show('修改医生用户','http://localhost:8080/admin_doctor_edit','600','650');
	        		  
	        	}else if(result.value.userType == 3 && (result.value.doctor != null || result.value.patient != null)){
	        		window.iframeOpt = {
	                	method: 'seem',
	                	data: result.value.patient
	        		}
	        		x_admin_show('修改病人用户','http://localhost:8080/admin_patient_edit','600','650');
	        	}else{
	        		layer.msg('此用户未绑定信息或您无权查看！',{time:500});
	        	}
			}else{
				layer.msg(result.message);
			}
		} 
	});
});
  
//点击修改
$(document).on("click",".edit_btn",function(){
	//拿到修改的id
	var userId = {
			"userId": parseInt($(this).attr("modify-id"))
	}
	//请求后台 拿到相相关信息
	$.ajax({
		async: false,
		type: "post",
		contentType: "application/json;charset=UTF-8",
		url:"http://localhost:8080/sys/getUser/"+parseInt($(this).attr("modify-id")),
		data: JSON.stringify(userId),
		success:function(result){
			if(result.success){
				window.iframeOpt = {
						method: 'save',
						data: result.value
				}
				x_admin_show('修改用户','http://localhost:8080/admin_user_edit','600','500');
			}else{
				layer.msg(result.message,{time:500});
			}
		} 
	});
});
  
//禁用
$(document).on("click",".delete_btn",function(){
	var user;
	//1、弹出确认删除
	var empName = $(this).parents("tr").find("td:eq(1)").text();
	var empId = $(this).attr("delete-id");
	var type = $(this).parents("tr").find("td:eq(5)").text();
	if(type == '开启'){
		user = {"userId": ""+empId,"accountType": "2"};
		op = "禁用";
	}else{
		user = {"userId": ""+empId,"accountType": "1"};
		op = "开启";
	}
	if(confirm("确认"+op+"【"+empName+"】吗？")){
		$.ajax({
			async: false,
			type: "post",
			contentType: "application/json;charset=UTF-8",
			url:"http://localhost:8080/sys/updateUser",
			data: JSON.stringify(user),
			success:function(result){
                to_page(currentPage);
            } 
        });
    }
});

//查询第几页的信息（页面 与 条件）
function to_page(num){
	var pageUser = {
			"pageNum":""+num,
			"pageSize":"10",
			"param": {
				"userName": ""+$("#username").val(),
				"userPhone": ""+$("#userphone").val(),
				"userType": ""+$("#usertype").val(),
				"accountType": ""+$("#status").val()
			}
	}
	$.ajax({
		async: false,
		type: "post",
		contentType: "application/json;charset=UTF-8",
		url: "http://localhost:8080/sys/getUserList",
		data: JSON.stringify(pageUser),
		success:function(result){
			creat_user_table(result);
			build_page_info(result);
			build_page_nav(result);
		}
	});
}

//创建表格
function creat_user_table(result){
	$("#user_table").empty();
	var users = result.value.list;
	$.each(users, function(index, item) {
		//var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
		var userIdTd = $("<td></td>").append(item.userId);
		var userNameTd = $("<td></td>").append(item.userName);
		var userPhoneTd = $("<td></td>").append(item.userPhone);
		var passwordTd = $("<td></td>").append("******");
		var userTypeTd = $("<td></td>").append(item.userType);
		var accountType,delBtn;
		if(item.accountType == "1"){
			accountType = $("<td></td>").append("开启");
			delBtn = $("<a></a>").addClass("btn btn-warning btn-sm delete_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-ban-circle")).append("关闭");
		}else{
			accountType = $("<td></td>").addClass("bg-danger").append("关闭");
			delBtn = $("<a></a>").addClass("btn btn-success btn-sm delete_btn").append(
					$("<span></span>").addClass("glyphicon glyphicon-ok-circle")).append("开启");
		}
		var creatTime = $("<td></td>").append(item.creatTime);
		var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append(
				$("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
		var moreInfoBtn = $("<button></button>").addClass("btn btn-success btn-sm seem_btn").append(
				$("<span></span>").addClass("glyphicon glyphicon-eye-open")).append("查看详情");
		moreInfoBtn.attr("seem-id",item.userId);
		editBtn.attr("modify-id",item.userId);
		delBtn.attr("delete-id",item.userId);
		var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ").append(moreInfoBtn);
		//append方法执行完成以后还是会返回原来的元素
		$("<tr></tr>").append(userIdTd).append(userNameTd).append(userPhoneTd).append(passwordTd).append(userTypeTd)
			.append(accountType).append(creatTime).append(btnTd).appendTo("#user_table");
	});
}
  
//分页信息
function build_page_info(result) {
	$("#page_info_area").empty();
	$("#page_info_area").append("当前" + result.value.pageNum + "页，总共"
			+ result.value.pages + "页,总共"+ result.value.total + "条");
	totalRecord = result.value.total;
	currentPage = result.value.pageNum;
}

//分页条，添加链接
function build_page_nav(result) {
	$("#page_nav_area").empty();
	//page_nav_area
	var ul = $("<ul></ul>").addClass("pagination");
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
	if (!result.value.hasPreviousPage) {
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled")
	} else {
		firstPageLi.click(function() {
			to_page(1);
		});
		prePageLi.click(function() {
			to_page(result.value.pageNum - 1);
	});

	}
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
	if (!result.value.hasNextPage) {
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled")
	} else {
		nextPageLi.click(function() {
			to_page(result.value.pageNum + 1);
		});
		lastPageLi.click(function() {
			to_page(result.value.pages);
		});
	}
	ul.append(firstPageLi).append(prePageLi);
	
	$.each(result.value.navigatepageNums, function(index,item) {
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if (result.value.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			to_page(item);
		});
		ul.append(numLi);
	});
	ul.append(nextPageLi).append(lastPageLi);
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#page_nav_area");
}

//layui js
layui.use(['laydate','element','laypage','layer','form'], function(){
	$ = layui.jquery;//jquery
	laydate = layui.laydate;//日期插件
	lement = layui.element();//面包导航
	laypage = layui.laypage;//分页
	layer = layui.layer;//弹出层
	parent.layer = layui.layer; // 
	form = layui.form();

	//以上模块根据需要引入
	var start = {
			min: laydate.now()
			,max: '2099-06-16 23:59:59'
			,istoday: false
			,choose: function(datas){
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
		}
	};
  
	var end = {
			min: laydate.now()
			,max: '2099-06-16 23:59:59'
			,istoday: false
			,choose: function(datas){
				start.max = datas; //结束日选好后，重置开始日的最大日期
			}
	};
});

//批量删除提交
function delAll () {
	layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        layer.msg('删除成功', {icon: 1});
    });
 }
 /*用户-添加*/
function user_management_add(title,url,w,h){
	window.iframeOpt = {
		method: 'add'
	};
    x_admin_show(title,url,w,h);
}
/*用户-查看*/
function user_management_show(title,url,id,w,h){
    x_admin_show(title,url,w,h);
}

 /*用户-停用*/
function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){
        //发异步把用户状态进行更改
        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
        $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
        $(obj).remove();
        layer.msg('已停用!',{icon: 5,time:1000});
    });
}

/*用户-启用*/
function member_start(obj,id){
    layer.confirm('确认要启用吗？',function(index){
        //发异步把用户状态进行更改
        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
        $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
        $(obj).remove();
        layer.msg('已启用!',{icon: 6,time:1000});
    });
}
// 用户-编辑
function user_management_edit (title,url,id,w,h) {
    x_admin_show(title,url,w,h); 
}
/*密码-修改*/
function user_management_password(title,url,id,w,h){
    x_admin_show(title,url,w,h);  
}
/*用户-删除*/
function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        //发异步删除数据
        $(obj).parents("tr").remove();
        layer.msg('已删除!',{icon:1,time:1000});
    });
}