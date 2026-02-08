#include "Vendedor.hpp"

Vendedor::Vendedor(std::string n, double s, double c, bool m) 
    : FuncionarioContratado(n, s)
{
    this->_comissao = c;
    this->_bateu_meta = m;
}

double Vendedor::bonus()
{
    if (this->_bateu_meta)
    {
        return this->_comissao + (0.25 * this->_salario_base);
    }
    else
    {
        return 0.0;
    }
}

double Vendedor::descontos()
{
    if (this->_bateu_meta)
        return 0.0;
    return 0.10 * this->_salario_base;
}

Vendedor::~Vendedor()
{
}
