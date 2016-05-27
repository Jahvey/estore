package cn.itcast.video.tool;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTool {
	public static String jsonFromObject(Object obj)
	{
		assert obj.getClass() != List.class;
		
		return JSONObject.fromObject(obj).toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static String jsonArrayFromList(List list)
	{
		return JSONArray.fromObject(list).toString();
	}

}
