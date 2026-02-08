#include "Estagiario.hpp"

Estagiario::Estagiario(std::string n, double s, double a) 
    : FuncionarioContratado(n, s)
{
    this->_a_transporte = a;
}

double Estagiario::bonus()
{
    return this->_a_transporte;
}

double Estagiario::descontos()
{
    return 0.0;
}

Estagiario::~Estagiario()
{
}
