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
	            price: [/^[0-9]+(.[0-9]{2})?$/, '只能是小数点后两位'],
	            
	        });

		   form.on('submit(add)', function() {
			   var caseInfo = getInfo();
	           console.log(caseInfo);
	           debugger;
	           $.ajax({
	                  type: "post",
	                  contentType: "application/json;charset=UTF-8",
	                  url: "http://localhost:8080/case/saveCase",
	                  data: JSON.stringify(caseInfo),
	                  success:function(result){
	                      console.log(result);
	                      debugger;
	                     if(result.success){
	                         fillName(result.value);
	                      }else{
	                         alert(result.message);
	                      }
	                  }
	            });
			   
		   });
	   });
	   var medNum = 1;
	   var patientPerson = new Array();
	   var medicineNameList = new Array();
	   //初始化加载
	   $(function(){

	   });
	   
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
           var line = medicines.length >=3 ? 3 : medicines.length;
           for (var item = 0; item < line; item++) {
               var height = 0;
               $("<button class='show-medi-size medishow-button' href='javascript:void(0)' onclick='fillMediBlack(this,"+item+")'></button>")
                     .append(medicines[item].medicineId +"&nbspൠ&nbsp;"+medicines[item].medicineName).appendTo(bort);
               height = height + 25;
               medicineNameList.push(medicines[item]);
               $(obj).css("height", height);
           }
           
	   }
	   
       function fillMediBlack(obj,item){
    	   var bort = $(obj).parent().prev();
    	   $(bort).val(medicineNameList[item].medicineName);
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
                         alert(result.message);
                      }
                  }
            });
	   }
	   
	   function fillName (patients){
		   $("#nameshow").empty();
		   var line = patients.length >=3 ? 3 : patients.length;
		   for (var item = 0; item < line; item++) {
			   var height = 0;
			   $("<button class='show-word-size show-button' href='javascript:void(0)' onclick='fillBlack("+item+")'></button>")
			         .append(patients[item].patientId +"ൠ"+patients[item].patientName).appendTo("#nameshow");
			   height = height + 25;
			   patientPerson.push(patients[item]);
			   $("#nameshow").css("height", height);
           }
		   
	   }
	   function fillBlack(item){
		   $("#patientName").val(patientPerson[item].patientName);
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
			for (var i = 0; i < medicineNames.length; i++) {
				var medicine = {};
				medicine.medicineName = $(medicineNames[i]).val();
				medicine.consumption = $(consumptions[i]).val();
				list.push(medicine);
			}
			//病例信息
			var caseInfo = {
				"patientName" : "" + $("#patientName").val(),
				"patientSex" : "" + $("#patientSex").val(),
				"patientAge" : "" + $("#patientAge").val(),
				"illnessTime" : "" + $("#illnessTime").val(),
				"cureCycle" : "" + $("#cureCycle").val(),
				"doctorName" : "" + $("#doctorName").val(),
				"illnessDesc": "" + $("#illnessDesc").val(),
				"detailList" : list
			};

			return caseInfo;
		}

		//保存信息
		$("#save").click(function() {
			//1、读取信息
			var caseInfo = getInfo();
			console.log(caseInfo);
			debugger;

		});