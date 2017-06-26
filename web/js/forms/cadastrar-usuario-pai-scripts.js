$(document).ready(function(){
    formAjaxSubmit("#usuario-insert", 
        function(data){
            $("#idUsuario").val(data.idUsuario);            
            formAjaxSubmit("#endereco-insert", 
                function(data){  
                    $("#idEndereco").val(data.idEndereco); 
                    formAjaxSubmit("#usuario-pai-insert", 
                        function(data){
                            alert("Usuário cadastrado com sucesso!");
                        }
                    );
                    $("#usuario-pai-insert").submit();
                }
            );
            $("#endereco-insert").submit();
        }, 
        function(xhr){
            if(
                $("#senha").val() !== 
                $("#confirmar-senha").val()
            ){
                xhr.abort();
                $("#senha").val("");
                $("#confirmar-senha").val("");
                alert("Favor, verifique a senha confirmada!");                
            }
            if(
                $("#senha").val() === "" ||
                $("#login").val() === "" ||
                $("#email").val() === "" ||
                $("#cpf").val() === "" ||
                $("#nome").val() === "" ||
                $("#logradouro").val() === "" ||
                $("select[name='select-estado']") 
                === "-- Selecione seu estado --" ||
                $("select[name='select-cidade']") 
                === "-- Selecione sua cidade --" ||
                $("select[name='select-bairro']") 
                === "-- Selecione seu bairro --"
            ){
                xhr.abort();
                alert("Favor, preencha todos os campos!");
            }
        }
    );
});

function setBairro($el){
    $("#idBairro").val($el.val());
}