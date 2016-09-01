$(document).ready(function () {
    $("input[type=file]").on('change', function () {
        //alert($(this).val());
        $('#fileName').html('Selected file to be uploaded:<span style="font-weight: bold;"> '+$(this).val()+'</span>')
    });
});