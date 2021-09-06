//Dynamic Datepicker Fields
$("body").on("focus", ".datepicker", function() {
    $(this).datepicker();
});

$(document).ready(function() {
    var max_fields = 10; //maximum input boxes allowed
    var wrapper = $(".input_fields_wrap"); //Fields wrapper
    var add_button = $(".add_field_button"); //Add button ID

    var wrapper2 = $(".input_fields_wrap2"); //Fields wrapper
    var add_button2 = $(".add_field_button2"); //Add button ID

    var wrapper3 = $(".input_fields_wrap3"); //Fields wrapper
    var add_button3 = $(".add_field_button3"); //Add button ID

    var x = 0; //initlal text box count
    $(add_button).click(function(e) {
        //on add input button click
        e.preventDefault();
        if (x < max_fields) {
            //max input box allowed
            x++; //text box increment
            $(wrapper).append(
                '<div class="input-line-control removeMe"><div class="col-md-8"><div class="form-group"><input id="x" type="hidden" name="x" value=""><div class="hs_firstname field hs-form-field"><label for="titlefor">Training Title *</label><input id="titlefor" name="" required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="locafor">Training Location *</label><input id="locafor" name=""  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"> <span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="startfor">Start date *</label><input id="startfor" name="" required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="endfor">End date *</label><input id="endfor" name="" required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="descfor">Training Description *</label><input id="descfor" name="description_formation{{$x}}" required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"> <i class="error-log fa fa-exclamation-triangle"></i></span></div></div></div><div class="col-md-4"><button class="btn btn-danger remove-date"><i class="fa fa-remove"></i>Remove</button></div></div>'); //add input box
            document.getElementById('x').value = x;
            document.getElementById('titlefor').name = "titre_formation" + x;
            document.getElementById('titlefor').id = "titre_formation" + x;
            document.getElementById('locafor').name = "lieu_formation" + x;
            document.getElementById('locafor').id = "lieu_formation" + x;
            document.getElementById('startfor').name = "date_debut_formation" + x;
            document.getElementById('startfor').id = "date_debut_formation" + x;
            document.getElementById('endfor').name = "date_fin_formation" + x;
            document.getElementById('endfor').id = "date_fin_formation" + x;
            console.log("hi:" + document.getElementById('date_fin_formation1').name + x);
            document.getElementById('descfor').name = "description_formation" + x;
            document.getElementById('descfor').id = "description_formation" + x;
        }
    });

    $(wrapper).on("click", ".remove-date", function(e) {
        //user click on remove text
        e.preventDefault();
        $(this).closest("div.removeMe").remove();
        x--;
    });




    var y = 0; //initlal text box count
    $(add_button2).click(function(e) {
        //on add input button click
        e.preventDefault();
        if (y < max_fields) {
            //max input box allowed
            x++; //text box increment
            $(wrapper2).append(
                '<div class="input-line-control removeMe2"><div class="col-md-8"><div class="form-group"><input id="y" type="hidden" name="y" value=""> <div class="hs_firstname field hs-form-field"><label for="titre_certificat">Certificate Title *</label><input id="titre_certificat"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="organisation_certificat">Certificate Organization *</label><input id="organisation_certificat"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="startforcer">Start Date *</label><input id="startforcer"  required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="endforcer">Expiry Date *</label><input id="endforcer"  required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="code">Code Certificate *</label><input id="code"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="desccer">Certificate Description *</label><input id="desccer"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div></div></div><div class="col-md-4"><button class="btn btn-danger remove-date2"><i class="fa fa-remove"></i>Remove</button></div></div>'); //add input box
            document.getElementById('y').value = y;
            document.getElementById('titre_certificat').name = "titre_certificat" + y;
            document.getElementById('titre_certificat').id = "titre_certificat" + y;
            document.getElementById('organisation_certificat').name = "organisation_certificat" + y;
            document.getElementById('organisation_certificat').id = "organisation_certificat" + y;
            document.getElementById('startforcer').name = "date_debut_certificat" + y;
            document.getElementById('startforcer').id = "date_debut_certificat" + y;
            document.getElementById('endforcer').name = "date_expiration_certificat" + y;
            document.getElementById('endforcer').id = "date_expiration_certificat" + y;
            console.log("hi:" + document.getElementById('date_expiration_certificat').name + y);
            document.getElementById('desccer').name = "Description_certificat" + y;
            document.getElementById('desccer').id = "Description_certificat" + y;
            document.getElementById('code').name = "code_certificat" + y;
            document.getElementById('code').id = "code_certificat" + y;
        }
    });

    $(wrapper2).on("click", ".remove-date2", function(e) {
        //user click on remove text
        e.preventDefault();
        $(this).closest("div.removeMe2").remove();
        x--;
    });



    var z = 0; //initlal text box count
    $(add_button3).click(function(e) {
        //on add input button click
        e.preventDefault();
        if (z < max_fields) {
            //max input box allowed
            z++; //text box increment
            $(wrapper3).append(
                '<div class="input-line-control removeMe3"><div class="col-md-8"><div class="form-group"><input id="z" type="hidden" name="z" value=""><div class="hs_firstname field hs-form-field"><label for="projet">Project Title *</label><input id="projet"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i> </span></div><div class="hs_firstname field hs-form-field"><label for="lieu">Project url  *</label><input id="lieu"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="startpro">Start Date *</label><input id="startpro"  required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="endpro">End Date *</label><input id="endpro"  required="required" type="date" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="descpro">Project Description *</label><input id="descpro"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div><div class="hs_firstname field hs-form-field"><label for="imag">Project Image *</label><input id="imag"  required="required" type="text" value="" placeholder="" data-rule-required="true" data-msg-required="Please include your first name"><span class="error1" style="display: none;"><i class="error-log fa fa-exclamation-triangle"></i></span></div></div></div><div class="col-md-4"><button class="btn btn-danger remove-date3"><i class="fa fa-remove"></i>Remove</button></div></div>'); //add input box
            document.getElementById('z').value = z;
            document.getElementById('projet').name = "titre_projet" + z;
            document.getElementById('projet').id = "titre_projet" + z;
            document.getElementById('lieu').name = "liens_projet" + z;
            document.getElementById('lieu').id = "liens_projet" + z;
            document.getElementById('startpro').name = "date_debut" + z;
            document.getElementById('startpro').id = "date_debut" + z;
            document.getElementById('endpro').name = "date_fin" + z;
            document.getElementById('endpro').id = "date_fin" + z;
            console.log("hi:" + document.getElementById('date_fin_formation1').name + z);
            document.getElementById('descpro').name = "description_projet" + z;
            document.getElementById('descpro').id = "description_projet" + z;
            document.getElementById('imag').name = "image_projet" + z;
            document.getElementById('imag').id = "image_projet" + z;
        }
    });

    $(wrapper3).on("click", ".remove-date3", function(e) {
        //user click on remove text
        e.preventDefault();
        $(this).closest("div.removeMe3").remove();
        x--;
    });
});