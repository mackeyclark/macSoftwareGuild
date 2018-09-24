$(document).ready(function () {
    $('h1').addClass('text-center');
    $('h2').addClass('text-center');
    $('.myBannerHeading').removeClass().addClass('page-header');
    $('#yellowHeading').text('Yellow Team');
    $('.orange').css('background-color', 'Orange');
    $('.blue').css('background-color', 'Blue');
    $('.red').css('background-color', 'Red');
    $('.yellow').css('background-color', 'Yellow');
    $('#yellowTeamList').append(`
        <li>Joeseph Banks</li>
        <li>Simon Jones</li>
    `);
    $('#oops').hide();
    $('#footerPlaceholder').remove();
    $('#footer').css({ 'font-family': 'Courier', 'font-size': '24px' }).append(`
    <p>Mackey Clark <br/>
    thatmacameron@gmail.com</p>
    `);
});