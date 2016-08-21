


$(document).ready(function () {
    var b0 = 0, b1 = 0, rxy = 0, r2=0, xk = 0, yk=0; 
    
    b0 = parseFloat($('#beta0').text());
    b1 = parseFloat($('#beta1').text());
    rxy = parseFloat($('#rsubxy').text());
    r2 = parseFloat($('#rsub2').text());
    
    $('#xsubk').on('input',function() { 
       if(this.checkValidity()){
           xk = parseFloat($(this).val());
           if(isNaN(xk)){
               $('#ysubk').html('X<sub>k</sub> is invalid.');
               return;
           }
           console.log(b0);
           console.log(b1);
           console.log(xk);
           yk = b0 + (b1*xk);
           $('#ysubk').text(yk);
       }else{
           $('#ysubk').html('X<sub>k</sub> is invalid.');
       }
    });
});