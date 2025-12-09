#ifndef COMPRA_HPP
#define COMPRA_HPP

#include <map>
#include <vector>
#include <utility>
#include "cliente.hpp"
#include "produto.hpp"
using namespace std;

class Compra {
private:
    Cliente* cliente;
    std::vector<std::pair<Produto*, int>> produtos;
    double valorTotal;

public:
    Compra(Cliente* cliente);

    void adicionarProduto(Produto* produto, int quantidade);
    double calcularTotal();
    void finalizarCompra();

    Cliente* getCliente() const;
    std::vector<std::pair<Produto*, int>> getProdutos() const;
    double getValorTotal() const;
};

#endif