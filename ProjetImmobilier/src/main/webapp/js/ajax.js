$(document).ready(function() {
    var $communes = $('#communes');
    var $quartiers = $('#quartiers');
    console.log("test ajax");
     
    // chargement des régions
    $.ajax({
        url: 'index.do',
//        data: 'go', // on envoie $_GET['go']
        dataType: 'json', // on veut un retour JSON
        success: function(data) {
        	console.log("test function 1 ajax");
        	$(".communeItem").remove();
            $.each(data, function(index, item) { // pour chaque noeud JSON
                // on ajoute l option dans la liste
//            	$communes.append('<option value="'+ index +'">'+ value +'</option>');
            	$communes.append('<option value="'+index+'">' +  item.nomCommune +  '</option>');
            	console.log("blabla "+item);

            });
        }
    });
 
    // à la sélection d une commune dans la liste
    $communes.on('change', function() {
        var val = $(this).val(); // on récupère la valeur de la commune
        
        if(val != '') {
            $quartiers.empty(); // on vide la liste des quartiers
            
            console.log("communes on change");
            $.ajax({
                url: 'index.do',
                data: 'nom_commune='+ val, // on envoie $_GET['nom_commune']
                dataType: 'json',
                success: function(data) {
                	console.log("function data quartier");
                	console.log(data);
                	$(".quartierItem").remove();
                    $.each(data, function(index, value) {
//                    	$quartiers.append('<option value="'+ index +'">'+ value +'</option>');
                    	//$quartiers.append('<form:options items="${allQuartiers}" itemValue="'+libelleQuartier+'"" itemLabel="'+libelleQuartier+'"');
                    	$quartiers.append('<option value="'+ value +'">'+ value +'</option>');
                    });
                }
            });
        }
    });
});