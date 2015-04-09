package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadImageAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private File file;
	private String fileContentType;
	private String fileFileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@SuppressWarnings("unchecked")
	public void upload() {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		// 设置文件上传大小
		fileUpload.setSizeMax(100*100 * 1024);
		fileUpload.setFileSizeMax(2 * 1024 * 1024);
		List<FileItem> list = null;
		try {
			list = fileUpload.parseRequest(request);
			 System.out.println(  list.size());
			for (FileItem item : list) {
              System.out.println(  item.getContentType());
				// 一种是表单数据，一种是图片数据
				if (!item.isFormField()) {
					System.out.println(2);
					String img = item.getName();
					String file_upload_path = "F:\\MyEclipseWorkspace\\AymServer\\WebRoot\\images"
							+ "/" + img;
					System.out.println("图片上传的路径：：" + file_upload_path);
					item.write(new File(file_upload_path));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String uploadImage() {
		System.out.println("-----------------");
		System.out.println(fileFileName + "------------------" + file.length());
		try {
			FileInputStream fis = new FileInputStream(file);
			String photospath = ServletActionContext.getRequest().getRealPath("images");
			System.out.println(photospath);
			File fs = new File(photospath, fileFileName);
			FileOutputStream fos = new FileOutputStream(fs);
			int len = 0;
			byte[] buffer = new byte[1024];

			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
			fos.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "uploadfile";
	}
}
