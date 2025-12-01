#include <stdio.h>
#include "Data.hpp"
#include <string>
#include "Pessoa.hpp"
#include "Endereco.hpp"
#include <iostream>

int main()
{
    int dia, mes, ano;
    scanf("%d %d %d\n", &dia, &mes, &ano);
    Data d(dia, mes, ano);

    std::string rua, numero, bairro, cidade, pais;
    std::cin >> rua >> numero >> bairro >> cidade >> pais;
    Endereco e(rua, numero, bairro, cidade, pais);

    std::string nome, cpf, email;
    std::cin >> nome >> cpf >> email;
    Pessoa p(nome, cpf, email, e, d);

    int qtd_op;

    scanf("%d", &qtd_op);

    for (int i = 0; i < qtd_op; i++)
    {
        std::string op, info;
        std::cin >> op >> info;

        if (op == "CPF")
        {
            p.set_cpf(info);
        }
        else if (op == "EMAIL")
        {
            p.set_email(info);
        }
    }

    p.print();

    return 0;
}