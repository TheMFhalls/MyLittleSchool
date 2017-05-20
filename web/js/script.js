function formAjaxSubmit(identificador, sucesso){   
    if($(identificador).attr("setted") === "ready"){        
        return;
    }else{
        $(identificador).attr("setted", "ready");
    }
    $(identificador).on("submit", function(event){
        event.preventDefault();
        var elemento = $(this);
        var JsonForm = elemento.serializeObject();
        $.ajax({
            url: elemento.attr("action"),
            contentType: 'application/json',
            type: elemento.attr("method"),
            data: JSON.stringify(JsonForm),
            dataType: "json"
        }).done(function(data){
            sucesso(data);
        }).fail(function(){
            alert("Erro ao submeter o formulário '"+elemento.attr("id")+"'.");
        });
    });
    console.log("Setado! "+identificador);
};

function reload(){
    formAjaxSubmit("#estado-update", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-insert", function(data){
       console.log(data);
    });
    console.log("ENTROU!");
}

window.onload = function(){
    setTimeout(reload, 500);
};