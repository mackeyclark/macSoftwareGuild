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

    $('#make-purchase').click(function () { //should I use this function to check what I get back?
        //validate item chosen
        //validate change
        var money = $('#total-money-display').val();
        var item = $('#item-display').val();
        clearMessages();
        $.ajax({
            type: ('GET'),
            url: 'http://localhost:8080/money/' + money + '/item/' + item,
            success: function (change) {
                var quarters = change.quarters;
                var dimes = change.dimes;
                var nickels = change.nickels;
                var pennies = change.pennies;

                var returnChange = quarters + ' q ' +
                    + dimes + ' d ' +
                    + nickels + ' n ' +
                    + pennies + ' p ';

                $('#change-display').val(returnChange);
                $('#item-display').val('');
                $('#total-money-display').val('');
                totalInserted = 0;
                $('#messages-display').val('Thank You');
                $('#vmButtonsDiv').empty();
                loadItems();
            },
            error: function (jsXHR, statusMessage, causeThrown) {
                $('#messages-display').val(jsXHR.responseJSON.message);
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