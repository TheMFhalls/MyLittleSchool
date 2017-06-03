function mostrarEndereco(idEscola){
    var $itemEscola = $("[idescola='"+idEscola+"']");
  
    $.ajax({
        url: window.location.href+
        "escola/"+idEscola+"/endereco",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){
        if(data.length){
            var data = data[0];
            $itemEscola.find(".logradouro").html("<b>Endereço: </b>"+data.logradouro);
            $itemEscola.find(".numero").html("<b>Rua: </b>"+data.numero);            
            $itemEscola.find(".complemento").html("<b>Complemento: </b>"+data.complemento);
            $itemEscola.find("button").remove();
        }
    }).fail(function(){
        alert("Erro ao buscar o endereço!");
    });
}

function showEscolas(idBairro){
    var item_escola = $(".item-example").html();
    $.ajax({
        url: window.location.href+
        "bairro/"+idBairro+"/escola",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){
        if(data.length){
            $.each(data, function(){
                $(".itens-escola").append(item_escola);
                var elemento = $(".item-escola").last();
                var item = $(this)[0];
                elemento.attr("idescola", item.idEscola);
                elemento.find(".nomeFantasia").text(item.nomeFantasia);
                elemento.find("button").attr(
                    "onclick", 
                    "javascript:mostrarEndereco("+item.idEscola+");"
                );
                elemento = item = null;
            }); 
        }
    }).fail(function(){
        alert("Erro ao buscar as escolas!");
    });
}

$(document).ready(function(){
    showEscolas($.cookie("idBairro"));
});