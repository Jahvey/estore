package cn.itcast.video.model;

public class Video {
	private int id;
	private String name;
	private int length;
	private String image;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String xml() {
		return "<video id=\"" + id + "\" name=\"" + name + "\" url=\"" + url  + "\" length=\"" + length + "\" image=\""+ image +"\" />";
	}
	
	public String toString() {
		return "{ \"id\":" + id + ", \"url\":\"" + url + "\", \"name\":\"" + name + "\", \"length\":" + length + ", \"image\":\""+image+"\" }";
	}
}
