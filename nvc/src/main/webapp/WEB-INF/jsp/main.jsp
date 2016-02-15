<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.logo {width:180px; height:46px;margin-top:12px;margin-left:12px;float:left;positon:relative;background-image:url(<%=request.getContextPath()%>/image/logo_p.png)}
	.ret  {float:right;position:relative;margin-right:20px;margin-top:50px}
</style>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json2.js"></script>

<script type="text/javascript">
	$(function() {
		$("#treeFileList").tree({
			onClick: function(node) {
				if ($("#treeFileList").tree("isLeaf", node.target)) {
					var fileName = node.text;
					var pageName = "";
					if (fileName.match(/.mp3$/)){
						pageName = "audioplayer.html?id=";
					}
					else {
						pageName = "videoplayer.html?id=";
					}
					var content =content ='<iframe scrolling="auto" frameborder="0" src="' + pageName + node.id +'" style="width:100%; height:100%"></iframe>';;
					$("#workspace").panel({content: content});
				}
			},
			
			onDblClick: function(node) {
				if (!$("#treeFileList").tree("isLeaf", node.target)) {
					$("#treeFileList").tree("toggle", node.target);
				}
			}
		
		});
	});
</script>

<title>筝韵艺校</title>
</head>
<body class="easyui-layout">
	<div region="north" style="height:70px">
	 	<div class="logo"></div>
	 	<div class="ret"><a href="index.html">返回首页</a></div>
	</div>
	<div region="west" split="true" style="width:200px">
		<ul id="treeFileList" class="easyui-tree" url="getfilelist.html" data-options="method:'GET'"></ul>
	</div>
	<div id="workspace" region="center" split="true" class="easyui-panel">
	</div>
</body>
</html>