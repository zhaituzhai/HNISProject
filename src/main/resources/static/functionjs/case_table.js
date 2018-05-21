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
		    	    $("#diseaseName").val(data.illnessGrade);
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
	   var diseaseList = new Array();
	   //初始化加载
	   $(function(){
		   getLogUser();
	   });
	   
	   function getDisease(){
		   
		   var selectWay = $("#selectWay").val();
		   if(selectWay == 1){
			   var pageDise = {
						"pageNum":"1",
						"pageSize":"5",
						"param": {
							"diseaseName": ""+$("#diseaseName").val()
						}
				}
			   
			   $.ajax({
					async: false,
					type: "post",
					contentType: "application/json;charset=UTF-8",
					url: "http://localhost:8080/dise/getDiseList",
					data: JSON.stringify(pageDise),
					success:function(result){
						debugger;
						fillDisease(result.value.list);
					}
				});
		   }else if(selectWay == 2){
			   var pageDise = {
						"pageNum":"1",
						"pageSize":"5",
						"param": {
							"illnessGrade": ""+$("#diseaseName").val()
						}
				}
			   
			   $.ajax({
					async: false,
					type: "post",
					contentType: "application/json;charset=UTF-8",
					url: "http://localhost:8080/case/getCaseName",
					data: JSON.stringify(pageDise),
					success:function(result){
						debugger;
						fillCaseList(result.value.list);
					}
				});
		   }
		   
	   }
	   
	   function fillCaseList(diseases){
		   var height = 0;
		   $("#diseaseShow").empty();
		   diseaseList = new Array();
		   var line = diseases.length >=5 ? 5 : diseases.length;
		   for (var item = 0; item < line; item++) {
			   
			   $("<button class='show-word-size show-button' href='javascript:void(0)' onclick='FillCaseBlack("+item+")'></button>")
			         .append(diseases[item].illnessGrade).appendTo("#diseaseShow");
			   height = height + 25;
			   diseaseList.push(diseases[item]);
           }
		   $("#diseaseShow").css("height", height);
	   }
	   
	   function FillCaseBlack(item){
		   $("#diseaseName").val(diseaseList[item].illnessGrade);
		   $("#illnessDesc").val(diseaseList[item].illnessDesc);
		   fillCaseMedicine(diseaseList[item].caseDetail);
		   $("#diseaseShow").empty();
		   $("#diseaseShow").css("height", 0);
	   }
	   
	   function fillCaseMedicine(caseDetail){
		   
		   $("#medicineBody").empty();
			$.each(caseDetail, function(index, item) {
			//药名和用量
			var medicineNameTd = $("<input name='medicineName' onkeyup='getMedicine(this)' required='required' value='"+item.medicineName+"' style='width: 120px;height: 25px;'  /><div id='medishow' class='medishow'></div>"+
					"<input name='remark' placeholder='用量' required='required' value='"+item.remark+"' style='width: 100px;height: 25px;'  />");
			var diseaseMedicine= $("<td colspan='3' align='right'>药名</td>").append(medicineNameTd);
			//数量
			var diseaseMedicineLable = $("<td align='right'>数&nbsp;量</td>");
			//数量和价格text.replace(/[^0-9]/ig,"");
			var medicineNumAndPrice = $("<input name='price' type='hidden' value='"+item.price+"' />"+
					"<input name='consumption' required='required' value='"+item.consumption.replace(/[^0-9]/ig,'')+"' onblur='countPrice(this);' style='width: 20px;height: 25px;' />"+
					"<select name='mediunit' style='width: 45px;height: 30px;'><option value='盒' selected='selected'>盒</option><option value='袋'>袋</option><option value='瓶'>瓶</option><option value='其他'>其他</option></select>"+
					"<input type='button' style='width: 25px;height: 25px;' onclick='operateMedicine(this)' id='addMedicine' value='+' /><input name='total' value='"+item.totalPrice+"' onblur='countPrice(this);' placeholder='总价' style='width: 50px;height: 25px;' />");
			
			$("#mediunit").val(item.consumption.replace(/[0-9]/ig,''));
			var diseaseNumAndPrice= $("<td align='left' colspan='2'></td>").append(medicineNumAndPrice);
			
			$("<tr></tr>").append(diseaseMedicine).append(diseaseMedicineLable).append(diseaseNumAndPrice)
			.appendTo("#medicineBody");
			});
			
			
	   }
	   
	   function fillDisease(diseases){
		   var height = 0;
		   $("#diseaseShow").empty();
		   diseaseList = new Array();
		   var line = diseases.length >=5 ? 5 : diseases.length;
		   for (var item = 0; item < line; item++) {
			   
			   $("<button class='show-word-size show-button' href='javascript:void(0)' onclick='fillDiseaseBlack("+item+")'></button>")
			         .append(diseases[item].diseaseName).appendTo("#diseaseShow");
			   height = height + 25;
			   diseaseList.push(diseases[item]);
           }
		   $("#diseaseShow").css("height", height);
	   }
	   
	   function fillDiseaseBlack(item){
		   $("#diseaseName").val(diseaseList[item].diseaseName);
		   $("#illnessDesc").val(diseaseList[item].deseaseDescription+"\n"+diseaseList[item].therapeuticMethod);
		   fillCaseMedicine(null);
		   $("#diseaseShow").empty();
		   $("#diseaseShow").css("height", 0);
	   }
	   
	   function cleandiseaseShow(){
		   $("#diseaseShow").empty();
		   $("#diseaseShow").css("height", 0);
	   }
	   
	   function getLogUser(){
			$.ajax({
		        async: false,
		        type: "get",
		        contentType: "application/json;charset=UTF-8",
		        url: "http://localhost:8080/sys/getLoginUser",
		        success:function(result){
		        	debugger;
		            //alert(result.success);
		            if(result.success){
		                $("#doctorName").val(result.value.doctor.doctorName);
		            }else{
		            	window.location.href = "http://localhost:8080/login";
		            }
		        }
		    });
		}
	   
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
			var remarks = $("[name='remark']");
			var consumptions = $("[name='consumption']");
			var mediunits = $("[name='mediunit']");
			var prices = $("[name='price']");
			var totalPrices = $("[name='total']");
			for (var i = 0; i < medicineNames.length; i++) {
				var medicine = {};
				medicine.medicineName = $(medicineNames[i]).val();
				medicine.remark = $(remarks[i]).val();
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
				"illnessGrade" : "" + $("#diseaseName").val(),
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