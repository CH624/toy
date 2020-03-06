$(document).ready(function () {
    $('#loginForm').validate({
        rules: {
            loginId: {
                required: true,
                minlength: 5,
            },
            password: {
                required: true,
                minlength: 8
            }
        },
        messages: {
            loginId: {
                required: "Please enter a login id",
            },
            password: {
                required: "Please provide a password",
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