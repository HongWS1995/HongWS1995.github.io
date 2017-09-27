	var num=0;//定义取得列表的次数
	$("select#s").click(function(){
	//0的时候调用action取得数据库的值
		if(num==0){
			$.get("../product/getAll.action",function(data){
				showProductList(data);
			});
		}	
	});
	//列表的值改变时提示value值是否合法
	$("select#s").change(function(){
		alertMessage();
	});
	//对表单出库数量进行合法性判断
	$("input[name='quantity']").blur(function(){
		if($("input[name='quantity']").val()<=0){
			alert("数量必须是大于0的整数！");
		}
	});
	//对出库商品进行库存检查(调用action取得数据库值),库存充足则调用出库操作，否则提示库存不足
	$("input[name='submit']").click(function(){
	//得到表单值
		var id = $("select#s").val();
		var quantity =$("input[name='quantity']").val();
		var handler = $("input[name='handler']").val();
		
		//alert(id+":"+quantity+":"+handler);
		//调用action取得数据库值
		$.get("../product/getById.action",{id:id},function(data){
			//alert(JSON.stringify(data));
			//合法性检查
			if(quantity<data.quantity){
			//库存充足则调用出库操作，
				$.post("../takeout/add.action",{id:id,quantity:quantity,handler:handler},function(data){
					alert("经手人:"+data.handler+"对商品出库操作成功");
					location.reload();
				});
			}
			else{
			//否则提示库存不足
				alert("库存不足！");
			}
		});
		
	});
	function alertMessage(){
		if($("select#s").val()<=0){
			alert("请选择出库商品！");
		}
		else
			alert("您选择的商品id是:"+$("select#s").val());			
		
	}
	//插入下拉框option元素的文本和值，并将全局变量num置为1
	function showProductList(data){
		if(num==0){
			for(var obj in data.map){
				//alert(obj);
				$("select#s").append("<option value="+data.map[obj]+">"+obj+"</option>");
			}
			num=1;
			
		}
	}