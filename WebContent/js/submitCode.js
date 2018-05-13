$(function () {
	$("#subCode").click(function () {
		//判断所提交的代码去掉前后空格之后是否为空，为空打印提示
		var code = $.trim($(".row1 textarea").val());
		if (code == null || code.length == 0) {
			$("#result").html("所提交的代码不能为空");
		}
		
		var url;
		
		//根据当前所选语言栏修改相应的url
		switch ($("li[class='active']").attr("id")) {
		case "c":
			url = "RunC";
			break;
		case "c++":
			url = "RunCa";
			break;
		case "java":
			url = "RunJAVA";
			break;

		default:
			break;
		}
		$.post(
			url,
			{"text":code},
			function (result) {
				$("#result").html(result);
//				alert(result);
			}	
		);
	});
});




