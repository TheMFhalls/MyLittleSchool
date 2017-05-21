function formAjaxSubmit(identificador, sucesso){   
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

function reload(){
    formAjaxSubmit("#estado-update", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-insert", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-delete", function(data){
       console.log(data);
    });
}

function view(){
    $("#admin-bar").load(window.location.href+
        "view/header/admin-bar.html");
}

window.onload = function(){
    setInterval(reload, 500);
    view();
};