<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
         <title>La Muuf, elle assure !!!</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/css/index.css"/>" />
    </head>
    <body>
    <header>     
        <img id=muuf src="inc/images/maaf.jpg">
        <img id=efficace src="inc/images/maaf_cest_efficace.gif">
        <img id=dauphin src="inc/images/dauphin.gif">
    </header>
    
     <div class="menu">
	   <a class="button" href="inscription">Inscription</a> 
	   <br/>
	   <a class="button" href="connexion">Connexion</a>
	  
	</div>
	
	<div class="titre">
	 <img class="assuranceAuto" src="inc/images/assurance.jpg" />
	<div class="soustitre">
	<p>Des garanties incluses, des réductions avec les Bonus auto… c’est ça notre assurance auto !</p>
	
	
	
	</div>
	
	
	
	
	</div>
    
    
   <img class=voitAnim src="inc/images/voitAnim.gif">
        <section>
        <aside>
        

        </aside>

    </section>
        <footer>
        <div class="c1">
            <form action="/ma-page-de-traitement" method="post">
                <div>
                    <p>Contact @</p>
                   
                </div>
                </form>
			 </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="index.js"></script>
    </body>
</html>