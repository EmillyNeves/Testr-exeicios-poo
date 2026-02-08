#ifndef IMOVEL_HPP
#define IMOVEL_HPP

#include "Investimento.hpp"

class Imovel : public Investimento {
private:
    double area;
    double valorizacao_m2;
    double valor_aluguel;
    int meses;

public:
    Imovel(string n, double in, double area, double valorizacao_m2, double valor_aluguel, int meses);
    double retorno() override;
};

#endif
