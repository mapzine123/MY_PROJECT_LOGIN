$(document).ready(function() {
    let websocket;

    let sendBtn = document.querySelector(".sendBtn");

    function connect() {
        const wsUri = sessionStorage.getItem("wsUri");
        const name = sessionStorage.getItem("name");

        websocket = new WebSocket(wsUri);

        websocket.onopen = onOpen;
        websocket.onmessage = onMessage;
        websocket.onclose = onClose;

        function disconnect() {
            websocket.send(name + "님이 퇴장하셨습니다.");
            websocket.close();
        }

        function send() {
            let messageBox = document.querySelector(".messageBox");
            msg = messageBox.value;
            if(msg.trim() !== "") {
                websocket.send(name + " : " + msg);
            }
            document.querySelector(".messageBox").value = "";
            messageBox.focus();
        }

        function onOpen() {
            websocket.send(name + "님이 입장하셨습니다.");
        }
        function onMessage(event) {
            data = (event.data).slice(3, event.data.length);
            messageBox = document.querySelector(".chatBox");
            messageBox.innerHTML = data + "<br/>" + messageBox.innerHTML;
        }
        function onClose() {

        }
        document.querySelector(".sendBtn").addEventListener("click", send);
        const divForm = document.querySelector(".divForm");
        function sendMsg(event) {
            event.preventDefault();
            send();
        }
        divForm.addEventListener("submit", sendMsg);

        $(window).on("beforeunload", disconnect);
    }
    connect();


});