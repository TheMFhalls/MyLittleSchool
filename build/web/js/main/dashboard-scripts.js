$(document).ready(function(){
    if(!$(".dashboard-load").length){
        $(".login span")
            .addClass("dashboard-load")
            .append("<a id=\"logout-button\" href=\"javascript:logout();\">"+
            "<i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i> SAIR</a>")
            .prepend("<a href=\"javascript:$('main').load(window.location.href+'view/main/dashboard.html');\">"+
            "<i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i> DASHBOARD</a>")
            .find("#login-button").remove();
    }
    
    $.ajax({
        url: "/usuario/security/"+$.cookie("usuario"),
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
        $.each(data, function(index, valor){
            $(".search-"+index).text(valor);
        });
        switch($.cookie("usuario")){
            case "pessoa":
                $(".search-nomeFantasia").parent().hide();
                $(".search-cnpj").parent().hide();
                $(".search-razaoSocial").parent().hide();
            break;
            case "escola":
                $(".search-nome").parent().hide();
                $(".search-cpf").parent().hide();
            break;
        }
    }).fail(function(){
        alert("Erro ao buscar informações!");
    });
});

function logout(){
    $.ajax({
        url: "/logout",
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        beforeSend: function(){
            $("#ajax-img").html("<img class='ajax-img' src='img/ajax-loader.gif' />");
        },
        complete: function(){
            $("#ajax-img").html("");
        }
    }).done(function(data){
        if(data.status === 1){
            alert(data.mensagem);
            $("#admin-bar").load(window.location.href+
                "view/header/admin-bar.html");
            $("main").load(window.location.href+
                "view/main/regiao.html");
        }else{
            alert("Erro interno do servidor!");
        }
    }).fail(function(){
        alert("Erro ao deslogar do sistema!");
    });
}