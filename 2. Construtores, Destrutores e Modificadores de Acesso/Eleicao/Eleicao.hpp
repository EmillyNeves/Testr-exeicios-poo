#ifndef _ELEICAO_H
#define _ELEICAO_H

class Eleicao
{
private:
    int n_candidatos;
    int *votos;
    int qtd_total_votos;

public:
    Eleicao(int num_candidatos);
    ~Eleicao();

    void votar(int candidato, int quantidade);
    int vencedor(void);
    int numero_votos(void);
};

#endif