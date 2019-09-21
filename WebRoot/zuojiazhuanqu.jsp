
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>
<head>
<title>作者专区-首页</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/author.css"/>
    <link rel="stylesheet" type="text/css" href="css/store.css"/>
    
</head>
<c:if test="${pagelist eq null}">
<script>
    location.href="checkServlet?op=bookinfo&index=1&authorid="+${au.authorid};
        
</script>
</c:if>
<body type="index">
<div class="au_nav">
	<div class="au_box" id="loginSign">
	 <div class="au_nav_a">
		<a href="default.jsp"  target="_blank">读书网首页</a>
		
		        |<span>${au.authorname}</span>|
		        
		        <a  href="checkServlet?op=tuichu">退出</a>
	 </div>
	 <a href="default.jsp"><img src="images/logo.png"></a>
	</div>
  </div>
 

	<div class="au_head">
	 <div class="au_box">
		<div class="au_pic" style="margin-left: 35px;">
		    <a href="checkServlet?op=toaddbook&authorid=${au.authorid}" title="创建新书" class="buildbook">创建新书</a>
			<div class="pic_shade"></div>
		</div>
		
		<div class="au_intro">
			<div class="au_name">
		
			</div>
			
			</div>
			
		</div>
	</div>
	<div class="au_box content">
		<div class="con_nav">
			<a href="/author/announce" class="fr voice"><em class="auico warn"></em>网站公告</a> 
			<a href="javascript:;" onclick="zuopin()"><span class="focus">作品库</span> </a>
			<a href="javascript:;" onclick="choulao()"><span >稿酬查询</span> </a>
		</div>
		<div class="con">
			<div class="con paylist" style="display: none;" id="choulao">
        
        	<table style="width: 700px; border: 2px;margin-top: 10px;margin-left: 150px;" >
        	<tr>
        	<td style="font-size: 15px; font: bold;">您当前的书卷：${author.authorprice}</td>
        	<td style="font-size: 15px; color: red" >请选择要兑换的金额： 10:1   10书卷=1元</td>	
        	</tr>
        	<tr>
        	<td colspan="2">
        	<em style="margin-right: 255px;">10元&nbsp;&nbsp;<input type="radio" name="ra" value="10" class="pub_ico au_pointer"></em>
        	<em style="margin-right: 200px;">20元&nbsp;&nbsp;<input type="radio" name="ra" value="20" class="pub_ico au_pointer"></em>
        	<em>50元&nbsp;&nbsp;<input type="radio" name="ra" value="50" class="pub_ico au_pointer"></em>
        	</td>
        	</tr>
        	<tr>
        	 	<td colspan="2">
        	<em style="margin-right: 245px;">100元&nbsp;&nbsp;<input type="radio" name="ra" value="100" class="pub_ico au_pointer"></em>
        	<em style="margin-right: 195px;">200元&nbsp;&nbsp;<input type="radio" name="ra" value="200" class="pub_ico au_pointer"></em>
        	<em>300元&nbsp;&nbsp;<input type="radio" name="ra" value="300" class="pub_ico au_pointer"></em>
        	
        	</td>
        	
        	</tr>
        	
        	
        	<tr style="font-size:15px;">
        	
        	<td colspan="2">兑换的id：${author.authorid}&nbsp;</td>
        	</tr>
       
       <tr>
       <td colspan="2"><input type="button" value="确定兑换" onclick="duihuan()"/></td>
       </tr>
       
        	
        	
        	</table>
       </div>
			<div class="booklist" id="booklist">
			<ul>
			
			   
			       
					
				
					<c:forEach items="${pagelist.list }" var="n">

					<li>
					<div class="bookinfo">
					  
					     <img  class="booklink"  src="${n.images}"  />
					  
						<h2><a href="checkServlet?op=toupdatenovel&bookid=${n.bookid}">${n.bookname }</a>
						<em class="number">图书编号：${n.bookid }</em>
						 <em class="number">字数：${n.booknumber }</em>
						 <em class="number">点赞数:${n.clicks }</em>
							   
							
						</h2>
						<div class="lastchapter">
						<em>是否收费:</em>
						<em>${n.ischarge}</em>
					
					  
						</div>
						
			
						<div class="bookstate state_blur">
							<em>小说状态：</em>
							<em>${n.bookstate}</em>
							
						</div>
					

                        <!--是否出现签约流程链接-->
                        <div class="color_link">
				<a href="checkServlet?op=toaddchapter&bookid=${n.bookid}&authorid=${au.authorid}&bookname=${n.bookname}"><em style="=background-color:#1ABC9C ; border:1px solid green;font-size: 15px;border-radius: 5px/3px">添加章节</em></a>	  			
                            
                                
                        </div>

<c:choose>
<c:when test="${n.bookstate eq'连载'}">
 <div class="book_btns">
						 <a href="checkServlet?op=toupdatebook&bookid=${n.bookid }" class="edit">
						 编辑章节
						 </a> 
						 
						 
						  
						</div>
</c:when>
<c:otherwise>


</c:otherwise>
</c:choose>
                       
					</div>
					</li>
					</c:forEach>
					
			
			</ul>
			</div>
			
			    
			<div class="pagenumber" id="pagenumber">总计<em>&nbsp;【${pagelist.totalpage}页】&nbsp;</em>记录<a href="checkServlet?op=bookinfo&index=${pagelist.indexpage-1}&authorid=${au.authorid}">上一页</a>
			<a href="checkServlet?op=bookinfo&index=1&authorid=${au.authorid}" class="now">1</a>
			<a href="checkServlet?op=bookinfo&index=${pagelist.indexpage+1}&authorid=${au.authorid}">下一页</a>&nbsp;&nbsp;至第
			<input type="text" id="toPage" name="toPage" value="1" size="3" />页&nbsp;
		<input type="button" class="submit"  onclick="appointPage(1)" value="跳转"/></div>
	   
	  </div>
	</div>
	
<div class="footer">
	<div class="au_box">
		<p>
			Copyright<em>©</em>2008-2010 www.zongheng.com All Rights Reserved
		</p>
		<p>版权所有 徐州看书网络技术有限公司</p>
	</div>
</div>
</body>
<script src="js/jquery-1.12.4.js"></script>
<script>
function appointPage(){
 var  index=$("#toPage").val();
 if(isNaN(index))
  {
	  alert("请输入正确的页数！");
	 
  }else{
	location.href="checkServlet?op=bookinfo&index="+index+"&authorid="+${au.authorid};
  }
}


function choulao(){
$("#choulao").show();
$("#booklist").hide();
$("#pagenumber").hide();
}


function zuopin(){
$("#choulao").hide();
$("#booklist").show();
$("#pagenumber").show();
}
function duihuan()
{
if(confirm("确定要兑换吗？"))
{
var price=$('input:radio:checked').val();
   var prices=price*10;
$.post(
"checkServlet",
"op=duihuan&authorid="+${au.authorid}+"&price="+prices,
function(r)
{
  if(r.r=="1")
  {
  alert("兑换成功！");
  }else{
  alert("余额不足，兑换失败！");
  }
}

,"json");
}

}
</script>