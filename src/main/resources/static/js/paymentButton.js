/**
 * 入金ボタンをクリック→入金フォームに変更＋入金ボタンの無効化
 * 出金ボタンをクリック→出金フォームに変更＋出金ボタンの無効化
 */

const incomeButton = document.getElementById("incomeButton");
const spendingButton = document.getElementById("spendingButton");
const incomeForm = document.getElementById("incomeForm");
const spendingForm = document.getElementById("spendingForm");

incomeButton.disabled = true;
spendingForm.style.display = "none";

function clickIncome() {
	spendingForm.style.display = "none";
	incomeForm.style.display = "block";
	spendingButton.disabled = false;
	incomeButton.disabled = true;
}

function clickSpending() {
	incomeForm.style.display = "none";
	spendingForm.style.display = "block";
	incomeButton.disabled = false;
	spendingButton.disabled = true;
}