function schemaBuilding(x, y, elementId) {
    var txt = "<table class='table table-active table-hover table-striped '>" +
        "<thead><tr><th>#</th>";
    for (var i = 0; i < y; i++) {
        txt += "<th> C" + (i + 1).toString() + "</th>"
    }

    txt += "<th id ='" + elementId + 'n' + "'> Norm</th></tr></thead><tbudy class='table table-dark'>";
    for (var i = 0; i < x; i++) {
        txt += "<tr><td> C" + (i + 1).toString() + "</td>";
        for (var j = 0; j < y; j++) {
            if (i == j) {
                txt += "<td><input onchange='complete(" + elementId + "z" +
                    i.toString() + j.toString() +
                    ")' tybe='text' id='" + elementId + "z" +
                    i.toString() + j.toString() +
                    "' value='1' style='width:100%; ' />"
                continue;
            }
            var id = '\"' + elementId + "z" + i.toString() + j.toString() + '\"';
            var rid = '\"' + elementId + "z" + j.toString() + i.toString() + '\"';
            txt += "<td><input tybe='text' style='width:100%' onchange='complete( " + id + "," + rid +
                ")' id='" + elementId + "z" +
                i.toString() + j.toString() + "'/>"
        }
        txt += "<td id ='" + elementId + 'Norm' + i.toString() + "'></td></tr>";
    }
    txt += "</tbudy></table>";
    if (elementId == 'criteria') {
        document.getElementById(elementId).innerHTML = txt;
    } else {
        document.getElementById('alternatives').innerHTML += "<div class='col-md-4'>" + txt + "</div>";

    }

}

function complete(Id, RID) {
    var x = getFloat(Id.toString());
    document.getElementById(RID).value = (1 / x).toString();
}

function buildingBlocks(x, y) {
    var btxt = "<div class='row' id='criteria' ></div><div class='row' id='alternatives'></div><div class='row' id='solution'></div>";

    for (let index = 0; index < x; index++) {
        btxt += "<div class='col-md-4' id='alt" + (index + 1).toString() + "'></div>"
    }
    btxt += "</div>";
    document.getElementById('sln').innerHTML = btxt;
    schemaBuilding(x, x, 'criteria');
    for (let index = 0; index < x; index++) {
        var l = 'alt' + (index + 1).toString();
        schemaBuilding(y, y, l)
    }
}

function buildingNorm(v, Id, len) {
    for (var i = 0; i < len; i++) {
        var eId = Id + i.toString();
        document.getElementById(eId).innerHTML =
            '<input type="button" style="width:100%" class="btn btn-primary" value="' +
            v[i].toString() + '"/>';
    }
}

function getInt(Id) {
    return parseInt(document.getElementById(Id).value);
}

function getFloat(Id) {
    return eval(parseFloat(document.getElementById(Id).value));
}

function MatrixInit(x, Segment) {
    var cri = [];

    for (var i = 0; i < x; i++) {
        var crii = [];
        for (var j = 0; j < x; j++) {
            var id = Segment + i.toString() + j.toString();
            crii[j] = getFloat(id);
        }
        cri[i] = crii;
    }
    return cri;
}

function criteriaMatrix() {
    var criteria = MatrixInit(getInt('Cri'), 'criteriaz');
    return criteria;
}

function modelBase() {
    var altM = [];
    for (var i = 0; i < getInt('Cri'); i++) {
        var txt = 'alt' + (i + 1).toString() + 'z';
        altM[i] = MatrixInit(getInt('Alt'), txt);
    }
    return altM;
}

function sumVec(v, len) {
    var sum = 0.0;
    for (var i = 0; i < len; i++) {
        sum += v[i];
    }
    return sum;
}

function norm(a, len) {
    var norm = [];
    for (var i = 0; i < len; i++) {
        norm[i] = sumVec(a[i], len);
    }
    var sum = sumVec(norm, len);
    for (var i = 0; i < len; i++) {
        norm[i] = norm[i] / sum;
    }
    return norm;
}

function start() {
    var cri = getInt('Cri');
    var alt = getInt('Alt');
    var NCM = norm(criteriaMatrix(), cri);
    var MM = modelBase();
    var NMM = [];
    for (var i = 0; i < cri; i++) {
        var x = MM[i];
        NMM[i] = norm(x, alt);
    }
    buildingNorm(NCM, 'criteriaNorm', cri);
    for (var i = 0; i < cri; i++) {
        var txt = "alt" + (i + 1).toString() + "Norm";
        buildingNorm(NMM[i], txt, alt);
    }

    var txt = "<div class='col-md-6'> <table class='table table-active table-hover table-striped '>" +
        "<thead><tr><th>#</th>";
    for (var i = 0; i < cri; i++) {
        txt += "<th>C" + (i + 1).toString() + "</th>"
    }
    txt += "</thead><tbudy>";
    for (var i = 0; i < alt; i++) {
        txt += "<tr><td>A" + (i + 1).toString() + "</td>"
        for (var j = 0; j < cri; j++) {
            txt += "<td>" + NMM[j][i].toString() + "</td>"
        }
        txt += "</tr>"
    }
    txt += "</tbudy></table></div><div class='col-md-3'><table class='table table-hover table-striped table-dark'><tr><th>Criteria Judgement</th></tr>"
    for (var i = 0; i < cri; i++) {
        txt += "<tr><td><input type='button' class='btn btn-danger' value ='" + NCM[i].toString() + "'/></td></tr>"
    }
    txt += "</table></div>"

    txt += "<div class='col-md-3'><table class='table table-hover table-striped table-dark'><tr><th>Alternative Truth</th></tr>"
    var vector = MultiplyMV(NMM, NCM);
    for (var i = 0; i < alt; i++) {
        txt += "<tr><td><input type='button' class='btn btn-success' value ='" + vector[i].toString() + "'/></td></tr>"
    }
    txt += "</table></div>"
    var max = maxV(vector);
    txt += "<diV><input type='button' class='btn btn-info' style='width:100%' value='A" + max[1].toString() + " =" + max[0].toString() + "'/></div>"

    document.getElementById('solution').innerHTML = txt;
}

function maxV(v) {
    z = v[0]
    index = 1;
    for (x = 0; x < v.length; x++) {
        if (z < v[x]) {
            z = v[x];
            index = x + 1;
        }
    }
    return [z, index];
}

function MultiplyMV(m, v) {

    var vector = [];
    for (var i = 0; i < getInt('Alt'); i++) {

        vector[i] = 0.0;
        for (var j = 0; j < getInt('Cri'); j++) {
            vector[i] += m[j][i] * v[j];
        }
    }
    return vector;
}