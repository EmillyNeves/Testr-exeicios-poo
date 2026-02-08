#ifndef INVESTIMENTO_HPP
#define INVESTIMENTO_HPP

#include <string>
#include <iostream>

using namespace std;

class Investimento
{
protected:
    string nome;
    double investimento_inicial;

public:
    Investimento(string nome, double investimento_inicial);
    string get_nome() const;
    double get_investimento_inicial() const;
    virtual ~Investimento();

    virtual double retorno() = 0;
};

#endif