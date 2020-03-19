$(function () {
    
	$("#marque").change(function () {
	       
	       $.ajax({
	    	   url: "getModeles",
	    	   data: "marque_id=" + $("#marque").val(),
	    	   dataType: "json",
	    	   method: "post",
	    	   success: function(data) {
	    		  
	    		   $("#modele").empty();
	    		   $("#modele").append($('<option/>',
						   {				   
					   value : "",
					   text : "---Choix---"				   				  				   
						   }			   
				   ))
	    		   $.each(data, function(index, element){
	    			   
	    			   
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
	
	("#prixButton").click(function(){
		
		 $.ajax({
	  	   url: "calcul",
	  	   data: "prixTotal=" + $("#prixTotal").val(),
	  	   dataType: "json",
	  	   method: "post",
	  	   success: function(data) {
	  		   
	  	   }
		
		
		
	})

	    
	});
	
	
	
	
	
	
	
	
});