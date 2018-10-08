
$(document).ready(function(){
    $('.table .eBtn').on('click', function(){
        
        var id = $(this).data("id");
        
        $.getJSON("/editProduto/" + id, function(data){
            console.log(data);
            var form = $(".myForm");
            $(".modal-body").append("<input type=\"hidden\" class=\"form-control\" name=\"id\" value=\"\"/>");
            form.find("input[name=id]").val(data.id);
            form.find("input[name=nome]").val(data.nome);
            form.find("input[name=descricao]").val(data.descricao);
            form.find("input[name=precoCompra]").val(data.precoCompra);
            form.find("input[name=precoVenda]").val(data.precoVenda);
            form.find("input[name=quantidade]").val(data.quantidade);
            form.find("input[name=status]").val(data.status);
            form.find("input[name=nome]").val(data.nome);
        });
        
        $('.myForm #exampleModal').modal();
    });
    
    $('.table .dBtn').on('click', function(){
        
        var id = $(this).data("id");
        console.log(id);
        if($('.dBtn1').on('click', function(){
            $.post("/deletarProduto/" + id);
        }));
    });
            
});
