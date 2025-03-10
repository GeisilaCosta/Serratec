// Recupera os dados do carrinho do localStorage, se houver
var carrinho = JSON.parse(localStorage.getItem('carrinho')) || {};


function adicionarAoCarrinho(id, preco) {
    if (carrinho[id]) {
        carrinho[id].quantidade += 1;
    } else {
        carrinho[id] = {
            preco: preco,
            quantidade: 1
        };
    }
}

function calcularTotal() {
    var total = 0;
    for (var id in carrinho) {
        total += carrinho[id].preco * carrinho[id].quantidade;
    }
    return total;
}

document.querySelectorAll('.like').forEach(function(botao) {
    botao.addEventListener('click', function() {
        alert('Você curtiu este produto!');
    });
});

document.querySelectorAll('.carrinho').forEach(function(botao) {
    botao.addEventListener('click', function() {
        var id = this.parentElement.parentElement.dataset.id;
        var preco = parseFloat(this.parentElement.parentElement.dataset.preco);
        adicionarAoCarrinho(id, preco);
        alert('Produto adicionado ao carrinho! Total agora é: R$' + calcularTotal().toFixed(2));

        // Armazena os dados do carrinho no localStorage
        localStorage.setItem('carrinho', JSON.stringify(carrinho));

        window.location.href = "paginaDeCompra.html"; // Redireciona para a página de compra
    });
});



// Adiciona um evento de clique ao botão "Finalizar Compra"
document.getElementById('finalizar').addEventListener('click', function() {
    alert('Compra finalizada! Total: R$' + calcularTotal().toFixed(2));
    carrinho = {}; // Limpa o carrinho
    localStorage.removeItem('carrinho'); // Remove o carrinho do localStorage
});

// Adiciona um evento de clique a cada botão "Remover do Carrinho"


// Adiciona um evento de clique a cada botão "Remover do Carrinho"
document.querySelectorAll('.remover').forEach(function(botao) {
    botao.addEventListener('click', function() {
        var id = this.parentElement.parentElement.dataset.id;
        delete carrinho[id]; // Remove o produto do carrinho
        localStorage.setItem('carrinho', JSON.stringify(carrinho)); // Atualiza o carrinho no localStorage
        this.parentElement.parentElement.remove(); // Remove o card do produto do DOM
        alert('Produto removido do carrinho!');
    });
});




