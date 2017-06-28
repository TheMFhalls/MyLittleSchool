$(document).ready(function(){
    formAjaxSubmit("#login",
        function(data){
            console.log(data);
        }
    );
});