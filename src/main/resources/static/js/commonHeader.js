$(function() {
  // Sign-Outクリック
  $('#SignOut').click(function() {
    let f = $('form');
    f[0].action = '/logout';
    f.submit();
  })

  // menuへクリック
  $('#ToMenu').click(function() {
    location.href='/menu';
  })
})

