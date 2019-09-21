<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>

<head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>我的书架</title>

    <link rel="stylesheet" href="css/basic.min.css" />
    <link rel="stylesheet" href="css/home.min.css" />

</head>
<body scriptSign="home">
        <div class="wrap">
<div class="head head-nologin">
            <div class="logo">
                <a href="default.jsp"><img src="images/logo.png" width="200px" ></a>
            </div>
            <div class="spcoline"></div>
            <div class="home_tit">个人中心</div>
            <div class="homenav">
                <ul>
                   
                </ul>
            </div>
            <div class="home_rbox">
                <ul>
                    <li class="home_lnk"><a href="default.jsp"><span>返回首页</span></a></li>
                    <li class="home_user"> 
                        <a href="http://home.zongheng.com/account" target="_blank"  class="ud_userTox"><span class="user-name">&nbsp;</span></a>
                        <div class="home_ulink">
                            <a href="http://home.zongheng.com/show/userInfo/51330893.html">个人主页</a>
                            <a class="ud_logout"  href="javascript:void(0)">退出</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="h20-blank"></div>
    <div class="wrap">
        <div class="hsub"  id="header">
            <div class="hsub_tab">
                <ul>
                    <li class="active"><a href="javscript:;" onclick="collection()">我的书架</a></li>
                    <li class="spline"></li>
                    <li class=""><a href="javascript:;" id="historys" onclick="history()">最近阅读</a></li>
                    <li class=""><a href="javascript:;" onclick="authorshezhi()">账户设置</a></li>
                </ul>
            </div>
        </div>
        
        
        
            <!-- 列表箱体历史记录 -->
            
        <div id="history" style="display: none;">
            <div class="h25-blank"></div>
            <div class="home_innerwrap">
                <div class="recentlist_tit listType_a">
                    <div class="catName">类别</div>
                    <div class="bookName">书名</div>
                    <div class="author">作者</div>
                    <div class="upDateChapter">上次阅读</div>
                    <div class="bookStatus">状态</div>
                    <div class="updateTime">更新时间</div>
                    <div class="ctrlBook">操作</div>
                </div>
		
	                <ul>
	                	<c:forEach items="${historylist}" var="hl">
		                    <li class="recentbookLine listType_a">
		                        <div class="catName">${hl.novel.type.booktype}</div>
		                        <div class="bookName"><a href="checkServlet?op=searchbookinfo&bookid=${hl.novel.bookid}" target="_blank" class="txtove">${hl.novel.bookname}</a>
		                    
		                        
		                  
		                       </div>
		                       
		               
		                     
		                        
		                       
		                       
		                        
		                        <div class="author"><a href="http://home.zongheng.com/show/userInfo/12775608.html" target="_blank" class="txtove">${hl.author.authorname}</a></div>
		                        <div class="upDateChapter" title=""><a href="checkServlet?op=tochapterinfo&chapterid=${hl.chapterid}&bookid=${hl.novel.bookid }" target="_blank" class="txtove">${hl.chaptertitle}</a></div>
		                        <div class="bookStatus">${hl.novel.bookstate}</div>
		                        <div class="updateTime" style="font-size: 12px;max-width: 20px;">${hl.modifytime}</div>
		                        <div class="ctrlBook">
			                        
											<span class="redbtn" data-bookId="735577" onclick="addshujia(${hl.novel.bookid})">加入书架</span>
										</div>
										</li>
										</c:forEach>
										</ul>
						</div>		
        
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
          
  <!-- 账户内容头部 -->
    <div id="ac" class="wrap" style="display: none;">
        <header class="top">
            <section class="right">
            
                <p class="name">${author.authorname}
                <i class="star"></i><i class="star"></i>
                <b class="vip vip0"></b>
           
                </p>
             
                <p class="num">
                    <span>账户余额&nbsp;&nbsp;<i>${author.authorprice}</i><i>&nbsp;书卷&nbsp;</i></span>
                </p>
                <p class="btn-iphone">
                    <a href="checkServlet?op=tochongzhi&authorid=${author.authorid}" target="_blank"><i>立即充值</i></a>
                    
                </p>
            </section>
        </header>
        <!-- 列表和分类 -->
        <nav class="account-nav">
         <i><a href="javascript:;" onclick="chongzhi()">充值记录</a></i><i><a href="javascrit:;" onclick="xiaofeijilu()">消费记录</a></i>
        </nav>
        <div class="nav-content" id="chongzhi">
        <p class="table-title"><i>充值金额</i><i style="margin-left: 150px;">充值方式</i><i>充值时间</i><i style="margin-left: 20px;">充值人id</i></p>         
   
   
   <ul>
	                	<c:forEach items="${rechargerecordlist}" var="rl">
		                    <li class="recentbookLine listType_a">
		                        <div class="catName">${rl.price}<em>书卷</em></div>
		                        <div class="author"><a href="javascript:;" target="_blank" class="txtove" style="margin-left:30px;">${rl.rechargemode}</a></div>
		                        <div class="bookStatus" style="margin-left: 15px;">${rl.rechargetime}</div>
		                        <div class="updateTime" style="font-size: 12px;margin-left: 25px;">${rl.authorid}</div>
		     
									
										</li>
										</c:forEach>
										</ul>
     
    </div>

        
           <div class="nav-content" id="xiaofeijilu" style="display: none;">
        <p class="table-title"><i>消费金额</i><i style="margin-left: 160px;">消费章节</i><i>消费时间</i><i style="margin-left: 20px;">消费人id</i></p>         
   
   
   <ul>
	                	<c:forEach items="${consumptionlist}" var="cul">
		                    <li class="recentbookLine listType_a">
		                        <div class="catName">${cul.consumptionamount}<em>书卷</em></div>
		                        <div class="author"><a href="javascript:;" target="_blank" class="updateTime"  style="margin-left: 20px;">${cul.chapter.chaptertitle}</a></div>
		                        <div class="bookStatus" style="margin-left: 15px;">${cul.consumptiontime}</div>
		                        <div class="updateTime" style="font-size: 12px;margin-left: 25px;">${au.authorid}</div>
		     
									
										</li>
										</c:forEach>
										</ul>
     
    </div>
        
        
        
        
        
        
        
        
        
        
        
        
 
     
	    
		            
		            </div>
		
		
		
		
           <!-- 主箱体 收藏的书-->
        <div class="home-main" id="collection"> 
            <div class="btntab">
                <div class="fl">
                </div>
               
            </div>
           
            <div class="home_innerwrap">
                <div class="shelf_list_tit listType_a">
                    <div class="bookSelecter"></div>
                    <div class="catName">类别</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="bookName">书名</div>
                    <div class="author">作者</div>
                    <div class="upDateChapter">内容概要</div>
                    <div class="bookMark">书签</div>
                    <div class="bookStatus">状态</div>
                    <div class="updateTime">点赞次数</div>
                    <div class="ctrlBook">操作</div>
                    
                </div>
	         	
	         	<c:forEach items="${collectionlist}" var="cl">
	         	<div id="coll">
	           <ul>	           		 
	                    <li class="shelf_bookLine listType_a" >
	                       
	                        <div class="catName"><a href="http://www.zongheng.com/category/1.html" target="_blank">${cl.type.booktype}</a></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                        <div class="bookName">
		                        <a href="http://book.zongheng.com/book/189169.html" target="_blank" class="txtove">${cl.bookname }</a>
		                        <c:if test="${cl.ischarge eq '收费'}">
		                        <em class="vip"></em>
		                        
		                        </c:if>
		                        <a href="checkServlet?op=searchbookinfo&bookid=${cl.bookid}"><em style="margin-left: 10px;background-color:#D32F2F; border:0.2px solid red;font-size: 12px;color:white; border-radius: 5px/3px">阅读此书</em></a>
	                        </div>
	                        <div class="author">${cl.author.authorname }</div>
	                        <div class="upDateChapter"><span style="width:70px;display:inline-block;">${cl.bookoutline}...</span></div>
	                        <div class="bookMark">
		                        
		                        <c:if test="${cl.booktitle eq null}">
		                        <a>无</a>
		                        </c:if>
			                         	<a>${cl.booktitle}</a>
									 
	                        </div>
	                        <div class="bookStatus">${cl.bookstate }</div>
	                        <div class="updateTime">${cl.clicks }</div>
	                        
	                        <div class="ctrlBook"><a href="javascript:;" onclick="deletecollection(${cl.bookid},this)"class="redbtn">移出书架</a></div>
	                        
	                    </li>
	                    
	                </ul>
		</div>
	                </c:forEach>
	                <div class="home_innerbot pagenumber clear"  id="shanchu">
		            
		                <div class="fl" >
		                    <label class="bookSelecter">
		                        <input type="checkbox"  autocomplete="off" class="chapter-checkbox" value="2027987">
		                        <em class="checkbox em_checked"></em>
		                       
		                    </label>
		                    
		                    <a href="javascript:;"  onclick="deleteallcollection()" class="btngry">全部删除</a>
		                    
		                </div>
		                <div class="fr">
		                   
		                    
		                </div>
		                  </div>
	              </div>
	              
	              
	              
            </div>
    <div class="h40-blank"></div>
    
    <div class="footer">
		







<div class="partlink">
    <div class="wrap">
        <div class="title">出版合作联系</div>
        <div class="clearfix">
            <div class="mail fl">
                
                <div>版权合作联系人：许先生<a href="mailto:xubin@zongheng.com">xubin@zongheng.com</a></div>
                
                <div>广告合作联系人 : 张女士<a href="mailto:zhangwen@zongheng.com">zhangwen@zongheng.com</a></div>
                
            </div>
            <div class="help-btn">
                <a class="btn" href="http://www.zongheng.com/help/index.html" target="_blank">帮助中心</a>
                <p>服务时间：24小时</p>
            </div>
            
            <div class="b1 foot-cell">
                <div class="tit">客服</div>
                <div class="qq">965151179</div>
                <div class="email"><a href="mailto:zhkf@zongheng.com">zhkf@zongheng.com</a></div>
            </div>
            <div class="b2 foot-cell">
                <div class="tit">举报</div>
                <div class="tel">4006289988</div>
                <div class="email"><a href="mailto:jubao@zongheng.com">jubao@zongheng.com</a></div>
            </div>
           
            <div class="app foot-blank">
                <div class="imgbox fl">
                    <img src="http://rcode.zongheng.com/v2018/images/app.png" alt="">
                </div>
                <p>客户端下载</p>
            </div>
            
            <div class="wchat foot-blank">
                <div class="imgbox fl">
                    <img src="http://rcode.zongheng.com/v2018/images/wx.png" alt="">
                </div>
                <p>微信公众号</p>
            </div>
        </div>
    </div>
</div>
<div class="copyright">
    <div class="links"><a href="http://www.zongheng.com/company/about.html" target="_blank">关于纵横</a>|<a href="http://www.zhwenxue.com/join" target="_blank">诚聘英才</a>|<a href="http://www.zongheng.com/company/business.html" target="_blank">商务合作</a>|<a href="http://www.zongheng.com/company/copyright.html" target="_blank">法律声明</a>|<a href="http://www.zongheng.com/help/index.html" target="_blank">帮助中心</a>|<a href="http://author.zongheng.com" target="_blank">作者投稿</a>|<a href="http://www.zongheng.com/company/contact.html" target="_blank">联系我们</a>|<a href="http://www.zongheng.com/company/link.html" target="_blank">友情链接</a>|<a href="http://news.zongheng.com/zhuanti/wlqz/index.html" target="_blank">谨防诈骗</a>|<a href="http://www.zongheng.com/company/sitemap.html" target="_blank">网站地图</a></div>
    <p>Copyright©<a href="http://www.zongheng.com" target="_blank">www.zongheng.com</a>All Rights Reserved 版权所有 北京幻想纵横网络技术有限公司   京ICP证：080527号《网络文化经营许可证》   <a href="http://static.zongheng.com/images/license/publication-license.jpg" target="_blank">京ICP备11009265号</a>   <a href="http://static.zongheng.com/images/license/business-license.jpg" target="_blank">京网文[2015]2368-459号</a></p>
    <p>新出发京零字第朝130010号  丨  统一社会信用代码91110105678221683F  丨 <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010502030124" target="_blank">京公网安备  	11010502030124号</a>  丨 <a href="http://www.cyberpolice.cn/wfjb/" target="_blank">公安部网络违法犯罪举报网站</a></p>
    <p><a href="http://www.zongheng.com" target="_blank">纵横小说网</a>,提供<a href="http://www.zongheng.com/category/1.html" target="_blank">玄幻小说</a>,<a href="/category/9.html" target="_blank">都市小说</a>,<a href="http://huayu.baidu.com" target="_blank">言情小说</a>等<a href="http://book.zongheng.com/store/c0/c0/b0/u0/p1/v0/s9/t0/u0/i1/ALL.html" target="_blank">免费小说</a>阅读。作者发布小说作品时，请遵守国家互联网信息管理办法规定。</p>
    <p>本站所收录小说作品、社区话题、书库评论均属其个人行为，不代表本站立场。</p>
</div>

    </div>
</body>
</html>
<script src="js/jquery-1.12.4.js"></script>
<script>

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



















function deletecollection(bookid,a)
{
	if(confirm("确定要移除书架吗？")){
		$.post(

		"checkServlet",
		"op=deletecollection&bookid="+bookid+"&authorid="+${au.authorid},
		
		function(r)
		{
			if(r.r=="1")
			{
			$(a).parent().parent().remove();
			}
		}
		,"json");
	}
	
	}
	
	function history()
	{
		
	
		$("#history").show();
		$("#collection").hide();
		$("#shanchu").hide();
		$("#chongzhi").hide();
		$("#ac").hide();
	}
	
	function collection()
	{
		$("#collection").show();
		$("#shanchu").show();
		$("#history").hide();
		$("#chongzhi").hide();
		$("#ac").hide();
	}
	
	
	function  authorshezhi()
	{
		
		$("#shanchu").hide();
		$("#collection").hide();
		$("#history").hide();
		$("#ac").show();
		//$("#chongzhi")show();
		
	}
	
	function  xiaofeijilu()
	{
		$("#shanchu").hide();
		$("#collection").hide();
		$("#history").hide();
		//$("#ac").hide();
		$("#chongzhi").hide();
		$("#xiaofeijilu").show();
	}
	
	function chongzhi(){
		$("#shanchu").hide();
		$("#collection").hide();
		$("#history").hide();
		$("#xiaofeijilu").hide();
		$("#chongzhi").show();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	function deleteallcollection(){
		if(confirm("确定要全部移除删除吗？")){	
	              $.post(	
					"checkServlet",
					"op=deleteallcollection&authorid="+${au.authorid},
					function(r)
					{
						if(r.r>="1")
						{
						$("#coll").parent().remove();
						}
					}
					,"json");
				}
		}
	
	
</script>