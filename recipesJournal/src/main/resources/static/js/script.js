$(document).ready(function(e){
    $('form#register-form button[type=button], form#login-form button[type=button]').on('click', (e) => {
        $('form#register-form').fadeToggle();
        $('form#login-form').slideToggle();
        console.log(e);
    });
});