#include "Freelancer.hpp"

Freelancer::Freelancer(std::string n, 
    int h, double v) : Funcionario(n)
{
    this->_h_trabalhadas = h;
    this->_valor_hora = v;
}
double Freelancer::salario()
{
    return this->_h_trabalhadas * 
    this->_valor_hora;
}
Freelancer::~Freelancer()
{
}
