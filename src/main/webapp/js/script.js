/**
 * Created by ruslan on 31.10.16.
 */

function createPerson() {
    var data = {};
    data['firstName'] = $('#firstName').val();
    data['lastName'] = $('#lastName').val();
    data['age'] = $('#age').val();
    data['sex'] = $('#sex').val();
    var url = '/api/persons';
    var method = 'POST';

    sendAjax(url, method, data, function (data) {
        $('#response').html('Created person with id = ' + data.id);
    });

};

function sendAjax(url, method, data, callback) {
    $.ajax({
        url: url,
        type: method,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        dataType: 'json',
        success: callback
    });
};