// 出勤時間登録ボタンクリック
$(function() {
	$('#registAttendance').click(function(){
          cmnAjax($('#formAttendance'), '/attendance');
	})	
})

