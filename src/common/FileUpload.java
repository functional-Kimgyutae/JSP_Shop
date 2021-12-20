package common;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class FileUpload {
	
	public static String fileUp (MultipartRequest multiRequest,String path,int p_id,int num) {
		String url = "";
		 try{		    	
		    	String fileName = nullOrEmptyToReplaceString(multiRequest.getFilesystemName("img"+num) ,"");
		        int i = -1;
		        i = fileName.lastIndexOf("."); 
		        String realFileName = "\\img_" + p_id + "_"+ num + fileName.substring(i, fileName.length());
		       
		        File oldFile = new File(path+"\\" + fileName);
		        File newFile = new File(path + realFileName);
		        oldFile.renameTo(newFile);
		        url = "\\Shop\\data\\product_img" + realFileName;
		    } catch (Exception e){
		    	e.printStackTrace();
		    }
		 return url;
	}
	
	public static String nullOrEmptyToReplaceString(String str, String replaceStr) {
		if (str == null || "".equals(str)) {
			return replaceStr;
		}
		return str;
	}
}
