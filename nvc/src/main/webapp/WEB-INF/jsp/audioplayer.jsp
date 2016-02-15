<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dewplayer/swfobject.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			type: "GET",
			contentType: "application/json;charset=UTF-8",
			url: "getaudio.html?id=" + "${aid}",
			cache: false,
			async: false,
			success: function(data) {
				var flashvars = {
						  mp3: data,
						  javascript: "on"
						};
						var params = {
						  wmode: "transparent"
						};
						var attributes = {
						  id: "dewplayer"
						};
						swfobject.embedSWF("<%=request.getContextPath()%>/js/dewplayer/dewplayer-bubble.swf", "dewplayer_content", "250", "65", "9.0.0", false, flashvars, params, attributes);
			}
		});
	});
	
</script>
<title>音频播放</title>
</head>
<body>
<div id="content">
	
	<div id="dewplayer_content"></div>

</div>


</body>
</html>