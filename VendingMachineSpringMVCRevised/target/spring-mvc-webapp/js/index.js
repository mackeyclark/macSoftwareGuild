/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function clearMessages() {
    $('#messages-display').val('');
}

$('document').ready(function () {

    totalInserted = 0;
    function addMoney(toAdd) {
        totalInserted += toAdd;
        $('total-inserted-display').val(totalInserted);
    }

    $('#add-dollar').click(function () {
        $('#change-display').val('');
        clearMessages();
        addMoney(1);
    });

    $('#add-quarter').click(function () {
        $('#change-display').val('');
        clearMessages();
        addMoney(0.25);
    });

    $('#add-dime').click(function () {
        $('#change-display').val('');
        clearMessages();
        addMoney(0.1);
    });

    $('#add-nickel').click(function () {
        $('#change-display').val('');
        clearMessages();
        addMoney(0.05);
    });

});