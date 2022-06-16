/**
 * 
 */
res1 = document.getElementById("res1"); // res1태그 내용 가져오기

var arr1 = [1, 2, 3, 4];
res1.innerHTML += "var arr1 = [1, 2, 3, 4];" + "<br>"; //태그 내용변경 (추가)
res1.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>"; 
res1.innerHTML += "<br>"; 

var arr2 = new Array(1, 2, 3, 4);
res1.innerHTML += "var arr2 = new Array(1, 2, 3, 4);" + "<br>";
res1.innerHTML += "실행 후 출력 결과 : " + arr2 + "<br>";
res1.innerHTML += "<br>"; 

res2 = document.getElementById("res2");
res2.innerHTML += "arr1[0] -> " + arr1[0] + "<br>";
res2.innerHTML += "arr1[1] -> " + arr1[1] + "<br>";
res2.innerHTML += "arr1[2] -> " + arr1[2] + "<br>";


res3 = document.getElementById("res3");
res3.innerHTML += "값의 인덱스위치 반환 / -1은 값이 없다는 의미" + "<br>";
res3.innerHTML += "arr1.indexOf(2) -> " + arr1.indexOf(2) + "<br>";
res3.innerHTML += "arr1.indexOf(3) -> " + arr1.indexOf(3) + "<br>";
res3.innerHTML += "arr1.indexOf(4) -> " + arr1.indexOf(4) + "<br>";
res3.innerHTML += "arr1.indexOf(5) -> " + arr1.indexOf(5) + "<br>";
res3.innerHTML += "<br>";

res4 = document.getElementById("res4");
res4.innerHTML += "원본은 유지하고 배열을 합친 결과값을 반환해준다." + "<br>";
res4.innerHTML += "arr1.concat(['a','b','c']) -> " + arr1.concat(['a','b','c']) + "<br>";
res4.innerHTML += "arr1 원본은 유지-> " + arr1 + "<br>";
res4.innerHTML += "<br>";

res5 = document.getElementById("res5");
res5.innerHTML += "원본은 유지하고 배열을 합친 결과값을 문자열로 반환해준다." + "<br>";
res5.innerHTML += "arr1.join() -> " + arr1.join() + "<br>";
res5.innerHTML += "arr1.join('/') -> " + arr1.join('/') + "<br>";
res5.innerHTML += "arr1.join('-') -> " + arr1.join('-') + "<br>";
res5.innerHTML += "arr1 원본은 유지-> " + arr1 + "<br>";
res5.innerHTML += "<br>";

res6 = document.getElementById("res6");
res6.innerHTML += "arr1.push(10) -> 값 추가 후의 배열의 크기(길이)반환 " + arr1.push(10) + "<br>";
res6.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res6.innerHTML += "arr1.push(20, 30) -> " + arr1.push(20, 30) + "<br>";
res6.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res6.innerHTML += "<br>";

res7 = document.getElementById("res7");
res7.innerHTML += "arr1.unshift(5) -> 값 추가 후의 배열의 크기(길이)반환" +arr1.unshift(5) + "<br>";
res7.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res7.innerHTML += "arr1.unshift(6, 7) -> " + arr1.unshift(6, 7) + "<br>";
res7.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res7.innerHTML += "<br>";

res8 = document.getElementById("res8");
res8.innerHTML += "arr1.pop() -> 배열의 뒤에있는 값 제거 후 제거 값 반환" + arr1.pop() + "<br>";
res8.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res8.innerHTML += "<br>";

res9 = document.getElementById("res9");
res9.innerHTML += "arr1.shift() -> 배열의 앞에있는 값 제거 후 제거 값 반환" + arr1.shift() + "<br>";
res9.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res9.innerHTML += "<br>";

res10 = document.getElementById("res10");
res10.innerHTML += "arr1.slice(2) -> 선택한 인덱스 배열값부터 이후 배열 요소들을 잘라서 출력(원본은 유지)" + "<br>";
res10.innerHTML += "원본값 -> " + arr1 + "<br>";
res10.innerHTML += "실행 후 출력 결과 -> " + arr1.slice(2) + "<br>";
res10.innerHTML += "<br>";
res10.innerHTML += "arr1.slice(2, 6) ->  요소 사이에 범위값을 지정 해서 그 범위에 해당하는값만 잘라서 출력(원본유지)"  + "<br>";
res10.innerHTML += "원본값 -> " + arr1 + "<br>";
res10.innerHTML += "실행 후 출력 결과 -> " + arr1.slice(2, 6) + "<br>";
res10.innerHTML += "<br>";

res11 = document.getElementById("res11");
res11.innerHTML += "arr1.splice(2,0,10,15) -> 선택한 인덱스 위치의 배열값부터 원하는 만큼 배열값을 제거하고 제거한 인덱스위치부터 원하는 요소를 추가한다 반환은 제거한 인덱스값을 반환" + "<br>";
res11.innerHTML += "원본값 -> " + arr1 + "<br>";
res11.innerHTML += "실행 후 출력 결과 -> 0값은 해당위치의 요소를 삭제하지 않겠다. 제거한 요소가 없으므로 반환값이 없다.-> " + arr1.splice(2, 0, 10, 15) + "<br>";
res11.innerHTML += "<br>";
res11.innerHTML += "arr1.splice(2, 4 , 20, 30, 40) ->  인덱스2번 요소부터 4개의 요소를 지우고 인덱스 2번부터 20, 30, 40 요소를 추가하겠다." + "<br>";
res11.innerHTML += "원본값 -> " + arr1 + "<br>";
res11.innerHTML += "실행 후 출력 결과 -> " + arr1.splice(2, 4 , 20, 30, 40)  + "<br>";
res11.innerHTML += "<br>";

res12 = document.getElementById("res12");
res12.innerHTML += "arr1.sort() : 문자열로 정렬 ->" + arr1.sort(); + "<br>";
res12.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res12.innerHTML += "<br>";
res12.innerHTML += "arr1.sort(function(x,y) {return(x - y)}) 숫자로 오름차순 -> " + arr1.sort(function(x,y) {return(x - y)}); + "<br>";
res12.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res12.innerHTML += "<br>";
res12.innerHTML += "arr1.sort(function(x,y) {return(y - x)}) 숫자로 내림차순 -> " + arr1.sort(function(x,y) {return(y - x)}); + "<br>";
res12.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res12.innerHTML += "<br>";

res13 = document.getElementById("res13");
res13.innerHTML += " 원본 ->" + arr1; + "<br>";
res13.innerHTML += "arr1.reverse() : 원본순서 반대로 정렬 ->" + arr1.reverse(); + "<br>";
res13.innerHTML += "실행 후 출력 결과 -> " + arr1 + "<br>";
res13.innerHTML += "<br>";

var input1 = document.getElementById("input1");
var exam1 =  document.getElementById("exam1");

var arr3 =  input1.value.split(",");
for(let i = 0; i < arr3.length; i++) {
	arr3[i] = arr3[i].trim();
}

exam1.innerHTML += "['" + arr3.join("','") + "']";


var input2 = document.getElementById("input2");
var exam2 =  document.getElementById("exam2");

var arr4 = input2.value.split(",");
var total = 0;

for(let item of arr4) {
	item = parseInt(item);
	arr3.push(item);
	total += parseInt(item);
}

//arr3= arr3.concat(arr4);
arr3.push(total);
exam2.innerHTML += "['" + arr3.join("','") + "']";
