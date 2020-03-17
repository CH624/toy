$(document).ready(function () {
    $('#registerForm').validate({
        rules: {
            loginId: {
                required: true,
                minlength: 5,
                remote : "/register/check"
            },
            password: {
                required: true,
                minlength: 8
            },
            retypePassword: {
                required: true,
                minlength: 8
            },
            name: {
                required: true
            },
        },
        messages: {
            name:{
                required: "Please choose a name",
            },
            loginId: {
                required: "Please enter a login id",
                minlength: "Your login id must be at least 5 characters long",
                remote : "존재하는 아이디입니다"
            },
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 8 characters long"
            },
            retypePassword: {
                required: "Please provide a retype password",
                minlength: "Your password must be at least 8 characters long"
            }
        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.input-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });
});