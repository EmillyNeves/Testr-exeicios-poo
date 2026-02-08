#include "Funcionario.hpp"
Funcionario::Funcionario()
{
    this->nome = "";
}
Funcionario::Funcionario(std::string nome)
{
    this->nome = nome;
}
std::string Funcionario::get_nome()
{
    return this->nome;
}
Funcionario::~Funcionario()
{
}