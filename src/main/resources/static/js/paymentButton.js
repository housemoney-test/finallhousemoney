/**
 * 入金ボタンをクリック→入金フォームに変更＋入金ボタンの無効化
 * 出金ボタンをクリック→出金フォームに変更＋出金ボタンの無効化
 */

const incomeButton = document.getElementById("incomeButton");
const spendingButton = document.getElementById("spendingButton");
const incomeForm = document.getElementById("incomeForm");
const spendingForm = document.getElementById("spendingForm");

incomeButton.disabled = true;
spendingForm.style.visibility = "hidden";

function clickIncome() {
	spendingForm.style.visibility = "hidden";
	incomeForm.style.visibility = "visible";
	spendingButton.disabled = false;
	incomeButton.disabled = true;
}

function clickSpending() {
	incomeForm.style.visibility = "hidden";
	spendingForm.style.visibility = "visible";
	incomeButton.disabled = false;
	spendingButton.disabled = true;
}