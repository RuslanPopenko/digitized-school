/**
 * Created by ruslan on 31.10.16.
 * Updated by Макс
 */

//----------------------------------------PERSON---------------------------------------

function createPerson() {
    var data = {};
    data['firstName'] = $('#firstName').val();
    data['lastName'] = $('#lastName').val();
    data['age'] = $('#age').val();
    data['sex'] = $('#sex').val();
    var url = '/api/persons';

    sendAjax(url, 'POST', data, function (data) {
        $('#responseCreate').html('Created person with id = ' + data.id);
    });
};

function getPerson() {
    var url = '/api/persons/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        $('#responseGet').html('Person ' + data.id + ': '
            + data.firstName + ' ' + data.lastName
            + ', age - ' + data.age + ', sex - ' + data.sex);
    });
}

function getAllPersons() {
    var url = '/api/persons';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++)
            output = output.concat('Person ' + data[i].id + ': '
                + data[i].firstName + ' ' + data[i].lastName
                + ', age - ' + data[i].age + ', sex - ' + data[i].sex + '<br>')
        $('#responseGetAll').html(output);
    });
}

function updatePerson() {
    var data = {};
    data['firstName'] = $('#firstNameU').val();
    data['lastName'] = $('#lastNameU').val();
    data['age'] = $('#ageU').val();
    data['sex'] = $('#sexU').val();
    var url = '/api/persons/'+$('#idU').val();

    sendAjax(url, 'PUT', data, function (data) {
        $('#responseUpdate').html('Updated person with id = ' + data.id);
    });
};

function deletePerson() {
    var url = '/api/persons/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        $('#responseDelete').html('Deleted person:'
            + data.firstName + ' ' + data.lastName
            + ', age - ' + data.age + ', sex - ' + data.sex);
    });
}

//----------------------------------------PUPIL----------------------------------------

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
                url = '/api/subjects/';
                getRequestRecursive(url, ids, pupilData['subjects'], function(data) {
                    url = '/api/pupils';
                    sendAjax(url, 'POST', pupilData, function(data) {
                        $('#responseCreate').html('Created pupil with id = ' + data.id);
                    })
                });
            });
        });
    });
}

function getPupil() {
    var url = '/api/pupils/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        var output = 'Pupil ' + data.id
            + ': personId = ' + data.person.id
            + ', schoolId = ' + data.school.id
            + ', schoolClassId = ' + data.schoolClass.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseGet').html(output);
    });
}

function getAllPupils() {
    var url = '/api/pupils';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++) {
            output = output.concat('Pupil ' + data[i].id
                + ': personId = ' + data[i].person.id
                + ', schoolId = ' + data[i].school.id
                + ', schoolClassId = ' + data[i].schoolClass.id + ', subjectIds -');
            for (var j = 0; j < data[i].subjects.length; j++)
                output = output.concat(' ' + data[i].subjects[j].id);
            output = output.concat('<br>');
            $('#responseGetAll').html(output);
        }
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
                url = '/api/subjects/';
                getRequestRecursive(url, ids, pupilData['subjects'], function(data) {
                    url = '/api/pupils/'+$('#idU').val();
                    sendAjax(url, 'PUT', pupilData, function(data) {
                        $('#responseUpdate').html('Updated pupil with id = ' + data.id);
                    })
                });
            });
        });
    });
}

function deletePupil() {
    var url = '/api/pupils/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        var output = 'Deleted pupil ' + data.id
            + ': personId = ' + data.person.id
            + ', schoolId = ' + data.school.id
            + ', schoolClassId = ' + data.schoolClass.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseDelete').html(output);
    });
}

//----------------------------------------SUBJECT--------------------------------------

function createSubject() {
    var data = {};
    data['name'] = $('#name').val();
    var url = '/api/subjects';

    sendAjax(url, 'POST', data, function (data) {
        $('#responseCreate').html('Created subject with id = ' + data.id);
    });
};

function getSubject() {
    var url = '/api/subjects/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        $('#responseGet').html('Subject ' + data.id + ': ' + data.name);
    });
}

function getAllSubjects() {
    var url = '/api/subjects';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++)
            output = output
                .concat('Subject ' + data[i].id + ': ' + data[i].name + '<br>');
        $('#responseGetAll').html(output);
    });
}

function updateSubject() {
    var data = {};
    data['name'] = $('#nameU').val();
    var url = '/api/subjects/'+$('#idU').val();

    sendAjax(url, 'PUT', data, function (data) {
        $('#responseUpdate').html('Updated subject with id = ' + data.id);
    });
};

function deleteSubject() {
    var url = '/api/subjects/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        $('#responseDelete').html('Deleted subject:' + data.name);
    });
}

//----------------------------------------SCHOOL---------------------------------------

function createSchool() {
    var schoolData = {};
    schoolData['name'] = $('#name').val();
    schoolData['type'] = $('#type').val();
    var str = $('#pupil_ids').val();
    var ids = str.split(',');
    schoolData['pupils'] = [];
    var url = '/api/pupils/';

    getRequestRecursive(url, ids, schoolData['pupils'], function(data) {
        str = $('#schoolclass_ids').val();
        ids = str.split(',');
        schoolData['schoolClasses'] = [];
        url = '/api/schoolclasses/';
        getRequestRecursive(url, ids, schoolData['schoolClasses'], function(data) {
            url = '/api/schools';
            sendAjax(url, 'POST', schoolData, function(data) {
                $('#responseCreate').html('Created school with id = ' + data.id);
            });
        });
    });
}

function getSchool() {
    var url = '/api/schools/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        var output = 'School ' + data.id
            + ': name - ' + data.name
            + ', type - ' + data.type;
        $('#responseGet').html(output);
    });
}

function getAllSchools() {
    var url = '/api/schools';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++) {
            output = output.concat('School ' + data[i].id
                + ': name - ' + data[i].name
                + ', type - ' + data[i].type);
            output = output.concat('<br>');
        }
        $('#responseGetAll').html(output);
    });
}

function updateSchool() {
    var schoolData = {};
    schoolData['name'] = $('#nameU').val();
    schoolData['type'] = $('#typeU').val();
    var str = $('#pupil_idsU').val();
    var ids = str.split(',');
    schoolData['pupils'] = [];
    var url = '/api/pupils/';

    getRequestRecursive(url, ids, schoolData['pupils'], function(data) {
        str = $('#schoolclass_idsU').val();
        ids = str.split(',');
        schoolData['schoolClasses'] = [];
        url = '/api/schoolclasses/';
        getRequestRecursive(url, ids, schoolData['schoolClasses'], function(data) {
            url = '/api/schools/'+$('#idU').val();
            sendAjax(url, 'PUT', schoolData, function(data) {
                $('#responseUpdate').html('Updated school with id = ' + data.id);
            });
        });
    });
}

function deleteSchool() {
    var url = '/api/schools/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        var output = 'Deleted school ' + data.id
            + ': name - ' + data.name
            + ', type - ' + data.type;
        $('#responseDelete').html(output);
    });
}

//----------------------------------------SCHOOLCLASS-----------------------------------------

function createSchoolClass() {
    var schoolClassData = {};
    schoolClassData['name'] = $('#name').val();
    var url = '/api/schools/'+$('#school_id').val();

    sendAjax(url, 'GET', null, function (data) {
        schoolClassData['school'] = data;
        var str = $('#pupil_ids').val();
        var ids = str.split(',');
        schoolClassData['pupils'] = [];
        url = '/api/pupils/';
        getRequestRecursive(url, ids, schoolClassData['pupils'], function (data) {
            str = $('#subject_ids').val();
            ids = str.split(',');
            schoolClassData['subjects'] = [];
            url = '/api/subjects/';
            getRequestRecursive(url, ids, schoolClassData['subjects'], function (data) {
                url = '/api/schoolclasses';
                sendAjax(url, 'POST', schoolClassData, function (data) {
                    $('#responseCreate').html('Created schoolClass with id = ' + data.id);
                });
            });
        });
    });
}

function getSchoolClass() {
    var url = '/api/schoolclasses/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        var output = 'SchoolClass ' + data.id
            + ': name - ' + data.name
            + ', schoolId = ' + data.school.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseGet').html(output);
    });
}

function getAllSchoolClasses() {
    var url = '/api/schoolclasses';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++) {
            output = output.concat('SchoolClass ' + data[i].id
                + ': name - ' + data[i].name
                + ', schoolId = ' + data[i].school.id + ', subjectIds -');
            for (var j = 0; j < data[i].subjects.length; j++)
                output = output.concat(' ' + data[i].subjects[j].id);
            output = output.concat('<br>');
            $('#responseGetAll').html(output);
        }
    });
}

function updateSchoolClass() {
    var schoolClassData = {};
    schoolClassData['name'] = $('#nameU').val();
    var url = '/api/schools/'+$('#school_idU').val();

    sendAjax(url, 'GET', null, function (data) {
        schoolClassData['school'] = data;
        var str = $('#pupil_idsU').val();
        var ids = str.split(',');
        schoolClassData['pupils'] = [];
        url = '/api/pupils/';
        getRequestRecursive(url, ids, schoolClassData['pupils'], function (data) {
            str = $('#subject_idsU').val();
            ids = str.split(',');
            schoolClassData['subjects'] = [];
            url = '/api/subjects/';
            getRequestRecursive(url, ids, schoolClassData['subjects'], function (data) {
                url = '/api/schoolclasses/'+$('#idU').val();
                sendAjax(url, 'PUT', schoolClassData, function (data) {
                    $('#responseUpdate').html('Updated schoolClass with id = ' + data.id);
                });
            });
        });
    });
}

function deleteSchoolClass() {
    var url = '/api/schoolclasses/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        var output = 'Deleted schoolClass ' + data.id
            + ': name - ' + data.name
            + ', schoolId = ' + data.school.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        $('#responseDelete').html(output);
    });
}

//----------------------------------------TEACHER-----------------------------------------

function createTeacher() {
    var teacherData = {};
    var url = '/api/persons/'+$('#person_id').val();

    sendAjax(url, 'GET', null, function (data) {
        teacherData['person'] = data;
        var str = $('#subject_ids').val();
        var ids = str.split(',');
        teacherData['subjects'] = [];
        url = '/api/subjects/';
        getRequestRecursive(url, ids, teacherData['subjects'], function(data) {
            str = $('#school_ids').val();
            ids = str.split(',');
            teacherData['schools'] = [];
            url = '/api/schools/';
            getRequestRecursive(url, ids, teacherData['schools'], function(data) {
                str = $('#schoolClass_ids').val();
                ids = str.split(',');
                teacherData['schoolClasses'] = [];
                url = '/api/schoolclasses/';
                getRequestRecursive(url, ids, teacherData['schoolClasses'], function(data) {
                    url = '/api/teachers';
                    sendAjax(url, 'POST', teacherData, function (data) {
                        $('#responseCreate').html('Created teacher with id = ' + data.id);
                    });
                });
            });
        });
    });
}

function getTeacher() {
    var url = '/api/teachers/'+$('#id').val();

    sendAjax(url, 'GET', null, function (data) {
        var output = 'Teacher ' + data.id
            + ': personId = ' + data.person.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        output = output.concat(', schoolIds -');
        for (var i = 0; i < data.schools.length; i++)
            output = output.concat(' ' + data.schools[i].id);
        output = output.concat(', schoolClassIds -');
        for (var i = 0; i < data.schoolClasses.length; i++)
            output = output.concat(' ' + data.schoolClasses[i].id);
        $('#responseGet').html(output);
    });
}

function getAllTeachers() {
    var url = '/api/teachers';

    sendAjax(url, 'GET', null, function (data) {
        var output = '';
        for (var i = 0; i < data.length; i++) {
            output = output.concat('Teacher ' + data[i].id
                + ': personId = ' + data[i].person.id + ', subjectIds -');
            for (var j = 0; j < data[i].subjects.length; j++)
                output = output.concat(' ' + data[i].subjects[j].id);
            output = output.concat(', schoolIds -');
            for (var j = 0; j < data[i].schools.length; j++)
                output = output.concat(' ' + data[i].schools[j].id);
            output = output.concat(', schoolClassIds -');
            for (var j = 0; j < data[i].schoolClasses.length; j++)
                output = output.concat(' ' + data[i].schoolClasses[j].id);
            output = output.concat('<br>');
        }
        $('#responseGetAll').html(output);
    });
}

function updateTeacher() {
    var teacherData = {};
    var url = '/api/persons/'+$('#person_idU').val();

    sendAjax(url, 'GET', null, function (data) {
        teacherData['person'] = data;
        var str = $('#subject_idsU').val();
        var ids = str.split(',');
        teacherData['subjects'] = [];
        url = '/api/subjects/';
        getRequestRecursive(url, ids, teacherData['subjects'], function(data) {
            str = $('#school_idsU').val();
            ids = str.split(',');
            teacherData['schools'] = [];
            url = '/api/schools/';
            getRequestRecursive(url, ids, teacherData['schools'], function(data) {
                str = $('#schoolClass_idsU').val();
                ids = str.split(',');
                teacherData['schoolClasses'] = [];
                url = '/api/schoolclasses/';
                getRequestRecursive(url, ids, teacherData['schoolClasses'], function(data) {
                    url = '/api/teachers/'+$('#idU').val();
                    sendAjax(url, 'PUT', teacherData, function (data) {
                        $('#responseUpdate').html('Updated teacher with id = ' + data.id);
                    });
                });
            });
        });
    });
}

function deleteTeacher() {
    var url = '/api/teachers/'+$('#idD').val();

    sendAjax(url, 'DELETE', null, function (data) {
        var output = 'Deleted teacher ' + data.id
            + ': personId = ' + data.person.id + ', subjectIds -';
        for (var i = 0; i < data.subjects.length; i++)
            output = output.concat(' ' + data.subjects[i].id);
        output = output.concat(', schoolIds -');
        for (var i = 0; i < data.schools.length; i++)
            output = output.concat(' ' + data.schools[i].id);
        output = output.concat(', schoolClassIds -');
        for (var i = 0; i < data.schoolClasses.length; i++)
            output = output.concat(' ' + data.schoolClasses[i].id);
        $('#responseDelete').html(output);
    });
}

//----------------------------------------AJAX-----------------------------------------

function getRequestRecursive(url, ids, accumulator, callback) {
    sendAjax(url + ids.pop(), 'GET', null, function (data) {
        accumulator.push(data);
        if (ids.length > 0) {
            getRequestRecursive(url, ids, accumulator, callback);
        } else {
            callback();
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