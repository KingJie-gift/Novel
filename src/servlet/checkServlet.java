package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.math.BigInteger;

import javax.activation.URLDataSource;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;












import javax.xml.stream.Location;

import dao.impl.AuthorDaoImpl;
import entity.Author;
import entity.Chapter;
import entity.Collection;
import entity.Comment;
import entity.Consumptionrecord;
import entity.History;
import entity.Novel;
import entity.Page;
import entity.Rechargerecord;
import service.impl.AuthorServiceImpl;
import service.impl.BooktypeServiceImpl;
import service.impl.BuychapterServiceImpl;
import service.impl.ChapterServiceImpl;
import service.impl.CollectionServiceImpl;
import service.impl.CommentServiceImpl;
import service.impl.ConsumptionrecordServiceImpl;
import service.impl.HistoryServiceImpl;
import service.impl.NovelServiceImpl;
import service.impl.PhoneServiceImpl;
import service.impl.RechargerecordServiceImpl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;

public class checkServlet extends HttpServlet {
  


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String op=request.getParameter("op");
		AuthorServiceImpl al=new AuthorServiceImpl();//用户及作家
		BooktypeServiceImpl bl=new BooktypeServiceImpl();//小说类型
		NovelServiceImpl nl=new NovelServiceImpl();  //小说
    ChapterServiceImpl cl=new ChapterServiceImpl();		//章节
     CollectionServiceImpl csl=new CollectionServiceImpl(); //收藏
     HistoryServiceImpl  hl=new HistoryServiceImpl();  //历史记录
      BuychapterServiceImpl  bsl=new BuychapterServiceImpl();  //购买记录
      RechargerecordServiceImpl rl=new RechargerecordServiceImpl();//添加充值记录
       CommentServiceImpl csi=new CommentServiceImpl(); //用户评论
       ConsumptionrecordServiceImpl  ctl=new ConsumptionrecordServiceImpl();  //消费记录
   	PhoneServiceImpl psi=new PhoneServiceImpl();//手机短信
		if(op==null || op.equals("searchlikebook"))//模糊查询所有图书
		{
			 List list=bl.getbooktype();
				request.setAttribute("booktypelist", list);
			String bookname=request.getParameter("bookname");
			 int typeid=-1;
			 if(request.getParameter("typeid")=="" ||  request.getParameter("typeid")==null)
			 {
				 typeid=-1;
			 }else{
				  typeid=Integer.parseInt(request.getParameter("typeid"));
			 }
			bookname=bookname==null?"":bookname;
			String regex = "[\u4E00-\u9FA5]+";
			if(!bookname.matches(regex)&&bookname!=""){
				
			bookname=new String(request.getParameter("bookname").getBytes("ISO-8859-1"), "utf-8"); 
			}
		
			String index=request.getParameter("index");
			index=index==null?"1":index;
			
			
		 List<Novel>allnovel=nl.getallnovel();
		    int indexs=Integer.parseInt(index);
			Page page =new Page();
			page.setSizepage(5);
			page.setDatacount(nl.getallnovel(bookname,typeid));
			page.setIndexpage(indexs);
			page.setList(nl.getAllnovel(bookname,typeid,page));
			request.setAttribute("book", bookname);
			request.setAttribute("typeid", typeid);
			request.setAttribute("allnovel", allnovel);
			request.setAttribute("pagelist", page);
			  request.getRequestDispatcher("sousuo.jsp").forward(request, response);
		}else if(op.equals("addbook"))//添加新书
		{
			
			int authorid=0;//获取小说人id
			String bookname=null;//小说名称
			int booktype=0;//小说类型
			String bookH=null;//首字母
			String sf=null;//首发平台
			String content=null;//小说简介
			String guanjianzi=null;//关键字
			 String image=null;//图片地址
			String sendword=null;//作者寄语
			
			
			String name="";//上传的文件路径 
	        //上传的文件名
	        String uploadFileName="";
	        //表单字段元素的name属性值
	        String filedName="";
	        //获取服务器项目路径
	        String savePath=request.getServletContext().getRealPath("images/");
	        //判断请求中的内容是否为multipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //如果为true，就是表单中含有上传标签
	        if(isMulty)
	        {
	         //对来的请求进行处理
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(102400);
	         try{
	           //parseRequest方法解析请求，获取请求里的表单字段
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //判断每个元素 是普通还是文件
	            if(item.isFormField()){//true普通false是文件
	            //获取元素name属性值
	            filedName=item.getFieldName();
	           
	            if(filedName.equals("authorid"))
	            {
	            	authorid=Integer.parseInt(item.getString("utf-8"));
	            }
	            if(filedName.equals("bookname"))
	            {
	            	bookname=item.getString("utf-8");
	            }
	            if(filedName.equals("ra"))
	            {
	            	sf=item.getString("utf-8");
	            }
	            if(filedName.equals("select")){
	            	booktype=Integer.parseInt(item.getString("utf-8"));
	            }
	            if(filedName.equals("firstLetter"))
	            {
	            	bookH=item.getString("utf-8");
	            }
	            if(filedName.equals("guanjianzi"))
	            {
	            	guanjianzi=item.getString("utf-8");
	            }
	            if(filedName.equals("description"))
	            {
	            	content=item.getString("utf-8");
	            }
	            if(filedName.equals("wishWord"))
	            {
	            	sendword=item.getString("utf-8");
	            }   
	        
	            }else{
	            //处理文件上传 
	            //1.获取用户上传的文件名
	            String fileName=item.getName();
	            //判断用户是否上传了文件
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //判断文件类型是否合法
	            /* List<String>typelist=Arrays.asList("jpg","bmp");
	             //从文件名中截取文件类型
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("不合法文件");
	             return;
	             }*/
	             //2.创建一个文件对象，方便下一步进行文件写入
	             File   file=new File(savePath,fileName);
	             //3.把文件写入到对应路径下
	             item.write(file);
	            image="images/"+fileName;
	             
	             //out.print("文件上传成功！名字是："+"images/"+fileName);
	             
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("文件过大");
	         }catch(Exception e)
	         {
	        	 e.printStackTrace();
	         }
	        }
		
			
			
			Novel n=new Novel();
			n.setAuthorid(authorid);
			n.setBookname(bookname);
			n.setBookoutline(content);
			n.setPlatform(sf);
			n.setBooktype(booktype);
			n.setImages(image);
			n.setBooktitle(guanjianzi);
			n.setSendword(sendword);
			n.setShouzimu(bookH);
		
			int result=nl.add(n);
		    
			
			if(result>0)
			{
				  Novel ns=nl.getauthorid(authorid,bookname);
				  request.setAttribute("novel", ns); 
                  request.getRequestDispatcher("xiezuo.jsp").forward(request, response);				
			}else{
				request.getRequestDispatcher("zuojia.jsp").forward(request, response);				
			}
			
			
		}else if(op.equals("addchapter"))//作家页面跳新增章节页面
		{
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			String chaptername=request.getParameter("chaptername");
			String chaptercontent=new String(request.getParameter("chaptercontent"));
			 int chapterprice=Integer.parseInt(request.getParameter("select"));
			int number=chaptercontent.length();
			
			Chapter c=new Chapter();
			c.setChaptercontent(chaptercontent);
		    c.setChapternumber(number);
			c.setChaptertitle(chaptername);
	    	 c.setChapterprice(chapterprice);
			 c.setBookid(bookid);
			
		      Novel novel=nl.getnovel(bookid);//原来小说字数
		     
		      int booknumber=cl.countchapternumber(bookid);//当前所有章节字数
		      novel.setBooknumber(booknumber+number);
		      novel.setBookname(novel.getBookname());
		      novel.setBookstate(novel.getBookstate());
		      novel.setBooktitle(novel.getBooktitle());
		      novel.setBookoutline(novel.getBookoutline());
		      novel.setClicks(novel.getClicks());
             novel.setBooktype(novel.getBooktype());
             
		                  nl.update(novel);
						 int result=cl.add(c);
						 String ischarge="免费";
						    int isprice=cl.getischarge(novel.getBookid());
						    if(isprice!=0)
						    {
						    	ischarge="收费";
						    }
						 nl.updateischarge(ischarge, novel.getBookid());
						 if(result>0)
						 {
							 	List list=cl.getchapter(bookid);
								request.setAttribute("chapterlist", list);
						         Novel n=nl.getnovel(bookid);
						         request.setAttribute("novel", n);
						    request.getRequestDispatcher("xiezuo.jsp").forward(request, response);
								
							}else{
								request.getRequestDispatcher("zuojia.jsp").forward(request, response);				
							}
			 
		
		}else if(op.equals("bookinfo"))//作家专区页面，写作的所有小说
		{
		    int authorid= Integer.parseInt(request.getParameter("authorid"));//获取小说人id
		   
			int index=Integer.parseInt(request.getParameter("index"));
			
			Page page =new Page();
			page.setSizepage(3);
			page.setDatacount(nl.getall(authorid));
			page.setIndexpage(index);
			page.setList(nl.getauthornovel(page, authorid));
			
			request.setAttribute("pagelist", page);
			Author a=al.getauthor(authorid);
			request.setAttribute("author", a);
			request.getRequestDispatcher("zuojiazhuanqu.jsp").forward(request, response);
			
		}else if(op.equals("toupdatebook"))//作家专区页面，去修改章节
		{
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			Novel n = nl.getnovel(bookid) ;
			request.setAttribute("novel", n);
	     	List list=cl.getchapter(bookid);
	     	
			request.setAttribute("chapterlist", list);
			request.getRequestDispatcher("updatexiezuo.jsp").forward(request, response);
		}else if(op.equals("zuojiazhuanqu"))//作家专区页面
		{
			
			int id= Integer.parseInt(request.getParameter("authorid"));//获取小说人id
	       	request.getRequestDispatcher("zuojiazhuanqu.jsp").forward(request, response);
	       	 
			
		}else if(op.equals("toaddbook"))//添加章节 通过创建新书页面
		{
		
			 List list=bl.getbooktype();
			request.setAttribute("booktypelist", list);
			int id= Integer.parseInt(request.getParameter("authorid"));//获取小说人id
			request.setAttribute("authorid", id);
			
			request.getRequestDispatcher("zuojia.jsp").forward(request, response);
		}else if(op.equals("searchchapter"))//获取章节内容
		{
			
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			//更新历史记录，如果没有添加一条
			int result=hl.updatehistory(bookid,chapterid,authorid);
			if(result<=0)
			{
				int count=hl.addhistory(bookid, chapterid, authorid);
			}
			 Chapter c=cl.getchapters(chapterid);
			 
			 
			 out.print(c.getChaptercontent());
		}else if(op.equals("toaddchapter"))//添加章节，通过作家专区页面
		{
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int authorid= Integer.parseInt(request.getParameter("authorid"));//获取小说人id
            String   bookname = new String(request.getParameter("bookname").getBytes("ISO-8859-1"), "utf-8");  //字符转
			  Novel ns=nl.getauthorid(authorid,bookname);
			  request.setAttribute("novel", ns);
			 List list=cl.getchapter(bookid);
			request.setAttribute("chapterlist", list);
			request.getRequestDispatcher("xiezuo.jsp").forward(request, response);
		}else if(op.equals("updatechapter")) //更新小说章节
		{
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			String chaptername=request.getParameter("chaptername");
			
			 String chaptercontent=new String(request.getParameter("chaptercontent"));
			 int chapterprice=Integer.parseInt(request.getParameter("select"));
			int number=chaptercontent.length();
			
			Chapter c=new Chapter();
			c.setChaptercontent(chaptercontent);
		    c.setChapternumber(number);
			c.setChaptertitle(chaptername);
	    	c.setChapterprice(chapterprice);
		    c.setBookid(bookid);
		    c.setChapterid(chapterid);
						 int result=cl.update(c);
						   
						 if(result>0)
						 {
							 
						      Novel novel=nl.getnovel(bookid);//原来小说字数
						      int booknumber=cl.countchapternumber(bookid);//当前所有章节字数
						      
						      novel.setBooknumber(booknumber);
						      novel.setBookname(novel.getBookname());
						      novel.setBookstate(novel.getBookstate());
						      novel.setBooktitle(novel.getBooktitle());
						      novel.setBookoutline(novel.getBookoutline());
						      novel.setClicks(novel.getClicks());
				              novel.setBooktype(novel.getBooktype());
						      nl.update(novel);
						      
						      String ischarge="免费";
							    int isprice=cl.getischarge(bookid);
							    if(isprice!=0)
							    {
							    	ischarge="收费";
							    }
						      nl.updateischarge(ischarge, bookid);//判断是否收费
							 	List list=cl.getchapter(bookid);
								request.setAttribute("chapterlist", list);
						         Novel n=nl.getnovel(bookid);
						         request.setAttribute("novel", n);
						    request.getRequestDispatcher("updatexiezuo.jsp").forward(request, response);
								
							}else{
								request.getRequestDispatcher("zuojia.jsp").forward(request, response);				
							}
			 
		}else if(op.equals("toaddcollection"))//判断有没有收藏过
		{
			
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		  int result=csl.collection(authorid, bookid);
		  out.print("{\"r\":\""+result+"\"}");
		}else if(op.equals("addcollection"))//添加收藏
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			  int result=csl.addcollection(authorid, bookid);
			  out.print("{\"r\":\""+result+"\"}");
		}else if(op.equals("searchshujia"))//获取书架
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			List <Collection>list=csl.getcollection(authorid);
			List<Consumptionrecord> consumptionlist=ctl.getAll(authorid);
			 List<Novel>collectionlist=new ArrayList<Novel>();
			 for (int i = 0; i < list.size(); i++) {
				 
				   int bookid=list.get(i).getBookid();
				   collectionlist.addAll(nl.getnovellist(bookid));
			}
            
			 
			 
			 
			 List <History>lists=hl.gethistorylist(authorid);
			 List<Chapter>historylist=new ArrayList<Chapter>();
			 for (int i = 0; i < lists.size(); i++) {
				 
				   int chapterid=lists.get(i).getChaperid();
				   historylist.add(cl.getchapters(chapterid));
			}
			 
			  List<Rechargerecord>rechargerecordlist=rl.getRechargerecord(authorid);//获取充值记录
			 
			  Author a=al.getauthor(authorid);
			  request.setAttribute("author", a);
			  request.setAttribute("consumptionlist", consumptionlist);
			 request.setAttribute("rechargerecordlist", rechargerecordlist);
			 request.setAttribute("historylist", historylist);
			request.setAttribute("collectionlist", collectionlist);
            request.getRequestDispatcher("shujia.jsp").forward(request, response);
		
		}else if(op.equals("deletecollection")){//单个移除收藏
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			 int result=csl.delte(authorid, bookid);
			 out.print("{\"r\":\""+result+"\"}");
			 
		}else if(op.equals("deleteallcollection"))
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			 int result=csl.deleteall(authorid);
			 out.print("{\"r\":\""+result+"\"}");
			 
		}else if(op.equals("searchbookinfo"))//点击图书详情进入评论页面
		{
			//加载评论
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int index=0;
			if(request.getParameter("index")=="" || request.getParameter("index")==null)
			{
				index=1;
			}else{
			index=Integer.parseInt(request.getParameter("index"));
			}
			
			Page p=new Page();
			p.setSizepage(8);
			p.setDatacount(csi.getCount(bookid));
			p.setIndexpage(index);
			p.setList(csi.plfen(p, bookid));			
			request.setAttribute("tpage", p.getTotalpage());
			
			List<Novel>listnovel=nl.getnovellist(bookid);
		   List listchapter=cl.getchapter(bookid);
			
			 
			request.setAttribute("listnovel", listnovel);
			request.setAttribute("listchapter", listchapter); 
			request.getRequestDispatcher("pinglun.jsp").forward(request, response);
			
		}else if(op.equals("readering"))//点击阅读
		{	
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		    Chapter ch=cl.getchapterlist(bookid);
		    int minchapterid=cl.getminchapter(bookid);
			Chapter c=cl.getchapters(minchapterid);
			
			
			//更新历史记录，如果没有添加一条
		 int result=hl.updatehistory(bookid,ch.getChapterid(),authorid);
				if(result<=0)
				{
					int count=hl.addhistory(bookid, ch.getChapterid(), authorid);
				}
				
			 request.setAttribute("list", c);
			 List listchapter=cl.getchapter(bookid);
			request.setAttribute("listchapter", listchapter); 
				
				
				
				
			 request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
			
		}else if(op.equals("tochapterinfo"))//章节详情
		{
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			Chapter c=cl.getchapters(chapterid);
			 List listchapter=cl.getchapter(bookid);
			 
			 
			
			request.setAttribute("list", c);
			request.setAttribute("listchapter", listchapter); 
			 request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
			
			
		}else if(op.equals("updateclicks"))//给图书点赞
		{
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			Novel n= nl.getnovel(bookid);
			
			int result=nl.updatenovelclicks(n.getClicks()+1, bookid);
			out.print("{\"r\":\""+result+"\"}");
			
		}else if(op.equals("checkischarge"))//判断章节是否免费，立即阅读
		{
			
           int bookid=Integer.parseInt(request.getParameter("bookid"));
           int authorid=Integer.parseInt(request.getParameter("authorid"));
		    Chapter ch=cl.getchapterlist(bookid);
		    int minchapterid=cl.getminchapter(bookid);
		    Chapter c= cl.getchapters(minchapterid);
		    int count=0;
		    if(c.getChapterprice()>0)//代表不是免费的
		    {		    	 
		     count=bsl.getbuy(minchapterid, authorid);//判断有没有购买过
		    if(count==0)
		    {
		    	out.print("{\"r\":\""+count+"\"}");
		    	
		    }else{
		    	out.print("{\"r\":\""+count+"\"}");
		    	
		    }
		    }else{
		    	out.print("{\"r\":\""+1+"\"}");
		    }
		    
		}else if(op.equals("buychapter"))//点击立刻阅读判断章节
		{
			
			 int authorid=Integer.parseInt(request.getParameter("authorid"));
			 int bookid=Integer.parseInt(request.getParameter("bookid"));
				
			   Novel n=nl.getnovel(bookid);
			    Chapter ch=cl.getchapterlist(bookid);
			    int minchapterid=cl.getminchapter(bookid);
			    Chapter c= cl.getchapters(minchapterid);
			    Author a=al.getauthor(authorid);
			    if(c.getChapterprice()>a.getAuthorprice())
			    {
			    	out.print("{\"rs\":\""+1+"\"}");
			    }else{
			    	
			    	bsl.add(bookid, minchapterid, a.getAuthorid());//添加购买记录
			    	ctl.addConsumptionre(authorid,minchapterid,c.getChapterprice());//添加消费记录
			    	  al.updatezuozhe((c.getChapterprice()*0.6)+n.getAuthor().getAuthorprice(),n.getAuthor().getAuthorid());//给作者更新金额  章节价格的60%
			    	Author admin=al.getauthor(3);
			    	al.updateadmin(admin.getAuthorprice()+(c.getChapterprice()*0.4));//网站的收益
			    	bsl.getauthoridprice((int) (a.getAuthorprice()-c.getChapterprice()),a.getAuthorid());//用户减去对应的章节金额
			    	out.print("{\"rs\":\""+0+"\"}");
			    }
		}else if(op.equals("checkischarges"))//普通章节的判断
		{

			int authorid=Integer.parseInt(request.getParameter("authorid"));
	           int bookid=Integer.parseInt(request.getParameter("bookid"));
	           int chapterid=Integer.parseInt(request.getParameter("chapterid"));
	           Chapter c= cl.getchapters(chapterid);
	           int count=0;
	           if(c.getChapterprice()>0)//代表不是免费的
			    {		    	 
			     count=bsl.getbuy(chapterid,authorid);//判断有没有购买过
			    if(count==0)
			    {
			    	out.print("{\"r\":\""+count+"\"}");
			    	
			    }else{
			    	out.print("{\"r\":\""+count+"\"}");
			    	
			    }
			    }else{
			    	out.print("{\"r\":\""+1+"\"}");
			    }
		}else if(op.equals("buychapters"))//购买普通的章节
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		    Chapter ch=cl.getchapterlist(bookid);
		    
		    Chapter c= cl.getchapters(chapterid);
		    Author a=al.getauthor(authorid);//用户的id
		    if(c.getChapterprice()>a.getAuthorprice())
		    {
		    	out.print("{\"rs\":\""+1+"\"}");
		    }else{
		    	bsl.add(bookid, chapterid, a.getAuthorid());
		    	ctl.addConsumptionre(authorid,chapterid,c.getChapterprice());//添加消费记录
		        al.updatezuozhe((c.getChapterprice()*0.6)+c.getNovel().getAuthor().getAuthorprice(),c.getNovel().getAuthorid());//给作者更新金额  章节价格的60%
		    	Author admin=al.getauthor(3);//网站对象
		    	al.updateadmin(admin.getAuthorprice()+(c.getChapterprice()*0.4));//网站的收益  40%
		    	bsl.getauthoridprice((int) (a.getAuthorprice()-c.getChapterprice()),a.getAuthorid());//用户减去对应的章节金额
		    	out.print("{\"rs\":\""+0+"\"}");
		    }
		}else if(op.equals("toupdatenovel"))//更新小说详细信息
		{
			 List list=bl.getbooktype();
			request.setAttribute("booktypelist", list);
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			  Novel n=nl.getnovel(bookid);
			  request.setAttribute("novel", n);
			  request.getRequestDispatcher("updatezuojia.jsp").forward(request, response);
		}else if(op.equals("addauthorprice"))//用户充值
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//取用户id
		      Author a=al.getauthor(authorid);
			  int price=Integer.parseInt(request.getParameter("price"));//取充值的金额
			   String mode=request.getParameter("radio");//取充值的方式
		      al.addauthoridprice(price+a.getAuthorprice(), authorid);//将原有的书卷和充值的书卷相加
		     Rechargerecord  r=new Rechargerecord();
		     r.setAuthorid(authorid);
		     r.setPrice(price);
		     r.setRechargemode(mode);
		     
		      int result=rl.addRechargerecord(r);
		      if(result>0)
		      {
		    	  
		    	  out.print("<script>"+"alert(`充值书卷成功！`);location.href=`sousuo.jsp`;"+"</script>");
		      }else{
		    	  out.print("<script>"+"alert(`充值书卷失败！`);location.href=`sousuo.jsp`;"+"</script>");
		      }
		      
		}else if(op.equals("tochongzhi"))//去充值
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//取用户id
			 Author a=al.getauthor(authorid);
			request.setAttribute("author", a);
			request.getRequestDispatcher("chongzhi.jsp").forward(request, response);
		}else if(op.equals("updatebook"))//更新小说信息
		{
			
			int bookid=0;//小说id
			String bookname=null;//小说名称
			int booktype=0;//小说类型
			String bookH=null;//首字母
			String sf=null;//首发平台
			String content=null;//小说简介
			String guanjianzi=null;//关键字
			 String image=null;//图片地址
			String sendword=null;//作者寄语
			String state=null;//小说状态
			
			String name="";//上传的文件路径 
	        //上传的文件名
	        String uploadFileName="";
	        //表单字段元素的name属性值
	        String filedName="";
	        //获取服务器项目路径
	        String savePath=request.getServletContext().getRealPath("images/");
	        //判断请求中的内容是否为multipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //如果为true，就是表单中含有上传标签
	        if(isMulty)
	        {
	         //对来的请求进行处理
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(102400);
	         try{
	           //parseRequest方法解析请求，获取请求里的表单字段
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //判断每个元素 是普通还是文件
	            if(item.isFormField()){//true普通false是文件
	            //获取元素name属性值
	            filedName=item.getFieldName();
	           
	           
	            if(filedName.equals("bookname"))
	            {
	            	bookname=item.getString("utf-8");
	            }
	            if(filedName.equals("ra"))
	            {
	            	sf=item.getString("utf-8");
	            }
	            if(filedName.equals("select")){
	            	booktype=Integer.parseInt(item.getString("utf-8"));
	            }
	            if(filedName.equals("firstLetter"))
	            {
	            	bookH=item.getString("utf-8");
	            }
	            if(filedName.equals("guanjianzi"))
	            {
	            	guanjianzi=item.getString("utf-8");
	            }
	            if(filedName.equals("description"))
	            {
	            	content=item.getString("utf-8");
	            }
	            if(filedName.equals("wishWord"))
	            {
	            	sendword=item.getString("utf-8");
	            }   
	            if(filedName.equals("bookid"))
	            {
	            	bookid=Integer.parseInt(item.getString("utf-8"));
	            }if(filedName.equals("state"))
	            {
	            	state=item.getString("utf-8");
	            }
	        
	            }else{
	            //处理文件上传 
	            //1.获取用户上传的文件名
	            String fileName=item.getName();
	            //判断用户是否上传了文件
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //判断文件类型是否合法
	            /* List<String>typelist=Arrays.asList("jpg","bmp");
	             //从文件名中截取文件类型
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("不合法文件");
	             return;
	             }*/
	             //2.创建一个文件对象，方便下一步进行文件写入
	             File   file=new File(savePath,fileName);
	             //3.把文件写入到对应路径下
	             item.write(file);
	            image="images/"+fileName;
	             
	             //out.print("文件上传成功！名字是："+"images/"+fileName);
	             
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("文件过大");
	         }catch(Exception e)
	         {
	        	 e.printStackTrace();
	         }
	        }
			
		
			
			
			Novel n=new Novel();
			n.setBookname(bookname);
			n.setBookoutline(content);
			n.setPlatform(sf);
			n.setBooktype(booktype);
			n.setImages(image);
			n.setBooktitle(guanjianzi);
			n.setSendword(sendword);
			n.setShouzimu(bookH);
			n.setBookid(bookid);
			n.setBookstate(state);
			int result=nl.update(n);
		    
			if(result>0)
			{
				 out.print("<script>"+"alert(`修改小说成功！`);location.href=`zuojiazhuanqu.jsp`"+"</script>");
                //  request.getRequestDispatcher("xiezuo.jsp").forward(request, response);				
			}else{
				out.print("<script>"+"alert(`修改小说失败！`);location.href=`zuojiazhuanqu.jsp`"+"</script>");
			}
			
			
			

      	}else if(op.equals("selectpl")){//分页评论
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int index=Integer.parseInt(request.getParameter("index"));
			Page p=new Page();
			p.setSizepage(8);
			p.setDatacount(csi.getCount(bookid));
			p.setIndexpage(index);
			p.setList(csi.plfen(p, bookid));			
			try {
				List plist=p.getList();
				out.print(JSON.toJSONString(plist,false));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//添加评论
		}else if(op.equals("addpl")){
			  Comment comm=new Comment();
			  int bookid=Integer.parseInt(request.getParameter("bookid"));
			  comm.setAuthorid(Integer.parseInt(request.getParameter("auid")));
			  comm.setBookid(bookid);
			  comm.setContent(request.getParameter("pltext"));
			  int result=csi.add(comm);
			  out.print("{\"result\":\""+result+"\"}");
		
		
		}else if(op.equals("addauthor"))//注册
		{
			String name=request.getParameter("uname");
			String regex = "[\u4E00-\u9FA5]+";
			
			 String phone=request.getParameter("phone");
			 int code=Integer.parseInt(request.getParameter("code"));
			if(name==null){
				int count=psi.delCode(phone, code);
				if(count==0){
				out.print("{\"count\":\"无效\"}");
				}else{
					out.print("{\"count\":\"正确\"}");
				}
			}else{
				
			if(!name.matches(regex)&&name!=""){
				
			name=new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8"); 
			//System.out.println("编译后"+name);
			}else{
			name=request.getParameter("uname");
			}
			//md5加密
			String pwd=request.getParameter("pw1");
			String mdpwd=null;
			 try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				 md.update(pwd.getBytes());
				mdpwd= new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			 String email=request.getParameter("email");
				
			
			 
			Author a=new Author();
			a.setAuthorname(name);
			a.setPwd(mdpwd);
			a.setAuthorprice(0);
			a.setCollectionbook(0);
			a.setReleasebook(0);
			a.setEmail(email);
		
			a.setPhone(phone);
			
			int result=al.Insert(a);
			if(result>0){
				out.print("<script>"
						+ "alert('成功！');location.href='denglu.jsp';"
						+ "</script>");
			}else{
				out.print("<script>"
						+ "alert('失败！');location.href='zhuce.jsp';"
						+ "</script>");
			}
		}
			
		}else if(op.equals("checkAuthorname")){
			String name = request.getParameter("uname");
			int result = al.checkauthorname(name);
			out.print("{\"result\":\"" + result + "\"}");
			
		}else if (op.equals("login")) {//登录
			String url=request.getParameter("url");
			String url2=null;
			if(url.length()>=12){
			url2=url.substring(0,12);
			}else{
				url2="";
			}
			String pwd=request.getParameter("pw");
			String mdpwd=null;
			 try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				 md.update(pwd.getBytes());
				mdpwd= new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Author a = new Author();
			a.setAuthorname(request.getParameter("username"));
			a.setPwd(mdpwd);
			Author au = al.login(a);
			if (au == null) {
				
				
				out.print("<script>"
						+ "alert('账号密码有误！');location.href='denglu.jsp';"
						+ "</script>");
			} else {
				
				if(url.equals("login") || url2.equals("checkServlet") || url.equals("denglu.jsp")){
				request.getSession().setAttribute("au", au);
				request.getRequestDispatcher("default.jsp").forward(request,
						response);
				}else{
						request.getSession().setAttribute("au", au);
						request.getRequestDispatcher(url).forward(request,
								response);
				}
			}
			
		}else if(op.equals("defaullt"))//首页显示排行榜
		{
			List<Novel>allnovel=nl.getallnovel();
			request.setAttribute("allnovel", allnovel);
			List<Novel>numberlist=nl.numberlist();
			request.setAttribute("numberlist", numberlist);
			
			List<Novel>newlist=nl.newlist();
			request.setAttribute("newlist", newlist);
			request.getRequestDispatcher("default.jsp").forward(request, response);
		}else if(op.equals("duihuan"))//兑换现金
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//取用户id
		      Author a=al.getauthor(authorid);
			  int price=Integer.parseInt(request.getParameter("price"));//取兑换的金额
		
			  
			  if(a.getAuthorprice()<price)
			  {
				  out.print("{\"r\":\"" + 0+ "\"}");
				  return;
			  }else{
		       al.addauthoridprice(a.getAuthorprice()-price, authorid);
		      out.print("{\"r\":\"" + 1 + "\"}");
			  }
		}else if(op.equals("toupdate")){//根据用户id找到信息，去更新
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			Author a=al.getauthor(authorid);
			request.setAttribute("s",a);
			request.getRequestDispatcher("xiugaiyonghu.jsp").forward(request, response);
		}else if(op.equals("update")){//更新用户
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			String authorname=request.getParameter("uname");
			String regex = "[\u4E00-\u9FA5]+";
			if(!authorname.matches(regex)&&authorname!=""){
				
				authorname=new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8"); 
			}
			String authorpwd=request.getParameter("pw1");
			String mdpwd=null;
			 try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				 md.update(authorpwd.getBytes());
				mdpwd= new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			String email=request.getParameter("email");
			Author a=new Author();
			a.setAuthorid(authorid);
			a.setAuthorname(authorname);
			a.setPwd(mdpwd);
			a.setEmail(email);
			a.setAuthorprice(0);
			int result=al.Update(a);
			if(result>0){
				out.print("<script>"
						+ "alert('修改成功！');location.href='default.jsp';"
						+ "</script>");
			}else{
				out.print("<script>"
						+ "alert('修改失败！');location.href='default.jsp';"
						+ "</script>");
			}
		}else if(op.equals("sendcode"))//发送验证码
		{
			String phone=request.getParameter("phone");
			int code=(int)((Math.random()*9+1)*1000); 
			String result=psi.sendCode(phone, code);
			if(result.equals("1")){
				out.print("{\"result\":\"成功\"}");
				psi.addCode(phone, code);
			}else{
				out.print("{\"result\":\"失败\"}");
			}
		}else if(op.equals("tuichu"))//退出登录
		{
			
			request.getSession().removeAttribute("au");
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
			
		}
		out.flush();
		out.close();
	}

}
