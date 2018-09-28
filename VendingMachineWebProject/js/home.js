totalInserted = 0;
function addMoney(toAdd) {
    totalInserted += toAdd;
    $('#total-money-display').val(totalInserted);
}

$('document').ready(function () {
    loadItems();

    $('#add-dollar').click(function () {
        addMoney(1);
    });

    $('#add-quarter').click(function () {
        addMoney(0.25);
    });

    $('#add-dime').click(function () {
        addMoney(0.1);
    });

    $('#add-nickel').click(function () {
        addMoney(0.05);
    });

    $('#make-purachse').click(function () {
        //validate change
        //if url specifications are met PUT inventory -1 and call return change function
        //clear button's value and reload to match current inventory
        clearMessages();
        $.ajax({
            type: ('PUT'),
            url: ('http://localhost:8080/items'),
            success: function () {

            },
            error: function (jsXHR, statusMessage, causeThrown) {
                $('#messages-display').val('Error calling web service. Please try again later.');
            }
        });
    });

    $('#cancel').click(function () {
        returnChange();
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

                var newButton = $('<input></input>').attr({ type: 'button', class: 'itemButton btn btn-lg btn-block', id: item.id, value: item.id + ' ' + item.name + ' $' + item.price + ' Quantity left: ' + item.quantity });
                $('#vmButtonsDiv').append(newButton.append(cell));
                $('.itemButton').click( function () {
                    $('#item-display').val();
                });
            });
        },
        error: function (jsXHR, statusMessage, causeThrown) {
            $('#messages-display').val('Error calling web service. Please try again later.');
        }
    });
}

function clearMessages() {
    $('#messages-display').empty();
}

function returnChange() {
    //if an item was not selected return total inserted
    //if an iten was selected, convert return change JSON into money
    clearMessages();
    $.ajax({
        type: ('GET'),
        url: ('http://localhost:8080/money/' + totalInserted + 'item/' + ItemId),
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
