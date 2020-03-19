$(function () {
    
	$("#marque").change(function () {
	       
	       $.ajax({
	    	   url: "getModeles",
	    	   data: "marque_id=" + $("#marque").val(),
	    	   dataType: "json",
	    	   method: "post",
	    	   success: function(modeles) {
	    		  
	    		   $("#modele").empty();
	    		   $("#modele").append($('<option/>',
						   {				   
					   value : "",
					   text : "---Choix---"				   				  				   
						   }			   
				   ))
	    		   $.each(modeles, function(index, element){
	    			   
	    			   
	    			   $("#modele").append($('<option/>',
	    					   {
	    				   
	    				   value : element.idModele,
	    				   text : element.nomModele
	    				   
	    				   
	    				   
	    					   }
	    					   
	    			   ))
	    			   
	    			   
	    		   })
	    		   
	    	   },
	    	   error: function() {
	    		   console.log("Une erreur s'est produite");
	    	   }
	    	   
	    	   
	       });
    
    });
	
	$("#prixBouton").click(function() {
		if ($("#marque").val() != "" && $("#modele").val() != "" && $("#age").val() != "") {
			$.ajax({
				url: "calcul",
				dataType: "json",
				method: "post",
				data: {"idMarque": $("#marque").val(), "idModele": $("#modele").val(), "idAge": $("#age").val()},
				success: function(prixTotal) {
					$("#prix").val(prixTotal);
				}
			});
		} else {
			alert("Les champs Marque, Modele et Age ne sont pas tous renseignés");
		}
	});

});