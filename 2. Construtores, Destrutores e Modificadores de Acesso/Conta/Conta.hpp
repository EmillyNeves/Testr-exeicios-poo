#ifndef _CONTA_H
#define _CONTA_H
#include <string>
#include "Pessoa.hpp"

class Conta
{
private:
    std::string numero;
    Pessoa titular;
    float saldo;

public:
    Conta(std::string numero, Pessoa titular);
    void deposito_conta(float valor);
    void saque_conta(float valor);
    float saldo_conta(void);
    void print(void);
};
#endif