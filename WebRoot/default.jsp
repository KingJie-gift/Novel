<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>起纵看书网 - 原创小说网站,(最新)小说免费阅读下载 好看的小说阅读网!</title><meta name="keywords" content="小说,小说阅读网,小说网" /><meta name="description" content="看书网,专业原创小说网站,提供最新言情,都市校园,穿越,网游,玄幻,武侠,科幻,历史等小说免费阅读和小说下载,是最好看的小说阅读网。看小说,就上看书网！" />
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" href="css/basic.min.css" />
    <link rel="stylesheet" href="css/search.min.css"/>
    <link rel="stylesheet" href="css/store.css" />
</head>
<c:if test="${numberlist eq null}">
<script>
location.href="checkServlet?op=defaullt";
</script>
</c:if>
<body>
	<!-- 未登录 -->
	<div class="menuTop">
		<div class="clearfix container">
			<div class="fl clearfix">
				<a href="#" target="_blank">客户端下载</a>
				<a id="StranLink" name="StranLink" href="javascript:StranBody()" title="繁体版">
                        繁体版
                    </a>
				<a href="#">免费小说</a>
				<a href="#">包月作品</a>
				<a href="#">手机阅读</a>
			</div>
			
			
			
			
		
			
	
			
		<div class="fr clearfix">
		<c:choose>
		
		<c:when test="${au eq null}">
		<a href="denglu.jsp" class="active">登录</a>
				<a href="zhuce.jsp">注册</a>
		</c:when>
				<c:otherwise>
				
			
					<a href="">你好，'${au.authorname } '</a>
					<a href="checkServlet?op=toupdate&authorid=${au.authorid}">修改密码 </a>
					<a href="checkServlet?op=tuichu">退出登录</a>
				
				</c:otherwise>
		</c:choose>
			</div>
			
	       	   
	
			
			
	
		</div>
	</div>
	
	<div class="container">
		<div class="headBox clearfix">
			
			<div class="searchBox clearfix">
				<form action="checkServlet?op=searchlikebook" method="post">
					<input type="text" class="fl txt" name="bookname" id="search_txt" placeholder="搜书、搜人" >
					<input type="submit" class="sub_btn" name="" value="" id="search_btn" >
					</form>
		         <div></div>
			</div>
		</div>
		<div class="menuBox clearfix">
		
			<nav class="menu fl clearfix" >
			
				<a href="javascript:;" title="完本"  onclick="wan()"   ondblclick="dwan()" style="margin-left: 390px;">完本</a>
				<a href="javascript:;" onclick="zuojiazhuanqu()">作者专区</a>
				<a href="checkServlet?op=searchlikebook" title="小说排行榜">排行</a>
			
				
			</nav>
		
		</div>
		<div class="contentBox clearfix" id="toubu">
			<div class="types fl" style="height: 700px;">
					<c:set var="sum" value="0"></c:set>
					<div class="recommend fr" style="margin-top: 40px;">
				<div class="title">字数排行</div>
				<c:forEach items="${numberlist}" var="nl">
				<ul>
					<li class="text-overflow clearfix">
			<a href="checkServlet?op=searchbookinfo&bookid=${nl.bookid}" target="_blank">
			<span class="fl"><c:set value="${sum+1}" var="sum" /> ${sum}</span>
			<div class="scal"><img class="fl"  src="${nl.images}"class="bookShadow"/></div>
		        <div class="fl bookContent">
			<div class="bookName text-overflow">${nl.bookname}</div>
			<div class="bookType text-overflow">${nl.type.booktype}</div>
		        <div class="bookAuthor text-overflow">${nl.author.authorname}</div>
			</div>
			
		</a>
		
	</li>
				</ul>
	</c:forEach>
			</div>
			</div>
			<div class="recommend fr" style="margin-top: 20px;">
					<c:set var="sum" value="0"></c:set>
				<div class="title">最新发布</div>
				<c:forEach items="${newlist}" var="wl">
				<ul>
					<li class="text-overflow clearfix">
			<a href="http://www.kanshu.com/artinfo/168915.html" target="_blank">
			<span class="fl"><c:set value="${sum+1}" var="sum" /> ${sum}</span>
			<div class="scal"><img class="fl" src="${wl.images}" class="bookShadow"/></div>
		        <div class="fl bookContent">
			<div class="bookName text-overflow">${wl.bookname}</div>
			<div class="bookType text-overflow">${wl.type.booktype}</div>
		        <div class="bookAuthor text-overflow">${wl.author.authorname}</div>
			</div>
		</a>
	</li>
				</ul>
				</c:forEach>
			</div>
			
			
			<div class="books">
				
					<div id="bb-bookblock" class="bb-bookblock" data-slide>
							<div class="bb-item"><a href="https://www.kanshu.com/artinfo/2064143.html" target="_blank"><img src="picture/15658372263730.jpg"/></a></div>
	       <div class="bb-item"><a href="http://news.kanshu.com/zt/fuli/2017/channel_male.html" target="_blank"><img src="picture/15639621128575.jpg"/></a></div>
	       <div class="bb-item"><a href="https://www.kanshu.com/artinfo/24884.html" target="_blank"><img src="picture/15635570113098.jpg"/></a></div>
					</div>

				<div class="sexBox">
					<a href="javascript:void(0);" data-click data-par="sexBox" data-com="nannv" data-class="nansheng" class="sexL active fw">男生</a>
					<a href="javascript:void(0);" data-click data-par="sexBox" data-com="nannv" data-class="nvsheng" class="sexL woman fw">女生</a>
					<div class="changeBox">
						<div class="nannv nansheng clearfix"><div class="bookInfo clearfix">
			<a href="http://www.kanshu.com/artinfo/91794.html" target="_blank"><div class="scal"><img src="picture/91794s.jpg" onerror="javascript:this.src='http://img.kanshu.com/articleInfo/images/nopic.jpg'"  class="fl bookShadow"/></div></a>
			<div class="infoDetail">
			<div class="bookName text-overflow"><a href="http://www.kanshu.com/artinfo/91794.html" target="_blank">绝世狂神</a></div>
			<div class="detail">一个卑微的生灵，降落神荒大陆。他是废物？是可悲的生命？
不，他是王！神荒主宰！
陆家身份低微的少年陆云，因为一次变故，彻底改变命运，至此走上神荒大陆至强的崛起之路。
陆云说：“我狂！正因为我强！”
无尽新奇的神器，诡异狰狞的妖兽，千种功法，万种武技，宗派间的恩怨，一切尽在《绝世狂神》！</div><div class="readNum clearfix"><div class="fl num">75861708人追读</div>
			<a href="http://www.kanshu.com/artinfo/91794.html" class="fr brown" target="_blank">免费试读</a>
			</div>
			</div>
			</div><div class="bookInfo clearfix">
			<a href="http://www.kanshu.com/artinfo/76234.html" target="_blank"><div class="scal"><img src="picture/76234s.jpg" onerror="javascript:this.src='http://img.kanshu.com/articleInfo/images/nopic.jpg'"  class="fl bookShadow"/></div></a>
			<div class="infoDetail">
			<div class="bookName text-overflow"><a href="http://www.kanshu.com/artinfo/76234.html" target="_blank">蛮荒大帝</a></div>
			<div class="detail">蛮荒少年秦威，无意中获得上古残缺令牌，得到神通传承，修炼无敌功法，走上逆天强者之路。自始携美纵横，若挡我道路，杀之，若触我逆鳞，屠尽，坐拥万花丛中独领风骚，战天斗地，傲视四合八荒！</div><div class="readNum clearfix"><div class="fl num">84644159人追读</div>
			<a href="http://www.kanshu.com/artinfo/76234.html" class="fr brown" target="_blank">免费试读</a>
			</div>
			</div>
			</div></div><div class="nannv nvsheng clearfix nodis"><div class="bookInfo clearfix">
			<a href="http://www.kanshu.com/artinfo/48522.html" target="_blank"><div class="scal"><img src="picture/48522s.jpg" onerror="javascript:this.src='http://img.kanshu.com/articleInfo/images/nopic.jpg'"  class="fl bookShadow"/></div></a>
			<div class="infoDetail">
			<div class="bookName text-overflow"><a href="http://www.kanshu.com/artinfo/48522.html" target="_blank">凤唳九天</a></div>
			<div class="detail">她看似痴傻，却遇神杀神，遇佛弑佛，扮猪吃老虎！除了狠毒嫡母，宰了蛇蝎嫡姐，吓傻了无情父亲，气死了腹黑皇帝。
终于可以逍遥离开，后面却跟了一堆痴情美男，这么多尾巴，怎么甩掉啊！</div><div class="readNum clearfix"><div class="fl num">4647063人追读</div>
			<a href="http://www.kanshu.com/artinfo/48522.html" class="fr brown" target="_blank">免费试读</a>
			</div>
			</div>
			</div><div class="bookInfo clearfix">
			<a href="http://www.kanshu.com/artinfo/165221.html" target="_blank"><div class="scal"><img src="picture/165221s.jpg" onerror="javascript:this.src='http://img.kanshu.com/articleInfo/images/nopic.jpg'"  class="fl bookShadow"/></div></a>
			<div class="infoDetail">
			<div class="bookName text-overflow"><a href="http://www.kanshu.com/artinfo/165221.html" target="_blank">农女种田忙</a></div>
			<div class="detail">赶潮流穿越？醉了！
穿越到农家？醉了！
刚穿越来就被退了婚？醉了！
双亲早亡，亲戚欺负？醉了！
抢占田产，说要养钱？醉了！
醉了醉了全都醉了！
徐苗怎么都没想到，好端端的出趟差，竟然就来到了这么个地方，姥姥不疼、舅舅不爱？成，既然如此，就别怪姑奶奶不客气。
翻身做主人，种田做生意，带着弟弟、妹妹奔小康，可这又来认亲是个什么鬼？
穷在闹市无人问，富在深山有远亲？
看姑奶奶怎么收拾你们这些水蛭，哼哼！</div><div class="readNum clearfix"><div class="fl num">29637人追读</div>
			<a href="http://www.kanshu.com/artinfo/165221.html" class="fr brown" target="_blank">免费试读</a>
			</div>
			</div>
			</div></div>
					</div>
					<div class="clearfix">
						<ul class="listBox">
										
				
				
<li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2039327.html" target="_blank" title="无上神帝">无上神帝</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2039371.html" target="_blank" title="太古神尊">太古神尊</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2055972.html" target="_blank" title="超级天才狂少">超级天才狂少</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2018818.html" target="_blank" title="逍遥小神农">逍遥小神农</a></li></ul><ul class="listBox"><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2037926.html" target="_blank" title="重生之绝品狂少">重生之绝品狂少</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2040963.html" target="_blank" title="我的女总裁">我的女总裁</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2034055.html" target="_blank" title="拳圣">拳圣</a></li><li class="text-overflow"><a href="http://www.kanshu.com/artinfo/2035359.html" target="_blank" title="上古传奇">上古传奇</a></li>
					        </ul>
					</div>
				</div>
			</div>
		</div>
		
					<!-- 搜索主内容 -->
<div class="store_list_wrap" id="wanben"   style="margin-top: 20px; display: none;">
            <div class="store_collist">
            
    <c:forEach  items="${allnovel}" var="pn">
 <div class="bookbox fr"  style="margin-top: 15px;">
                    <div class="bookimg">
                        <a href="http://book.zongheng.com/book/864726.html" target="_blank">
                            <img src="${pn.images}" alt="">
                        </a>
                    </div>
                    <div class="bookinfo">
                        <div class="bookname">
                            <a href="checkServlet?op=searchbookinfo&bookid=${pn.bookid}" target="_blank">${pn.bookname}</a>
                        </div>
                        <div class="bookilnk">
                            <a href="http://home.zongheng.com/show/userInfo/50759580.html" target="_blank">${pn.author.authorname}</a>|
                            <a href="http://www.zongheng.com/category/15.html" target="_blank">${pn.type.booktype}</a>|
                            <span>
                            	
                            	${pn.bookstate}
                            
                        	</span>
                       
                        </div>
                        <div class="bookintro">${pn.bookoutline}</div>
                        <div class="bookupdate">
                            <a href="javascript:;" class="fl">字数${pn.booknumber}&nbsp;&nbsp;点赞${pn.clicks}</a>
                            <span class="rank_d_b_time"></span>
                        </div>
                      </div>
                    </div>
                        </c:forEach>
                </div>
                
</div>

		<script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/modernizr.custom.js"></script>
        <script type="text/javascript" src="js/jquery.bookblock1.js"></script>
        
	<script type="text/javascript" src="js/index18.js"></script>
</body>

	<c:if test="${au != null }">
		<p id="lo" hidden>${au.authorid}</p>
		<p id="loname" hidden>${au.authorname}</p>
	</c:if> <c:if test="${au == null }">
		<p id="lo" hidden></p>
	</c:if>

</html>
<script>
function  zuojiazhuanqu(){
	
	var authorid=$("#lo").html();
	if(authorid=="")
	{
		if(confirm("您还未登陆，无法查看此专区"))
		{
			location.href="denglu.jsp";
		}
	}else{
		
		location.href="checkServlet?op=zuojiazhuanqu&authorid="+authorid;
	}
}


function wan()
{
	  $("#wanben").show();
	  $("#toubu").hide();
	}
	
	
function dwan()
{
	  $("#wanben").hide();
	  $("#toubu").show();
	}
	
		
	
</script>