package org.leelun.file.model;

import java.util.Arrays;
import java.util.List;

/**
 * 	onlyoffice 支持的文件类型
 * @see <a href="https://api.onlyoffice.com/editors/config/#documentType">FileType</a>
 * @author leelun
 * @date 2020年5月11日
 *
 */
public enum FileType{
	//	.doc,.docx, .epub, .htm, .html,.pdf, .txt, .xps等
    Text{
    	
		private List<String> supports = Arrays.asList(
				".doc", ".docx", ".docm",
				".dot", ".dotx", ".dotm",
				".odt", ".fodt", ".rtf", 
				".txt", ".html", ".htm", 
				".mht", ".pdf", ".djvu", 
				".fb2", ".epub", ".xps");
    	
    	@Override
    	public boolean support(String ext) {
    		return supports.contains(ext);
    	}
    },
    
    //	.csv,.xls,.xlsx等
    Spreadsheet{

    	private List<String> supports = Arrays.asList (
                        ".xls", ".xlsx", ".xlsm",
                        ".xlt", ".xltx", ".xltm",
                        ".ods", ".fods", ".csv");
    	
    	@Override
    	public boolean support(String ext) {
    		return supports.contains(ext);
    	}
    	
    },
    
    //	.ppt,.pptx,.pps,.ppsx,等 
	Presentation {
		private List<String> supports = Arrays.asList(
				".ppt", ".pptx", ".pptm",
				".pps", ".ppsx", ".ppsm",
				".pot",".potx", ".potm",
				".odp", ".fodp");

		@Override
		public boolean support(String ext) {
			return supports.contains(ext);
		}
	};
	
	public boolean support(String ext) {
		throw new AbstractMethodError();
	};
	
}