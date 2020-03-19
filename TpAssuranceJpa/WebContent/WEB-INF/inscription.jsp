<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/css/inscription.css"/>" />
    </head>
    <body>
    <header>     
        <img id=muuf src="inc/images/maaf.jpg">
        <img id=efficace src="inc/images/maaf_cest_efficace.gif">
        <img id=dauphin src="inc/images/dauphin.gif">
    </header>
    
     <div class="menu">
        <form method="post" action="inscription" >
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
				
				
                <input type="submit" value="Inscription" class="sansLabel"/>
               
               
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                
               
            </fieldset>
        </form>
        </div>
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
    <script src="index.js"></script>
    </body>
</html>