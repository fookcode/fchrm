//************************************************************//
//File Name : NvcBPO.java
//Author    : kinee
//Mailto    : kinee@163.com
//Comment   : 
//Date      : Jul 21, 2014
//************************************************************//

package com.fookcode.nvc.bpo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.fookcode.nvc.common.dto.TTreeItemDTO;

public class TNvcBPO {
	
	private HashMap<Integer, String> pathMap = new HashMap<Integer, String>();
	
	public String BeanToJson(Object obj) throws IOException {  
		ObjectMapper objectMap = new ObjectMapper();
		return objectMap.writeValueAsString(obj);
	} 
	
	public List<TTreeItemDTO> getRootList(String rootPath) {
		pathMap.clear();        //每次刷新会调用此函数，清空历史记录
		
		final String rootDirName = "media";  //"点播文件";
		
		ArrayList<TTreeItemDTO> result = new ArrayList<TTreeItemDTO>();
		TTreeItemDTO root = new TTreeItemDTO();
		root.setId(0);
		root.setText(rootDirName);
		root.setState("open");
		root.setChildren(new ArrayList<TTreeItemDTO>());
		
		File file = new File(rootPath+rootDirName);            //根目录
		File[] subFiles = file.listFiles();
		int len = pathMap.size();
		for(int i = 1;i <= subFiles.length; i++) {
			int id = i+len;
			File subFile = subFiles[i-1];
			pathMap.put(id, subFile.getAbsolutePath().substring(rootPath.length()));
			TTreeItemDTO item = new TTreeItemDTO();
			item.setId(id);
			item.setText(subFile.getName());
			if (subFile.isDirectory()) {
				item.setState("closed");
			}
			root.getChildren().add(item);
			
		}
		result.add(root);
		
		return result;
	}
	
	public List<TTreeItemDTO> getFileList(String rootPath, int index) {
		ArrayList<TTreeItemDTO> result = new ArrayList<TTreeItemDTO>();
		String parentPath = rootPath + pathMap.get(index);
		if (parentPath != null) {
			File parentFile = new File(parentPath);
			if (parentFile.isDirectory()) {
				File[] subFiles = parentFile.listFiles();
				int len = pathMap.size();
				for(int i = 1;i <= subFiles.length; i++) {
					int id = i+len;
					File subFile = subFiles[i-1];
					pathMap.put(id, subFile.getAbsolutePath().substring(rootPath.length()));
					TTreeItemDTO item = new TTreeItemDTO();
					item.setId(id);
					item.setText(subFile.getName());
					if (subFile.isDirectory()) {
						item.setState("closed");
					}
					result.add(item);
				}
					
			}
		}
		return result;
	}
	
	public String getFilePath(int id) {
		return pathMap.get(id);
	}
}

