#include <stdio.h>
#include "rede.hpp"
#include "produto.hpp"
#include "restaurante.hpp"
int main()
{
    char rede_nome[32];
    scanf("%s\n", rede_nome);

    char r_nome[32];
    char p_nome[32];
    int estoque, vendas;
    float preco, custo;
    scanf("%s\n", r_nome); // r1

    scanf("%s %d %d %f %f\n", p_nome, &estoque, &vendas, &custo, &preco);
    Produto p1 = Produto(p_nome, estoque, vendas, custo, preco);

    scanf("%s %d %d %f %f\n", p_nome, &estoque, &vendas, &custo, &preco);
    Produto p2 = Produto(p_nome, estoque, vendas, custo, preco);

    scanf("%s %d %d %f %f\n", p_nome, &estoque, &vendas, &custo, &preco);
    Produto p3 = Produto(p_nome, estoque, vendas, custo, preco);

    Restaurante r1 = Restaurante(r_nome, p1, p2, p3);

    scanf("%s\n", r_nome); // r2

    scanf("%s %d %d %f %f\n", p_nome, &estoque, &vendas, &custo, &preco);
    p1 = Produto(p_nome, estoque, vendas, custo, preco);

    scanf("%s %d %d %f %f\n", p_nome, &estoque, &vendas, &custo, &preco);
    p2 = Produto(p_nome, estoque, vendas, custo, preco);

    scanf("%s %d %d %f %f", p_nome, &estoque, &vendas, &custo, &preco);
    p3 = Produto(p_nome, estoque, vendas, custo, preco);
    Restaurante r2 = Restaurante(r_nome, p1, p2, p3);

    Rede rede = Rede(rede_nome, r1, r2);

    Produto mais_ven = rede.mais_vendido();
    printf("%s %d\n", mais_ven.get_nome(), mais_ven.qtd_vendas());

    Restaurante mais_lucro = rede.mais_lucrativo();
    printf("%s %.2f\n", mais_lucro.get_nome(), mais_lucro.lucro());

    printf("%.2f\n", rede.valor_vendas());
    printf("%.2f\n", rede.custo());
    printf("%.2f\n", rede.lucro());

    return 0;
}