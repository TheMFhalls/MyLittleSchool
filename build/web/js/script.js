function formAjaxSubmit(identificador, sucesso){
    $(identificador).on("submit", function(event){
        var elemento = $(this);
        event.preventDefault();
        $.ajax({
            url: elemento.attr("action"),
            contentType: 'application/json',
            type: elemento.attr("method"),
            data: elemento.serialize(),
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
};