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
        $('#responseCreate').html('Created person with id = ' + data.id);
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
        $('#responseUpdate').html('Updated person with id = ' + data.id);
    });
};

function getPerson() {
    var url = '/api/persons/'+$('#id').val();
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        $('#responseGet').html('Person:' + data.firstName + ' '
            + data.lastName + ', age = ' + data.age + ', sex = ' + data.sex);
    });
}

function getAllPersons() {
    var url = '/api/persons';
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        $('#responseGetAll').html('Person:' + data.firstName + ' '
            + data.lastName + ', age = ' + data.age + ', sex = ' + data.sex);
    });
}

function deletePerson() {
    var url = '/api/persons/'+$('#id').val();
    var method = 'DELETE';

    sendAjax(url, method, null, function (data) {
        $('#responseDelete').html('Deleted person:' + data.firstName + ' '
            + data.lastName + ', age = ' + data.age + ', sex = ' + data.sex);
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