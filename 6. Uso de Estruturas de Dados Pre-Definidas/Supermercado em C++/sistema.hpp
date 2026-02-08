#ifndef SISTEMA_HPP
#define SISTEMA_HPP

#include <vector>
#include <string>
#include "produto.hpp"
#include "cliente.hpp"
#include "compra.hpp"
using namespace std;

class Sistema
{
private:
    vector<Produto *> produtos;
    vector<Cliente *> clientes;
    vector<Compra *> compras;
    Compra *compraAtual;

public:
    Sistema();
    ~Sistema();

    void registrarProduto(string nome, double preco);
    void registrarCliente(string nome, string cpf);
    void adquirirProduto(string nomeProduto, int quantidade);
    void iniciarCompra(string cpf);
    void addItem(string nomeProduto, int quantidade);
    void finalizarCompra();
    void revenue();
    void maisVendido();
    void melhorCliente();
    void emFalta();
};

#endif