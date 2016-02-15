<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
 var flashvars={
	  f: "getvideo.html?id=[$pat]",
      a: "${vid}",
	  s: 1,
	  c:0
 	};
 var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always',wmode:"transparent"};
 var video=['/getvideo.html?id=html5->ajax/get/utf-8'];
 CKobject.embed("<%=request.getContextPath()%>/js/ckplayer/ckplayer.swf", "ckplayer_content", "ckplayer", "600",
		 "400", false, flashvars, video, params);
 /*CKobject.embedSWF(播放器路径,容器id,播放器id/name,播放器宽,播放器高,flashvars的值,其它定义也可省略);*/
});
</script>

<title>视频播放</title>
</head>
<body>
<div id="ckplayer_content"></div>

</body>
</html>