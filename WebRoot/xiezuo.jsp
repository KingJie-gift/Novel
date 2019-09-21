<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>
<head>
<style>  
</style>  
<meta charset="utf-8">
<title>作品专区-管理章节</title>
<meta name="renderer" content="webkit">
    <link rel="stylesheet" type="text/css" charset="utf-8" href="css/public.css">
    <link rel="stylesheet" type="text/css" charset="utf-8" href="css/manage.css">
</head>
<body bookId="873323" authorization="3" level="0"  
       serialStatus="0"  draftId=""  isfemale="0">
<div class="pub_nav_bg creat_add">
	<div class="au_box">
    	<div class="mod_tit">
        	<span class="bookname"></span>
            <a href="checkServlet?op=zuojiazhuanqu&authorid=${au.authorid}" class="btn_bg bookstore">作品库</a>
        </div>
    </div>
</div>
<form action="checkServlet?op=addchapter" method="post">
<div class="pub_con_bg">
	<div class="manage">
    	<div id="listerrbg"></div>
        <div class="errlist" id="listerr">
            <div class="larw"><input type="text" maxlength="20" class="errcopy"/></div>
          
        </div>
    	<div class="side" style="margin-left: -20px;height:550px;overflow:auto;">
            <div class="side_tit">
                <h2 class="booktome">目录</h2>
            </div>
            <div class="articelist" id="artList">
            <ul id="ul">
         <c:forEach items="${chapterlist}" var="c">
         <li style="margin-left: 3px;">${c.chaptertitle}</li>
         
         </c:forEach>
            
            </ul>
            </div>
            
        </div>
        <div class="wide" style="display:block;">
            <div class="sensitive">
            	<div class="senspad">
                    <p><em class="pub_ico ico_err"></em>您输入的内容中包含违禁词: <span class="strong"></span></p>
                </div>
            </div>
            <div class="bookend">
            	<div class="book_tome"></div>
                <h2 class="book_chapter"></h2>
                <div class="book_content"></div>
                <div class="book_summary"></div>
                <div class="book_authorsay"></div>
            </div>
            <div class="coding">
                <div class="w_list clear">
                    <div class="minstar fl">*</div>
                    <div class="w_con">
                        <div class="select1 select_dom">
                    
                            <span class="au_input select select_nav"><em class="arr_select pub_ico fr"></em><em class="font_c_gray">所在分卷</em><em class="sel_con">${novel.bookname}</em></span>
                            <div class="option">
                                <ul class="choicetome">
                                    <li>作品相关</li>
                                   
                                </ul>
                            </div>
                        </div>
                        <div class="select1 noselect">
                   
                        </div>
                    </div>
                </div>
                <div class="w_list clear">
                    <div class="minstar fl">*</div>
                    <div class="w_con">
                        <div class="au_input art_name"><em class="font_c_gray">章节名</em><input type="text" maxlength="20" value="" placeholder="请输入章节名20字以内" class="df_input chapter_name" name="chaptername" id="chaptername"/></div>
                        <p class="value_error"  id="valueerror"><em class="ico_err pub_ico"></em><em class="error_con">您输入的格式不对</em></p>
                    </div>
                </div>
                <div class="w_list clear">
                    <div class="minstar fl">*</div>
                    <div class="w_con">
                        <div class="textarea">
                            <textarea placeholder="请输入章节内容8000字以内" class="des chapter_content" name="chaptercontent" maxlength="30000" id="chaptercontent"></textarea>
                            <p class="setfont"><em>0</em> / 8000</p>
                        </div>
                    </div>
                </div>
                <div class="w_list clear remark">
                    
                   
                    </div>
                </div>
                <div class="w_list clear">
                    
                </div>
                <div class="w_list clear submit_model">
                    <div class="w_con">
                        <div class="au_input publish_m radio_dom" style="width: 294px; ">
                         <em class="font_c_gray">收费模式:</em>
                         <select class="label" style="width: 104px; height: 26px" name="select" >
                         <option value="0">&nbsp;&nbsp;免费&nbsp;&nbsp;</option><option value="40">&nbsp;&nbsp;40书卷&nbsp;&nbsp;</option><option value="50">&nbsp;&nbsp;50书卷&nbsp;&nbsp;</option><option value="60">&nbsp;&nbsp;60书卷&nbsp;&nbsp;</option><option value="70">&nbsp;&nbsp;70书卷&nbsp;&nbsp;</option><option value="80">&nbsp;&nbsp;80书卷&nbsp;&nbsp;</option><option value="90">&nbsp;&nbsp;90书卷&nbsp;&nbsp;</option><option value="100">&nbsp;&nbsp;100书卷&nbsp;&nbsp;</option>
                         </select>
                         </div>
                    </div>
                </div>
                <div class="w_list clear submit_style">
              
                <div class="w_list clear">
                    <div class="minstar fl"></div>
                    <div class="w_con">
                    <input type="hidden" name="bookid" value="${novel.bookid}">
                  
                    <input type="submit" value="上传章节" class="upload_c btn_bg">
                       
                    </div>
                </div>
                </form>
                <div class="w_list clear">
                    
                    <div class="w_con">
                        <div class="upload_warn">
                       
                            <p>1、编辑、移动、删除章节在作品库中的作品列表里该作品的【章节管理】里。</p>
                            <p>2、分卷不能移动，创建分卷、章节的顺序即为分卷、章节在目录中的展示顺序，也就是书的顺序。</p>
                            <p>3、程序能处理绝大多数文本格式的排版，但请不要录入带硬回车换行的作品</p>
                            <p>4、添加的章节会被程序识别为作品或当前卷的最新一章，请注意选择章节所在卷。章节请按顺序输入，不要颠倒。</p>
                            <p>5、章节名字应与内容相符，不具有文学性、故意夸大其词的广告性、政治性以及恶搞性章节名将会被删除。</p>
                            <p>6、上传的章节内容必须与符合读书网收录标准，不符合收录标准的作品将被禁阅或删除。</p>
                            <p>7、凡是六小时内重复上传新章节、单章字数低于2000字将不在首页更新列表，以及分类更新列表内显示更新情况(漫画作品除外)</p>
                        </div>
                    </div>
                </div>
            
 
</body>
</html>
<script src="js/jquery-1.12.4.js"></script>
<script>


$("form").submit(function(){

  var chaptername=$("#chaptername").val();
  if(chaptername=="")
  {
   alert("章节名称不能为空!");
   return false;
  }
  
  var content=$("#chaptercontent").val();
  if(content.length<1){
  alert("内容长度有误！");
  return false;
  }
  
  
   var content=$("#chaptercontent").val();
  if(content.length<1){
  alert("内容长度有误！");
  return false;
  }
  if(content.length>8000)
  {
  alert("内容长度最多为8000字！");
  return false;
  }
  
  
   //$("#ul").append("<li>"+chaptername+"</li>");
})
</script>