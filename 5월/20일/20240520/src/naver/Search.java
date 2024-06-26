package naver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Search {
	private String title;
	private String link;
	private String description;
	private String bloggername;
	private String bloggerlink;
	private String postdate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBloggername() {
		return bloggername;
	}

	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}

	public String getBloggerlink() {
		return bloggerlink;
	}

	public void setBloggerlink(String bloggerlink) {
		this.bloggerlink = bloggerlink;
	}


	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public Search() {
	}

	

	public Search(String title, String link, String description, String bloggername, String bloggerlink,
			String postdate) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.bloggername = bloggername;
		this.bloggerlink = bloggerlink;
		this.postdate = postdate;
	}
	

	@Override
	public String toString() {
		
		return "Search [title=" + title + ", link=" + link + ", description=" + description + ", bloggername="
				+ bloggername + ", bloggerlink=" + bloggerlink + ", postdate=" + postdate + "]";
	}

}