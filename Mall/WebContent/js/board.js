//해당 URL로 이동하는 기능 수행
function goUrl(url){
	location.href = url;
}

//삭제 여부를 학인 후 해당 URL로 이동하는 기능 수행
function deleteCheck(url){
	if(confirm('정말로 삭제하시겠습니까?')){
		goUrl(url);
	}
}

//작성/수정 폼의 공백을 체크하는 기능
function boardWriteCheck(form){
		
	if(form.title.value.length == 0){ // <- 이거랑
		alert("겁나 어렵군요 제목 넣으세요");
		form.title.focus();
		return;
	}
	
	if(form.writer.value == ""){ // <- 이거랑 조건이 같은거에요
		alert("겁나 어렵군요 이름 넣으세요");
		form.writer.focus();
		return;
	}
	
	/*if(form.contents.value == ""){
		alert("겁나 어렵군요 내용 넣으세요");
		form.contents.focus();
		return;
	}
	*/
	if(CKEDITOR.instances.editor.getData() == ""){
		alert("겁나 어렵군요 내용 넣으세요");
		CKEDITOR.instances.editor.focus();
		return;
	}
	form.submit();
}

//검색창의 공백을 체크하는 기능
function searchCheck(form){
	
	if(form.searchText.value == ""){
		alert("검색어를 입력하세요");
		form.searchText.focus();
		return;
	}
	
	form.submit();
}

//폼 필드가 비어있는지 여부를 체크하여 에러메시지를 출력
function checkNotEmpty(inputField, errorSpan){	
	if(inputField.value.length == 0){
		errorSpan.innerHTML = "작성자 이름을 입력하세요";
	}else{
		errorSpan.innerHTML = "";
	}
}