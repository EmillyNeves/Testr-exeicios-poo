#include "FuncionarioContratado.hpp"
#include <string>

FuncionarioContratado::
FuncionarioContratado() : Funcionario()
{
    this->_salario_base = 0.0;
}

FuncionarioContratado::FuncionarioContratado
(std::string nome, double s) : Funcionario(nome)
{
    this->_salario_base = s;
}

double FuncionarioContratado::salario()
{
    return this->_salario_base + 
    this->bonus() - this->descontos();
}

FuncionarioContratado::~FuncionarioContratado()
{
}
