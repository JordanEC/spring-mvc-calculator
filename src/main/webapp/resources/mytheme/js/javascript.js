function reemp(val)
{
    document.getElementById("d").value = val;
}
function ader(val)
{
    document.getElementById("d").value += val;
}

String.prototype.insertAt = function (index, string) {
    return this.substr(0, index) + string + this.substr(index);
};

String.prototype.isNegative = function () {
    return this.charAt(0) === '-';
    
};

String.prototype.subcadena = function (cadena) {
    return cadena.substr(1, cadena.length);
};

String.prototype.delLastChar = function (cadena) {
    return cadena.substr(0, cadena.length - 1);
};

function fixOperation(cadena){
    cadena = cadena.replace("%", "/100");
    return cadena.replace("+", "%2B");
}

function ante(val) {
    var cad = document.getElementById("d").value;
    if (cad.isNegative())
        document.getElementById("d").value = cad.subcadena(cad);
    else
        document.getElementById("d").value = cad.insertAt(0, val);

}

function disp() {
    return document.getElementById("d").value;
}

function borr() {
    var cad = document.getElementById("d").value;
    document.getElementById("d").value = cad.delLastChar(cad);
}

function memory(mem) {
    $.ajax({
        type: 'POST',
        url: 'CalculatorSpringMVC/memory',
        data: 'mem='+mem+'&'+'value='+disp(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data) {
            reemp(data);
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });

}

function calcular() {
    $.ajax({
        type: 'POST',
        url: 'CalculatorSpringMVC/calcular',
        data: 'op='+fixOperation(disp()),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data) {
            reemp(data);
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
}