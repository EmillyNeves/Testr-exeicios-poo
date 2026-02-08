#ifndef PRODUTO_HPP
#define PRODUTO_HPP

#include <string>
using namespace std;

class Produto {
private:
    string nome;
    double preco;
    int quantidade;

public:
    Produto(string nome, double preco);
    
    string getNome() const;
    double getPreco() const;
    int getQuantidade() const;
    
    void adicionarEstoque(int qtd);
    void removerEstoque(int qtd);
    bool temEstoque(int qtd) const;
};

#endif