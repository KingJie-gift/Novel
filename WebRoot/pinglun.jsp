<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="玄幻小说,武侠小说,都市小说,历史小说,网络小说,言情小说,青春小说">
<meta name="description"
	content="小说阅读,精彩小说尽在看书网.看书网,小说,小说网,网络小说,小说下载,小说txt,小说全文阅读,原创网络文学,畅销图书,精品图书,传统出版,电子书,在线阅读">
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="email=no" />
<!--[if IE]><script src="//img.kanshu.com/2013/uks/js/li
    brary/html5.min.js?version=19.604.14"></script><![endif]-->
<link rel="stylesheet" href="css/base.min.css">
<script
	src="js/jquery.js"></script>
</head>
<body class="">
	<header class="headerBox">
    <div class="mainBody clearfix">
       
        <div class="rightBox fr">

            <div class="searchBox">
                <form id="sereachForm" action="checkServlet?op=searchlikebook" method="get">
                    <input id="keywords" name="keys" type="text" class="txt" placeholder="" value="">
                    <button id="sereachSubmit" type="submit" class="searchBtn">搜索</button>
                </form>
            </div>
                            <a href="denglu.jsp" class="loginBtn btn">登录</a>
                <a href="zhuce.jsp" class="registorBtn btn line">注册</a>
                    </div>
    </div>
</header>
		<section class="xiangqingBody commonHeader2Box bgImg3 pageBox">
			
			<!-- bgImg3:男频 bgImg4:女频 -->
			<div class="bodyBox mainBody clearfix">
				<!-- 搜索导航 -->
				<div class="searchHeader commonHeader2">
					<div class="box1 clearfix">
						<a href="default.jsp"><span class="item">首页</span></a><span class="item">书籍详情</span>
					</div>
					<form id="sereachForm_info" action="checkServlet?op=searchlikebook"
						method="get">
						<div class="box2">
							<input name="bookname" type="text" placeholder=""
								class="txt_input" id="keywords_info" />
							<button type="submit" id="sereachSubmit_info" class="searchBtn">搜索</button>
						</div>
					</form>
				</div>
				<div class="clearfix xiangqingBox">
					<div class="bookBox clearfix">
	<input type="hidden" value="2059477" id="book_id" /> <input type="hidden"
		value="战皇" id="book_name" /> <input type="hidden" value="0"
		id="month_coin" />
		
		
	<c:if test="${au != null }">
		<p id="lo" hidden>${au.authorid}</p>
		<p id="loname" hidden>${au.authorname}</p>
	</c:if> <c:if test="${au == null }">
		<p id="lo" hidden></p>
	</c:if>
	
	
	<c:forEach items="${listnovel}" var="ln">
	<input type="hidden" id="bookid" value="${ln.bookid}">
	<div class="imgBox">
	  <title>看书网--${ln.bookname}</title>
		<img src="${ln.images}"
			onerror="this.src='//img.kanshu.com/articleInfo/images/nopic.jpg'" class="bookImg" alt="">
	</div>

	<div class="conBox">
	
		<div class="author text-overflow">
			<span>${ln.bookname }</span>${ln.author.authorname}&nbsp;著
		</div>
		<div class="labels clearfix">
			<span>${ln.bookstate }</span><span>${ln.type.booktype}</span> <span>${ln.ischarge}</span>
		</div>
		<div class="detailInfo" data-before="2"><p>${ln.bookoutline}</p></div>
		<div class="otherInfo clearfix">
			<div class="item">
				<span><span style="font-size: 15px;color:#9999B3">字数&nbsp;</span>${ln.booknumber}</span>
			</div>
			<div class="item">
				<span>${ln.clicks}</span>总点击
			</div>
		</div>
		<div class="btns clearfix">
		
			<a href="javascript:;"
				class="btn readBtn active" onclick="readering(${ln.bookid},${au.authorid})">立即阅读</a> <a href="javascript:;"
				class="btn addBtn" id="faddstrack" onclick="addStrack(${ln.bookid})">加入书架</a>
			
		</div>
	</div>

</div>
<!--  <script type="text/javascript" src="js/kanshu.js" charset="UTF-8"></script>-->
					<div class="box1 clearfix">
						<div class="flBox" data-show="zxzjBox">
							<div class="titles clearfix">
								<span data-box="zxzjBox" class="item active" id="active">作者寄语</span> <span
									data-box="muluBox" class="item" id="items">目录</span>
									
							</div>
							<div class="zxzjBox" id="flBox">
								<div class="newArticle text-overflow"
									data-date="">
									作者寄语</div>
								<div>
									${ln.sendword}
								</div>
								
									
								<div class="labels clearfix">
									<label for="">作者自定义标签</label><span>${ln.booktitle}</span></div>
									</c:forEach>
								<div class="title1">粉丝互动</div>
								<div class="list1 clearfix" id="book_data_fr"></div>

							<div class="title1 clearfix">
							评论专区
							<div class="sendBtn" onclick="sendComment()">发表评论</div>

						     </div>
								<div class="pinglunList" id="list"></div>
									<textarea class="pltext" id="pltext" rows="10" cols="112"></textarea>
							<div id="pl"></div>
							<p style=" text-align:center;">
								<c:forEach var="i" begin="1" end="${tpage }">
									<span onclick="fen(${i},${ln.bookid})"> &nbsp; ${i} &nbsp; </span>
								</c:forEach>
							</p>
							</div>
							<div class="muluBox" id="muluBox">
								<div class=" list clearfix">
								<c:forEach items="${listchapter}" var="lc">
								<a href="javascript:;"  onclick="tochapterinfo(${lc.chapterid},${lc.novel.bookid},${au.authorid})" class="item text-overflow">${lc.chaptertitle}<span style="margin-left: 5px;font-size: 10px;"><c:if test="${lc.chapterprice !=0}">[${lc.chapterprice}书卷]</c:if></span></a>
									</c:forEach>

								</div>
							</div>
							
						</div>
						<div class="frBox">
							<!-- 作家介绍 -->
							<div class="boxItem" data-name="作家介绍">
							
								
									<div class="txt"></div>
									<div class="desc"></div>
						
								<div class="title1 clearfix">
									其他作品： <a
										href="https://www.kanshu.com/bookrack/myBooklist/108791438"
										class="moreBtn fr">查看更多&gt;&gt;</a>

								</div>
								 																<div class="tempbookBox">
									<div class="bookImg">
										<a href="/artinfo/2055144.html"><img
											src="picture/xiushenzhe.jpg"
											class="img" alt=""></a>
									</div>
									<div class="bookName text-overflow">修神者</div>
									<div class="bookDesc"></div>
									<a href="javascript:;" id="saddstrack_2055144"
										class="addBtn" onclick="addStrack(2055144,2)">加入书架</a>
									<script type="text/javascript">
                      bookrack(2055144,2);
                      </script>
								</div>
																																<div class="tempbookBox">
									<div class="bookImg">
										<a href="/artinfo/2055141.html"><img
											src="picture/wangpaixianren.jpg"
											class="img" alt=""></a>
									</div>
									<div class="bookName text-overflow">王牌线人</div>
									<div class="bookDesc"></div>
									<a href="javascript:;" id="saddstrack_2055141"
										class="addBtn" onclick="addStrack(2055141,2)">加入书架</a>
									<script type="text/javascript">
                      bookrack(2055141,2);
                      </script>
								</div>
																																<div class="tempbookBox">
									<div class="bookImg">
										<a href="/artinfo/2025943.html"><img
											src="picture/lieguo.jpg"
											class="img" alt=""></a>
									</div>
									<div class="bookName text-overflow">列国</div>
									<div class="bookDesc"></div>
									<a href="javascript:;" id="saddstrack_2025943"
										class="addBtn" onclick="addStrack(2025943,2)">加入书架</a>
									<script type="text/javascript">
                      bookrack(2025943,2);
                      </script>
								</div>
																																<div class="tempbookBox">
									<div class="bookImg">
										<a href="/artinfo/165239.html"><img
											src="picture/jiantianzi.jpg"
											class="img" alt=""></a>
									</div>
									<div class="bookName tex-overflow">剑天子</div>
									<div class="bookDesc"></div>
									<a href="javascript:;" id="saddstrack_165239"
										class="addBtn" onclick="addStrack(165239,2)">加入书架</a>
									<script type="text/javascript">
                      bookrack(165239,2);
                      </script>
								</div>
																																																 							</div>
							<!-- 粉丝排行榜 -->
							<div class="boxItem" id="readerDynamics">
								<script type="text/javascript">
		        $('#readerDynamics').load('/artinfo/readerDynamics', {articleid:2059477}, function(data){});
		    </script>
							</div>
							<!-- 强推榜 -->
							<div class="boxItem">
								<div class="title">强推榜</div>
								<div class="item-list"><a class="item-info" data-num="1" href="https://www.kanshu.com/artinfo/168915.html">
							
                  <div class="item-info-right"><img src="picture/168915_m.jpg" alt=""></div>
                  <div class="item-info-left">
                    <div class="desc text-overflow">剑魔</div>
                    <div class="author text-overflow">[武侠仙侠]-李小七</div>
                  </div>
                  
                </a><a href="https://www.kanshu.com/artinfo/187158.html" class="item-info text-overflow up" data-num="2">斩天</a><a href="https://www.kanshu.com/artinfo/2009703.html" class="item-info text-overflow up" data-num="3">凡仙</a><a href="https://www.kanshu.com/artinfo/2059548.html" class="item-info text-overflow up" data-num="4">斗易</a><a href="https://www.kanshu.com/artinfo/76234.html" class="item-info text-overflow up" data-num="5">蛮荒大帝</a><a href="https://www.kanshu.com/artinfo/179291.html" class="item-info text-overflow up" data-num="6">秘术少年</a><a href="https://www.kanshu.com/artinfo/2039899.html" class="item-info text-overflow up" data-num="7">半步帝临</a><a href="https://www.kanshu.com/artinfo/2067208.html" class="item-info text-overflow up" data-num="8">平生武帝</a><a href="https://www.kanshu.com/artinfo/19214.html" class="item-info text-overflow up" data-num="9">至尊逍遥仙</a><a href="https://www.kanshu.com/artinfo/2065225.html" class="item-info text-overflow up" data-num="10">都市小英雄</a></div>
							</div>
							</div>
						</div>
					</div>
					</div>
					<!-- 打赏投月票弹窗 -->
					<div class="ds_dialog nodis">
						<div class="ds_con">
							<div class="closeBtn" data-hide=".ds_dialog">关闭</div>
							<div class="ds_title clearfix">
								<span data-box="typBox" data-show=".typBox" data-hide=".dsBox"
									class="item active">投月票</span> <span data-box="dsBox"
									data-show=".dsBox" data-hide=".typBox" class="item ">打赏</span>
							</div>
							<div class="typBox">
								<!-- 账户内有月票 -->
								<!-- 默认有月票 bg1:无月票 bg2:投票成功 -->
								<div class="title1">
									亲，您当前拥有<span class="accountMonthTickets"></span>张月票哦
								</div>
								<div class="txt1"></div>7
								<div class="tc nodis">
									选择月票张数量：<span class="btn reduceBtn btnDef" data-tar=".showTxt">-</span><span
										class="showTxt btnDef" data-min="1" data-max="999">1</span><span
										class="btn addBtn btnDef" data-tar=".showTxt">+</span>
								</div>
								<a href="javascript:;" class="subBtn" onclick="sendTickets()">投月票</a>
							</div>
							<div class="dsBox">
								<!-- 有余额 -->
								<div class="mainBox">
									<div class="clearfix"></div>
									<div class="title1">
										账户余额<span class="accountCoin">0</span>书币,本次打赏<span>0</span>书币
									</div>
									<div class="txtBox">
										<textarea class="txt" id="rewardComment" data-changenum
											data-maxnum="300" data-cur=".numBox .num"
											placeholder="这本书太棒了，犒劳一下，希望后续更加精彩！"></textarea>
										<div class="numBox">
											<span class="num">0</span>/<span class="total">300</span>
										</div>
									</div>
									<a href="javascript:;" class="subBtn" onclick="sendCoins()">确认打赏</a>
								</div>
								<!-- 余额不足 -->
								<div class="noMoneyBox nodis">
									<div class="title">账户余额不足</div>
									<div class="txt">
										本次打赏<span></span>书币
									</div>
									<div class="txt"></div>
									<div class="btns clearfix">
										<a href="javascript:;" class="btn" onclick="payPage()">去充值</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					 
					<!-- 判断是否登录 -->
					 <footer class="footerBox tc">
    <nav class="minMainBody menuBox" style="margin-left: -30px;">
        <ul class="clearfix">
            <li><a href="http://about.kanshu.com/" target="_blank">关于我们</a></li>
            <li><a href="http://about.kanshu.com/contactus.htm" target="_blank">联系我们</a></li>
            <li><a href="#" target="_blank">加入我们</a></li>
        </ul>
    </nav>
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


</body>
</html>
<script src="js/jquery-1.12.4.js"></script>
<script>

/**
 * 发送评论
 */
function sendComment(){
		var  bookid=$("#bookid").val();
		var authorid=$("#lo").html();
		var pltext=$("#pltext").val();
		
	     if (authorid== "") {
		if (confirm("您还未登录,是否登录")) {
			window.location.href = "denglu.jsp";
		}
	} else {

			$.post(
					"checkServlet",
					"op=addpl&auid="+authorid+"&pltext="+pltext+"&bookid="+bookid,
					function(r) {
				if (r.result > 0) {
					$("#pltext").val('');
					fen(1);
				} else {
					alert("评论失败");
				}
			}, "JSON");
		
	}
}



	
$("#items").click(function(){
		$("#flBox").hide();
		$("#muluBox").show();
		$("#active").addClass("border:1px solid #e3e3e3");
		
	});
	
	

$("#active").click(function(){
		$("#flBox").show();
		$("#muluBox").hide();
		$("#items").addClass("border:1px solid #e3e3e3");
	});

 function readering(bookid,authorid)
 {
	
	$.post(
	"checkServlet",
	"op=checkischarge&bookid="+bookid+"&authorid="+authorid,
	 function(r)
		{
		if(r.r=="0")
		{
			if(confirm("本章节需要付费您还未购买！是否要购买？")){
				
				$.post(
						"checkServlet",
						"op=buychapter&bookid="+bookid+"&authorid="+authorid,
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
			location.href="checkServlet?op=readering&bookid="+bookid+"&authorid="+authorid;
		}
		
		},"json");
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 function tochapterinfo(chapterid,bookid,authorid)
 {
	 
	 $.post(
	"checkServlet",
		"op=checkischarges&bookid="+bookid+"&chapterid="+chapterid+"&authorid="+authorid,
				 function(r)
					{
					if(r.r=="0")
					{
						if(confirm("本章节需要付费您还未购买！是否要购买？")){
							
							$.post(
									"checkServlet",
									"op=buychapters&bookid="+bookid+"&chapterid="+chapterid+"&authorid="+authorid,
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
						location.href="checkServlet?op=tochapterinfo&chapterid="+chapterid+"&bookid="+bookid;
					}
					
					},"json");
	 
	 
	 
	 
	 
	 
 } 
		/**
		评论
		*/
		$(function() {
			var  bookid=$("#bookid").val();
			fen(1,bookid);
		});

		function fen(index,bookid) {

			var  bookid=$("#bookid").val();
					$.post(
							"checkServlet",
							"op=selectpl&index="+index +"&bookid="+bookid,
							function(data) {
								var list = eval(data);
								var html = "</br>";

								for (var i = 0; i < list.length; i++) {

									html += "</br><div class='item'><div class='conBox'><div class='pl_title text-overflow'><span class='ding'>"
											+ list[i].author.authorname
											+ " </br></br></span></div><div class='pl_con' data-before='2'>"
											+ list[i].content
											+ "</br></br></div><div class='clearfix other'><span>"
											+ list[i].commenttime
											+ " </span></div></div></div></br><hr>";
								}
								
								$("#pl").html(html);

							});

		}
 
		
		function addStrack(bookid){
			
			var authorid=$("#lo").html();
				$.post(
				 "checkServlet",
				 "op=toaddcollection&bookid="+bookid+"&authorid="+authorid,
				  function(r)
				  {
					 if(r.r=="1")
					 {
						 alert("收藏失败,已经收藏过啦!");
						
					 }else{
						 $.post(
						 "checkServlet",
						  "op=addcollection&bookid="+bookid+"&authorid="+authorid, 
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
		
			 	
		
</script>