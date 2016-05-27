package cn.itcast.video.service;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import cn.itcast.video.model.Weather;
import cn.itcast.video.model.WeatherErrorResult;
import cn.itcast.video.model.WeatherResult;
import cn.itcast.video.tool.JsonTool;
import cn.itcast.video.tool.XmlTool;

public class WeatherResultService extends BaseResultService {
	private String[] place;
	public void setPlace(String[] place) {
		this.place = place;
	}
	
	public WeatherResult result()
	{
		WeatherResult wr = new WeatherResult();
		List<Weather> weathers = new ArrayList<Weather>();
		for (String str : place) {
			Weather w = new Weather();
			w.setCity(str);
			w.setStatus("晴转多云");
			weathers.add(w);
		}
		wr.setWeathers(weathers);
		return wr;
	}
	
	public String jsonResult() {		
		if (place != null && place.length > 0) {
			return JsonTool.jsonFromObject(result());
		} else {
			WeatherErrorResult result = new WeatherErrorResult();
			result.setError("没有传递地址信息");
			return JsonTool.jsonFromObject(result);
		}
	}

	public String xmlResult() {
		if (place != null && place.length > 0) {
			List<Weather> weathers = result().getWeathers();
			Element root = new Element("weathers");
			Document doc = new Document(root);
			for (Weather w : weathers) {
				Element videoEmt = new Element("weather");
				videoEmt.setAttribute("city", w.getCity());
				videoEmt.setAttribute("status", w.getStatus());
				root.addContent(videoEmt);
			}
			XMLOutputter output = new XMLOutputter();
			return output.outputString(doc);
		} else {
			return XmlTool.xml("error", "没有传递地址信息");
		}
	}
}
