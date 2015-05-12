$(document).ready(function() {
    var $communes = $('#communes');
    var $quartiers = $('#quartiers');
    var $prixMin = $('#prixMin');
    var $prixMax = $('#prixMax');
    console.log("test ajax");
     
    // chargement des régions
//    $.ajax({
//        url: 'index.do',
//        data: 'go', // on envoie $_GET['go']
//        dataType: 'json', // on veut un retour JSON
//        success: function(data) {
//        	console.log("test function 1 ajax");
//        	$(".communeItem").remove();
//            $.each(data, function(index, item) { // pour chaque noeud JSON
                // on ajoute l option dans la liste
//            	$communes.append('<option value="'+ index +'">'+ value +'</option>');
//            	$communes.append('<option value="'+index+'">' +  item.nomCommune +  '</option>');
//            	console.log("blabla "+item);
//
//            });
//        }
//    });
 
    // à la sélection d une commune dans la liste
    $communes.on('change', function() {
        var val = $(this).val(); // on récupère la valeur de la commune
        
        if(val != '') {
            $quartiers.empty(); // on vide la liste des quartiers
            
            console.log("communes on change");
            $.ajax({
                url: 'commune.do',
                data: 'communeNom='+ val, // on envoie $_GET['nom_commune']
                dataType: 'json',
                success: function(data) {
                	console.log("test function 2 ajax");
                	console.log(data)
                	$(".quartierItem").remove();
                	
                	for(iterator in data){
                		console.log("test item niveau 1 :" + data[iterator].libelleQuartier);
                		$quartiers.append('<option value="'+ data[iterator].libelleQuartier +'">'+ data[iterator].libelleQuartier +'</option>');
                	}
                	
//                    $.each(data, function(item) {
//                    	console.log("each :" + data[item].libelleQuartier);
//                    	$quartiers.append('<option value="'+ data[item].libelleQuartier +'">'+ data[item].libelleQuartier +'</option>');
                    	
//                    });
                }
            });
        }
    });
    
    $prixMin.on('change', function(){
    	
    	var val = $(this).val();
    	$prixMax.empty();
    	
    	$.ajax({
    		url:'prix.do',
    		data: 'minimum='+ val, // on envoie $_GET['nom_commune']
            dataType: 'json',
            success: function(data) {
            	
            	for(iterator in data){
            		console.log("test item niveau 1 :" + data[iterator]);
            		$prixMax.append('<option value="'+ data[iterator] +'">'+ data[iterator] +'</option>');
            	}
            	
            }
    	})
    	
    });
    
});