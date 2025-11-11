#ifndef _PRODUTO_H
#define _PRODUTO_H
#include <stdio.h>
#include <string.h>
class Produto
{
private:
    char _nome[32];
    int _estoque;
    int _vendas;
    float _custo;
    float _preco;

public:
    Produto(char *nome, int estoque, int vendas, float custo, float preco);
    char *get_nome();
    int qtd_vendas();
    float valor_vendas();
    float custo_producao();
    float lucro();
};

Produto::Produto(char *nome, int estoque, int vendas, float custo, float preco)
{
    this->_custo = custo;
    this->_preco = preco;
    this->_vendas = vendas;
    this->_estoque = estoque;
    strcpy(this->_nome, nome);
}
char *Produto::get_nome()
{
    return this->_nome;
}
int Produto::qtd_vendas()
{
    return this->_vendas;
}
float Produto::valor_vendas()
{
    return this->_vendas * this->_preco;
}
float Produto::custo_producao()
{
    return this->_custo * this->_estoque;
}
float Produto::lucro()
{
    return this->valor_vendas() - this->custo_producao();
}
#endif