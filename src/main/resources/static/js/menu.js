// 出勤時間登録ボタンクリック
$(function() {
	$('#updAttendance').click(function(){
    location.href='/attendance';
	})	
})

// 退勤時間登録ボタンクリック
$(function() {
	$('#updLeaving').click(function(){
    location.href='/leaving';
	})	
})

// 一覧表示ボタンクリック
$(function() {
  $('#viewWorkingTimeList').click(function(){
    location.href='/viewWorkingTimeList';
  })  
})
