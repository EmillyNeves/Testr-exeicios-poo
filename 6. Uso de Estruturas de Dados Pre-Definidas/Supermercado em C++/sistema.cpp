#include "sistema.hpp"
#include <iostream>
#include <iomanip>
#include <algorithm>
using namespace std;

Sistema::Sistema() {
    compraAtual = nullptr;
}

Sistema::~Sistema() {
    for (auto produto : produtos) {
        delete produto;
    }
    for (auto cliente : clientes) {
        delete cliente;
    }
    for (auto compra : compras) {
        delete compra;
    }
    if (compraAtual != nullptr) {
        delete compraAtual;
    }
}

void Sistema::registrarProduto(string nome, double preco) {
    Produto* produto = new Produto(nome, preco);
    produtos.push_back(produto);
}

void Sistema::registrarCliente(string nome, string cpf) {
    Cliente* cliente = new Cliente(nome, cpf);
    clientes.push_back(cliente);
}

void Sistema::adquirirProduto(string nomeProduto, int quantidade) {
    for (auto produto : produtos) {
        if (produto->getNome() == nomeProduto) {
            produto->adicionarEstoque(quantidade);
            return;
        }
    }
}

void Sistema::iniciarCompra(string cpf) {
    for (auto cliente : clientes) {
        if (cliente->getCpf() == cpf) {
            compraAtual = new Compra(cliente);
            return;
        }
    }
}

void Sistema::addItem(string nomeProduto, int quantidade) {
    if (compraAtual != nullptr) {
        for (auto produto : produtos) {
            if (produto->getNome() == nomeProduto) {
                compraAtual->adicionarProduto(produto, quantidade);
                return;
            }
        }
    }
}

void Sistema::finalizarCompra() {
    if (compraAtual != nullptr) {
        double total = compraAtual->calcularTotal();
        cout << fixed << setprecision(2) << total << endl;
        compraAtual->finalizarCompra();
        compras.push_back(compraAtual);
        compraAtual = nullptr;
    }
}

void Sistema::revenue() {
    double total = 0;
    for (auto compra : compras) {
        total += compra->getValorTotal();
    }
    cout << fixed << setprecision(2) << total << endl;
}

void Sistema::maisVendido() {
    vector<pair<Produto*, int>> vendas;

    for (auto compra : compras) {
        vector<pair<Produto*, int>> produtosCompra = compra->getProdutos();
        for (auto& par : produtosCompra) {
            bool encontrado = false;
            for (auto& venda : vendas) {
                if (venda.first == par.first) {
                    venda.second += par.second;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                vendas.push_back(make_pair(par.first, par.second));
            }
        }
    }

    Produto* maisVendido = nullptr;
    int maxVendas = 0;

    for (auto& par : vendas) {
        if (par.second > maxVendas) {
            maxVendas = par.second;
            maisVendido = par.first;
        }
    }

    if (maisVendido != nullptr) {
        cout << maisVendido->getNome() << endl;
    }
}

void Sistema::melhorCliente() {
    vector<pair<Cliente*, int>> numCompras;

    for (auto compra : compras) {
        bool encontrado = false;
        for (auto& par : numCompras) {
            if (par.first == compra->getCliente()) {
                par.second++;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            numCompras.push_back(make_pair(compra->getCliente(), 1));
        }
    }

    Cliente* melhorCliente = nullptr;
    int maxCompras = 0;

    for (auto& par : numCompras) {
        if (par.second > maxCompras) {
            maxCompras = par.second;
            melhorCliente = par.first;
        }
    }

    if (melhorCliente != nullptr) {
        cout << melhorCliente->getNome() << endl;
    }
}

void Sistema::emFalta() {
    for (auto produto : produtos) {
        if (produto->getQuantidade() < 5) {
            cout << produto->getNome() << endl;
        }
    }
}