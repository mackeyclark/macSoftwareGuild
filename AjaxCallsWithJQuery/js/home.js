$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/contacts',
        success: function(contactArray) {
            var contactsDiv = $('#allContacts');
            $.each(contactArray, function(index, contact){
                var contactInfo = '<p>';
                contactInfo += 'Name: ' + contact.firstName + ' ' + contact.lastName + '<br>';
                contactInfo += 'Company: ' + contact.company + '<br>';
                contactInfo += 'Email: ' + contact.email + '<br>';
                contactInfo += 'Phone: ' + contact.phone + '<br>';
                contactInfo += '<hr>';

                contactsDiv.append(contactInfo);nh
            });
        },
        error: function() {
            alert('FAILURE');
        }
    });

    $('#add-button').on('click', function () {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/contact',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function() {
                alert('SUCCESS');
            },
            error: function(jsXHR, textStatus, errorThrown) {
                alert('FAILURE');
            }
        })
    })
})