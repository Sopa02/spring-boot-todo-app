window.onload = function() {
    let now = new Date(),
        month = now.getMonth() + 1,
        day = now.getDate(),
        year = now.getFullYear(),
        hour = now.getHours(),
        minute = now.getMinutes();

    month = month < 10 ? '0' + month : month;
    day = day < 10 ? '0' + day : day;
    hour = hour < 10 ? '0' + hour : hour;
    minute = minute < 10 ? '0' + minute : minute;

    let date = [year, month, day].join('-');
    let time = [hour, minute].join(':');
    let dateTime = [date, time].join('T');
    let dueInput = document.getElementById('dueInput');
    dueInput.min = dateTime;
}