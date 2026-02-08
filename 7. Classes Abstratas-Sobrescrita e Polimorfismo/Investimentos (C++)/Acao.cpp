#include "Acao.hpp"

Acao::Acao(string n, double in, double tv)
    : Investimento(n, in), taxa_variacao(tv) {}

double Acao::retorno()
{
    double valor_atual = investimento_inicial * (1 + taxa_variacao);
    return valor_atual - investimento_inicial;
}