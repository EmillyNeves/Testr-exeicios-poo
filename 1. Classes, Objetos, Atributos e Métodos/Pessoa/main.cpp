#include <stdio.h>
class Pessoa
{
public:
    char nome[32];
    int ano_nascimento;

    int calcula_idade(int ano_atual)
    {
        if (ano_atual > 0 && ano_atual >= this->ano_nascimento)
            return ano_atual - this->ano_nascimento;
        else
            return -1;
    }
};

int main()
{

    Pessoa p;
    int ano_atual;
    int idade;
    scanf("%s %d\n", p.nome, &p.ano_nascimento);
    scanf("%d", &ano_atual);

    idade = p.calcula_idade(ano_atual);

    if (idade < 0)
    {
        printf("VALOR INVALIDO\n");
    }
    printf("%d\n", idade);

    return 0;
}