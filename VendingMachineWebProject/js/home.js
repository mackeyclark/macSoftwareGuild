totalInserted = 0;
function addMoney(toAdd) {
    totalInserted += toAdd;
    $('#total-money-display').val(totalInserted);
}

$('document').ready(function () {
    loadItems();

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

    $('#make-purachse').click(function () { //should I use this function to check what I get back?
        //validate item chosen
        //validate change
        clearMessages();
        $.ajax({
            type: ('GET'),
            url: 'http://localhost:8080/money/' + $('#change-display').val() + '/item/' + $('#item-display').val(),
            success: function (data, status) {
                var returnChange;

                returnChange += data.quarters
                             += data.dimes
                             += data.nickles
                             += data.pennies;

                $('#change-display').val(returnChange);
            },
            error: function (jsXHR, statusMessage, causeThrown) {
                $('#messages-display').val(statusMessage);
            }
        });
    });

    $('#cancel').click(function () {
        if (totalInserted > 0) {
            $('#total-money-display').val('');
            $('#change-display').val(totalInserted);
            totalInserted = 0;
        } else {
            $('#messages-display').val('Error: No Change Inserted')
        }
    });
});

function loadItems() {
    $.ajax({
        type: ('GET'),
        url: ('http://localhost:8080/items'),
        success: function (itemArray) {
            $.each(itemArray, function (index, item) {
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;
                var itemId = item.id;

                var cell = name;
                cell += price;
                cell += 'Quantity left: ' + quantity;
                cell += itemId;

                var newButton = $('<input></input>').attr({ type: 'button', class: 'itemButton btn btn-lg btn-block', id: item.id, onClick: 'saveItem(' + item.id + ')', value: item.id + ' ' + item.name + ' $' + item.price + ' Quantity left: ' + item.quantity });
                $('#vmButtonsDiv').append(newButton.append(cell));
            });
        },
        error: function (jsXHR, statusMessage, causeThrown) {
            $('#messages-display').val('Error calling web service. Please try again later.');
        }
    });
}

function saveItem(itemId) {
    $('#item-display').val(itemId);
}

function clearMessages() {
    $('#messages-display').val('');
}

function returnChange() {
    //if an iten was selected, convert return change JSON into money
    clearMessages();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/money/' + $('#change-display').val() + '/item/' + $('#item-display').val(),
        success: function () {

        },
        error: function (jsXHR, statusMessage, causeThrown) {
            $('#messages-display').val('Error calling web service. Please try again later.');
        }
    });
}

function checkAndDisplayValidationMessages() {
    //if the user inputs something invalid take the message json and display it
}
