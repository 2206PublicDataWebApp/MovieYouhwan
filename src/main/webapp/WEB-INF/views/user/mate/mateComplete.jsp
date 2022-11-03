<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ȯ : ��Ī �Ϸ�</title>
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/mate.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/mate.js" defer></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="mate-option-wrapper">
		<h3>��Ī �Ϸ�!</h3>
		<!-- ��Ī �Ϸ� ��� ���� -->
		<div id="mate-text">
			<div class="matecomplete-profile">����Ʈ ������</div>
			<div class="matecomplete-grade">����Ʈ ��</div>
		</div>
		<!-- ��Ī �Ϸ� ������ �ε� ���� -->
		<div id="mate-data">
			<div class="matecomplete-profile">
				<!-- ���� div : matecomplete-userimage -->
				<div class="matecomplete-userimage"></div>
				ö�� *(20��, ����)
			</div>
			<div class="matecomplete-grade">3.6</div>
			<div class="matecomplete-chatting">
				<button class="go-chatting">ä���ϱ�</button>
			</div>
		</div>
		<!-- ��ư ���� -->
		<div id="matecomplete-button">
			<button class="matecomplete-button">�ٽø�Ī</button>
			<button class="matecomplete-button">��Ī���</button>
		</div>
	</div>
</body>
</html>