$(document).ready(function(){
    $(".show-mensagem").html($.cookie("mensagem"));
    $("button[id='mensagem']").on("click", function(){
	var person = prompt("Escreva abaixo sua mensagem para esta escola");
        if (!(person === null || person === "")) {
            var mensagem = "<p><b>Usuario do Chat: </b>"+person+"</p>";
            if($.cookie("mensagem")){
                 $.cookie("mensagem", $.cookie("mensagem")+mensagem);
            }else{
                $.cookie("mensagem", mensagem);
            }           
        }
    });
});