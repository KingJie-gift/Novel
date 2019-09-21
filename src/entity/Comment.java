package entity;

import java.sql.Time;
//评论表
public class Comment {
	private int commentid;//主键id
	private int authorid;//评论人id
	private int bookid;//评论书id
	private String commenttime;//评论时间
	private String content;//评论内容
	private Author author;//用户对象
	
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getCommenttime() {
		return commenttime;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
