#include <stdio.h>
#include "Endereco.hpp"
#include "Data.hpp"
#include <iostream>

Endereco ::Endereco(std::string rua, std::string numero, std::string bairro, std::string cidade, std::string pais) : rua(rua), numero(numero), bairro(bairro), cidade(cidade), pais(pais)
{
}
void Endereco ::print()
{
    std::cout << "Endereco(" << rua << ", " << numero << ", " << bairro << ", " << cidade << ", " << pais << ")";
}