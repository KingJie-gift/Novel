<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'denglu.jsp' starting page</title>
</head>
<link href="css/login_new.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/loginuser.js"></script>
<script type="text/javascript" src="js/jquery.base64.js"></script>
<script type="text/javascript"  src="js/gVerify.js"></script>
<body>
	<div class="contain">
		<div class="top">

			<div class="logo">
				<a href="default.jsp"><img src="images/logo.png"
					border="0" class="logo" /></a>
			</div>

			<div class="yd_nav">
				<span><a target="_blank" href="default.jsp">首页</a></span><i>|</i> <span><a
					target="_blank" href="http://top.kanshu.com/">排行榜</a></span><i>|</i> <span><a
					target="_blank" href="http://quanben.kanshu.com/">全本</a></span><i>|</i> <span><a
					target="_blank" href="http://all.kanshu.com/">书库</a></span><i>|</i>

				<div id="gengduo" class="sp_more">
					<a class="n_a" href="#">更多</a>

					<ul class="yd_snav2" id="nav_s1">

						<li><a target="_blank" href="http://xuanhuan.kanshu.com/">玄幻
								· 奇幻</a></li>

						<li><a target="_blank" href="http://wuxia.kanshu.com">武侠
								· 仙侠</a></li>

						<li><a target="_blank" href="http://dushi.kanshu.com">都市</a>
							· <a target="_blank" href="http://mm.kanshu.com">言情</a></li>

						<li><a target="_blank" href="http://lishi.kanshu.com">历史
								· 军事</a></li>

						<li><a target="_blank" href="http://wangyou.kanshu.com">网游
								· 竞技</a></li>

						<li><a target="_blank" href="http://kehuan.kanshu.com">科幻
								· 灵异</a></li>

						<li><a target="_blank" href="http://mm.kanshu.com">女生言情小说</a></li>

					</ul>

				</div>

			</div>

			<div class="clear"></div>

		</div>

		<script type="text/javascript">
			function ortherLogin(t) {

				var url = encodeURIComponent(window.location.href);

				u_array = url.split('#');

				if (u_array.length - 1 != 0) {

					url = u_array[u_array.length - 1];

				}

				window.location = "/new/login/" + t + "?url=" + url;

			}
		<%String url = request.getHeader("referer");
			String returl = "login";
			if (url != null) {
				returl = url.substring(url.lastIndexOf('/') + 1);
			}
			%>
			
		</script>
		<div class="cont denglu">
			<div class="cont_left">
				<h2 class="mt30">用户登录</h2>
				<!-- 登录表单开始 -->
				<form name="logform" id="logform"
					action="checkServlet?op=login&url=<%=returl%>" method="post"
					autocomplete="off" onsubmit="return goHomeLogin();">

					<ul class="list">
						<li><span class="r1">用户名：</span><span class="r2"><input
								type="text" id="username" name="username"
								onfocus="cancelVal('username');" value="用户名/邮箱"
								style="color:#BBBBBB;" onblur="checkUsername();" /></span>
							<p id="v_uname" style="display:none;" style="padding-left:10px;">用户名不可为空</p></li>
						<li><span class="r1">密&nbsp;&nbsp;码：</span><span class="r2"><input
								type="password" id="pw" name="pw"
								onfocus="$('#v_passwd').hide();" onblur="checkPasswd();" /></span>
							<p id="v_passwd" style="display:none;" style="padding-left:10px;">密码不可为空</p></li>
							
						  <li id="show_yzm" ><span class="r1">验证码：</span><span class="r2b">
                                <input type="text" id="code_input" maxlength="4" name="validCode"></span><a id="v_container" style="width: 200px;height: 50px;"></a><span id="v_code" style="display:none;" style="padding-left:10px;">验证码有误</span></li>
						
						
						
						<li><span class="r1"></span><input name="" type="submit"
							id="login" title="登录"
							onmouseover="this.className = 'button_login2'"
							onmouseout="this.className = 'button_login'" value="立即登录"
							class="button_login" data="1" /> <a
							href="http://www.kanshu.com/new/user/findPass1?forget=1">忘记密码？</a></li>
							
							
						
					</ul>
				</form>
			</div>
			<div class="cont_right">
				<h2>用户注册</h2>
				<ul>
					<li>没有看书网账号？</li>
					<li><a href="zhuce.jsp" title="立即注册"
						class="button_regist">立即注册</a></li>

				</ul>

			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer">
		<p class="p_01">
			<a href="http://about.kanshu.com/" rel="nofollow">关于看书网</a>|<a
				href="http://about.kanshu.com/contactus.htm" rel="nofollow">联系我们</a>|<a
				href="http://about.kanshu.com/cpyc.htm" rel="nofollow">诚聘英才</a>|<a
				href="http://about.kanshu.com/swhz.htm" rel="nofollow">商务合作</a>|<a
				href="http://about.kanshu.com/friendlink.htm" rel="nofollow">友情链接</a>
		</p>
		<p>
			本站所收录所有<a href="http://xuanhuan.kanshu.com/">玄幻小说</a>、<a
				href="http://mm.kanshu.com/">言情小说</a>、<a
				href="http://dushi.kanshu.com/">都市小说</a>及其它各类<a
				href="http://www.kanshu.com/">小说</a>作品、<a
				href="http://www.kanshu.com/">小说阅读网</a>、<a
				href="http://www.kanshu.com/artinfo/">免费小说阅读网</a>、<a
				href="http://www.kanshu.com/">小说</a>评论均属其个人行为，不代表本站立场。
		</p>
		<p>
			Copyright (C) 2004-2013 <a href="http://www.kanshu.com/">看书网</a> All
			Rights Reserved 成都古羌科技有限公司 版权所有
		</p>
		<p>蜀ICP备05000570号 电信增值业务许可证：川B2-20100073</p>
		<p>网络文化经营许可证：川网文[2011]0207-6号</p>
	</div>

	<div style="display:none">
		
	</div>
	<link rel="stylesheet" id='skin' type="text/css"
		href="css/ymprompt.css" />
	
</body>
</html>
<script>
var verifyCode = new GVerify("v_container");

	 $("#logform").submit(function(){
	 	var res = verifyCode.validate(document.getElementById("code_input").value);
            if(!res){
                	$("#v_code").show();
                	$("#code_input").val("");
                return false;
            }
            $("#v_code").hide();
               return true;
            
	 })
</script>