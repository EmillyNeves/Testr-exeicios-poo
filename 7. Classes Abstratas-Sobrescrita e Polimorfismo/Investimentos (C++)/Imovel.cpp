#include "Imovel.hpp"
#include <cmath>
Imovel::Imovel(string n, double in, double a, double m2, double v_aluguel, int m)
    : Investimento(n, in), area(a), valorizacao_m2(m2), valor_aluguel(v_aluguel), meses(m) {}

double Imovel::retorno()
{
    double valor_atual_imovel = investimento_inicial * pow(1 + valorizacao_m2, meses);
    double total_alugueis = valor_aluguel * meses;

    return (valor_atual_imovel + total_alugueis) - investimento_inicial;
}
