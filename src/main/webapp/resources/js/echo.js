$(document).ready(function() {
    let websocket;


    function connect() {
        const sendBtn = document.querySelector(".sendBtn");
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
            const cardBorder = document.createElement("div");
            cardBorder.classList.add("card");
            cardBorder.classList.add("border-primary");
            cardBorder.classList.add("mb-3");
            cardBorder.classList.add("messageSize");

            const cardHeader = document.createElement("span");
            cardHeader.classList.add("card-header");
            cardHeader.innerText = sessionStorage.getItem("name");

            const cardBody = document.createElement("span");
            cardBody.classList.add("card-body");

            const cardText = document.createElement("p");
            cardText.classList.add("card-text");
            cardText.innerText = data;

            cardBorder.appendChild(cardHeader);
            cardBorder.appendChild(cardBody);

            cardBody.appendChild(cardText);

            messageBox.prepend(cardBorder);
        }
        function onClose() {

        }
        sendBtn.addEventListener("click", send);
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