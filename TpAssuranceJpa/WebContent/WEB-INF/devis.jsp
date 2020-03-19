<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Devis</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/css/devis.css"/>" />
    </head>
    <body>
    <header>     
        <img id=muuf src="inc/images/maaf.jpg">
        <img id=efficace src="inc/images/maaf_cest_efficace.gif">
        <img id=dauphin src="inc/images/dauphin.gif">
    </header>
    
    <div class="devis">
    	<img class="assuranceAuto" src="inc/images/devis.jpg">
    </div>
    
    <div class="defileParent">
		<span class="defile" data-text=" Contrats à prix discount !!!! ">

		</span>
	</div>

	<div class="div">
    <form class=form1 name="form" action="devis" method="post" id="form">
            <label>Marque :</label>
            <br>

            <select id="marque" name="marque" >
                   <option>---Choix----</option>
                   <c:forEach items="${marques}" var="marque">
                   <option value="${marque.idMarque}">${marque.nomMarque}</option>
                   </c:forEach>
                   
               </select>

            <br>
            <br>

            <label>Modéle :</label>
            <br>

            <select id=modele name="modele">
                   <option value="">---Choix----</option>                   
            </select>

            <br>
            <br>

            <label>Age :</label>
            <br>

            <select id=age name="age">
                   <option value="">---Choix----</option>
                   <c:forEach items="${ages}" var="age">
                   <option value="${age.idAge}">${age.valeurAge}</option>
                   </c:forEach>                    
                </select>
        </form>

        <br>

        
        <button id="prixBouton">Valider</button>
        <br>
        <br>
        <br>

        <label>Prix :</label>
        <input id=prix type="text" value="0.00" > Euros
        <img class=voiture src="voitAnim.gif">
    </div>
    
    <img id=image class=image src="">
    
	
	
    
    
   <img class=voitAnim src="inc/images/voitAnim.gif">
        <section>
        <aside>

		<a class="button" href="index.jsp">Accueil</a> 

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
    <script src="inc/javascript/index.js"></script>
    </body>
</html>