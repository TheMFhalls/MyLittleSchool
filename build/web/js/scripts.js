function formAjaxSubmit(identificador, sucesso){ 
    /*
    formAjaxSubmit("#estado-update", function(data){
       console.log(data);
    });
    */
    if($(identificador).attr("setted") === "ready"){        
        return;
    }else{
        $(identificador).attr("setted", "ready");
    }
    $(identificador).on("submit", function(event){
        event.preventDefault();
        var elemento = $(this);
        var jsonForm = elemento.serializeObject();
        $.ajax({
            url: window.location.href+
            elemento.attr("action"),
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
    $("#admin-bar").load(window.location.href+
        "view/header/admin-bar.html");
    $("main").load(window.location.href+
        "view/main/regiao.html");
};