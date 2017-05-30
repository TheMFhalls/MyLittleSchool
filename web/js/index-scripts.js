function selectEstados(elemento){
    $.ajax({
        url: window.location.href+
        "estado",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){
        if(data.length){            
            $(elemento).append($('<option>', {
                text: "-- Selecione seu estado --"
            }));

            $.each(data, function(){
                var item = $(this)[0];

                $.each(data, function(){
                    var item = $(this)[0];
                    $(elemento).append($('<option>', {
                        value: item.idEstado,
                        text: item.nome
                    }));
                });               
            }); 
            
            $(elemento).removeAttr("disabled");
        }
    }).fail(function(){
        alert("Erro ao selecionar os estados!");
    });
}

function selectCidades(elemento){
    var destino = $("select[name='select-cidade']");
    var idEstado = elemento.val();
    
    //Limpar SELECT de cidades        
        destino.empty();
        destino.attr("disabled", "disabled"); 
    //Fim limpar SELECT de cidades          
    
    $.ajax({
        url: window.location.href+
        "estado/"+idEstado+"/cidade",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){       
        if(data.length){
            destino.append($('<option>', {
                text: "-- Selecione sua cidade --"
            }));
            
            $.each(data, function(){
                var item = $(this)[0];
                destino.append($('<option>', {
                    value: item.idCidade,
                    text: item.nome
                }));
            });  
            
            destino.removeAttr("disabled");
        }        
    }).fail(function(){
        alert("Erro ao selecionar as Cidades!");
    });
}

function selectBairros(elemento){
    var destino = $("select[name='select-bairro']");
    var idCidade = elemento.val();
    
    //Limpar SELECT de bairros        
        destino.empty();
        destino.attr("disabled", "disabled"); 
    //Fim limpar SELECT de bairros          
    
    $.ajax({
        url: window.location.href+
        "cidade/"+idCidade+"/bairro",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){       
        if(data.length){
            destino.append($('<option>', {
                text: "-- Selecione seu bairro --"
            }));
            
            $.each(data, function(){
                var item = $(this)[0];
                destino.append($('<option>', {
                    value: item.idCidade,
                    text: item.nome
                }));
            });  
            
            destino.removeAttr("disabled");
        }        
    }).fail(function(){
        alert("Erro ao selecionar os Bairros!");
    });
}

$(document).ready(function(){
    selectEstados("select[name='select-estado']");
});