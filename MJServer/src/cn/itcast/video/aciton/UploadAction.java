package cn.itcast.video.aciton;

import java.io.File;

import cn.itcast.video.service.UploadServiceResult;

@SuppressWarnings("serial")
public class UploadAction extends BaseAction <UploadServiceResult> {
	// 文件上传到哪个文件夹下面(必须是存在的文件夹)
	static final String FILE_DIR = "/Users/apple/Desktop/";
	private String username;
	private File file;
	private String fileFileName;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public UploadAction()
	{
		service = new UploadServiceResult();
	}
	
	/**
	 * 处理文件上传
	 */
	public void upload() throws Exception {
		if (file != null) {
			service.setSuccess(true);
			service.setMessage("上传成功");
			file.renameTo(new File(FILE_DIR + fileFileName));
			System.out.println(username + "上传了" + fileFileName + "文件");
		} else {
			service.setSuccess(false);
			service.setMessage("上传失败");
		}

		write();
	}
}
