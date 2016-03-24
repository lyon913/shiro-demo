<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var="ctx" value="/" />
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/resources/js/LodopFuncs.js"></script>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}

.printObj {
	width: 800px;
	height: 650px;
}
</style>
<title>证书打印</title>
</head>
<body>
	<div align="center">
		<object id="LODOP_OB"
			classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" class="printObj">
			<embed id="LODOP_EM" type="application/x-print-lodop"
				class="printObj">
		</object>
	</div>
	<button onclick="setup()">维护</button>
	<button onclick="design()">设计</button>
	<script type="text/javascript">
		var bgImgUrl = '<c:url value="/resources/image/zs/zs_p1.jpg"/>';
		var data = ${data_json};
		var LODOP;
		$(function() {
			LODOP = getLodop(document.getElementById('LODOP_OB'), document
					.getElementById('LODOP_EM'));
			createPage();
			preview();
		});

		function preview() {
			LODOP.SET_SHOW_MODE("PREVIEW_IN_BROWSE", 1);
			LODOP.SET_PREVIEW_WINDOW(0, 0, 1, 800, 600, '打印')
			LODOP.PREVIEW();
		}

		function setup() {
			LODOP.SET_SHOW_MODE("SETUP_IN_BROWSE", 1);
			LODOP.PRINT_SETUP();
		}

		function design() {
			LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE", 1);
			LODOP.PRINT_DESIGN();
		}

		function createPage() {
			//页面设置
			LODOP.PRINT_INITA(0, 1, 983, 699, "不动产登记证书_第一页_v1.4");
			LODOP.SET_PRINT_PAGESIZE(0, 2600, 1850, "16K");
			LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' style='margin:0;padding:0;' src='/shiro-demo/resources/image/zs/zs_p1.jpg'>");
			LODOP.SET_SHOW_MODE("BKIMG_LEFT", 0);
			LODOP.SET_SHOW_MODE("BKIMG_TOP", 0);
			LODOP.SET_SHOW_MODE("BKIMG_WIDTH", "259.03mm");
			LODOP.SET_SHOW_MODE("BKIMG_HEIGHT", "178.06mm");
			LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW", true);

			//证书数据
			LODOP.ADD_PRINT_TEXT(86, 133, 294, 21, data.QLR);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(123, 133, 294, 21, data.GYQK);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(163, 133, 294, 21, data.ZL);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(203, 133, 294, 21, data.BDCDYH);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(242, 133, 294, 21, data.QLLX);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(281, 133, 294, 21, data.QLXZ);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(319, 133, 294, 21, data.YT);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(350, 133, 294, 21, data.MJ);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(398, 133, 294, 21, data.SYQX);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(440, 133, 293, 184, data.QLQTQK);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);
			LODOP.ADD_PRINT_TEXT(83, 551, 361, 476,	data.FJ);
			LODOP.SET_PRINT_STYLEA(0, "FontSize",10);

			
			//证书省份
			LODOP.ADD_PRINT_TEXT(40, 50, 37, 28, data.A);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 12);
			LODOP.SET_PRINT_STYLEA(0, "Alignment", 2);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			//证书年份
			LODOP.ADD_PRINT_TEXT(40, 102, 50, 28, data.B);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 11);
			LODOP.SET_PRINT_STYLEA(0, "Alignment", 2);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			//证书市、县
			LODOP.ADD_PRINT_TEXT(40, 165, 87, 28, data.C);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 12);
			LODOP.SET_PRINT_STYLEA(0, "Alignment", 2);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			//证书号7位
			LODOP.ADD_PRINT_TEXT(40, 338, 81, 28, data.D);
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 12);
			LODOP.SET_PRINT_STYLEA(0, "Alignment", 2);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);

			LODOP.ADD_PRINT_BARCODE(573, 640, 199, 49, "PDF417", data.barcode);

		};
	</script>
</body>
</html>