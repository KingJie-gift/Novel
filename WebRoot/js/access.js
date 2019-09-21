var timestamp=new Date().getTime();
var xxoo=getCookie("xxoo");
if(xxoo==null || timestamp>xxoo)
{
	document.cookie="xxoo="+(timestamp+7210000);
	url = document.referrer ;
	url = encodeURIComponent(url) ;
	nowurl = window.location.href;
	nowurl = encodeURIComponent(nowurl) ;
	$.getScript("http://ct.kanshu.com/count/access?url="+url+"&nowurl="+nowurl);
}

function getCookie(name)
{
    var bikky = document.cookie;
    name += "=";
    var i = 0;
    while (i < bikky.length)
    {
      var offset = i + name.length;
      if (bikky.substring(i, offset) == name)
      {
        var endstr = bikky.indexOf(";", offset);
        if (endstr == -1) endstr = bikky.length;
          return unescape(bikky.substring(offset, endstr));
      }
        i = bikky.indexOf(" ", i) + 1;
        if (i == 0) break;
    }
    return null;
}

$(document).ready(function(){
$.ajax({
type: "POST",
url: "/new/collect_info/",
data: "from_url="+encodeURIComponent(window.location.href),
success: function(msg){}
});
});

//add by fanrong click_collect
$(document).ready(function(){
	var url_regexp = new RegExp("(aid=)|(html\/)|(artinfo\/)[0-9]{1,12}");
	var cur_url = window.location.href;
	var tag = false;
	$("body").mouseover(function(){
	    if(tag == false && url_regexp.test(cur_url))
	    {
	        //setTimeout("bookCK()", 2000);
	        bookCK();
	    }
	    tag = true;
	});
});

function bookCK()
{
	
  $.ajax({
	    type: "get",
	    async: true,
	    data: "from_url="+encodeURIComponent(window.location.href),
	    url: "/new/iframe/book/addClick",
	    dataType: "jsonp",
	    jsonp: "callback",
	    jsonpCallback:"myCallBack",
	    success: function(data){ }
	});
}