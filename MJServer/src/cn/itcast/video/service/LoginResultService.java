package cn.itcast.video.service;

import cn.itcast.video.model.LoginErrorResult;
import cn.itcast.video.model.LoginSuccessResult;
import cn.itcast.video.tool.JsonTool;
import cn.itcast.video.tool.XmlTool;

public class LoginResultService extends BaseResultService {
	private boolean success;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String jsonResult() {
		if (success) {
			LoginSuccessResult result = new LoginSuccessResult();
			result.setSuccess(message);
			return JsonTool.jsonFromObject(result);
		} else {
			LoginErrorResult result = new LoginErrorResult();
			result.setError(message);
			return JsonTool.jsonFromObject(result);
		}
	}

	public String xmlResult() {		
		if (success) {
			return XmlTool.xml("success", message);
		} else {
			return XmlTool.xml("error", message);
		}
	}
}
