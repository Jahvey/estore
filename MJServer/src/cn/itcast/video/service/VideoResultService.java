package cn.itcast.video.service;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import cn.itcast.video.model.Video;
import cn.itcast.video.model.VideoResult;
import cn.itcast.video.tool.JsonTool;

public class VideoResultService extends BaseResultService {
	private VideoResult result() {
		List<Video> videos = new ArrayList<Video>();
		for (int i = 0; i < 16; i++) {
			String no = "";
			if (i<9) {
				no = "0";
			}
			no += (i + 1) + "";
			
			Video video = new Video();
			video.setId(i+1);
			video.setName("小黄人 第"+no+"部");
			video.setLength(10 + i*2);
			video.setImage("resources/images/minion_"+ no +".png");
			video.setUrl("resources/videos/minion_"+ no +".mp4");
			videos.add(video);
		}
		VideoResult result = new VideoResult();
		result.setVideos(videos);
		return result;
	}
	
	public String jsonResult()
	{
		return JsonTool.jsonFromObject(result());
	}
	
	public String xmlResult()
	{
		List<Video> videos = result().getVideos();
		Element root = new Element("videos");
		Document doc = new Document(root);
		for (Video video : videos) {
			Element videoEmt = new Element("video");
			videoEmt.setAttribute("id", video.getId() + "");
			videoEmt.setAttribute("name", video.getName());
			videoEmt.setAttribute("length", video.getLength() + "");
			videoEmt.setAttribute("image", video.getImage());
			videoEmt.setAttribute("url", video.getUrl());
			root.addContent(videoEmt);
		}
		XMLOutputter output = new XMLOutputter();
		return output.outputString(doc);
	}
}
