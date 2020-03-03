$(document).ready(function () {
    $.validator.setDefaults({
        submitHandler: function () {
            CommonAjax.setData('POST', '/api/register', $('#registerForm').serialize());
            CommonAjax.manipulateServerData(function (result) {
                if(result.operationStatus === 'SUCCESS'){
                    toastr.options.onHidden = function() { window.location.href='/login' };
                    toastr.options.timeOut = '2000';
                    toastr.success('회원가입 성공', 'Success');
                }else{
                    toastr.error('회원가입 실패', 'Error');
                }
            })
        }
    });
    $('#registerForm').validate({
        rules: {
            loginId: {
                required: true,
                minlength: 5,
                remote : "/api/register/check"
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