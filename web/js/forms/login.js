$(document).ready(function(){
    formAjaxSubmit("#login",
        function(data){
            if(data.status === 0){
                alert(data.mensagem);
            }else if(data.status === 1){
                console.log(data.mensagem);
            }
        }
    );
});