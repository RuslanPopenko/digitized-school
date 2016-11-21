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

function updatePerson() {
    var data = {};
    data['firstName'] = $('#firstName').val();
    data['lastName'] = $('#lastName').val();
    data['age'] = $('#age').val();
    data['sex'] = $('#sex').val();
    var url = '/api/persons/'+$('#id').val();
    var method = 'PUT';

    sendAjax(url, method, data, function (data) {
        $('#response').html('Updated person with id = ' + data.id);
    });
};

function getPerson() {
    var url = '/api/persons/'+$('#id').val();
    var method = 'GET';

    $.ajax({
        url: url,
        type: method,
        contentType: 'application/json; charset=utf-8'
    });
}

function getAllPersons() {
    var url = '/api/persons';
    var method = 'GET';

    $.ajax({
        url: url,
        type: method,
        contentType: 'application/json; charset=utf-8'
    });
}

function deletePerson() {
    var url = '/api/persons/'+$('#id').val();
    var method = 'DELETE';

    $.ajax({
        url: url,
        type: method,
        contentType: 'application/json; charset=utf-8',
        success: function () {
            $('#response').html('Deleted person with id = ' + $('#id').val());
        }
    });
}

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