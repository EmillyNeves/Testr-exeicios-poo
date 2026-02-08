#include <stdio.h>
#include <string>
#include <iostream>
#include "Pessoa.hpp"
#include "Conta.hpp"

int main()
{
    std ::string nome;
    std ::string cpf;
    std ::string numero_conta;
    int qtd_op;

    std::cin >> nome >> cpf >> numero_conta;

    scanf("%d", &qtd_op);

    Pessoa titular(nome, cpf);
    Conta conta(numero_conta, titular);

    for (int i = 0; i < qtd_op; i++)
    {
        char op;
        float valor;
        scanf("\n%c %f", &op, &valor);

        if (valor <= 0)
        {
            printf("VALOR INVALIDO\n");
        }
        else
        {
            if (op == 'D')
            {
                conta.deposito_conta(valor);
            }
            else if (op == 'S')
            {
                conta.saque_conta(valor);
            }
        }
    }
    conta.print();

    return 0;
}