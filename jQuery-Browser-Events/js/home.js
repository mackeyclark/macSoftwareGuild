$(document).ready(function () {
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();
    $('#mainButton').on('click', function () {
        $('#mainInfoDiv').show();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    })
    $('#akronButton').on('click', function () {
        $('#mainInfoDiv').hide();
        $('#akronInfoDiv').show();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
        $('#akronWeather').hide();
    })
    $('#minneapolisButton').on('click', function () {
        $('mainInfoDiv').hide();
        $('#minneapolisInfoDiv').show();
        $('#akronInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
        $('#minneapolisWeather').hide();
    })
    $('#louisvilleButton').on('click', function () {
        $('mainInfoDiv').hide();
        $('#louisvilleInfoDiv').show();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleWeather').hide();
    })
    $('#akronWeatherButton').on('click', function () {
        $('#akronWeather').toggle('fast');
    })
});