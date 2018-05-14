	   layui.use(['form', 'layer'], function() {
	        $ = layui.jquery;
	        var form = layui.form(),
	        layer = layui.layer;
	        form.verify({
	        	requcheck: function(value) {
	                if(value.length < 1) {
	                    return '必填项必填啊！';
	                }
	            },
	            price: [/^(?!0+(?:\.0+)?$)(?:[1-9]\d*|0)(?:\.\d{1,2})?$/, '最多只能是小数点后两位'],
	            num: [/[^\d]/g, '只能是数字'],
	        });

	        var iframeOpt = parent.iframeOpt;
	        if(iframeOpt != null){
		    	if(iframeOpt.method == 'seem'){
		    		$("#modify").css('display','none');
		    		$("#seem").css('display','inline-block');
		    	    var data = iframeOpt.data;
		    	    console.log(data);
		    	    debugger;
		    	    $("#caseId").val(data.caseId);
		    	    $("#patientName").val(data.patientName);
		    	    $("#patientSex").val(data.patientSex == "M" ? "男" : "女");
		    	    $("#patientAge").val(data.patientAge);
		    	    $("#illnessTime").val(data.illnessTime);
		    	    $("#illnessDesc").val(data.illnessDesc);
		    	    fillMedicine(data.detailList);
		    	    $("#doctorName").val(data.doctorName);
		    	    $("#cureCycle").val(data.cureCycle);
		    	    $("#cureTime").val(data.cureTime);
		    	    
		    	    form.render(); //更新全部
		    	    form.render('select'); //刷新select选择框渲染
		    	
		    	}
	        }
	    	
	    	form.on('submit(cal)', function() {
    	         // 获得frame索引
    	         var index = parent.layer.getFrameIndex(window.name);
    	         //关闭当前frame
    	         parent.layer.close(index);
    	    });
	    		
	    	    
	    	form.on('submit(print)', function() {
	   	         // 获得frame索引
	   	         var index = parent.layer.getFrameIndex(window.name);
	   	         //关闭当前frame
	   	         parent.layer.close(index);
	   	    });
	        
		   form.on('submit(add)', function() {
			   /*var caseInfo = getInfo();
	           console.log(caseInfo);
	           debugger;
	           $.ajax({
	                  type: "post",
	                  async: false,
	                  contentType: "application/json;charset=UTF-8",
	                  url: "http://localhost:8080/case/saveCase",
	                  data: JSON.stringify(caseInfo),
	                  success:function(result){
	                      console.log(result);
	                      debugger;
	                     if(result.success){
	                         alert("存入成功！");
	                      }else{
	                    	 alert("存入失败！");
	                      }
	                  }
	            });*/
			   
		   });
	   });
	   var medNum = 1;
	   var patientPerson = new Array();
	   var medicineNameList = new Array();
	   var priceList = new Array();
	   //初始化加载
	   $(function(){

	   });
	   
	   	function fillMedicine(medicine){
			$("#medicineBody").empty();
			$.each(medicine, function(index, item) {
			//var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
			var diseaseIdTd = $("<td align='right'>药&nbsp;名</td>");
			var departmentTd = $(" <td colspan='2' align='left'></td>").append(item.medicineName);
			var diseaseTypeTd = $("<td align='right'>用&nbsp;量</td>");
			var diseaseNameTd = $("<td></td>").append(item.diseaseName);
			var deseaseDescriptionTd = $("<td align='left' colspan='2'></td>").append(item.consumption);
			$("<tr></tr>").append(diseaseIdTd).append(departmentTd).append(diseaseTypeTd).append(diseaseNameTd).append(deseaseDescriptionTd)
			.appendTo("#medicineBody");
			});
	   	}
		   
	   function getMedicine(obj){
		   var medicine = {
                   "medicineName": ""+$(obj).val()
            }
            $.ajax({
                  type: "post",
                  contentType: "application/json;charset=UTF-8",
                  url: "http://localhost:8080/medi/getMedicineName",
                  data: JSON.stringify(medicine),
                  success:function(result){
                      console.log(result);
                      debugger;
                     if(result.success){
                         fillMediName(obj,result.value);
                      }else{
                         alert(result.message);
                      }
                  }
            });
	   }
	   
	   function fillMediName(obj,medicines){
		   medicineNameList = medicines;
		   var bort = $(obj).next();
		   $(bort).empty();
           var line = medicines.length >=5 ? 5 : medicines.length;
           for (var item = 0; item < line; item++) {
               var height = 0;
               $("<button class='show-medi-size medishow-button' href='javascript:void(0)' onclick='fillMediBlack(this,"+item+")'></button>")
                     .append(medicines[item].medicineId +"ൠ"+medicines[item].medicineName).appendTo(bort);
               height = height + 25;
               medicineNameList.push(medicines[item]);
               $(obj).css("height", height);
           }
           
	   }
	   
       function fillMediBlack(obj,item){
    	   var bort = $(obj).parent().prev();
    	   $(bort).val(medicineNameList[item].medicineName);
    	   var price = $(obj).parent().parent().next().next().children(":first");
    	   $(price).val(medicineNameList[item].price);
    	   debugger;
           $(obj).parent().empty();
           $(obj).parent().css("height", 0);
       }
	   
	   function getPatient (){
		   var user = {
                   "patientName": ""+$("#patientName").val()
            }
            $.ajax({
                  type: "post",
                  contentType: "application/json;charset=UTF-8",
                  url: "http://localhost:8080/sys/getPatientName",
                  data: JSON.stringify(user),
                  success:function(result){
                	  console.log(result);
                      debugger;
                     if(result.success){
                    	 fillName(result.value);
                      }else{
                         //layer.msg(result.message,{time:500});
                      }
                  }
            });
	   }
	   
	   function cleanName(){
		   $("#nameshow").empty();
		   $("#nameshow").css("height", 0);
	   }
	   
	   function fillName (patients){
		   var height = 0;
		   $("#nameshow").empty();
		   patientPerson = new Array();
		   var line = patients.length >=5 ? 5 : patients.length;
		   for (var item = 0; item < line; item++) {
			   
			   $("<button class='show-word-size show-button' href='javascript:void(0)' onclick='fillBlack("+item+")'></button>")
			         .append(patients[item].patientId +"ൠ"+patients[item].patientName).appendTo("#nameshow");
			   height = height + 25;
			   patientPerson.push(patients[item]);
           }
		   $("#nameshow").css("height", height);
	   }
	   function fillBlack(item){
		   $("#patientName").val(patientPerson[item].patientName);
		   $("#patientId").val(patientPerson[item].patientId);
		   $("#patientSex").val(patientPerson[item].patientSex=='M'?'男':'女');
		   $("#patientAge").val(patientPerson[item].patientBorn);
		   $("#nameshow").empty();
		   $("#nameshow").css("height", 0);
	   }

		//添加药品行按钮 medicineTable
		function operateMedicine(obj) {
			if ($(obj).val() == "+") {
				var tr = $(obj).parent().parent();
				tr.after(tr.clone());
				$(obj).val("-");
			} else if ($(obj).val() == "-") {
				$(obj).parent().parent().remove();
			}
		}

		//读取信息
		function getInfo() {
			//药品
			var list = new Array();
			var medicineNames = $("[name='medicineName']");
			var consumptions = $("[name='consumption']");
			var mediunits = $("[name='mediunit']");
			var prices = $("[name='price']");
			var totalPrices = $("[name='total']");
			for (var i = 0; i < medicineNames.length; i++) {
				var medicine = {};
				medicine.medicineName = $(medicineNames[i]).val();
				medicine.consumption = ""+$(consumptions[i]).val()+$(mediunits[i]).val();
				medicine.price = $(prices[i]).val();
				medicine.totalPrice = $(totalPrices[i]).val();
				list.push(medicine);
			}
			//病例信息
			var caseInfo = {
				"patientName" : "" + $("#patientName").val(),
				"patientId" : "" + $("#patientId").val(),
				"patientSex" : "" + $("#patientSex").val(),
				"patientAge" : "" + $("#patientAge").val(),
				"illnessTime" : "" + $("#illnessTime").val(),
				"cureCycle" : "" + $("#cureCycle").val(),
				"doctorName" : "" + $("#doctorName").val(),
				"cureTime" : "" + $("#cureTime").val(),
				"illnessDesc": "" + $("#illnessDesc").val(),
				"detailList" : list
			};

			return caseInfo;
		}
		
		function countPrice(obj){
			
			var num = $(obj).val();
			var price = $(obj).prev().val();
			var priBou = $(obj).next().next().next();
			debugger;
			$(priBou).val(num*price); 
		}

		//保存信息
		function saveCase() {
			//1、验证信息
			
			//2、读取信息
			var caseInfo = getInfo();
           console.log(caseInfo);
           debugger;
           $.ajax({
                  type: "post",
                  async: false,
                  contentType: "application/json;charset=UTF-8",
                  url: "http://localhost:8080/case/saveCase",
                  data: JSON.stringify(caseInfo),
                  success:function(result){
                      console.log(result);
                      debugger;
                     if(result.success){
                         alert("存入成功！");
                      }else{
                    	 alert("存入失败！");
                      }
                  }
            });

		}