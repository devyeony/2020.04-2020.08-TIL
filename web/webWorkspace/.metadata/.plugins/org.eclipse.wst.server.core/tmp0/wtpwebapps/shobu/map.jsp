<%@page import="com.shobu.model.MemberVO"%>
<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>토토판매점 - 쇼부 Shobu</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#chatBox {
	position: fixed;
	bottom: 150px;
	right: 100px;
	background: #170B3B;
	width: 320px;
	height: 350px;
	text-align: center;
	padding-top: 10px;
	border-radius: 10px;
}

#chatlog {
	width: 300px;
	height: 300px;
	resize: none;
}

#msg {
	width: 240px;
}

.button-wrapper {
	display: inline-block;
	margin: 20px 5px;
	padding: 10px;
}

.dark-button-2 {
	background: #333;
}

.show {
	background: #fff;
	border: none;
	padding: 2px;
	cursor: pointer;
	display: block;
	position: relative;
	overflow: hidden;
	transition: all .35s ease-in-out .35s;
	margin: 0 auto;
	width: 150px;
	text-align: center;
}

.dark-button-2 .show, .dark-button-2 .show span {
	background: #333;
	color: #fff;
}

.dark-button-2 .show:after, .dark-button-2 .show:before, .dark-button-2 .show:hover span
	{
	background: #fff;
	color: #444;
}

.show span {
	display: block;
	padding: 15px 30px;
	background: #fff;
	z-index: 100;
	position: relative;
	transition: all .35s ease-in-out .35s;
}

.show:hover span {
	background: #36B4C7;
	color: #fff;
	transition: all .35s ease-in-out .35s;
}

.show:after {
	bottom: -100%;
	right: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.show:hover:after {
	right: 0;
	bottom: 0;
	transition: all ease-in-out .35s;
}

.show:before {
	top: -100%;
	left: -100%;
	content: "";
	width: 100%;
	height: 100%;
	position: absolute;
	background: #36B4C7;
	transition: all .35s ease-in-out .5s;
}

.show:hover:before {
	left: 0;
	top: 0;
	transition: all ease-in-out .35s;
}

#showBox {
	position: fixed;
	bottom: 50px;
	right: 50px;
}
</style>
<!-- 채팅 박스 css 끝 -->

<!-- 맵 스타일 시작 -->
<style>
#map {
	width: 1600px;
	height: 700px;
	margin: 0 auto;
}

.mapBox {
	margin-top: 50px;
	width: 1600px;
	height: 800px;
	align-content: center;
}
</style>

<!--채팅박스 js 시작 -->
<script>
	var userId = "${sessionScope.member.id}";
	var ws = new WebSocket("ws://localhost:8888/wschat"); // 서버 아이피 넣어야함.
	ws.onopen = function() {
		
	};

	ws.onmessage = function(message) {
		var temp = message.data;
		var temp1 = temp.indexOf(":");
		var idPart = temp.substring(0, temp1 - 1); // 세션 아이디랑 동일한지 확인용
		var textPart = temp.substring(temp1 + 1, temp.length);
		var displayId;
		if (idPart == userId) {
			displayId = "My";
		} else {
			displayId = idPart;
		}
		document.getElementById("chatlog").textContent += displayId + " : "
				+ textPart + "\n";
		scrolldown();
	};
	
	function postToServer() { // 서버에 보내는 
		ws.send(userId + " " + document.getElementById("msg").value); //userId 추가했음. 
		document.getElementById("msg").value = ""; // 보내고난 정보 없애는 용도로 사용됨. 
	};
	
	function closeConnect() { // 종료부분
		ws.close();
	};

	// Enter Key 누르면 전송되도록
	function checkEnter() {
		if (window.event.keyCode == 13) {
			postToServer();
		}
	}

	function scrolldown() {
		$('#chatlog').scrollTop($('#chatlog')[0].scrollHeight);
	}

	//JQuery
	$(document).ready(function() {
		<%-- <% /* 시험용 */
			MemberVO member = new MemberVO();
			member.setId("jjy");
			request.getSession().setAttribute("member", member);
		%> --%>
		
		$('#chatBox').hide();
		// 클릭하면 보여지고 다시 클릭하 사라지는
		$('#show').click(function() {
			$('#chatBox').slideToggle();
		});
	});
</script>
<!-- 채팅박스 js 끝 -->

<!-- 맵 스크립트 부분  -->
<script>
	var map;
	function initMap() {

		map = new google.maps.Map(document.getElementById('map'), {
			zoom : 14,
			center : {
				lat : 37.4865187,
				lng : 127.0200871
			}
		});
		<c:forEach items="${mapList}" var="mapArr">
			var marker = new google.maps.Marker({position: {lat: ${mapArr.localY}, lng: ${mapArr.localX}}, map: map}); 
		</c:forEach>
		
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
					lat : position.coords.latitude,
					lng : position.coords.longitude
				};

				map.setCenter(pos);
			}, function() {
				handleLocationError(true, infoWindow, map.getCenter());
			});
		} else {
			handleLocationError(false, infoWindow, map.getCenter());
		}
		
		
	}

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
		infoWindow.setPosition(pos);
		infoWindow
				.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
						: 'Error: Your browser doesn\'t support geolocation.');
	}
</script>
<!-- Map 개인 키 부분 -->
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0085qYvaQZv0nFw1TGj1lWGUdjnv16jU&callback=initMap">
</script>
<!-- 맵 스크립트 부분 끝 -->


</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="mapBox">
		<div style="font-size: 40pt; text-align: center;">토토 판매점</div>
		<br />
		<div id="map"></div>
	</div>

	<!-- chatBox -->
	<div id="chatBox">
		<textarea id="chatlog" readonly></textarea>
		<br /> <input id="msg" type="text" onkeydown="checkEnter()" />
		<button type="submit" id="sendButton" onClick="postToServer()">send</button>
	</div>
	<div class="dark-button-2 button-wrapper" id="showBox">
		<div class="show" id="show">
			<span>잡담 참여</span>
		</div>
	</div>
	<!-- chatBox -->

</body>
</html>