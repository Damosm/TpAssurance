$(function () {
    var imageSelectionee;

    $("#MaListeDeroulante").change(function () {
        imageSelectionee = $("#MaListeDeroulante").val();
       $("#image").attr("src", "/TpAssurance/javax.faces.resource/images/" + imageSelectionee + ".xhtml?ln=default");
        
       $.ajax({
    	   url: "#{modeleBean.getListeModeleAudi}",
    	   data: $("MaListeDeroulante").text(),
    	   dataType: "json",
    	   method: "post",
    	   success: function(data) {
    		   
    	   },
    	   error: function() {
    		   alert("Erreur");
    	   }
       });
    });
    
    function Choix(form) {
    	
    	
        i = form.Rubrique.selectedIndex;
        if (i == 0) {
            return;
        }
        switch (i) {
            case 1:
                var txt = new Array('A1','A2','A3');
                break;
            case 2:
                var txt = new Array('Golf', 'Touran', 'Passat');
                break;
            case 3:
                var txt = new Array('C-Max', 'S-Max', 'Mondeo');
                break;
        }

        for (i = 0; i < 3; i++) {

            form.SousRubrique.options[i + 1].text = txt[i];
        }
    }




    var MaListeDeroulante = $('#MaListeDeroulante');
    var choix1;
    var choix2;
    var choix3;



    MaListeDeroulante.change(function () {
        
        choix1 = $('#MaListeDeroulante option:selected').text();
        Choix(choix1);
    });



    var SousRubrique = $('#SousRubrique');
    SousRubrique.change(function () {
        choix2 = SousRubrique.val();

    });




    var SousRubrique2 = $('#SousRubrique2');

    SousRubrique2.change(function () {
        choix3 = SousRubrique2.val();
    });




    $('#valider').click(function () {
        calcul();

    });



    function calcul() {

        var prixMarque;
        var prixModele;
        var prixAge;
        var prixTotal;


        switch (choix1) {
            case "Audi":
                prixMarque = 200;
                break;

            case "VW":
                prixMarque = 150;
                break;
            case "Ford":
                prixMarque = 100;
                break;
        }




        switch (choix2) {

            case "A1":
                prixModele = 50;
                break;

            case "A2":
                prixModele = 100;
                break;

            case "A3":
                prixModele = 150;
                break;

            case "C-Max":
                prixModele = 50;
                break;

            case "S-Max":
                prixModele = 100;
                break;

            case "Mondeo":
                prixModele = 150;
                break;

            case "Golf":
                prixModele = 50;
                break;

            case "Touran":
                prixModele = 100;
                break;

            case "Passat":
                prixModele = 150;
                break;
        }

        switch (choix3) {
            case '18':
                prixAge = 2;
                break;
            case '19':
                prixAge = 1.9;
                break;
            case '20':
                prixAge = 1.8;
                break;
            case '21':
                prixAge = 1.7;
                break;
            case '22':
                prixAge = 1.6;
                break;
            case '23':
                prixAge = 1.5;
                break;
            case '24':
                prixAge = 1.4;
                break;
            case '25':
                prixAge = 1.3;
                break;
            case '26':
                prixAge = 1.2;
                break;
            case '27':
                prixAge = 1.1;
                break;
            case '28':
                prixAge = 1;
                break;
            case '29':
                prixAge = 1;
                break;
            case '30':
                prixAge = 1;
                break;
            case '31':
                prixAge = 1;
                break;

        }

        prixTotal = (prixMarque + prixModele) * prixAge;
        //console.log("Le prix est de" + prixTotal);
        //alert(prixTotal).innerHTML;
        $('#prix').val(prixTotal);
        //document.write(prixTotal);




    }

    
});

 