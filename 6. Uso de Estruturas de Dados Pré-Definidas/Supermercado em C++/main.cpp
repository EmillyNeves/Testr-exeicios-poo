#include <iostream>
#include <string>
#include "sistema.hpp"
using namespace std;

int main() {
    Sistema sistema;
    string comando;
    
    while (cin >> comando) {
        if (comando == "ENCERRAR") {
            break;
        }
        
        if (comando == "REGISTRAR_PRODUTO") {
            string nome;
            double preco;
            cin >> nome >> preco;
            sistema.registrarProduto(nome, preco);
        }
        else if (comando == "REGISTRAR_CLIENTE") {
            string nome, cpf;
            cin >> nome >> cpf;
            sistema.registrarCliente(nome, cpf);
        }
        else if (comando == "ADQUIRIR_PRODUTO") {
            string nome;
            int quantidade;
            cin >> nome >> quantidade;
            sistema.adquirirProduto(nome, quantidade);
        }
        else if (comando == "INICIAR_COMPRA") {
            string cpf;
            cin >> cpf;
            sistema.iniciarCompra(cpf);
        }
        else if (comando == "ADD_ITEM") {
            string nome;
            int quantidade;
            cin >> nome >> quantidade;
            sistema.addItem(nome, quantidade);
        }
        else if (comando == "FINALIZAR_COMPRA") {
            sistema.finalizarCompra();
        }
        else if (comando == "REVENUE") {
            sistema.revenue();
        }
        else if (comando == "MAIS_VENDIDO") {
            sistema.maisVendido();
        }
        else if (comando == "MELHOR_CLIENTE") {
            sistema.melhorCliente();
        }
        else if (comando == "EM_FALTA") {
            sistema.emFalta();
        }
    }
    
    return 0;
}