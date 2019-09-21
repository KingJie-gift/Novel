<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>

<head>
<style type="text/css">
.thumb-image{
 float:left;width:120px;
 position:relative;
 padding:5px;
}
</style>
    <title>
        作者专区-创建书籍
    </title>
    
<meta name="renderer" content="webkit">
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <link rel="stylesheet" type="text/css" href="css/modify_190708.css">
    
</head>

<body>


<div class="au_nav">
	<div class="au_box" id="loginSign">
	 <div class="au_nav_a">
		<a href="default.jsp"  target="_blank">看书网首页</a>|
		<a href="/nzh/editors"  target="_blank">编辑介绍</a>|
		<a href="http://www.zongheng.com/company/author.html"  target="_blank"  class="goodluck">作者福利</a>
		
		        |<span id="authorname"></span>|
		        <a  href="http://author.zongheng.com/loginout">退出</a>
		   
	 </div>
	 <a href="default.jsp" class="au_logo" style="height: 61px; width: 288px"></a>
        <script src="//author.zongheng.com/nzh/header/notice"></script>

	</div>
  </div>
 <form action="checkServlet?op=addbook" method="post"enctype="multipart/form-data">
<div class="au_create">
    <div class="au_box">
        <div class="au_c_con">
            <div class="au_c_tit">
                <a href="/book/notice" target="_blank" class="note pub_ico">投稿须知</a>
                <span class="focus">作品信息</span>
              
                
            </div>
            <div class="au_c_form">
                <ul>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>书名：</div>
                        <div class="au_c_c fl">
                            <p class="clear"><input type="text" placeholder="请输入您要创建的书名" class="au_text bookvalue fl"
                                                    maxlength="12" name="bookname" id="bookname"
                                                    value=''/><em
                                    class="pub_ico through fl"></em></p>
                            <p class="au_error"><em class="ico_err pub_ico"></em>您输入的书名格式有误</p>
                            <p class="au_tip">1-12个字符</p>
                        </div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>选择站点：</div>
                        <div class="au_c_c fl radio_dom select_site_radio">
                                                                  <em class="focus label">纵横中文网</em><input  type="radio" value="纵横中文网" name="ra" class="pub_ico au_pointer" checked="checked">                     
                                                                 <em class="label">花语女生网</em><input type="radio"    value="花语女生网" name="ra" class="pub_ico au_pointer" >
                                                                 
                                                          
                                                                 
                        </div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>征文活动：</div>                             
                                        <div class="au_c_c fl">
                                            <input type="hidden" name="essayActivityId" placeholder="活动" value="0">
                                            <div class="joined_act">暂无可以参加的征文活动</div>
                                        </div>
                                    


                    </li>
                    <li class="clear selli">
                        <div class="au_c_t fl"><em>*</em>类别：</div>
                        <div class="au_c_c fl">
                            <div class="au_select fl select_dom kindlist_ul">
                                <select class="au_s_nav select_nav" name="select">
                               <c:forEach items="${booktypelist }" var="bk">
                               <option value="${bk.bookid }">${bk.booktype}</option>
                                </c:forEach>
                                </select>
                             
                             
                            </div>
                            
                        </div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>作品首字母：</div>
                        <div class="au_c_c fl">
                            <input type="text" placeholder="作品首字母" class="au_text bookstr"  id="firstLetter" maxlength="1" name="firstLetter" value=''/>
                            <p class="au_error"><em class="ico_err pub_ico"></em>您输入的作品首字母有误</p>
                            <p class="au_tip">1位字母a-zA-Z</p>
                        </div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>作品关键字：</div>
                        <div class="au_c_c fl">
                     
                            <div style="width: 330px; height: 50px">
                             <input type="text" name="guanjianzi" class="akeys clear" style="width: 325px; height: 49px" maxlength="4">
                            </div>
                            <em style="font-size: 12px;color:#C6C6C6">热血","爽文","穿越","升级","异世","重生","争霸","搞笑","生活"</em>
                            <p></p>
                            <em style="font-size: 12px; color:#C6C6C6">"法宝","末世","魔兽","救亡","推理","网游"</em>
                            <p class="au_tip">1-4个关键字</p>
                        </div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl">上传封面：</div>
                    <div class="au_c_c fl">
                    
                          <!--  <input type="file"  id="fileId">-->
                         
                           <!--  <a href="javascript:;" class="upload greenbtn" id="pic">点击上传</a>--> 
                          <input   id="fileId" name="fileId" type="file"/>  
                            </div>
                            <div class="uploadarea">
                            
                          
                            <p class="au_cor_gay">1、只能上传规格为240*320像素的小于10MB的JPG图片</p>
                            <p class="au_cor_gay">2、禁止上传任何有黄色、暴力、血腥、恐怖、广告宣传或者不适合公众欣赏的封面，一经发现即做禁书处理</p>
                            <p class="au_cor_gay">3、作品封面由用户个人制作并上传，基于此产生的法律责任本站不承担连带责任。</p>
                        </div>
                            <div  id="image-holder" style="margin-left:130px;width: 154px; height: 192px;"></div>
                    </li>
                    <li class="clear">
                        <div class="au_c_t fl"><em>*</em>内容简介：</div>
                        <div class="au_c_c fl">
                            <div class="textarea">
                                <textarea placeholder="请在此输入作品简介" class="bookintro" maxlength="50" name="description" id="content"></textarea>
                                <em class="au_cor_gay">1-50位字符</em>
                                
                            </div>
                        </div>
                    </li>
                    <li class="clear">
                     <div class="au_c_t fl">作品寄语：</div>
                
                            <div class="textarea">
                                <textarea placeholder="请在此输入作品寄语"  class="bookintro"  maxlength="30" name="wishWord"></textarea>
                                <em class="au_cor_gay">1-30位字符</em>
                               
                            </div>
                    
                            <div class="submitintro" style="margin-left: 126px;">
                            <input type="hidden" name="authorid" value="${au.authorid}">
                              <input type="submit" value="下一步：上传内容"class="nextstep greenbtn fl">
                         
                            </div>
                           
                               </form>
                            <p class="au_wan"><em class="ico_err pub_ico"></em>说明</p>
                            <p class="au_cor_gay">1、作品名字应与内容相符，不具有文学性、故意夸大其词的广告性、政治性、恶搞性或淫亵性作品名将会被删除。</p>
                            <p class="au_cor_gay">2、上传的作品内容必须与符合纵横收录标准，不符合收录标准的作品将被禁阅或删除。</p>
                            <p class="au_cor_gay">3、新作品将在48小时内审核完毕（节假日顺延），请建立完后立即上传章节，凡章节低于三章或少于3000字一般不会通过审核。</p>
                            <p class="au_cor_gay">4、读书网有权将该作品推荐给合作伙伴宣传或转载，以便为作者寻找更多带来收益的机会，不另行专门告知。</p>
      


<div class="footer">
	<div class="au_box">
		<p>
			Copyright<em>©</em>2008-2010 www.huanxiang.com All Rights Reserved
		</p>
		<p>版权所有 徐州幻想小组</p>
	</div>
</div>

</body>
</html>
<script src="js/jquery-1.4.4.min.js"></script>
<script>

$(function(){


$("#fileId").bind('change', function () {
  if (typeof (FileReader) != "undefined") {
    var image_holder = $("#image-holder");
    image_holder.empty();
    var reader = new FileReader();
    reader.onload = function (e) {
      $("<img />", {
      "src": e.target.result,
      "class": "thumb-image"
      }).appendTo(image_holder);
    }
    image_holder.show();
    reader.readAsDataURL($(this)[0].files[0]);
  } else {
    alert("This browser does not support FileReader.");
  }
  });


});

  $("form").submit(function(){
  
    var bookname=$("#bookname").val();  //小说名称
    var bookH=$("#firstLetter").val();//作品首字母
   //  var img=$("").val();//小说封面
  var content=$("#content").val();//内容简介
 
     if(bookname=="")
     {
      alert("书名不能为空！");
      return false;
     }
       
    
     if(bookH=="")
    {
    alert("首字母不能为空！");
    return false;
    }
    
    
    if(content=="")
    {
    alert("请输入内容简介");
    return false;
    }
    
   
    /**判断上传文件文件格式**/
    
var filePath ="";
var fileType ="";
    var fileName = $("#fileId").val().split('\\'); //得到文件名数组
    var fileSize =  document.getElementById("fileId").files[0]; //获得文件大小；
    fileName2 = fileName[fileName.length-1]; // 获得文件名
    filePath = $("#fileId").val().toLowerCase().split(".");
    fileType =  filePath[filePath.length - 1]; //获得文件结尾的类型如 zip rar 这种写法确保是最后的
    if(!(fileType == "png" || fileType == "jpg" || fileType == "xlsx"|| fileType == "docx"|| fileType == "rar" || fileType == "zip" || fileType == "bmp" )){
      alert("文件格式不符合要求！");
      return false ;
    }else if(fileSize.size>102400){
       alert("错误,上传文件过大!");
        return false;
        }
          
  return true;

  
  });
  
  
  /*  $("#pic").click(function () {
$("#fileId").click(); //隐藏了input:file样式后，点击头像就可以本地上传
   

});*/
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
   

   
  

</script>