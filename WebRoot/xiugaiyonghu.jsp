
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<link href="css/login_v10.css" rel="stylesheet" type="text/css" />

</head>

<body>
<div class="contain"> 
<div class="top">
    <div class="logo"><a href="default.jsp"><img src="images/logo.png" border="0"  class="logo"/></a></div>
    <div class="yd_nav"> <span><a target="_blank" href="/">首页</a></span><i>|</i> <span><a target="_blank" href="http://top.kanshu.com/">排行榜</a></span><i>|</i> <span><a target="_blank" href="http://quanben.kanshu.com/">全本</a></span><i>|</i> <span><a target="_blank" href="http://all.kanshu.com/">书库</a></span><i>|</i>
        <div id="gengduo" class="sp_more" > <a class="n_a" href="#">更多</a>
            <ul class="yd_snav2" id="nav_s1">
                <li><a target="_blank" href="http://xuanhuan.kanshu.com/">玄幻 · 奇幻</a></li>
                <li><a target="_blank" href="http://wuxia.kanshu.com">武侠 · 仙侠</a></li>
                <li><a target="_blank" href="http://dushi.kanshu.com">都市</a> · <a target="_blank" href="http://mm.kanshu.com">言情</a></li>
                <li><a target="_blank" href="http://lishi.kanshu.com">历史 · 军事</a></li>
                <li><a target="_blank" href="http://wangyou.kanshu.com">网游 · 竞技</a></li>
                <li><a target="_blank" href="http://kehuan.kanshu.com">科幻 · 灵异</a></li>
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
</script>

  <div class="cont zhuce">
    <div class="cont_left">
      <h3 class="reg_tit"><span class="reg_tab r_u cur"><i class="icon tk_y"></i> <em>修改密码</em></span><span class="reg_tab r_s gy"><i class="icon tk_g"></i> <em>修改成功</em></span></h3>
      <ul class="list">
        <li><span class="r1">用户名：</span><span class="r2">
          <input name="uname" type="text" id="uname" value="${s.authorname}" readonly="readonly"/>
          <input type="hidden"  id="authorid" name="authorid" value="${s.authorid }"/>
          </span><span class="org">*</span><span class="r3" id="msg_uname"></span><b style="display:none;" id="hi_uname" data="0">请填写个人账号</b><b id="hv_uname" style="display:none;" class="r3">字母、数字结合,不支持特殊字数，限2-14个字符</b></li>
        <li><span class="r1">密码：</span><span class="r2">
          <input name="pw1" id="pw1" type="password" value="${s.pwd }">
          </span><span class="org">*</span><span class="r4" id="v_pw1" >6-15个字符，英文区分大小写</span><span style="display:none;" id="hi_pw1" data="0">6-15个字符，英文区分大小写</span><span id="hv_pw1" class="r3" style="display:none;">6-15个字符，英文区分大小写</span></li>
        <li><span class="r1">确认密码：</span><span class="r2">
          <input name="pw2" type="password" id="pw2"/>
          </span><span class="org">*</span><span class="r4" id="v_pw"></span><span id="hv_pw" class="r4" style="display:none;"></span></li>
            <li><span class="r1">电子邮箱：</span><span class="r2">
          <input name="email" type="text" id="email" value="${s.email }"/>
          </span><span class="org">*</span><span class="r4" id="v_email"></span><span id="hv_email" class="r4" style="display:none;"></span></li>
          <li><span class="r1">用户余额：</span>
          <input name="authorprice" type="text" id="authorprice" value="${s.authorprice }" readonly="readonly"/>
          </li>
        <li class="reg_nm"><span class="r1"></span>
          <input type="checkbox" name="read" value="1" id="read" checked="checked" onclick="validRegister(5, this)">
          我已阅读并同意<a href="http://about.kanshu.com/regtreaty.html" target="_blank" class="red">《看书网协议》</a></li>
        <li><span class="r1"></span>
          <input type="hidden" name="reurl" id="reurl" value="" />
          <input type="button" id="regSubmit" class="button_regist" value="立即修改" onclick="check()"/>
        </li>
      </ul>
    </div>
    <div class="cont_right">
      <h2>用户登录</h2>
      <ul>
        <li>已有看书网账号？ </li>
        <li><a href="/new/login/showLogin" title="立即登录" class="button_login" id="login_link">立即登录</a></li>
        <li>你也可以用站外账号登录:</li>
        <li><a href="javascript:void(0);" onclick="ortherLogin('qq');return false;" title="腾讯QQ账号登录" class="button_qq"></a></li>
        <li><a href="javascript:void(0);" onclick="ortherLogin('sina');return false;" title="新浪微博账号登录" class="button_sina"></a></li>
        <li><a href="javascript:void(0);" onclick="ortherLogin('renren');return false;" title="人人网账号登录" class="button_renren"></a></li>
      </ul>
    </div>
    <div class="clear"></div>
  </div>
</div>
<div class="footer">
    <p class="p_01"><a href="http://about.kanshu.com/" rel="nofollow">关于看书网</a>|<a href="http://about.kanshu.com/contactus.htm" rel="nofollow">联系我们</a>|<a href="http://about.kanshu.com/cpyc.htm" rel="nofollow">诚聘英才</a>|<a href="http://about.kanshu.com/swhz.htm" rel="nofollow">商务合作</a>|<a href="http://about.kanshu.com/friendlink.htm" rel="nofollow">友情链接</a></p>
    <p>本站所收录所有<a href="http://xuanhuan.kanshu.com/">玄幻小说</a>、<a href="http://mm.kanshu.com/">言情小说</a>、<a href="http://dushi.kanshu.com/">都市小说</a>及其它各类<a href="http://www.kanshu.com/">小说</a>作品、<a href="http://www.kanshu.com/">小说阅读网</a>、<a href="http://www.kanshu.com/artinfo/">免费小说阅读网</a>、<a href="http://www.kanshu.com/">小说</a>评论均属其个人行为，不代表本站立场。</p>
    <p>Copyright (C) 2004-2013 <a href="http://www.kanshu.com/">看书网</a> All Rights Reserved 成都古羌科技有限公司 版权所有</p>
    <p>蜀ICP备05000570号 电信增值业务许可证：川B2-20100073</p>
    <p>网络文化经营许可证：川网文[2011]0207-6号</p>
</div>

<div style="display:none">
</div>

</body>
</html>
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script>
$(function(){
		$("#regSubmit").click(function(){
		var authorid=$("#authorid").val();

		var price=$("#authorprice").val();
		var pwd1=$("#pw1").val();
		var pwd2=$("#pw2").val();
		var name=$("#uname").val();
		var email=$("#email").val();
			if(name==""){
				alert("用户名不能为空！");
				return false;
			}
			if(pwd1==""){
				alert("密码不能为空！");
				return false;
			}
			if(pwd2==""){
				alert("重复密码不能为空！");
				return false;
			}
			if(email==""){
				alert("邮箱不能为空！");
				return false;
			}	
   			if(!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
     			alert("格式不正确！请重新输入");
     			$("#email").focus();
    			 return false;
  			}
			if(pwd1==pwd2){
			
			location.href="checkServlet?op=update&uname="+ name + "&pw1=" + pwd1+"&email="+email+"&authorprice="+price+"&authorid="+authorid;
			}else{
				alert("两次密码输入不一致！请重新输入！");
				return false;
			}
			return true;
		});
});
</script>