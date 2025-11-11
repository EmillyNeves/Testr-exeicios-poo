#include <stdio.h>
#include <stdlib.h>
#include "binary_tree.h"


int main()
{
    int n, value;

    BinaryTree *bt = binary_tree_construct();

    // adiciona um conjunto de itens na arvore
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &value);
        binary_tree_add(bt, value);
    }

    // exibe o minimo e maximo apos as insercoes
    printf("%d\n", binary_tree_min(bt));
    printf("%d\n", binary_tree_max(bt));

    // le um conjunto de numeros e verifica se eles existem na arvore
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &value);
        if (binary_tree_exists(bt, value)) printf("EXISTE\n");
        else printf("NAO EXISTE\n");
    }

    binary_tree_destroy(bt);

    return 0;
}
