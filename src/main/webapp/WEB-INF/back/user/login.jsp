<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>后台管理系统登陆</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/static/back/css/font.css"> 
	<link rel="stylesheet" href="${ctx}/static/back/css/xadmin.css">
	<link rel="stylesheet" href="${ctx}/static/back/lib/layui/css/layui.css">
	
	<script src="${ctx}/static/back/lib/jquery/jquery-3.2.1.min.js"></script>
    <script src="${ctx}/static/back/lib/layui/layui.js"></script>
	<script src="${ctx}/static/common/js/util.js"></script>
	<script src="${ctx}/static/common/js/mylayer.js"></script>
    <script src="${ctx}/static/back/js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login">
        <div class="message">管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form id="login_form" method="post" class="layui-form" >
            <input id="username" name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="password" name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
        </form>
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="button" onclick="submitForm()">
        <hr class="hr20" >
        <input value="注册" lay-submit lay-filter="register" style="width:100%;" type="button">
        <hr class="hr20" >
    </div>

    <script>
	    function submitForm() {
			/* 1、验证用户名
			1.1、用户名不能为空
			1.2、是否合法：4-20位数字或字母
			2、密码不能为空
			3、ajax提交用户名和密码，根据后台返回的ServerResponse决定进行什么操作 */
			var username = $("#username").val();
			var password = $("#password").val();
			// 1.1、用户名不能为空
			if(util.isNull(username)) {
				mylayer.errorMsg("用户名不能为空");
				return;
			}
			// 1.2、是否合法：4-8位数字或字母
			var pattern = /^[0-9a-zA-Z]{4,20}$/;
			if(!pattern.test(username)) {
				mylayer.errorMsg("用户名错误，格式为4-20位数字或字母");
				return;
			}
			//2、密码不能为空
			if(util.isNull(password)) {
				mylayer.errorMsg("密码不能为空");
				return;
			}
			//3、ajax提交用户名和密码，根据后台返回的ServerResponse决定进行什么操作
			$.ajax({
				url:"${ctx}/user/login.action",
				type:"post",
				dataType:"json",
				data:$("#login_form").serialize(),
				success:function(resp) {
					console.log(resp);
					if(resp.code == util.SUCCESS){
						mylayer.successUrl(resp.msg, "${ctx}/indexBack.action");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
    </script>

    
    <!-- 底部结束 -->
    
</body>
</html>