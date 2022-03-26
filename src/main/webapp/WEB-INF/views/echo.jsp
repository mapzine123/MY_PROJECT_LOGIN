<%--
  Created by IntelliJ IDEA.
  User: mapzi
  Date: 2022-03-27
  Time: 오전 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="body_container">
    <div id="one">
        별명 : <input type="text" id="nickname" />
        <input type="button" id="enter" value="입장" />
    </div>

    <div id="two" style="display: none">
        <input type="button" id="exit" value="퇴장"/>
        <br/>
        <div id="chatarea" style="width: 400px; height: 600px; border: 1px solid;"></div>
        <input type="text" id="message"/>
        <input type="button" id="send" value="보내기"/>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        let websocket;
        one = document.getElementById("one");
        two = document.getElementById("two");
        document.getElementById("enter").addEventListener("click", function() {
            connect();
        })

        document.getElementById("exit").addEventListener("click", function() {
            disconnect();
        });

        document.getElementById("send").addEventListener("click", function() {
            send();
        });


        function connect() { //
            // 웹 소켓 주소
            const wsUri = "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/websocket/echo.do";

            // 소캣 객체 생성
            websocket = new WebSocket(wsUri);
            // 웹 소켓에 이벤트 발생했을 때 호출될 함수 등록
            websocket.onopen = onOpen;
            websocket.onmessage = onMessage;
            websocket.onclose = onClose;
        }

        function disconnect() {
            msg = document.getElementById("nickname").value;
            websocket.send(msg + "님이 퇴장하셨습니다.");
            websocket.close();
        }

        function send() {
            nickname = document.getElementById("nickname").value;
            msg = document.getElementById("message").value;
            websocket.send(nickname + " : " + msg);
            document.getElementById("message").value = "";
        }

        function onOpen() { // 웹소켓에 연결됐을때 호출 될 함수
            nickname = document.getElementById("nickname").value;
            two = document.getElementById("two");
            two.style.display = 'block';
            websocket.send(nickname + "님 입장하셨습니다.");
        }

        function onMessage(evt) {
            data = evt.data;
            chatarea = document.getElementById("chatarea");
            chatarea.innerHTML = data + "<br/>" + chatarea.innerHTML;
        }

        function onClose() {

        }
    });
</script>
</body>
</html>
