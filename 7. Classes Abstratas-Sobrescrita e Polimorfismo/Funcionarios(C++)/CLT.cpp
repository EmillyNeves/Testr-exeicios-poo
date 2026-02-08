#include "CLT.hpp"
CLT::CLT(std::string n, double s, 
    double t, double f, double i) 
    : FuncionarioContratado(n, s)
{
    this->_ticket_alimentacao = t;
    this->_desconto_fgts = f;
    this->_desconto_irrf = i;
}

double CLT::bonus()
{
    return this->_ticket_alimentacao;
}

double CLT::descontos()
{
    return this->_salario_base * 
    (this->_desconto_fgts + this->_desconto_irrf);
}

CLT::~CLT()
{
}
