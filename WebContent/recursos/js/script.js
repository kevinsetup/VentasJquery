$(document).ready(function(){
listarestudiante();
listaes(0)
limpiar();
$("#telefono").numeric();
jQuery('#precio').keyup(function () { this.value = this.value.replace(/[^0-9\.]/g,''); });

});
$("#boton").click(function(){
	var esc= $("#esc").val();	
	var apell= $("#apellynombre").val();
	var correo= $("#correo").val();
	var tele = $("#telefono").val();
	var id = $("#id").val();
	if(id==0){
		$.post("home", {esc:esc,apell:apell,correo:correo,tele:tele, opc:3}).done(function(data){
			limpiar();
			listaes(0)
			listarestudiante();
			});
	}else{
		bootbox.confirm("Desea Modificar?", function(result) {
		if(result){
		 	bootbox.alert("Registro Modificado Correctamente...!", function() {		
			$.post("home", {idEscuela :esc, apell:apell, correo:correo, tele:tele, idp:id, opc:6}).done(function(data){
				$("#id").val(0);
				limpiar();
				listaes(0)
				listarestudiante();	
				
			});
		 	});
		}else{
	    	bootbox.alert("El registro no se Modifico...!");
	    	limpiar();
	    	listaes(0)
			listarestudiante();
	    }});		
	}
});
function listaes(x){
	var i, c =1;
	$("#esc").empty().append('<option selected="selected" value="test">Seleccionar Escuela</option>')
		$.get("home", {opc : "1"}, 
		function(data) {
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idescuela) {
				$("#esc").append(
						"<option selected='selected' value='" + d[i].idescuela + "'>"
								+ d[i].nombrecat + "</option>");
			} else {
				$("#esc").append(
						"<option value='" + d[i].idescuela + "'>"
								+ d[i].nombrecat + "</option>");
			}
		}
	});	
}

function listarestudiante(){
	var i, c =1;
	$.get("home",{opc:"2"},function(data){	
		var d = JSON.parse(data);
		
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
	
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nombrecat+"</td><td>"+d[i].apellynombre+"</td><td>"+d[i].correo+"</td><td>"+d[i].telefono+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idalumno+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idalumno+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}

function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado :D...!", function() {
    		$.get("home",{id:id,opc:5},function(data){
     			limpiar();
     			listaes(0);
     			listarestudiante();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }});
}
function modificar(id){	
	$.post("home",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#apellynombre").val(x[0].apelnombres);
		$("#correo").val(x[0].correo);
		$("#telefono").val(x[0].telefono);
		$("#id").val(x[0].idalumno);		
		listaes(x[0].idescuela);
	});
}
function limpiar(){
	$("#apellynombre").val("");
	$("#correo").val("");
	$("#telefono").val("");
	$("#apellynombre").focus();
}
