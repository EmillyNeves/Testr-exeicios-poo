#include "RendaFixa.hpp"
#include <cmath>
RendaFixa::RendaFixa(string n, double in, int d, double t)
    : Investimento(n, in), duracao(d), taxa_lucro(t) {}

double RendaFixa::retorno()
{
    return investimento_inicial * pow(1 + taxa_lucro, duracao);
}