#ifndef _PESSOA_H_
#define _PESSOA_H_
#include <string>
#include <iomanip>
#include "Endereco.hpp"
#include "Data.hpp"
class Pessoa
{
private:
    std::string nome;
    std::string cpf;
    std::string email;
    Endereco endereco;
    Data data_nascimento;
    int validar_cpf(std::string cpf);
    int validar_email(std::string email);

public:
    Pessoa(std::string nome, std::string cpf, std::string email, Endereco endereco, Data data_nascimento);
    void set_cpf(std::string cpf);
    void set_email(std::string email);
    void print();
};
#endif