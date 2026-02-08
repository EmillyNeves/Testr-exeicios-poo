#include "Investimento.hpp"

Investimento::Investimento(string n, double in) : nome(n), investimento_inicial(in) {}

Investimento::~Investimento() {}

string Investimento::get_nome() const {
    return nome;
}

double Investimento::get_investimento_inicial() const {
    return investimento_inicial;
}