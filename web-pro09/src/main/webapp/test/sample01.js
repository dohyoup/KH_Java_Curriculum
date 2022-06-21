/**
 * 
 */
 var errorMassgeBox = document.querySelectorAll("input[required]");
 for(errorBoxEvent of errorMassgeBox) {
	errorBoxEvent.addEventListener("blur", blurEventHandler);
}
 
 
function blurEventHandler() {
	// span호출해야한다 위에꺼는 input에다가 이벤트건거다 
}
 
/* 
	var in1 = document.getElementById("userid");
	var error1 = document.querySelector("#er1");
function handleBlur1() {
		if(in1.value ==="") {
			 error1.innerText = "필수 입력 항목 입니다";
			 error1.style.color ="red";
		}else {
			 error1.innerText = "";	
		}
    }
    
in1.addEventListener("blur", handleBlur1);


function f2() {
	let error2 = document.getElementById("er2");
	error2.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
}


 	var in2 = document.getElementById("userpw");
 	var error2 = document.querySelector("#er2");
function handleBlur2() {
		if(in2.value ==="") {
			 error2.innerText = "필수 입력 항목 입니다";
			 error2.style.color ="red";
		}else {
			 error2.innerText = "";	
		}
    }
    
in2.addEventListener("blur", handleBlur2);

	

	var in3 = document.getElementById("pwcheck");
	var error3 = document.querySelector("#er3");
function handleBlur3() {
		if(in3.value ==="") {
			 error3.innerText = "필수 입력 항목 입니다";
			 error3.style.color ="red";
		}else {
			 error3.innerText = "";	
		}
    }
    
in3.addEventListener("blur", handleBlur3);
*/
/*
window.onload = function() {
	initEventBinding();
}

function initEventBinding() {
	requiredEventBinding();
}

function requiredEventBinding() {
	var requiredElement = document.querySelectorAll("input[required]");
	for(let element of requiredElement) {
		element.addEventListener("blur", requiredHandler);
	}
}

function requiredHandler(e) {
	var element = e.target;
	var messageControl = element.parentElement.nextElementSibling;
	var messageLabel = messageControl.getElementsByClassName("error_next_box")[0];
	
	if(element.value){
		messageControl.style.display = "none";
		messageLabel.style.color = "";
		messageLabel.innerText = ""
	} else {
		messageControl.style.display = "inline";
		messageLabel.style.color = "red";
		messageLabel.innerText = "필수 입력 항목입니다."
	}
}


const in1 = document.querySelector("#userid");
const test = in1.parentElement.nextElementSibling;
console.log(test);
*/




















