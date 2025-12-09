#include "compra.hpp"

Compra::Compra(Cliente* cliente) {
    this->cliente = cliente;
    this->valorTotal = 0;
}

void Compra::adicionarProduto(Produto* produto, int quantidade) {
    for (auto& par : produtos) {
        if (par.first == produto) {
            par.second += quantidade;
            return;
        }
    }
    produtos.push_back(make_pair(produto, quantidade));
}

double Compra::calcularTotal() {
    valorTotal = 0;
    for (auto& par : produtos) {
        valorTotal += par.first->getPreco() * par.second;
    }
    return valorTotal;
}

void Compra::finalizarCompra() {
    for (auto& par : produtos) {
        par.first->removerEstoque(par.second);
    }
}

Cliente* Compra::getCliente() const {
    return cliente;
}

std::vector<std::pair<Produto*, int>> Compra::getProdutos() const {
    return produtos;
}

double Compra::getValorTotal() const {
    return valorTotal;
}