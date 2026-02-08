#include <stdio.h>
#include "Eleicao.hpp"
int main()
{
    int num_candidatos;
    scanf("%d", &num_candidatos);

    Eleicao e = Eleicao(num_candidatos);
    int num_votos;
    scanf("%d", &num_votos);

    for (int i = 0; i < num_votos; i++)
    {
        int candidato, quantidade;
        scanf("%d %d", &candidato, &quantidade);
        e.votar(candidato, quantidade);

    }

    printf("%d\n", e.vencedor());
    printf("%d\n", e.numero_votos());

    return 0;
}