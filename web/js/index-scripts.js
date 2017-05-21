function selectEstados(elemento){
    $(elemento).attr("disabled", "disabled");
    $.ajax({
        url: window.location.href+
        "estado",
        contentType: 'application/json',
        type: "GET",
        dataType: "json"
    }).done(function(data){
        $.each(data, function(){
            var item = $(this)[0];
            $(elemento).append($('<option>', {
                value: item.idEstado,
                text: item.nome
            }));
        });
        $(elemento).removeAttr("disabled");
    }).fail(function(){
        alert("Erro ao selecionar os estados!");
    });
}

$(document).ready(function(){
    selectEstados("select[name='select-estado']");
});