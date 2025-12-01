#ifndef _RESTAURANTE_H
#define _RESTAURANTE_H
#include "produto.hpp"
#include <string.h>
#include <stdio.h>
class Restaurante
{
private:
    Produto _p1;
    Produto _p2;
    Produto _p3;
    char _nome[32];

public:
    Restaurante(char *nome, Produto p1, Produto p2, Produto p3);
    char *get_nome();
    float valor_vendas();
    float custo();
    float lucro();
    Produto mais_vendido();
};

Restaurante::Restaurante(char *nome, Produto p1, Produto p2, Produto p3) : _p1(p1), _p2(p2), _p3(p3)
{
    strcpy(this->_nome, nome);
}

char *Restaurante::get_nome()
{
    return this->_nome;
}
float Restaurante::valor_vendas()
{
    return this->_p1.valor_vendas() + this->_p2.valor_vendas() + this->_p3.valor_vendas();
}
float Restaurante::custo()
{
    return this->_p1.custo_producao() + this->_p2.custo_producao() + this->_p3.custo_producao();
}
float Restaurante::lucro()
{
    return this->_p1.lucro() + this->_p2.lucro() + this->_p3.lucro();
}
Produto Restaurante::mais_vendido()
{
    Produto mais_ven = this->_p1;

    if (mais_ven.qtd_vendas() < this->_p2.qtd_vendas())
        mais_ven = this->_p2;
    if (mais_ven.qtd_vendas() < this->_p3.qtd_vendas())
        mais_ven = this->_p3;

    return mais_ven;
}

#endif