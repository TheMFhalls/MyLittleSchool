$(document).ready(function(){
    formAjaxSubmit("#login",
        function(data){
            if(data.status === 0){
                alert(data.mensagem);
            }else if(data.status === 1){
                $("main").load(window.location.href+
                    "view/main/dashboard.html");
                $.cookie('idUsuario', data.login);    
                $.cookie('usuario', $("input:radio[name=usuario]:checked").val());
            }
        },
        function(){
            $("#ajax-img").html("<img class='ajax-img' src='img/ajax-loader.gif' />");
        },
        function(){
            $("#ajax-img").html("");
        }
    );
});