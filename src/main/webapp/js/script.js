/**
 * Created by ruslan on 31.10.16.
 * Updated by Макс
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
    data['firstName'] = $('#firstNameU').val();
    data['lastName'] = $('#lastNameU').val();
    data['age'] = $('#ageU').val();
    data['sex'] = $('#sexU').val();
    var url = '/api/persons/'+$('#idU').val();
    var method = 'PUT';

    sendAjax(url, method, data, function (data) {
        $('#responseUpdate').html('Updated person with id = ' + data.id);
    });
};

function getPerson() {
    var url = '/api/persons/'+$('#id').val();
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        $('#responseGet').html('Person ' + data.id + ': ' + data.firstName + ' '
            + data.lastName + ', age = ' + data.age + ', sex = ' + data.sex);
    });
}

function getAllPersons() {
    var url = '/api/persons';
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++)
            output = output.concat('Person ' + data[i].id + ': '
                + data[i].firstName + ' ' + data[i].lastName
                + ', age = ' + data[i].age + ', sex = ' + data[i].sex + "\n")
        $('#responseGetAll').html(output);
    });
}

function deletePerson() {
    var url = '/api/persons/'+$('#idD').val();
    var method = 'DELETE';

    sendAjax(url, method, null, function (data) {
        $('#responseDelete').html('Deleted person:' + data.firstName + ' '
            + data.lastName + ', age = ' + data.age + ', sex = ' + data.sex);
    });
}

function createPupil() {
    var pupilData = {};
    var url = '/api/persons/'+$('#person_id').val();
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        pupilData['person'] = data;
        url = '/api/schools/'+$('#school_id').val();
        sendAjax(url, method, null, function (data) {
            pupilData['school'] = data;
            url = '/api/schoolclasses/'+$('#schoolClass_id').val();
            sendAjax(url, method, null, function (data) {
                pupilData['schoolClass'] = data;
                var str = $('#subject_ids').val();
                var ids = str.split(',');
                pupilData['subjects'] = [];
                for (var i = 0; i < ids.length; i++) {
                    url = '/api/subjects/'+ids[i];
                    sendAjax(url, method, null, function (data) {
                        pupilData['subjects'].push(data);
                        if (i == ids.length-1) {
                            url = '/api/pupils';
                            method = 'POST';
                            sendAjax(url, method, pupilData, function (data) {
                                $('#responseCreate').html('Created pupil with id = ' + data.id);
                            });
                        }
                    });
                }
            });
        });
    });
}

function getPupil() {
    var url = '/api/pupils/'+$('#id').val();
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        var output = 'Pupil ' + data.id + ': person ' + data.person.id + ', school '
            + data.school.id + ', schoolClass ' + data.schoolClass.id + ', subjects';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseGet').html(output);
    });
}

function getAllPupils() {
    var url = '/api/pupils';
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++) {
            output = output.concat('Pupil ' + data[i].id + ': person ' + data[i].person.id + ', school '
                + data[i].school.id + ', schoolClass ' + data[i].schoolClass.id + ', subjects');
            for (var j = 0; j < data[i].subjects.length; j++)
                output = output.concat(' ' + data[i].subjects[j].id);
            output = output.concat("\n");
        }
        $('#responseGetAll').html(output);
    });
}

function updatePupil() {
    var pupilData = {};
    var url = '/api/persons/'+$('#person_idU').val();
    var method = 'GET';

    sendAjax(url, method, null, function (data) {
        pupilData['person'] = data;
        url = '/api/schools/'+$('#school_idU').val();
        sendAjax(url, method, null, function (data) {
            pupilData['school'] = data;
            url = '/api/schoolclasses/'+$('#schoolClass_idU').val();
            sendAjax(url, method, null, function (data) {
                pupilData['schoolClass'] = data;
                var str = $('#subject_idsU').val();
                var ids = str.split(',');
                pupilData['subjects'] = [];
                for (var i = 0; i < ids.length; i++) {
                    url = '/api/subjects/'+ids[i];
                    sendAjax(url, method, null, function (data) {
                        pupilData['subjects'].push(data);
                        if (i == ids.length-1) {
                            url = '/api/pupils/'+$('#idU').val();
                            method = 'PUT';
                            sendAjax(url, method, pupilData, function (data) {
                                $('#responseCreate').html('Updated pupil with id = ' + data.id);
                            });
                        }
                    });
                }
            });
        });
    });
}

function deletePupil() {
    var url = '/api/pupils/'+$('#idD').val();
    var method = 'DELETE';

    sendAjax(url, method, null, function (data) {
        var output = 'Deleted pupil ' + data.id + ': person ' + data.person.id + ', school '
            + data.school.id + ', schoolClass ' + data.schoolClass.id + ', subjects';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseDelete').html(output);
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