/**
 * 
 */
const tabItem = document.querySelectorAll('.tab-item');
const tabContent = document.querySelectorAll('#tab-content');

for (let i = 0; i < tabItem.length; i++) {
	tabItem[i].addEventListener('click', tabToggle);
}

function tabToggle() {
	const activeItems = document.querySelectorAll('.active');
	activeItems.forEach(element => {
		element.classList.remove("active");
	})
	this.classList.add('active');
	
	const aryTabs = Array.prototype.slice.call(tabItem);
	const index = aryTabs.indexOf(this);
	tabContent[index].classList.add('active');
}
