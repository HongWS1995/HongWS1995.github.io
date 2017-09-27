$("input#submit").click(function(){
		var name=$("input[name='productName']").val();
		var count=$("input[name='quantity']").val();
		
		 $.post("../product/add.action",{productName:name,quantity:count},function(data){
			 alert(JSON.stringify(data));
			 alert("增加商品成功！商品名："+data.productName+"数量："+data.quantity);
			 location.reload();
		 });
	});