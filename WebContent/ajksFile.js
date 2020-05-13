$(function(){
	$("#index").click(function(){
//		$("#msg01").html("hello");
		$.ajax({
			method:"get",
			url:"/jdbc01/demo",
			dataType:"text",
			success:function(result){
				$("#msg01").text(result);
			}
		});
	});
})
$(document).ready(function(){
	$("#name").blur(function(){
		var name=$("#name").val();
		console.log(name);
		$.post({
			url:"/jdbc01/demo02",
			data:{"name":name},
			success:function(result){
				$("#msg02").text(result);
			}
		});
	})
})