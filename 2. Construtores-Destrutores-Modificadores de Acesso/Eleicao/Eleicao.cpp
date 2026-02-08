#include <stdlib.h>
#include "Eleicao.hpp"

Eleicao::Eleicao(int num_candidatos)
{
    /*A linha de código votos = (int *)calloc(n_candidatos, sizeof(int));
    já inicializa cada elemento do array votos para zero, pois a função calloc reserva memória e inicializa todos os bytes alocados com o valor zero.*/
    qtd_total_votos = 0;
    this->n_candidatos = num_candidatos;
    votos = (int *)calloc(n_candidatos, sizeof(int));
}

Eleicao::~Eleicao()
{
    free(votos);
}

void Eleicao::votar(int candidato, int quantidade)
{
    if (candidato >= 0 && candidato < n_candidatos)
    {
        votos[candidato] += quantidade;
        qtd_total_votos += quantidade;
    }
}

int Eleicao::vencedor()
{
    int id_vencedor = -1;
    int max_votos = votos[0];

    for (int i = 0; i < n_candidatos; i++)
    {
        if (max_votos < votos[i])
        {
            id_vencedor = i;
            max_votos = votos[i];
        }
    }
    return id_vencedor;
}

int Eleicao::numero_votos()
{
    return qtd_total_votos;
}
