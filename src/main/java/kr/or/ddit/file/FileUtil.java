package kr.or.ddit.file;

public class FileUtil {
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload";
	
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC09
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	* 
	* ex : form-data; name="uploadFile"; filename="rabbit.jpg"
	* 	return : rabbit.jpg
	*/
	public static String getFileName(String contentDisposition){
		String[] cdArr = contentDisposition.split("; ");
		String filename = "";
		for (String str : cdArr) {
			if(str.startsWith("filename")){
				String[] filenameArr = str.split("=");
				filename = filenameArr[1].replace("\"", "");
				break;
			}
		}
		return filename;
	}
}
