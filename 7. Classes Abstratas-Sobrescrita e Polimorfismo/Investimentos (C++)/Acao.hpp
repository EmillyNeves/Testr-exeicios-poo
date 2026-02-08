#ifndef ACAO_HPP
#define ACAO_HPP

#include <string>
#include <iostream>

#include "Investimento.hpp"

class Acao : public Investimento
{
private:
    double taxa_variacao;

public:
    Acao(string n, double in, double tv);
    double retorno() override;
};

#endif