totalInserted = 0;
function addMoney(toAdd) {
    totalInserted += toAdd;
    $('#total-money-display').val(totalInserted);
}

function returnChange() {

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

    });

    $('#btn' + itemId).click(function () {
        getItem();
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

                var newButton = $('<input></input>').attr({ type: 'button', class: 'btn btn-lg btn-block', id: 'btn' + item.id, value: item.id + ' ' + item.name + ' $' + item.price + ' Quantity left: ' + item.quantity });
                $('#vmButtonsDiv').append(newButton.append(cell));
            });
        },
        error: function (jsXHR, statusMessage, causeThrown) {
            $('#messages-display').val('Error calling web service. Please try again later.');
        }
    });
}

function getItem() {
    $.ajax({
        type: ('GET'),
        url: ('http://localhost:8080/money/' + totalInserted + 'item/' + $('#btn' + item.id)),
        success: function () {
            
        },
        error: function () {
            $('#messages-display')
                .append($('<p>')
                    .attr({ class: 'input-group-item input-group-item-danger' })
                    .text('Error calling web service. Please try again later.'));
        }
    });
}