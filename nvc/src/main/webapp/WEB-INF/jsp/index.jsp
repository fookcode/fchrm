<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jcoverflip/jquery-1.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jcoverflip/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jcoverflip/jquery.jcoverflip.js"></script>
<style type="text/css">

	.ui-jcoverflip {position: relative;}
     
    .ui-jcoverflip--item {position: absolute;display: block;}
     
    #flip {height: 400px;width: 660px;margin-bottom: 50px;}
      
    #flip .ui-jcoverflip--title {position: absolute;bottom: -50px;width: 100%;text-align: center;color: #555}
      
    #flip img {display: block;border: 0;outline: none;}
      
    #flip a {outline: none;}

    ul, ul li {margin: 0;padding: 0;display: block;list-style-type: none;}
    
    body {font-family: Arial, sans-serif;width: 660px;padding: 0;margin: 0 auto;background: #ededed url(<%=request.getContextPath()%>/image/bg.png) no-repeat fixed top}
    
      
</style>
<script type="text/javascript">
  //demo:http://www.jcoverflip.com//files/docs/jcoverflip-demo/index.html
  $(function(){
	$("#flip").jcoverflip({current: 3});
  });
</script>

<title>欢迎</title>
</head>
<body>
<div id="wrapper" style="width:660px;overflow:hidden;border:#000 1px">
	<ul id="flip">
		<li><a href="${server1}"><img src="<%=request.getContextPath()%>/image/logo_1.jpg" /></a></li>
	    <li><a href="${server2}"><img src="<%=request.getContextPath()%>/image/logo_2.jpg" /></a></li>
	    <li><a href="${server3}"><img src="<%=request.getContextPath()%>/image/logo_3.jpg" /></a></li>
	    <li><a href="${server4}"><img src="<%=request.getContextPath()%>/image/logo_4.jpg" /></a></li>
	    <li><a href="${server5}"><img src="<%=request.getContextPath()%>/image/logo_5.jpg" /></a></li>
	    <li><a href="${server6}"><img src="<%=request.getContextPath()%>/image/logo_6.jpg" /></a></li>
	</ul>
</div>
</body>
</html>