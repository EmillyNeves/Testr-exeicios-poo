#include "produto.hpp"

Produto::Produto(string nome, double preco) {
    this->nome = nome;
    this->preco = preco;
    this->quantidade = 0;
}

string Produto::getNome() const {
    return nome;
}

double Produto::getPreco() const {
    return preco;
}

int Produto::getQuantidade() const {
    return quantidade;
}

void Produto::adicionarEstoque(int qtd) {
    quantidade += qtd;
}

void Produto::removerEstoque(int qtd) {
    quantidade -= qtd;
}

bool Produto::temEstoque(int qtd) const {
    return quantidade >= qtd;
}