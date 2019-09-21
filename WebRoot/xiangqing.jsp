<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html id="html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>${list.novel.bookname}-起纵看书网</title>
    <meta name="keywords" content="玄幻小说,武侠小说,都市小说,历史小说,网络小说,言情小说,青春小说">
    <meta name="description" content="小说阅读,精彩小说尽在看书网.看书网,小说,小说网,网络小说,小说下载,小说txt,小说全文阅读,原创网络文学,畅销图书,精品图书,传统出版,电子书,在线阅读">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no"/>
    <!--[if IE]><script src="//img.kanshu.com/2013/uks/js/library/html5.min.js?version=19.604.14"></script><![endif]-->
    <link rel="stylesheet" href="css/base.min.css">

    
    <link rel="shortcut icon" href="//img.kanshu.com/2013/uks/images/favicon.ico" type="image/x-icon" />
    <script src="//img.kanshu.com/2013/uks/js/library/jquery/jquery.js?version=19.604.14"></script>
</head>
<body class="yueduye" id="yueduye"><!-- 女生样式 -->
<!-- 主体内容 -->


<header class="headerBox">
    <div class="mainBody clearfix">
       
        <div class="rightBox fr">

            <div class="searchBox">
                <form id="sereachForm" action="checkServlet?op=searchlikebook" method="get">
                    <input id="keywords" name="bookname" type="text" class="txt" placeholder="" value="">
                    <button id="sereachSubmit" type="submit" class="searchBtn">搜索</button>
                </form>
            </div>
                            <a href="javascript:void();" class="loginBtn btn">登录</a>
                <a href="https://www.kanshu.com/new/user/pcRegister" class="registorBtn btn line">注册</a>
                    </div>
    </div>
</header>

<!-- 主体内容 -->

<section class="pageBox">

    <div class="bodyBox mainBody">

        <input type="hidden" value="300" id="month_coin"/>

        <!-- 阅读页主体 -->

        <div class="readBox"  id="readBox"><!-- 设置页面宽度 -->

            <!-- 设置容器 -->

            <div class="settingBox" style="position:fixed;top:80px;left:80px;z-index:99;">

                <div class="item" id="muluBox">

                    <div class="label" id="muluBox">目录</div>

                    <div class="con muluBox" id="settingBox">

                        <div class="tempBox1">

                            <div class="tempBox">

                                <div class="closeBtn" data-hide=".muluBox">关闭</div>

                                <div class="title">目录&nbsp;(横向排行)
                                
                                <!--  <span class="btn btn_desc" onclick="chapterDirectory(2);">倒序</span><span

                                            class="btn btn_asc" onclick="chapterDirectory(1);">顺序</span>--></div>


      
                                <div class="clearfix mlTBox" id="mlTBox">
                             
           		   <c:forEach items="${listchapter}" var="lc">
                     <span style="margin-left: 10px; margin-right: 25px;"><a href="javascript:;"  onclick="tochapterinfo(${lc.chapterid},${lc.novel.bookid})">${lc.chaptertitle}</a></span> 
          </c:forEach>
        
                               </div>

                            </div>

                        </div>

                    </div>

                </div>

                <div class="item" id="shezhibox">

                    <div class="label">设置</div>

                    <div class="con shezhiBox"   id="conshezhibox">

                        <div class="tempBox1">

                            <div class="tempBox">

                                <div class="closeBtn" data-hide=".shezhiBox">关闭</div>

                                <div class="title">设置</div>

                                <div class="lists">

                                    <div class="item clearfix" data-title="阅读主题">

                                        <span class="bg bg1" data-class="bg1" onclick="bck1()"></span>

                                        <span class="bg bg2" data-class="bg2" onclick="bck2()"></span>

                                        <span class="bg bg3" data-class="bg3"  onclick="bck3()"></span>

                                        <span class="bg bg4" data-class="bg4" onclick="bck4()" ></span>

                                        <span class="bg bg5" data-class="bg5"  onclick="bck5()"></span>
                                        

                                    </div>

                                    <div class="item clearfix" data-title="字体大小">

                                        <span class="font add" data-font="add" onclick="fontjia()">A+</span>

                                        <span class="font curFont" id="fontsize">18</span>

                                        <span class="font reduce" data-font="reduce" onclick="fontjian()">A-</span>

                                    </div>

                                    <div class="item clearfix" data-title="字体颜色">

                                       <a href="#" onclick="bianbai()"><span style="margin-left: 20px; margin-right: 20px;">白色</span></a> 

                                        <a href="#" onclick="bianhei()"><span >黑色</span></a>

                                        

                                    </div>


                               


                                </div>

                            </div>

                        </div>

                    </div>

                </div>

                <div class="item">


                </div>

                <div class="item">

                    <a href="javascript:;" class="label" onclick="onclicks(${list.novel.bookid})">点赞</a>

                </div>

                <div class="item">
				
	                 <a href="javascript:;" class="label" id="collect" onclick="addshujia(${list.novel.bookid})">收藏本书</a>
				
	            </div>

            </div>

            <div class="box1 clearfix" >
            <span class="item"><a href="/">首页</a></span>
            <span class="item"><a href="#">${list.novel.bookname}</a></span>
            <span class="item">阅读页</span></div>

            <!-- 书籍信息 -->

                            <div class="bookInfoBox" id="bookInfoBox">

                    <div class="emptyBox1"></div>

                    <div class="emptyBox2"></div>

                    <div class="tempBox clearfix">

                        <div class="imgBox"><img src="${list.novel.images}" class="img" alt=""></div>

                        <div class="conBox">

                            <div class="title1">

                                <span>${list.novel.bookname}</span>${list.author.authorname}

                            </div>

                            <div class="labels clearfix">

                                <span>${list.novel.bookstate}</span><span>${list.novel.booktitle}</span><span>VIP</span>

                            </div>

                            <div class="otherInfo clearfix">

                                <div class="item"><span>${list.novel.booknumber}</span>字</div>

                                <div class="item"><span>${list.novel.clicks }</span>总点击</div>

                            

                            </div>

                        </div>

                    </div>

                </div>

                        <!-- 章节内容 -->

            <div class="contentBox" id="contentBox">

                <div class="emptyBox1"></div>

                <div class="emptyBox2"></div>

                <div class="commonTempBox">

                    <div class="title">${list.chaptertitle }</div>

                    <div class="tempcontentBox nopay" id="tempcontentBox">

                        <!-- noPay:vip收费章节时 -->
                
                     <textarea id="chaptercontent"  style="width: 760px; overflow:hidden; resize:none;border-style:none;background:transparent;height: 3700px;" readonly="readonly"> 
                      

                     </textarea>
               </div>

            </div>
			
			
			
		
        </div>


    </div>
<!-- 底部 -->

<footer class="footerBox tc">
   
    <div class="mainBody clearfix">
        <div>Copyright (C) 2004-2013 看书网 All Rights Reserved</div>
        <div>成都古羌科技有限公司 版权所有</div>
        <div>看书网-阅读网站</div>
        <div><a target="_blank" href="http://www.miibeian.gov.cn/">蜀ICP备14011046号</a>&nbsp;&nbsp;&nbsp;&nbsp;电信增值业务许可证：川B2-20100073</a></div>

        <div>网络文化经营许可证：川网文[2011]0207-6号&nbsp;&nbsp;&nbsp;&nbsp;</div>

        <div>请所有作者发布作品时务必遵守国家互联网信息管理办法规定，我们拒绝任何色情小说，一经发现，即作删除！</div>
        <div>本站所收录的作品、用户上传内容等均属用户个人行为。如前述内容侵害您的权益，欢迎举报投诉，一经核实，立即删除，本站不承担任何责任</div>
       
    </div>
</footer>
<script data-main="//img.kanshu.com/2013/uks/js/project/support/config.js?version=19.604.15" src="//img.kanshu.com/2013/uks/js/require-2.2.0.js?version=19.604.15"></script>
<!--站长统计-->
<!--  <div style="display:none">
    <script type="text/javascript" src="https://s5.cnzz.com/z_stat.php?id=1277738181&web_id=1277738181"></script>
</div>
-->
</body>
</html>
<script src="js/jquery-1.12.4.js"></script>
   <script>
   $(function(){
	   
 
       initData();
       
       
       
       
       
       
       
       
       
       
       
       
       
       
     //定位
 /*  var advertop = parseInt($("#settingBox").css("top"));

   	var adverleft = parseInt($("#settingBox").css("left"));

   	$(window).scroll(function() {

   		var scrolltop = parseInt($(this).scrollTop()); //获取滚动条下去的距离
   		var scrollleft = parseInt($(this).scrollLeft()); //获取滚动条向右的距离

   		$("#settingBox").offset({ top: scrolltop + advertop });
   		$("#settingBox").offset({ left: scrollleft + adverleft });
   	});
     */
             
   });

   function initData(){
	   
   $.ajax({
       "url" :"checkServlet",
        "type":"post",
        "data":"op=searchchapter&chapterid="+${list.chapterid}+"&bookid="+${list.novel.bookid}+"&authorid="+${au.authorid},
        "datatype":"json",
         "global":"false",
        "success":function(r){
        $("#chaptercontent").val(r);
      }
      
     
       });
      
   };
   
   
   function changechapterid(chapterid){
	   $.ajax({
	       "url" :"checkServlet",
	        "type":"post",
	        "data":"op=searchchapter&chapterid="+chapterid+"&bookid="+${list.novel.bookid},
	        "datatype":"json",
	         "global":"false",
	        "success":function(r){
	        	 $("#chaptercontent").html();
	        $("#chaptercontent").html(r);
	      }
	      
	     
	       });
	   
	   
   }

   
   
   //字体变色
   function bianbai()
   {
	   
	   $("#chaptercontent").css("color","white");
   }
   
   function bianhei()
   {
	   
	   $("#chaptercontent").css("color","#000");
   }
   
   function fontjia()
   {
	   
	   var size=parseInt($("#fontsize").html())+1;
	  if(size>20)
	  {
		  alert("不能再大了!");
		  return false;
	  }
	  $("#fontsize").html(size);
	  $("#tempcontentBox").css("font-size",size);
	  
   }
   
   
   function fontjian()
   {
	   
	   var size=parseInt($("#fontsize").html())-1;
	  if(size<15)
	  {
		  alert("不能再小!");
		  return false;
	  }
	  $("#fontsize").html(size);
	  $("#tempcontentBox").css("font-size",size);
   }
   
   //更换颜色
  function bck1() {
  $("#yueduye").css("background-color","#EDDFCB");
}  
   
   function bck2() {
	   $("#yueduye").css("background-color","#D2E4CF");
	   
	 }  
   
   

   function bck3() {
   $("#yueduye").css("background-color","#D8EAEA");
 }  
    
    function bck4() {
 	   $("#yueduye").css("background-color","#F6E7E6");
 	 }  
   
   
   

    function bck5() {
 	   $("#yueduye").css("background-color","#000");
 	 }  
   
   
   $("#shezhibox").hover(function(){
	
		$("#conshezhibox").show("slow");
	},
	function(){

		$("#conshezhibox").hide("fast");
	});
	
   
   
   
   
   
   
   
   $("#muluBox").hover(function(){
		
		$("#settingBox").show("slow");
	},
	function(){

		$("#settingBox").hide("fast");
	});
   
   
   
   $("#mlTBox a").hover(function(){
		
	   $(this).css("color","red");
	},function(){

		 $(this).css("color","black");
	});;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//加入收藏
	function  addshujia(bookid){
	$.post(
	 "checkServlet",
	 "op=toaddcollection&bookid="+bookid+"&authorid="+${au.authorid},
	  function(r)
	  {
		 if(r.r=="1")
		 {
			 alert("收藏失败,已经收藏过啦!");
			
		 }else{
			 $.post(
			 "checkServlet",
			  "op=addcollection&bookid="+bookid+"&authorid="+${au.authorid}, 
			 function(rs)
			 {
				 if(rs.r=="1")
				 {
				alert("收藏成功！");
				 }
				 },"json");
			 }
			  
		 }
	  
	,"json");
	
	}
	
	
	//给次数点赞
	function onclicks(bookid)
	{
		
		$.post(
				 "checkServlet",
				 "op=updateclicks&bookid="+bookid+"&authorid="+${au.authorid},
				  function(r)
				  {
					 if(r.r=="1")
					 {
						 alert("点赞成功!");
						
					 }else{
						 alert("点赞失败!");
					 }
				  }
				,"json");
				
		
		
	}
   
	
	
	function tochapterinfo(chapterid,bookid)
	 {
		 
		 $.post(
		"checkServlet",
			"op=checkischarges&bookid="+bookid+"&chapterid="+chapterid+"&authorid="+${au.authorid},
					 function(r)
						{
						if(r.r=="0")
						{
							if(confirm("本章节需要付费您还未购买！是否要购买？")){
								
								$.post(
										"checkServlet",
										"op=buychapters&bookid="+bookid+"&chapterid="+chapterid+"&authorid="+${au.authorid},
										function(rs)
										{
											if(rs.rs=="1")
											{
												alert("您的书卷不足，无法进行购买！");
											}else{
												alert("购买成功！");
											}
										}
								,"json");
							}
							
						}else{
							location.href="checkServlet?op=tochapterinfo&chapterid="+chapterid+"&bookid="+bookid+"&authorid="+${au.authorid};
						}
						
						},"json");
		 
	 }
                   </script>