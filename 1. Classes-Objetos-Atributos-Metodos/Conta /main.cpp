#include <stdio.h>
#include <string.h>
class Conta
{
public:
    char numero_conta[12];
    float saldo;

    void deposito(float valor)
    {
        this->saldo += valor;
    }
    void saque(float valor)
    {
        if (valor <= this->saldo)
            this->saldo -= valor;
        else
            printf("SALDO INSUFICIENTE\n");
    }
};

int main()
{
    Conta c;
    int qtd_operacoes;
    c.saldo = 0;
    strcpy(c.numero_conta, "12344567");

    scanf("%d", &qtd_operacoes);

    for (int i = 0; i < qtd_operacoes; i++)
    {
        char op;
        float valor;
        scanf("\n%c %f", &op, &valor);

        if (valor > 0)
        {

            if (op == 'D')
            {
                c.deposito(valor);
            }
            else if (op == 'S')
            {
                c.saque(valor);
            }
        }
        else
            printf("VALOR INVALIDO\n");
        printf("%.0f\n", c.saldo);
    }

    return 0;
}