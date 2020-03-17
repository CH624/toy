var CommonAjax = CommonAjax || {
    type: null,
    url: null,
    data: null,
    callback: null,
};

CommonAjax.setData = function (type, url, data) {
    this.type = type;
    this.url = url;
    this.data = data;
};

CommonAjax.getServerData = function () {
    var resultData = null;
    $.ajax({
        async: false,
        url: this.url,
        type: this.type,
        data: this.data,
        dataType: 'json',
        contentType: 'application/json',
        success: function (result) {
            result.operationStatus === 'SUCCESS' ? resultData = result.content : toastr.error(result.operationMessage, 'Error');
        },
        error: function (request, status, error) {
            toastr.error(request + '/' + status + '/' + error, 'Error');
        },
    });
    return resultData;
};

CommonAjax.manipulateServerData = function (callback) {
    $.ajax({
        async: false,
        type: this.type,
        url: this.url,
        data: this.data,
        dataType: 'json',
        contentType: 'application/json',
        success: function (result) {
            result.operationStatus === 'SUCCESS' ? callback(result) : toastr.error(result.operationMessage, 'Error');
        },
        error: function (request, status, error) {
            toastr.error(request + '/' + status + '/' + error, 'Error');
        },
    });
};