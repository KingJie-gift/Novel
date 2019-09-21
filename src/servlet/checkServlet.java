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
		AuthorServiceImpl al=new AuthorServiceImpl();//�û�������
		BooktypeServiceImpl bl=new BooktypeServiceImpl();//С˵����
		NovelServiceImpl nl=new NovelServiceImpl();  //С˵
    ChapterServiceImpl cl=new ChapterServiceImpl();		//�½�
     CollectionServiceImpl csl=new CollectionServiceImpl(); //�ղ�
     HistoryServiceImpl  hl=new HistoryServiceImpl();  //��ʷ��¼
      BuychapterServiceImpl  bsl=new BuychapterServiceImpl();  //�����¼
      RechargerecordServiceImpl rl=new RechargerecordServiceImpl();//��ӳ�ֵ��¼
       CommentServiceImpl csi=new CommentServiceImpl(); //�û�����
       ConsumptionrecordServiceImpl  ctl=new ConsumptionrecordServiceImpl();  //���Ѽ�¼
   	PhoneServiceImpl psi=new PhoneServiceImpl();//�ֻ�����
		if(op==null || op.equals("searchlikebook"))//ģ����ѯ����ͼ��
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
		}else if(op.equals("addbook"))//�������
		{
			
			int authorid=0;//��ȡС˵��id
			String bookname=null;//С˵����
			int booktype=0;//С˵����
			String bookH=null;//����ĸ
			String sf=null;//�׷�ƽ̨
			String content=null;//С˵���
			String guanjianzi=null;//�ؼ���
			 String image=null;//ͼƬ��ַ
			String sendword=null;//���߼���
			
			
			String name="";//�ϴ����ļ�·�� 
	        //�ϴ����ļ���
	        String uploadFileName="";
	        //���ֶ�Ԫ�ص�name����ֵ
	        String filedName="";
	        //��ȡ��������Ŀ·��
	        String savePath=request.getServletContext().getRealPath("images/");
	        //�ж������е������Ƿ�Ϊmultipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //���Ϊtrue�����Ǳ��к����ϴ���ǩ
	        if(isMulty)
	        {
	         //������������д���
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(102400);
	         try{
	           //parseRequest�����������󣬻�ȡ������ı��ֶ�
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //�ж�ÿ��Ԫ�� ����ͨ�����ļ�
	            if(item.isFormField()){//true��ͨfalse���ļ�
	            //��ȡԪ��name����ֵ
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
	            //�����ļ��ϴ� 
	            //1.��ȡ�û��ϴ����ļ���
	            String fileName=item.getName();
	            //�ж��û��Ƿ��ϴ����ļ�
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //�ж��ļ������Ƿ�Ϸ�
	            /* List<String>typelist=Arrays.asList("jpg","bmp");
	             //���ļ����н�ȡ�ļ�����
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("���Ϸ��ļ�");
	             return;
	             }*/
	             //2.����һ���ļ����󣬷�����һ�������ļ�д��
	             File   file=new File(savePath,fileName);
	             //3.���ļ�д�뵽��Ӧ·����
	             item.write(file);
	            image="images/"+fileName;
	             
	             //out.print("�ļ��ϴ��ɹ��������ǣ�"+"images/"+fileName);
	             
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("�ļ�����");
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
			
			
		}else if(op.equals("addchapter"))//����ҳ���������½�ҳ��
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
			
		      Novel novel=nl.getnovel(bookid);//ԭ��С˵����
		     
		      int booknumber=cl.countchapternumber(bookid);//��ǰ�����½�����
		      novel.setBooknumber(booknumber+number);
		      novel.setBookname(novel.getBookname());
		      novel.setBookstate(novel.getBookstate());
		      novel.setBooktitle(novel.getBooktitle());
		      novel.setBookoutline(novel.getBookoutline());
		      novel.setClicks(novel.getClicks());
             novel.setBooktype(novel.getBooktype());
             
		                  nl.update(novel);
						 int result=cl.add(c);
						 String ischarge="���";
						    int isprice=cl.getischarge(novel.getBookid());
						    if(isprice!=0)
						    {
						    	ischarge="�շ�";
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
			 
		
		}else if(op.equals("bookinfo"))//����ר��ҳ�棬д��������С˵
		{
		    int authorid= Integer.parseInt(request.getParameter("authorid"));//��ȡС˵��id
		   
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
			
		}else if(op.equals("toupdatebook"))//����ר��ҳ�棬ȥ�޸��½�
		{
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			Novel n = nl.getnovel(bookid) ;
			request.setAttribute("novel", n);
	     	List list=cl.getchapter(bookid);
	     	
			request.setAttribute("chapterlist", list);
			request.getRequestDispatcher("updatexiezuo.jsp").forward(request, response);
		}else if(op.equals("zuojiazhuanqu"))//����ר��ҳ��
		{
			
			int id= Integer.parseInt(request.getParameter("authorid"));//��ȡС˵��id
	       	request.getRequestDispatcher("zuojiazhuanqu.jsp").forward(request, response);
	       	 
			
		}else if(op.equals("toaddbook"))//����½� ͨ����������ҳ��
		{
		
			 List list=bl.getbooktype();
			request.setAttribute("booktypelist", list);
			int id= Integer.parseInt(request.getParameter("authorid"));//��ȡС˵��id
			request.setAttribute("authorid", id);
			
			request.getRequestDispatcher("zuojia.jsp").forward(request, response);
		}else if(op.equals("searchchapter"))//��ȡ�½�����
		{
			
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			//������ʷ��¼�����û�����һ��
			int result=hl.updatehistory(bookid,chapterid,authorid);
			if(result<=0)
			{
				int count=hl.addhistory(bookid, chapterid, authorid);
			}
			 Chapter c=cl.getchapters(chapterid);
			 
			 
			 out.print(c.getChaptercontent());
		}else if(op.equals("toaddchapter"))//����½ڣ�ͨ������ר��ҳ��
		{
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int authorid= Integer.parseInt(request.getParameter("authorid"));//��ȡС˵��id
            String   bookname = new String(request.getParameter("bookname").getBytes("ISO-8859-1"), "utf-8");  //�ַ�ת
			  Novel ns=nl.getauthorid(authorid,bookname);
			  request.setAttribute("novel", ns);
			 List list=cl.getchapter(bookid);
			request.setAttribute("chapterlist", list);
			request.getRequestDispatcher("xiezuo.jsp").forward(request, response);
		}else if(op.equals("updatechapter")) //����С˵�½�
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
							 
						      Novel novel=nl.getnovel(bookid);//ԭ��С˵����
						      int booknumber=cl.countchapternumber(bookid);//��ǰ�����½�����
						      
						      novel.setBooknumber(booknumber);
						      novel.setBookname(novel.getBookname());
						      novel.setBookstate(novel.getBookstate());
						      novel.setBooktitle(novel.getBooktitle());
						      novel.setBookoutline(novel.getBookoutline());
						      novel.setClicks(novel.getClicks());
				              novel.setBooktype(novel.getBooktype());
						      nl.update(novel);
						      
						      String ischarge="���";
							    int isprice=cl.getischarge(bookid);
							    if(isprice!=0)
							    {
							    	ischarge="�շ�";
							    }
						      nl.updateischarge(ischarge, bookid);//�ж��Ƿ��շ�
							 	List list=cl.getchapter(bookid);
								request.setAttribute("chapterlist", list);
						         Novel n=nl.getnovel(bookid);
						         request.setAttribute("novel", n);
						    request.getRequestDispatcher("updatexiezuo.jsp").forward(request, response);
								
							}else{
								request.getRequestDispatcher("zuojia.jsp").forward(request, response);				
							}
			 
		}else if(op.equals("toaddcollection"))//�ж���û���ղع�
		{
			
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		  int result=csl.collection(authorid, bookid);
		  out.print("{\"r\":\""+result+"\"}");
		}else if(op.equals("addcollection"))//����ղ�
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			  int result=csl.addcollection(authorid, bookid);
			  out.print("{\"r\":\""+result+"\"}");
		}else if(op.equals("searchshujia"))//��ȡ���
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
			 
			  List<Rechargerecord>rechargerecordlist=rl.getRechargerecord(authorid);//��ȡ��ֵ��¼
			 
			  Author a=al.getauthor(authorid);
			  request.setAttribute("author", a);
			  request.setAttribute("consumptionlist", consumptionlist);
			 request.setAttribute("rechargerecordlist", rechargerecordlist);
			 request.setAttribute("historylist", historylist);
			request.setAttribute("collectionlist", collectionlist);
            request.getRequestDispatcher("shujia.jsp").forward(request, response);
		
		}else if(op.equals("deletecollection")){//�����Ƴ��ղ�
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			 int result=csl.delte(authorid, bookid);
			 out.print("{\"r\":\""+result+"\"}");
			 
		}else if(op.equals("deleteallcollection"))
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			 int result=csl.deleteall(authorid);
			 out.print("{\"r\":\""+result+"\"}");
			 
		}else if(op.equals("searchbookinfo"))//���ͼ�������������ҳ��
		{
			//��������
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
			
		}else if(op.equals("readering"))//����Ķ�
		{	
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		    Chapter ch=cl.getchapterlist(bookid);
		    int minchapterid=cl.getminchapter(bookid);
			Chapter c=cl.getchapters(minchapterid);
			
			
			//������ʷ��¼�����û�����һ��
		 int result=hl.updatehistory(bookid,ch.getChapterid(),authorid);
				if(result<=0)
				{
					int count=hl.addhistory(bookid, ch.getChapterid(), authorid);
				}
				
			 request.setAttribute("list", c);
			 List listchapter=cl.getchapter(bookid);
			request.setAttribute("listchapter", listchapter); 
				
				
				
				
			 request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
			
		}else if(op.equals("tochapterinfo"))//�½�����
		{
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			Chapter c=cl.getchapters(chapterid);
			 List listchapter=cl.getchapter(bookid);
			 
			 
			
			request.setAttribute("list", c);
			request.setAttribute("listchapter", listchapter); 
			 request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
			
			
		}else if(op.equals("updateclicks"))//��ͼ�����
		{
			
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			Novel n= nl.getnovel(bookid);
			
			int result=nl.updatenovelclicks(n.getClicks()+1, bookid);
			out.print("{\"r\":\""+result+"\"}");
			
		}else if(op.equals("checkischarge"))//�ж��½��Ƿ���ѣ������Ķ�
		{
			
           int bookid=Integer.parseInt(request.getParameter("bookid"));
           int authorid=Integer.parseInt(request.getParameter("authorid"));
		    Chapter ch=cl.getchapterlist(bookid);
		    int minchapterid=cl.getminchapter(bookid);
		    Chapter c= cl.getchapters(minchapterid);
		    int count=0;
		    if(c.getChapterprice()>0)//��������ѵ�
		    {		    	 
		     count=bsl.getbuy(minchapterid, authorid);//�ж���û�й����
		    if(count==0)
		    {
		    	out.print("{\"r\":\""+count+"\"}");
		    	
		    }else{
		    	out.print("{\"r\":\""+count+"\"}");
		    	
		    }
		    }else{
		    	out.print("{\"r\":\""+1+"\"}");
		    }
		    
		}else if(op.equals("buychapter"))//��������Ķ��ж��½�
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
			    	
			    	bsl.add(bookid, minchapterid, a.getAuthorid());//��ӹ����¼
			    	ctl.addConsumptionre(authorid,minchapterid,c.getChapterprice());//������Ѽ�¼
			    	  al.updatezuozhe((c.getChapterprice()*0.6)+n.getAuthor().getAuthorprice(),n.getAuthor().getAuthorid());//�����߸��½��  �½ڼ۸��60%
			    	Author admin=al.getauthor(3);
			    	al.updateadmin(admin.getAuthorprice()+(c.getChapterprice()*0.4));//��վ������
			    	bsl.getauthoridprice((int) (a.getAuthorprice()-c.getChapterprice()),a.getAuthorid());//�û���ȥ��Ӧ���½ڽ��
			    	out.print("{\"rs\":\""+0+"\"}");
			    }
		}else if(op.equals("checkischarges"))//��ͨ�½ڵ��ж�
		{

			int authorid=Integer.parseInt(request.getParameter("authorid"));
	           int bookid=Integer.parseInt(request.getParameter("bookid"));
	           int chapterid=Integer.parseInt(request.getParameter("chapterid"));
	           Chapter c= cl.getchapters(chapterid);
	           int count=0;
	           if(c.getChapterprice()>0)//��������ѵ�
			    {		    	 
			     count=bsl.getbuy(chapterid,authorid);//�ж���û�й����
			    if(count==0)
			    {
			    	out.print("{\"r\":\""+count+"\"}");
			    	
			    }else{
			    	out.print("{\"r\":\""+count+"\"}");
			    	
			    }
			    }else{
			    	out.print("{\"r\":\""+1+"\"}");
			    }
		}else if(op.equals("buychapters"))//������ͨ���½�
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			int chapterid=Integer.parseInt(request.getParameter("chapterid"));
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
		    Chapter ch=cl.getchapterlist(bookid);
		    
		    Chapter c= cl.getchapters(chapterid);
		    Author a=al.getauthor(authorid);//�û���id
		    if(c.getChapterprice()>a.getAuthorprice())
		    {
		    	out.print("{\"rs\":\""+1+"\"}");
		    }else{
		    	bsl.add(bookid, chapterid, a.getAuthorid());
		    	ctl.addConsumptionre(authorid,chapterid,c.getChapterprice());//������Ѽ�¼
		        al.updatezuozhe((c.getChapterprice()*0.6)+c.getNovel().getAuthor().getAuthorprice(),c.getNovel().getAuthorid());//�����߸��½��  �½ڼ۸��60%
		    	Author admin=al.getauthor(3);//��վ����
		    	al.updateadmin(admin.getAuthorprice()+(c.getChapterprice()*0.4));//��վ������  40%
		    	bsl.getauthoridprice((int) (a.getAuthorprice()-c.getChapterprice()),a.getAuthorid());//�û���ȥ��Ӧ���½ڽ��
		    	out.print("{\"rs\":\""+0+"\"}");
		    }
		}else if(op.equals("toupdatenovel"))//����С˵��ϸ��Ϣ
		{
			 List list=bl.getbooktype();
			request.setAttribute("booktypelist", list);
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			  Novel n=nl.getnovel(bookid);
			  request.setAttribute("novel", n);
			  request.getRequestDispatcher("updatezuojia.jsp").forward(request, response);
		}else if(op.equals("addauthorprice"))//�û���ֵ
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//ȡ�û�id
		      Author a=al.getauthor(authorid);
			  int price=Integer.parseInt(request.getParameter("price"));//ȡ��ֵ�Ľ��
			   String mode=request.getParameter("radio");//ȡ��ֵ�ķ�ʽ
		      al.addauthoridprice(price+a.getAuthorprice(), authorid);//��ԭ�е����ͳ�ֵ��������
		     Rechargerecord  r=new Rechargerecord();
		     r.setAuthorid(authorid);
		     r.setPrice(price);
		     r.setRechargemode(mode);
		     
		      int result=rl.addRechargerecord(r);
		      if(result>0)
		      {
		    	  
		    	  out.print("<script>"+"alert(`��ֵ���ɹ���`);location.href=`sousuo.jsp`;"+"</script>");
		      }else{
		    	  out.print("<script>"+"alert(`��ֵ���ʧ�ܣ�`);location.href=`sousuo.jsp`;"+"</script>");
		      }
		      
		}else if(op.equals("tochongzhi"))//ȥ��ֵ
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//ȡ�û�id
			 Author a=al.getauthor(authorid);
			request.setAttribute("author", a);
			request.getRequestDispatcher("chongzhi.jsp").forward(request, response);
		}else if(op.equals("updatebook"))//����С˵��Ϣ
		{
			
			int bookid=0;//С˵id
			String bookname=null;//С˵����
			int booktype=0;//С˵����
			String bookH=null;//����ĸ
			String sf=null;//�׷�ƽ̨
			String content=null;//С˵���
			String guanjianzi=null;//�ؼ���
			 String image=null;//ͼƬ��ַ
			String sendword=null;//���߼���
			String state=null;//С˵״̬
			
			String name="";//�ϴ����ļ�·�� 
	        //�ϴ����ļ���
	        String uploadFileName="";
	        //���ֶ�Ԫ�ص�name����ֵ
	        String filedName="";
	        //��ȡ��������Ŀ·��
	        String savePath=request.getServletContext().getRealPath("images/");
	        //�ж������е������Ƿ�Ϊmultipart
	        boolean   isMulty=ServletFileUpload.isMultipartContent(request);
	        //���Ϊtrue�����Ǳ��к����ϴ���ǩ
	        if(isMulty)
	        {
	         //������������д���
	         FileItemFactory factory=new DiskFileItemFactory();
	         ServletFileUpload upload=new ServletFileUpload(factory);
	         upload.setSizeMax(102400);
	         try{
	           //parseRequest�����������󣬻�ȡ������ı��ֶ�
	           List<FileItem>items=upload.parseRequest(request);
	           for(FileItem item:items)
	           {
	            //�ж�ÿ��Ԫ�� ����ͨ�����ļ�
	            if(item.isFormField()){//true��ͨfalse���ļ�
	            //��ȡԪ��name����ֵ
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
	            //�����ļ��ϴ� 
	            //1.��ȡ�û��ϴ����ļ���
	            String fileName=item.getName();
	            //�ж��û��Ƿ��ϴ����ļ�
	            if(fileName!=null && !fileName.equals(""))
	            {
	             //�ж��ļ������Ƿ�Ϸ�
	            /* List<String>typelist=Arrays.asList("jpg","bmp");
	             //���ļ����н�ȡ�ļ�����
	            String type=fileName.substring(filedName.lastIndexOf(".")+1);
	             if(!typelist.contains(type))
	             {
	             out.print("���Ϸ��ļ�");
	             return;
	             }*/
	             //2.����һ���ļ����󣬷�����һ�������ļ�д��
	             File   file=new File(savePath,fileName);
	             //3.���ļ�д�뵽��Ӧ·����
	             item.write(file);
	            image="images/"+fileName;
	             
	             //out.print("�ļ��ϴ��ɹ��������ǣ�"+"images/"+fileName);
	             
	            }
	            }
	           }
	         }catch(FileUploadBase.SizeLimitExceededException e)
	         {
	          out.print("�ļ�����");
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
				 out.print("<script>"+"alert(`�޸�С˵�ɹ���`);location.href=`zuojiazhuanqu.jsp`"+"</script>");
                //  request.getRequestDispatcher("xiezuo.jsp").forward(request, response);				
			}else{
				out.print("<script>"+"alert(`�޸�С˵ʧ�ܣ�`);location.href=`zuojiazhuanqu.jsp`"+"</script>");
			}
			
			
			

      	}else if(op.equals("selectpl")){//��ҳ����
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
			//�������
		}else if(op.equals("addpl")){
			  Comment comm=new Comment();
			  int bookid=Integer.parseInt(request.getParameter("bookid"));
			  comm.setAuthorid(Integer.parseInt(request.getParameter("auid")));
			  comm.setBookid(bookid);
			  comm.setContent(request.getParameter("pltext"));
			  int result=csi.add(comm);
			  out.print("{\"result\":\""+result+"\"}");
		
		
		}else if(op.equals("addauthor"))//ע��
		{
			String name=request.getParameter("uname");
			String regex = "[\u4E00-\u9FA5]+";
			
			 String phone=request.getParameter("phone");
			 int code=Integer.parseInt(request.getParameter("code"));
			if(name==null){
				int count=psi.delCode(phone, code);
				if(count==0){
				out.print("{\"count\":\"��Ч\"}");
				}else{
					out.print("{\"count\":\"��ȷ\"}");
				}
			}else{
				
			if(!name.matches(regex)&&name!=""){
				
			name=new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8"); 
			//System.out.println("�����"+name);
			}else{
			name=request.getParameter("uname");
			}
			//md5����
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
						+ "alert('�ɹ���');location.href='denglu.jsp';"
						+ "</script>");
			}else{
				out.print("<script>"
						+ "alert('ʧ�ܣ�');location.href='zhuce.jsp';"
						+ "</script>");
			}
		}
			
		}else if(op.equals("checkAuthorname")){
			String name = request.getParameter("uname");
			int result = al.checkauthorname(name);
			out.print("{\"result\":\"" + result + "\"}");
			
		}else if (op.equals("login")) {//��¼
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
						+ "alert('�˺���������');location.href='denglu.jsp';"
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
			
		}else if(op.equals("defaullt"))//��ҳ��ʾ���а�
		{
			List<Novel>allnovel=nl.getallnovel();
			request.setAttribute("allnovel", allnovel);
			List<Novel>numberlist=nl.numberlist();
			request.setAttribute("numberlist", numberlist);
			
			List<Novel>newlist=nl.newlist();
			request.setAttribute("newlist", newlist);
			request.getRequestDispatcher("default.jsp").forward(request, response);
		}else if(op.equals("duihuan"))//�һ��ֽ�
		{
			int authorid=Integer.parseInt(request.getParameter("authorid"));//ȡ�û�id
		      Author a=al.getauthor(authorid);
			  int price=Integer.parseInt(request.getParameter("price"));//ȡ�һ��Ľ��
		
			  
			  if(a.getAuthorprice()<price)
			  {
				  out.print("{\"r\":\"" + 0+ "\"}");
				  return;
			  }else{
		       al.addauthoridprice(a.getAuthorprice()-price, authorid);
		      out.print("{\"r\":\"" + 1 + "\"}");
			  }
		}else if(op.equals("toupdate")){//�����û�id�ҵ���Ϣ��ȥ����
			int authorid=Integer.parseInt(request.getParameter("authorid"));
			Author a=al.getauthor(authorid);
			request.setAttribute("s",a);
			request.getRequestDispatcher("xiugaiyonghu.jsp").forward(request, response);
		}else if(op.equals("update")){//�����û�
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
						+ "alert('�޸ĳɹ���');location.href='default.jsp';"
						+ "</script>");
			}else{
				out.print("<script>"
						+ "alert('�޸�ʧ�ܣ�');location.href='default.jsp';"
						+ "</script>");
			}
		}else if(op.equals("sendcode"))//������֤��
		{
			String phone=request.getParameter("phone");
			int code=(int)((Math.random()*9+1)*1000); 
			String result=psi.sendCode(phone, code);
			if(result.equals("1")){
				out.print("{\"result\":\"�ɹ�\"}");
				psi.addCode(phone, code);
			}else{
				out.print("{\"result\":\"ʧ��\"}");
			}
		}else if(op.equals("tuichu"))//�˳���¼
		{
			
			request.getSession().removeAttribute("au");
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
			
		}
		out.flush();
		out.close();
	}

}
