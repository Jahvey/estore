package cn.itcast.video.aciton;

import cn.itcast.video.service.VideoResultService;

@SuppressWarnings("serial")
public class VideoAction extends BaseAction <VideoResultService> {
	public VideoAction()
	{
		service = new VideoResultService();
	}
	
	/**
	 * 处理视频信息
	 */
	public void video() throws Exception 
	{
		write();
	}
}
