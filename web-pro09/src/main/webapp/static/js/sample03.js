/**
 * 
 */
var std = {
    name: "홍길동",
    age: 23,
    gender: "M"
};  

function f1() {
	var res1 = document.getElementById("res1");
	res1.innerHTML += " var std = {" + "<br>";
	res1.innerHTML += "     name: '홍길동'," + "<br>";
	res1.innerHTML += "     age: 23," + "<br>";
	res1.innerHTML += "     gender: 'M'," + "<br>";
	res1.innerHTML += " }" + "<br>";
}

function f2() {
	var res2 = document.getElementById("res2");
	res2.innerHTML += "std.name ->" + std.name + "<br>";
	res2.innerHTML += "std['name'] ->" + std["name"] + "<br>";
}


function f3() {
	var res3 = document.getElementById("res3");
	for(let key in std) {
		res3.innerHTML += "std['" + key + "'] -> " + std[key] + "<br>";
	};
}

function f4() {
	var name = document.getElementById("id_input1_name");
	var age = document.getElementById("id_input1_age");
	var gender = document.getElementById("id_input1_gender");
	var res4 = document.getElementById("res4");
	var n, a, g
	
	if(!name.value) {
		res4.innerHTML = "이름을 입력하세요.";
		name.focus();
		return;
	}
	n = name.value;
	
	if(!age.value) {
		res4.innerHTML = "나이를 입력하세요.";
		age.focus();
		return;
	}
	a = parseInt(age.value);
	
	if(gender.selectedIndex == 0) {
		res4.innerHTML = "성별을 입력하세요.";
		gender.focus();
		return;
	}
	g = gender.value;
	
	
	var student =  genStudent(n, a, g);
	
	res4.innerHTML = "";
	for(let key in student) {
		res4.innerHTML += "student['"+ key +"'] -> " + student[key] + "<br>";
	};
}



function f5() {
	var res4 = document.getElementById("res4")
	var res5 = document.getElementById("res5")
	
	if(!res4.innerHTML) {
		res5.innerHTML = "함수로 객체 만들기를 먼저 진행하세요."
		return;
	}
	

	var name = document.getElementById("id_input1_name");
	var age = document.getElementById("id_input1_age");
	var gender = document.getElementById("id_input1_gender");
	var n, a, g
	
	n = name.value;
	a = parseInt(age.value);
	g = gender.value;
	
	
	var student =  genStudent(n, a, g);
	
	student.getGender = function() {
		if(this.gender === "M") {
			return "남자";
		} else {
			return "여자";
		}
	};
	
	 name = document.getElementById("id_input2_name");
	 age = document.getElementById("id_input2_age");
	 gender = document.getElementById("id_input2_gender");
	
	 name.value = student.name;
	 age.value = student.age;
	 gender.value = student.getGender();
}
function genStudent(name, age, gender) {
	var student = {
		name: name,
		age: age,
		gender: gender
	};
	return student;
}




function f6() {
var width = document.getElementById("id_input3_width");
var height = document.getElementById("id_input3_height");
var color = document.getElementById("id_input3_color");
var res6 = document.getElementById("res6");

if(!width.value) {
		res6.innerHTML = "너비를 입력하세요.";
		width.focus();
		return;
	}
	
	if(!height.value) {
		res6.innerHTML = "높이를 입력하세요.";
		height.focus();
		return;
	}

	if(!color.value) {
		res6.innerHTML = "색상코드를 입력하세요.";
		color.focus();
		return;
	}
	
	var square = genSquare(width.value, height.value, color.value);
	/*
	var tag ="<div style='display':inline-block; width:" +square.width +"px;";
	tag += "height:" + square.height + "px;";
	tag += "background-color:" + square.color + ";'>HTML 태그를 문자열로 만들어 innerHTML 에 설정</div>"
	*/
	var element = document.createElement("div");
	element.style.width = square.width + "px";
	element.style.height = square.height + "px";
	element.style.backgroundColor = square.color + "px";
	element.innerText = "HTML 태그 객체 생성하여 추가"
 	res6.appendChild(element);
		


	/*
	for(let key in square) {
		if(typeof(square[key]) ==="function") {
			res6.innerHTML += "square['"+ key +"']() -> " + square[key]() + "<br>";
		} else {
			res6.innerHTML += "square['"+ key +"'] -> " + square[key] + "<br>";
		}
	};
	*/	
}


function genSquare(width=1, height=1, color="#000000") {
	 var square =  {
		width: width,
		height: height,
		color: color,
		getArea: function() {
			return this.width * this,height;
		}
	};
	return square;
}










