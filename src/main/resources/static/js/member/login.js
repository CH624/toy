$(document).ready(function () {
    $('#loginForm').validate({
        submitHandler: function() {
            $.ajax({
                type: 'POST',
                url: '/login',
                data: JSON.stringify({
                        loginId : document.getElementById('loginId').value,
                        password : document.getElementById('password').value,
                }),
                contentType: 'application/json',
                success: function (result) {
                    sessionStorage.setItem('token', result);

                },
                error: function (request) {
                    toastr.error(request.responseJSON.message, 'Error');
                },
            });
        },
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