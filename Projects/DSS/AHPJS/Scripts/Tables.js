var x = 0;
var y = 0;
var z = 0;
var son = 0;
var alt = 0;
var PT = [];
var CG = [];
var RG = [];
var d = [];
var m = [];
var index = 1;
var MaxAlt = [];
var MinAlt = [];
var j = 0;


function max(d = []) {
    z = d[0]
    index = 1;
    for (x = 0; x < d.length; x++) {
        if (z < d[x]) {
            z = d[x];
            index = x + 1;
        }
    }
    return [z, index];
}

function min(d = []) {
    index = 1;
    z = d[0]
    for (x = 0; x < d.length; x++) {
        if (z > d[x]) {
            z = d[x];
            index = x + 1;
        }
    }
    return [z, index];
}



function getColumn(j) {
    for (x = 0; x < parseInt(document.getElementById("Son").value); x++) {
        CG[x] = PT[x][j];
    }

    return CG;
}

function assignPT() {
    PT = [];
    for (var i = 0; i < parseInt(document.getElementById("Alt").value); i++) {
        PT[i] = [];
        for (var j = 0; j < parseInt(document.getElementById("Son").value); j++) {
            PT[i][j] = parseInt(document.getElementById("p" + (i + 1).toString() + (j + 1).toString()).value);
        }
    }

    return PT;
}


function maxAlt() {
    //Dependency Injection
    assignPT()
    z = 0;
    for (var i = 0; i < parseInt(document.getElementById("Alt").value); i++) {

        z = PT[i][0];
        for (var j = 0; j < parseInt(document.getElementById("Son").value); j++) {
            if (z < PT[i][j]) {
                z = PT[i][j];
                MaxAlt[i] = PT[i][j];
            } else {
                MaxAlt[i] = z;
            }
        }


    }
    return " ";
}

function Regert() {
    var alt = parseInt(document.getElementById("Alt").value);
    var son = parseInt(document.getElementById("Son").value);
    for (var i = 0; i < son; i++) {
        RG[i] = [];
        var l = getColumn(i);
        var mx = max(l);
        var ms = mx[0]
        for (var j = 0; j < alt; j++) {
            RG[i][j] = ms - l[j];
        }

    }
    return '';
}

function fillvectorR() {
    var textl = "";
    var hs = [];
    var ss = [];
    var alt = parseInt(document.getElementById("Alt").value);
    var son = parseInt(document.getElementById("Son").value);
    for (var i = 0; i < alt; i++) {
        textl += "<tr>";
        for (var j = 0; j < son; j++) {
            textl += "<td>" + RG[j][i].toString() + "</td>";
            hs[j] = RG[j][i];
        }
        var is = max(hs);
        ss[i] = is[0];
        textl += "<td style='color:Red'> The max = " + is[0].toString() + "</td>" +
            "</tr>";
    }
    var cs = min(ss);
    textl += "<tr><td> the best regret Alt(A" + (cs[1] + 1).toString() + ") = " + cs[0].toString() + "</td></tr>"
    return textl;

}

function fillvectorOP(d, m) {
    var text = "";
    for (x = 0; x < d.length; x++) {

        text += "<tr><td style='color:green'>" + d[x] + "</td>" +
            "<td style='color:red'>" + m[x] + "</td>" +
            "</tr>"
    }
    var s = max(d);
    var k = max(m);
    text += "<tr><td style='bg-color:green'>The Optimistic Alt = A" + s[1].toString() + "(" + s[0].toString() + ")</td>" +
        "<td style='bg-color:red'>The Pessimestic Alt = A" + k[1].toString() + "(" + k[0].toString() + ")</td>" +
        "</tr>";
    return text;
}

function ProfitOpt() {
    ProfitOp() + RegertT();
}

function ProfitOp() {
    $("#Sbody").append(maxAlt() + minAlt() + Regert() + fillvectorOP(MaxAlt, MinAlt));
}

function RegertT() {
    var gr = fillvectorR(Regert());
    var ta = document.getElementById("Mbody").innerHTML += gr;
}



function minAlt() {
    assignPT()
    z = 0;
    for (var i = 0; i < parseInt(document.getElementById("Alt").value); i++) {

        z = PT[i][0];
        for (var j = 0; j < parseInt(document.getElementById("Son").value); j++) {
            if (z > PT[i][j]) {
                z = PT[i][j];
                MinAlt[i] = PT[i][j];
            } else {
                MinAlt[i] = z;
            }
        }


    }
    return " ";

}


function removet() {
    $("#tb").remove();
    return " ";
}

function addTable() {


    $("#Env").append(removet() + "<table Id='tb' class='table table-hover '><thead><tr><th>#</th>" +
        heads() + "</tr></thead><tbody>" + bodys() + "</tbody></table>");

    return;
}




function heads() {

    var headt = " ";
    for (x = 0; x < parseInt(document.getElementById("Son").value); x++) {
        var headt = headt + "<th> S" + (x + 1).toString() + "</th>";
    }
    return headt;
}

function bodys() {
    var bodyt = " ";

    for (y = 0; y < parseInt(document.getElementById("Alt").value); y++) {

        bodyt += "<tr><th>A" + (y + 1).toString() + "</th>"
        for (x = 0; x < parseInt(document.getElementById("Son").value); x++) {
            bodyt = bodyt + "<td> <input type='text' style='width:100%' id='p" + (y + 1).toString() +
                (x + 1).toString() + "' Placeholder=' P " + (y + 1).toString() + " " +
                (x + 1).toString() + "' ></td>";
        }
        bodyt += "</tr>"
    }
    return bodyt;
}