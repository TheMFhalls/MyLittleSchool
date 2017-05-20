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
    console.log("Setado! "+identificador);
};

function reload(){
    formAjaxSubmit("#estado-update", function(data){
       console.log(data);
    });
    formAjaxSubmit("#estado-insert", function(data){
       console.log(data);
    });
<<<<<<< HEAD
    console.log("ENTROU!");
}

window.onload = function(){
    setTimeout(reload, 500);
=======
    formAjaxSubmit("#estado-delete", function(data){
       console.log(data);
    });
>>>>>>> cf4b4d1504853635a5bbc4563897a4958e7113b5
};