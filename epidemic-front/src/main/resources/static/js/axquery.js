var Ax = {};

/* log */
Ax.log = function (msg) {
    try {
        layer.msg(msg);
    } catch (err) {
    }
};

// Error code preprocessing:
// return true to indicate filtered processing;Return false to indicate unfiltered
Ax.restErrFilter = function (statusCode, message) {
    return false;
}
// Default error handling
Ax.restErrHandler = function (statusCode, message) {
    layer.msg(message);
};
// rest there is no return 200 ( May return 500 wait error)
Ax.httpErrHandler = function () {
    // alert("server error");
};
// serviceUri：serviceName, req：Request parameter object
// dataHandler：Reply data processing function
Ax.rest = function (serviceUri, req, dataHandler, restErrHandler) {
    jQuery.ajax({
        url: serviceUri,
        method: "POST",
        processData: false,
        data: JSON.stringify(req),
        dataType: 'json',
        async: true,
        contentType: "application/json; charset=utf-8",
        success: function (ans) {
            if (ans.code != 0) {
                // A uniform filter is applied first
                if (Ax.restErrFilter(ans.code, ans.errorMessage)) return;

                // Use the fourth parameter (handled by the user's own processor)
                if (restErrHandler != null)
                    restErrHandler(ans.code, ans.errorMessage);
                else
                // If the fourth parameter is not provided, go to default processing (alert)
                    Ax.restErrHandler(ans.code, ans.errorMessage);
            } else {
                dataHandler(ans.data);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            Ax.httpErrHandler();
        },
    });
}




	