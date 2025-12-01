#include <stdio.h>
#include <string>
#include <iostream>
#include "Conta.hpp"

Conta::Conta(std::string numero_conta, Pessoa titular)
    : numero(numero_conta), titular(titular)
{
    this->saldo = 0;
}

void Conta::deposito_conta(float valor)
{
    this->saldo += valor;
}
void Conta::saque_conta(float valor)
{
    if (this->saldo >= valor)
        this->saldo -= valor;
    else
        printf("SALDO INSUFICIENTE\n");
}
float Conta::saldo_conta(void)
{
    return this->saldo;
}
void Conta::print(void)
{
    std::cout << "Conta(" << this->numero << ", ";
    printf("%.2f", this->saldo);
    std::cout << ", Pessoa(";
    std::cout << this->titular.nome << ", " << this->titular.cpf << "))"
              << std::endl;
}