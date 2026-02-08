#ifndef RENDAFIXA_HPP
#define RENDAFIXA_HPP

#include "Investimento.hpp"

class RendaFixa : public Investimento {
private:
    int duracao;       
    double taxa_lucro;

public:
    RendaFixa(string n, double in, int d, double t);
    double retorno() override;
};

#endif