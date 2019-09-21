
function yclose()
{
    ymPrompt.close();
}


function callbackFun(cbparm, cbfun) {
    $('#header').load('/artinfo/indexHeader');
    if (cbparm[0]) {
        var n = cbparm.length;

        switch (n) {
            case 1:
                cbfun(cbparm[0]);
                break;
            case 2:
                cbfun(cbparm[0], cbparm[1]);
                break;
            case 3:
                cbfun(cbparm[0], cbparm[1], cbparm[2]);
                break;
            case 4:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3]);
                break;
            case 5:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4]);
                break;
            case 6:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4], cbparm[5]);
                break;
            case 7:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4], cbparm[5], cbparm[6]);
                break;
            case 8:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4], cbparm[5], cbparm[6], cbparm[7]);
                break;
            case 9:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4], cbparm[5], cbparm[6], cbparm[7], cbparm[8]);
                break;
            case 10:
                cbfun(cbparm[0], cbparm[1], cbparm[2], cbparm[3], cbparm[4], cbparm[5], cbparm[6], cbparm[7], cbparm[8], cbparm[9]);
                break;
        }
    } else {
        cbfun();
    }

    cp = new Array();
    fu = function(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10) {
    };
}



function cancelVal(id) {
    if ($('#' + id).val() == '用户名/邮箱') {
        $('#' + id).val('');
        $('#' + id).removeAttr('style');
    }
    if ($('#' + id).val() == '请输入昵称') {
        $('#' + id).val('');
        $('#' + id).removeAttr('style');
    }
}

function checkUsername() {
    var uname = $('#username').val();
    if (uname == '用户名/邮箱' || uname == '') {
        $('#v_uname').show();
    }
    else{
        $('#v_uname').hide();
    }
}
function checkPasswd() {
    var passwd = $('#pw').val();
    if (passwd == '') {
        $('#v_passwd').show();
    }
}


function goHomeLogin() {
	var from = $('#logform');
    var username = $('#username').val();
    var pw = $('#pw').val();
	$('#username').blur();
	$('#pw').blur();
   
    if(username == ''){
       
        return false;
    }
	if(pw == ''){
       
        return false;
    }else{
    
    	return true;    
    }
	
}




//关闭邮箱激活提醒操作
function closeBox(url,obj) {

    if (url) {
        location.href = url;
        try {
            window.event.returnValue = false;
        } catch (e) {
        }
    }
	if(obj!==""){
		$(obj).focus()
	}
    ymPrompt.close();
	
}


//获取字符长度，中文为2个字符
function GetLength(str) {
    var realLength = 0;
    var n = str.length;
    var len = 0;//alert(n)
    for (var i = 0; i < n; i++) {
        var ns = str[i];
        if (ns == null) {	//ie6
            ns = str.substring(i, i + 1);
        }

        if (ns.match(/[^\x00-\xff]/ig) != null) { //全角
            len += 2;
        } else {
            len += 1;
        }
    }

    len = parseInt(len / 2);

    return len;
}


//hash
function getHash() {
    var hash = window.location.href;
    url = '';
    if (hash != '') {
        var au = hash.split('#');
        for (var i in au) {
            if (i > 0 && au[i] != '') {
                url += au[i] + '#';
            }
        }
        url = url.substring(0, url.length - 1);
        //url = url.substring().rTrim('#');
    }

    if (url == '') {
        url = 'http://www.kanshu.com';
    }

    return url;

}


//jq cookie插件
jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString();
        }
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else {
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};


function loadImg(id) {
    $('#' + id).html('<p style="padding-left: 35px; padding-top: 40px;"><img src="' + IMG_HOST + 'user/images/loading.gif"/></p>');
}

function infBox(h, url, bt,obj) {
    var mcss = '', arg="";
    if (!bt) {
        bt = '关&nbsp;&nbsp;闭';
    } else {
        mcss = ' style="padding-left:8px;" ';
    }
    var msg = '<div class="xuanfu">';  ;
    msg += '<div class="xxtishi">信息提示</div>';
    msg += '<div class="tishicontent">' + h + '</div>';

    if(url) {
		arg = url;
        msg += '<div class="qxbtn"><a href="javascript:void(0);" onclick="closeBox(' + arg + ')"' + mcss + '>' + bt + '</a></div>';
    }else if(obj){
		$(obj).blur();
        msg += '<div class="qxbtn"><a href="javascript:void(0);" onclick="closeBox(\''+arg+'\',\''+obj+'\')"' + mcss + '>' + bt + '</a></div>';
    }else {
        msg += '<div class="qxbtn"><a href="javascript:void(0);" onclick="closeBox()" ' + mcss +'>' + bt + '</a></div>';
    }
    msg += '</div>';
    ymPrompt.confirmInfo({btn: '', icoCls: '', msgCls: 'confirm', message: msg, titleBar: false, useSlide: true, autoClose: false, width: 318, height: 160});
	
}

function goFunction() {
    $('#nowInf').html('正在处理，请稍等...');
    callbackFun(cp, fu);
}

function getCookie(c_name)
{
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1)
                c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}
