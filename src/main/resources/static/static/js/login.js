var userInfo = {}

function handleClickRegister(){
		$("#registerForm").prop("hidden", false);
		$("#loginForm").prop("hidden", true);
}

function handleClickLogin(){
		$("#registerForm").prop("hidden", true);
		$("#loginForm").prop("hidden", false);
}

function handleRegister(){
	var username = $("#registerUsername").val();
	var password1 = $("#pwd1").val();
	var password2 = $("#pwd2").val();
	var sex =  $('input:radio[name="sex"]:checked').val();

	if(username === null || username === ""){
		alert("请输入账号")
		return;
	}
	if(password1 === null || password1 === ""){
		alert("请输入密码")
		return;
	}
	if(password2 === null || password2 === ""){
		alert("请输入密码")
		return;
	}
	console.log(sex)
	if(sex === null || sex === "" || undefined == sex){
		alert("请选择性别")
		return;
	}
	if (password1 != password2) {
		alert("两次密码不匹配");
		return;
	}

	data = {
		userName: username,
		password: password1,
		sex: sex
	}

	$.ajax({
		url: "http://127.0.0.1:8578/user/register",
        contentType: "application/json", //必须这样写
        dataType:"json",
		type: "post",
		data: JSON.stringify(data),
		success: function(response){
			alert(response.message)
		},
		error: function(response){
			console.log(response)
		}

	})
}


function handleLogin(){
	var username = $("#loginUsername").val();
	var password = $("#loginPassword").val();
	if(username === null || username === ""){
		alert("请输入账号")
		return;
	}
	if(password === null || password === ""){
		alert("请输入密码")
		return;
	}

	var data = {
		userName: username,
		password: password
	}

	$.ajax({
		url: "http://127.0.0.1:8578/user/login",
        contentType: "application/json", //必须这样写
        dataType:"json",
		type: "post",
		data: JSON.stringify(data),
		success: function(response){
		    if(response.message == "登录成功"){
		        userInfo = response.data;
		        localStorage.setItem("userInfo", JSON.stringify(userInfo));
		        window.location.href="/chat/index.html";
		    }else{
		        alert(response.message)
		    }
		},
		error: function(response){
			console.log(response)
		}
	})

}