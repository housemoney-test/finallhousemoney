/**
 * 
 */

const today = new Date();
let showDate = new Date(today.getFullYear(), today.getMonth(), 1);

const prev = () => {
	showDate.setMonth(showDate.getMonth() -1);
	createCalendar(showDate);
}

const next = () => {
	showDate.setMonth(showDate.getMonth() + 1);
	createCalendar(showDate);
}

const createCalendar = (date) => {
	let year = date.getFullYear();
	let month = date.getMonth();
	document.querySelector('#calendarHeader').innerHTML = year + "年" + (month +1) + "月";

	let calendar = createTable(year, month);
	document.querySelector('#calendar').innerHTML = calendar;
}

window.onload = () => {
	createCalendar(today);
}

const week = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

const createTable = (year, month) => {
	let calendar = "<table class='calendar'><tr class='dayOfWeek'>";
	for (let i = 0; i < week.length; i++) {
		calendar += "<th>" + week[i] + "</th>";
	}
	calendar += "</tr>";

	let count = 0;
	let startDayOfWeek = new Date(year, month, 1).getDay();
	let endDate = new Date(year, month + 1, 0).getDate();
	let lastMonthEndDate = new Date(year, month, 0).getDate();
	let row = Math.ceil((startDayOfWeek + endDate) / week.length);

	for (let i = 0; i < row; i++) {
		calendar += "<tr>";
		for (let j = 0; j < week.length; j++) {
			if (i == 0 && j < startDayOfWeek) {
				calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
			} else if (count >= endDate) {
				count ++;
                calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
			} else {
				count ++;
				if(year == today.getFullYear() && month == (today.getMonth()) && count == today.getDate()){
                    calendar += "<td class='today'>" + count + "</td>";
                }else{
                    calendar += "<td>" + count + "</td>";
                }
			}
		}
		calendar += "</tr>";
	}

	return calendar;
}