#include <stdio.h>
#include <string>
#include "Pessoa.hpp"
#include <cstdlib>
#include <iostream>

int Pessoa::validar_cpf(std::string cpf)
{
    for (char c : cpf)
    {
        if (!(c >= '0' && c <= '9'))
        {
            return 0;
        }
    }
    return 1;
}
int Pessoa::validar_email(std::string email)
{
    if (email.find("@") != std::string::npos && email.find(".com") != std::string::npos)
    {
        return 1;
    }
    return 0;
}

Pessoa::Pessoa(std::string nome, std::string cpf, std::string email, Endereco endereco, Data data_nascimento) : nome(nome), endereco(endereco), data_nascimento(data_nascimento)
{
    if (validar_cpf(cpf))
        this->cpf = cpf;
    else
        this->cpf = "N/A";

    if (validar_email(email))
        this->email = email;
    else
        this->email = "N/A";
}

void Pessoa::set_cpf(std::string cpf)
{
    if (validar_cpf(cpf))
        this->cpf = cpf;
    else
        printf("CPF INVALIDO\n");
}

void Pessoa::set_email(std::string email)
{
    if (validar_email(email))
        this->email = email;
    else
        printf("EMAIL INVALIDO\n");
}

void Pessoa::print()
{
    std::cout << "Pessoa(" << nome << ", " << cpf << ", " << email << ", ";
    endereco.print();
    std::cout << ", ";
    data_nascimento.print();
    std::cout << ")" << std::endl;
}