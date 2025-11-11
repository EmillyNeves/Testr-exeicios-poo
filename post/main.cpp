#include <stdio.h>
#include "post.hpp"
int main()
{
    char nome[32];
    char conteudo[32];

    scanf("%s %s", nome, conteudo);
    Post p = Post(nome, conteudo);

    int qtd_int;
    scanf("%d", &qtd_int);

    for (int op, i = 0; i < qtd_int; i++)
    {
        scanf("%d", &op);
        if (op)
            p.like();
        else
            p.dislike();
    }

    printf("%s\n%s\n%d\n%d\n%d\n", p.get_conteudo(), p.get_autor(), p.n_likes(), p.n_dislikes(), p.sentimento());

    return 0;
}