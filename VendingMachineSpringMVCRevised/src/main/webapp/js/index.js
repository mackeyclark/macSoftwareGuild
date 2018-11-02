/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


totalInserted = 0;
function addMoney(toAdd) {
    totalInserted += toAdd;
    $('#total-inserted-display').val(totalInserted);
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

function saveId(id) {
    $('#itemId').val(id);
}

function saveName(name) {
    $('#itemName').val(name);
}

function savePrice(price) {
    $('#itemPrice').val(price);
}

function saveInventory(inventory) {
    $('#itemInventory').val(inventory);
}

function clearMessages() {
    $('#messages-display').val('');
}

$('#cancel').click(function () {
    if (totalInserted > 0) {
        $('#total-money-display').val('');
        $('#change-display').val(totalInserted);
        totalInserted = 0;
    } else {
        $('#messages-display').val('Error: No Change Inserted')
    }
});
