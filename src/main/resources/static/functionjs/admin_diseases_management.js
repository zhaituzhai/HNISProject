var totalRecord,currentPage,queryUser;
var num = 1;
//1、页面初次加载      
$(function(){
	append_disease();
	to_page(1);
});
  
function selectByChoose(){
	to_page(1);
}
  
//查看修改疾病库
$(document).on("click",".edit_btn",function (){
	$.ajax({
		async: false,
		type: "post",
        contentType: "application/json;charset=UTF-8",
        url:"http://localhost:8080/dise/getDisease/"+parseInt($(this).attr("modify-id")),
        success:function(result){
        	if(result.success){
            	window.iframeOpt = {
                        method: 'seem',
                        data: result.value
                }
            	x_admin_show('修改疾病信息','http://localhost:8080/admin_diseases_edit','700','780');
	        }else{
	            layer.msg(result.message);
	        }
        } 
	});
});
  
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
  
//禁用
$(document).on("click",".delete_btn",function(){
	var user;
	//1、弹出确认删除
    var empName = $(this).parents("tr").find("td:eq(1)").text();
    var empId = $(this).attr("delete-id");
    var type = $(this).parents("tr").find("td:eq(5)").text();
    //alert($(this).parents("tr").find("td:eq(1)").text());
    if(type == '开启'){
    	user = {"userId": ""+empId,"accountType": "0"};
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
            url:"http://localhost:8080/sys/update",
            data: JSON.stringify(user),
            success:function(result){
                //alert(result.message);
            	to_page(currentPage);
            } 
    	});
	}
});

//查询第几页的信息（页面 与 条件）
function to_page(num){
	var diseaseType,department;
	diseaseType = $("#diseaseType").val()==0 ? diseaseType='' : $("#diseaseType").val();
	department = $("#department").val()==0 ? department='' :$("#department").val();
	var pageDise = {
			"pageNum":""+num,
			"pageSize":"5",
			"param": {
				"diseaseName": ""+$("#diseaseName").val(),
				"diseaseType": ""+diseaseType,
				"department": ""+department
			}
	}
	//async: false,
	$.ajax({
		async: false,
		type: "post",
		contentType: "application/json;charset=UTF-8",
		url: "http://localhost:8080/dise/getDiseList",
		data: JSON.stringify(pageDise),
		success:function(result){
			creat_user_table(result);
			build_page_info(result);
			build_page_nav(result);
		}
	});
}


function creat_user_table(result){
	$("#disease_table").empty();
	var users = result.value.list;
	$.each(users, function(index, item) {
	//var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
	var diseaseIdTd = $("<td></td>").append(item.diseaseId);
	var departmentTd = $("<td></td>").append(item.department);
	var diseaseTypeTd = $("<td></td>").append(item.diseaseType);
	var diseaseNameTd = $("<td></td>").append(item.diseaseName);
	var deseaseDescriptionTd = $("<td></td>").append(item.deseaseDescription);
	var deseaseManifestationTd = $("<td></td>").append(item.deseaseManifestation);
	var therapeuticMethodTd = $("<td></td>").append(item.therapeuticMethod);
	var therapeuticMarkTd = $("<td></td>").append(item.therapeuticMark);
	var entryTimeTd = $("<td></td>").append(item.entryTime);
	var creatTime = $("<td></td>").append(item.creatTime);
	var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append(
			$("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
	var delBtn = $("<a></a>").addClass("btn btn-danger btn-sm delete_btn").append(
			$("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
	editBtn.attr("modify-id",item.diseaseId);
	delBtn.attr("delete-id",item.diseaseId);
	var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
	//append方法执行完成以后还是会返回原来的元素
	$("<tr></tr>").append(diseaseIdTd).append(departmentTd).append(diseaseTypeTd).append(diseaseNameTd).append(deseaseDescriptionTd)
		.append(deseaseManifestationTd).append(therapeuticMethodTd).append(therapeuticMarkTd).append(entryTimeTd)
		.append(btnTd).appendTo("#disease_table");
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

layui.use(['laydate','element','laypage','layer','form'], function(){
    $ = layui.jquery;//jquery
	laydate = layui.laydate;//日期插件
	lement = layui.element();//面包导航
	laypage = layui.laypage;//分页
	layer = layui.layer;//弹出层
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
            method: 'save'
        }
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