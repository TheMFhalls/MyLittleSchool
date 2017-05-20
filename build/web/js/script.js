function formAjaxSubmit(identificador, sucesso){
    $(identificador).on("submit", function(event){
        event.preventDefault();
        var elemento = $(this);
        var jsonForm = elemento.serializeObject();
        $.ajax({
            url: elemento.attr("action"),
            contentType: 'application/json',
            type: elemento.attr("method"),
            data: JSON.stringify(jsonForm),
            dataType: "json"
        }).done(function(data){
            sucesso(data);
        }).fail(function(){
            alert("Erro ao submeter o formulário '"+elemento.attr("id")+"'.");
        });
    });
};

window.onload = function(){
    formAjaxSubmit("#estado-update", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-insert", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-delete", function(data){
       console.log(data);
    });
};