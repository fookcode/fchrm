//************************************************************//
//File Name : SystemController.java
//Author    : kinee
//Mailto    : kinee@163.com
//Comment   : /**
//Date      : Jul 21, 2014
//************************************************************//

package com.fookcode.nvc.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fookcode.nvc.bpo.TNvcBPO;

@Controller
public class SystemController {

	Logger logger = Logger.getLogger(this.getClass());
	
	public static String propertyFile = "/nvc.properties";
	
	private TNvcBPO nvcBPO;
	
	@Resource
	public void setNvcBPO(TNvcBPO nvcBPO) {
		this.nvcBPO = nvcBPO;
	}
	
	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="index", method=RequestMethod.GET)
	public ModelAndView initNvcIndexPage(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		InputStream in = new BufferedInputStream(new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + propertyFile));
		Properties p = new Properties();
		p.load(in);
		mv.addObject("server1", p.getProperty("server1"));
		mv.addObject("server2", p.getProperty("server2"));
		mv.addObject("server3", p.getProperty("server3"));
		mv.addObject("server4", p.getProperty("server4"));
		mv.addObject("server5", p.getProperty("server5"));
		mv.addObject("server6", p.getProperty("server6"));
		mv.setViewName("index");
		return mv;
	}
	
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="main", method=RequestMethod.GET)
	public String initNvcMainPage() {
		return "main";
	}
 	
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="videoplayer", method=RequestMethod.GET)
	public ModelAndView initNvcVideoPlayPage(@RequestParam(value="id", required=false)Integer id) {
 		ModelAndView mv = new ModelAndView();
 		mv.addObject("vid", id==null?"0":id.toString());
 		mv.setViewName("videoplayer");
		return mv;    
	}
 	
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="audioplayer", method=RequestMethod.GET)
	public ModelAndView initNvcAudioPlayPage(@RequestParam(value="id", required=false)Integer id) {
 		ModelAndView mv = new ModelAndView();
 		mv.addObject("aid", id==null?"0":id.toString());
 		mv.setViewName("audioplayer");
		return mv; 
	}
 	
 	@ResponseBody
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="getfilelist", method=RequestMethod.GET)
 	public String getRootFiles(@RequestParam(value="id", required=false)Integer id, HttpServletRequest request) throws Exception {
 		String result = "";
 		String rootPath = request.getSession().getServletContext().getRealPath("/");
 		logger.info(rootPath);
 		if (id == null) { 
 			result = nvcBPO.BeanToJson(nvcBPO.getRootList(rootPath));
 		}
 		else result = nvcBPO.BeanToJson(nvcBPO.getFileList(rootPath, id));
 		
 		logger.info(result);
 		return result; 
 	}
 	
 	@ResponseBody
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="getvideo", method=RequestMethod.GET)
 	public String getVideo(@RequestParam(value="id", required=false)Integer id, HttpServletRequest request) throws Exception {
 		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
 		//logger.info(baseUrl);
 		String result = baseUrl + nvcBPO.getFilePath(id).replace("\\", "/"); 
 		logger.info(result);
 		return result;
 	}
 	
 	@ResponseBody
 	@RequestMapping(produces={"text/html;charset=UTF-8"}, value="getaudio", method=RequestMethod.GET)
 	public String getAudio(@RequestParam(value="id", required=false)Integer id, HttpServletRequest request) throws Exception {
 		//String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
 		String result = nvcBPO.getFilePath(id).replace("\\", "/"); 
 		logger.info(result);
 		return result;
 	}

}

