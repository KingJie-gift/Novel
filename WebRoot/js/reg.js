
				
var checkResult = {};

var Check = {
    checkUserName : function() {
		
        var unameEl  = $("#uname"),
		    isReg = false ,
            uname    = $.trim(unameEl.val()),
            len         = uname.replace(/[^\x00-\xff]/g, 'aa').length;
	
        unameEl.val(uname);
		
        if (len < 2 || len > 14) {
        	$('#v_uname').removeAttr('class');
			$('#v_uname').addClass('r4') ;
        	$('#v_uname').css('color','red');
			$('#v_uname').text('请输入2-14个字母或数字');
			$('#v_uname').show();
        	return false;
        }
        uname = encodeURIComponent(uname);

    	$.ajaxSetup({async : false});
    	
        $.post('/new/user/isReg' , {uname:uname}, function(data) {
			$('#v_uname').removeAttr('class');
			$('#v_uname').addClass('r4') ;
            if(data == '111'){
            
					$('#v_uname').css('color','');
					$('#v_uname').text('ok');
					$('#v_uname').show();
					
					isReg = true ;
					return ;
			}else if(data == '331'){
					$('#v_uname').css('color','red');
					$('#v_uname').text('请输入2-14个字母或数字');
					
			}else if(data == '333'){
					$('#v_uname').css('color','red');
					$('#v_uname').text('不支持特殊字符');
				}else if(data == '944'){
					$('#v_uname').css('color','red');
					$('#v_uname').text('用户名不合法');
				}else if(data == '000'){
					$('#v_uname').css('color','red');
					$('#v_uname').text('用户名不能为空');
				}else if(data == '222'){
					$('#v_uname').css('color','red');
					$('#v_uname').text('用户名已存在');
				}
				
				$('#v_uname').show();
				isReg = false ;
				
        });
		return isReg ;
    	
    },
    checkPassword : function() {
        var passwordEl = $("#pw1"),
            password = $.trim(passwordEl.val());

        passwordEl.val(password);

        if (password.length < 6) {
         	$('#v_pw1').css('color','red');
			$('#v_pw1').text($('#hv_pw1').html());
			return false;
        }
        if (password.length > 15) {
         	$('#v_pw1').css('color','red');
			$('#v_pw1').text('密码不能超过15位');
			return false;
        }
        if((/[^\u0021-\u007E]/).test(password)){
        	$('#v_pw1').css('color','red');
        	$('#v_pw1').text('不支持特殊字符');
        	return false;
        }
        $('#v_pw1').css('color','#000');
		$('#v_pw1').text('ok');
        return true ;
    },
    checkRePassword : function() {
		$('#v_pw').show();
		
		if($('#pw2').val() == $('#pw1').val()){
			if($('#pw2').val() == ''){
				$('#v_pw').css('color','');
				$('#v_pw').text($('#hv_pw').html());
				return false ;
			}else{
				$('#v_pw').css('color','');
				$('#v_pw').text('ok');
				return true;
			}
		}else{
			$('#v_pw').css('color','red');
			$('#v_pw').text('密码不一致');
			return false ;
		}
		return false;
    },
    checkEmail : function () {
    	
        var emailEl = $("#email"),
        	isReg = false ,
            email = $.trim(emailEl.val());
		
        emailEl.val(email);
		$('#v_email').addClass('r4') ;

		if(email!=''&&email!='请填写个人常用邮箱'){

        if (/^[_\w-]+(\.[_\w-]+)*@([\w-])+(\.[\w-]+)*((\.[\w]{2,})|(\.[\w]{2,}\.[\w]{2,}))$/.test(email)) {
       		$.ajaxSetup({async : false});
        	$.post('/new/user/validEmail' , {email:email}, function(data) {
        		if(data == '999'){
					$('#v_email').css('color','red');
					$('#v_email').text('邮箱已经存在');
					isReg = false ;
				}else{
					$('#v_email').css('color','');
					$('#v_email').text('ok');
					isReg = true ;
				}
			});
			$('#v_email').show();
            return isReg ;
        } else {
        	$('#v_email').removeAttr('class');
            $('#v_email').css('color','red');
			$('#v_email').text('邮箱格式错误');
			$('#v_email').show();
			return false;
				
           
        }
        }else{
        	return true ;
        }
    },
  
	checkRead : function () {
		
		if($('#read').attr('checked') == true){
			//param = 1;
			$('#v_read').text('');
			return true;
		}else{
			$('#v_read').css('color','red');
			$('#v_read').text('注册前必须阅读协议');
			//param = 0;
			return false;
		}
	},
    checkRegister : function() {
		//alert('ssss');
        $.ajaxSetup({async : false});
		if(!Check.checkUserName()){
       		return false ;
        }
		//alert('ddd1');
        if(!Check.checkPassword()){
       		return false ;
        }
		
		//alert('ddd3');
        if(!Check.checkRePassword()){
       		return false ;
        }
		//alert('ddd4');
        if(!Check.checkEmail()){
       		return false ;
        }      //alert('ddd5');
		$('#regSubmit').val('正在提交...');
		$('#regSubmit').attr('disabled', true);
        var uname    = $("#uname").val(),
            pw1    = $("#pw1").val(),
            pw2    = $("#pw2").val(),  
            email       = $("#email").val(),
            username    = $("#username").val(),
            reurl    = $("#reurl").val(),
            validCode 	= $('#validCode').val();
            m_validCode = $('#m_validCode').val();
            mobile = $('#mobile').val();
            
            var read 		= 0;
        if($("#read").attr('checked') == true){
			read = 1;
		}else{
			read = 0;
		}
        username = encodeURIComponent(username);

		//reurl = encodeURIComponent(reurl);
		if(email=='请填写个人常用邮箱') email = '' ;
		
		var post_param;
		if($('#reg_validCode').css('display') == 'none') {
			post_param = {pw1:pw1,pw2:pw2,email:email,uname:uname,reurl:reurl,read:read,m_validCode:m_validCode,mobile:mobile}
		}else{
			post_param = {pw1:pw1,pw2:pw2,email:email,uname:uname,reurl:reurl,read:read,validCode:validCode}
		}
		
        $.post('/new/user/doPcRegister' , post_param , function(data) {
	
        if(data == '111'){
			if (reurl!="") {
				window.location = reurl;
				return;
			}
			window.location = "/new/user/regSuccess";
		}else if(data == '000'){
			$('#v_username').show();
			$('#v_username').text('昵称不能为空');
		}else if(data == '222'){
			$('#v_uname').show();
			$('#v_uname').text('用户名已存在');
		}else if(data == '333'){
			$('#v_username').show();
			$('#v_username').text('4-14个字符，支持字母、数字');
		}else if(data == '411'){
			$('#v_pw1').show();
			$('#v_pw1').text('密码不能小于6位');
		}else if(data == '422'){
			$('#v_pw1').show();
			$('#v_pw1').text('密码不能超过15位');
		}else if(data == '555'){
			$('#v_email').show();
			$('#v_email').text('邮箱格式错误');
		}else if(data == '999'){
			$('#v_email').show();
			$('#v_email').text('邮箱已经存在');
		}else if(data == '777'){
			
			$('#v_vc').show();
			$('#v_vc').text('验证码不一致');
			
		}else if(data == '888'){
			alert('注册前必须阅读协议');
		}else if(data == '444'){
			$('#v_pw').show();
			$('#v_pw').text('密码不一致');
		}else if(data == '944'){
			$('#v_username').show();
			$('#v_username').text('昵称不合法');
		}else if(data == '21036'){
			$('#v_mobile').css('color','red');
			$('#v_mobile').text('验证码已经失效');
		}else if(data == '21037'){
			$('#v_mobile').css('color','red');
			$('#v_mobile').text('验证码或手机号错误');
		}else{
			if (reurl!="") {
				window.location = reurl;
				return;
			}
			window.location = "/new/user/regSuccess";
		}
		
		$('#regSubmit').attr('disabled', false);
		$('#regSubmit').val('注 册');
        });
    }
};


function cancelVal(id){
if($('#'+id).val()=='用户名/邮箱'){
$('#'+id).val('') ;
$('#'+id).removeAttr('style') ;
}
if($('#'+id).val()=='请输入昵称'){
$('#'+id).val('') ;
$('#'+id).removeAttr('style') ;
}
} 	

function setFromid() {
    var fromid = $.Params.Values['fromid'];
    fromid = fromid ? fromid : "";
    $("#fromid").val(fromid);
}

function hiInf(id, f){
		if(f == 1){
			var con = $("#"+id).val();
			var htm = $("#hi_"+id).html();
			if(con == $("#hi_"+id).html() || con == ''){
				$("#"+id).val('');
				$("#"+id).css('color','black');
			}
		}else{
			var con = $("#"+id).val();
			var htm = $("#hi_"+id).html();
			if(con == $("#hi_"+id).html() || con == ''){
				$("#"+id).val(htm);
				$("#"+id).css('color','#BBBBBB');
			}
		}
	}
$(document).ready(function() {
    // 注册事件
    $("#uname").blur(Check.checkUserName);
    $("#pw1").blur(Check.checkPassword);
    $("#pw2").blur(Check.checkRePassword);
    $("#email").blur(Check.checkEmail);
   
    $("#read").blur(Check.checkRead);
    
    $("#regSubmit").click(Check.checkRegister);
    
    
    $('#email').hover(function(){$('.v_email').show();});
    
	$('#pw').hover(function(){$('.v_pw').show();});
	$('#pw1').hover(function(){$('.v_pw1').show();});
	$('#pw2').hover(function(){$('.v_pw').show();});
	$('#username').hover(function(){$('.v_username').show();});
	$('#validCode').hover(function(){$('.v_vc').show();});
	
	$('#email').focus(function(){hiInf('email', 1)}).blur(function(){hiInf('email', 0)});

	$('#username').focus(function(){hiInf('username', 1)}).blur(function(){hiInf('username', 0)});
	$('#moblie').focus(function(){hiInf('moblie', 1)}).blur(function(){hiInf('moblie', 0)});
	$('#vcode').focus(function(){hiInf('vcode', 1)}).blur(function(){hiInf('vcode', 0)});
});

// jquery url param plugin
(function($){function QueryStringParser(){this.load();} $.extend(QueryStringParser.prototype,{load:function(suppliedQueryString){this.Values=new Object();var queryString=suppliedQueryString||document.URL;var qsIndex=(suppliedQueryString||document.URL).indexOf('?');if(qsIndex<0) return;queryString=queryString.substring(qsIndex+1);if(queryString.length<=1){return;} var pairs=queryString.split('&');for(var i=0;i<pairs.length;i++){this.Values[pairs[i].split('=')[0].toLowerCase()]=decodeURIComponent(pairs[i].split('=')[1]);}},get:function(key){return(this.Values[key.toLowerCase()])?this.Values[key.toLowerCase()]:'';},set:function(key,value){this.Values[key.toLowerCase()]=value;return this;}});QueryStringParser.prototype.toString=function(){var params=[];for(var prop in this.Values){params.push(prop+"="+encodeURIComponent(this.Values[prop]));} return params.join('&');};$.Params=new QueryStringParser();})(jQuery);


// 回车键提交注册信息
document.onkeydown = function (event){
	event = document.all ? window.event : event;
	try{
		if (event.keyCode == 13){ 			
			if($('#regSubmit').length>0){
				event.keyCode = 0;
				Check.checkRegister();
			}
		}
	}catch(e){}
}