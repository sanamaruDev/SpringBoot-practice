// 退勤時間登録ボタンクリック
$(function() {
	$('#registLeaving').click(function(){
          cmnAjax($('#formLeaving'), '/leaving');
	})	
})

