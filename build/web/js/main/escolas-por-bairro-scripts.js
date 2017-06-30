function mostrarPontuacao(idEscola){
    var $itemEscola = $("[idescola='"+idEscola+"']");
  
    $.ajax({
        url: window.location.href+
        "escola/"+idEscola+"/pontuacao",
        contentType: 'application/json',
        type: "GET",
        dataType: "json",
        beforeSend: function(){
            $itemEscola.find("button#pontuacao")
                .html("<img class='ajax-img' src='img/ajax-loader.gif' />")
                .attr("disabled", true);
        },
        complete: function(){
            $itemEscola.find("button#pontuacao")
                .html("Mostrar Pontuação")
                .attr("disabled", false);
        }
    }).done(function(data){
        if(data.length){
            var data = data[0];
            var pontuacao = 0;
            pontuacao += parseFloat(data.alimentacao);
            pontuacao += parseFloat(data.infraestrutura);
            pontuacao += parseFloat(data.limpeza);
            pontuacao += parseFloat(data.educacao);
            pontuacao += parseFloat(data.organizacao);
            pontuacao += parseFloat(data.flexibilidade);
            pontuacao += parseFloat(data.profissionais);
            pontuacao += parseFloat(data.comunicacao);
            pontuacao += parseFloat(data.custo);
            pontuacao = pontuacao/9;
            $itemEscola.find(".pontuacao").html("<b>Pontuação: </b>"+pontuacao.toFixed(2));
            $itemEscola.find("button#pontuacao").remove();
        }
    }).fail(function(){
        alert("Erro ao buscar a pontuação!");
    });
}

function mostrarEndereco(idEscola){
    var $itemEscola = $("[idescola='"+idEscola+"']");
  
    $.ajax({
        url: window.location.href+
        "escola/"+idEscola+"/endereco",
        contentType: 'application/json',
        type: "GET",
        dataType: "json",
        beforeSend: function(){
            $itemEscola.find("button#endereco")
                .html("<img class='ajax-img' src='img/ajax-loader.gif' />")
                .attr("disabled", true);
        },
        complete: function(){
            $itemEscola.find("button#endereco")
                .html("Mostrar Endereço")
                .attr("disabled", false);
        }
    }).done(function(data){
        if(data.length){
            var data = data[0];
            $itemEscola.find(".logradouro").html("<b>Endereço: </b>"+data.logradouro);
            $itemEscola.find(".numero").html("<b>Rua: </b>"+data.numero);            
            $itemEscola.find(".complemento").html("<b>Complemento: </b>"+data.complemento);
            $itemEscola.find("button#endereco").remove();
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
        dataType: "json",
        beforeSend: function(){
            $("#ajax-img").html("<img class='ajax-img' src='img/ajax-loader.gif' />");
        },
        complete: function(){
            $("#ajax-img").html("");
        }
    }).done(function(data){
        if(data.length){
            $.each(data, function(){
                $(".itens-escola").append(item_escola);
                var elemento = $(".item-escola").last();
                var item = $(this)[0];
                elemento.attr("idescola", item.idEscola);
                elemento.find(".nomeFantasia").text(item.nomeFantasia);
                elemento.find("button#endereco").attr(
                    "onclick", 
                    "javascript:mostrarEndereco("+item.idEscola+");"
                );
                elemento.find("button#pontuacao").attr(
                    "onclick", 
                    "javascript:mostrarPontuacao("+item.idEscola+");"
                );
                elemento = item = null;
            }); 
        }else{
            $("main").html("<h1 class='text-center'>Sem escolas para esta região!</h1>");
        }
    }).fail(function(){
        alert("Erro ao buscar as escolas!");
    });
}

$(document).ready(function(){
    showEscolas($.cookie("idBairro"));
});