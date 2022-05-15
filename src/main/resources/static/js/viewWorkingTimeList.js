// 一覧表示ボタンクリック
$(function() {
	$('#viewWorkingTimeList').click(function(){
          cmnAjax($('#formAttendance'), '/viewWorkingTimeList');
	})	
})

