#ifndef _REDE_H
#define _REDE_H
#include "produto.hpp"
#include "restaurante.hpp"
#include <string.h>
class Rede
{
private:
    char _nome[32];
    Restaurante _r1;
    Restaurante _r2;

public:
    Rede(char *nome, Restaurante r1, Restaurante r2);
    float valor_vendas();
    float custo();
    float lucro();
    Produto mais_vendido();
    Restaurante mais_lucrativo();
};

Rede::Rede(char *nome, Restaurante r1, Restaurante r2) : _r1(r1), _r2(r2)
{
        strcpy(this->_nome, nome);
}

float Rede::valor_vendas()
{
    return this->_r1.valor_vendas() + this->_r2.valor_vendas();
}
float Rede::custo()
{
    return this->_r1.custo() + this->_r2.custo();
}
float Rede::lucro()
{
    return this->_r1.lucro() + this->_r2.lucro();
}
Produto Rede::mais_vendido()
{
    Produto mais_ven = this->_r1.mais_vendido();

    if (mais_ven.qtd_vendas() < this->_r2.mais_vendido().qtd_vendas())
        mais_ven = this->_r2.mais_vendido();

    return mais_ven;
}
Restaurante Rede::mais_lucrativo()
{
    Restaurante mais_lucro = this->_r1;

    if (mais_lucro.lucro()< this->_r2.lucro())
        mais_lucro = this->_r2;

    return mais_lucro;
}

#endif