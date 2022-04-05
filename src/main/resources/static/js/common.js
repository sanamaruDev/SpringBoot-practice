// ドロップダウンリスト選択内容表示
$(function(){
    $('.dropdown-menu .dropdown-item').click(function(){
        var visibleItem = $('.dropdown-toggle', $(this).closest('.dropdown'));
        visibleItem.text($(this).attr('value'));
   });
});

// 共通ajax処理
// ・formの値をJSON形式に変換
// ・type="button"のvulueがcontrollerでマッピングされないために独自メソッド追加
function cmnAjax(objForm, url){
	
  let jsonData = JSON.stringify(formToJson(objForm));
  $.ajax({
  	url: url,
      type: 'post',
      data: jsonData,
      contentType : 'application/json',
      dataType: "json",
 	})     
 	.done(function(data) {
		// data にサーバーから返された html が入る
		// 通信が成功したときの処理
		alert('成功');
 	}) 
	.fail(function(data) {
		// 通信が失敗したときの処理
		alert('失敗');
 	})
 	.always(function(data) {
		// 通信が完了したとき
 	});	
}	
	
// ajax送信用
// formの値をjson形式に変換
function formToJson(objForm){

	let mapForm = {};
		
	for(let i = 0; i <= objForm[0].elements.length - 1; i++) {
		
		let objEle = objForm[0].elements[i];
		
		if (objEle.name == null || objEle.name == "") {
			// nameなしの場合、次ループへ
			continue;	
		}
		
		switch (objEle.type){
		  case 'button':
		    // ドロップダウンリスト用
		    mapForm[objEle.name] = objEle.textContent;
		    break;
		  default:
		    mapForm[objEle.name] = objEle.value;
		}
	}

	return mapForm;

}