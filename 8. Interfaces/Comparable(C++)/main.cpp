#include "Product.hpp"
#include <iostream>
#include <algorithm>
#include <iomanip>
int main()
{
    vector<Product *> produtos;
    int n;
    cin >> n;
    string nome;
    double preco;

    for (int i = 0; i < n; i++)
    {
        cin >> nome;
        cin >> preco;
        produtos.push_back(new Product(nome, preco));
    }

    sort(produtos.begin(), produtos.end(), 
    [](Product *a, Product *b)
         { return *a < *b; });

    cout << fixed << setprecision(2);
    for (size_t j = 0; j < produtos.size(); j++)
    {
        cout << produtos[j]->get_nome() << " " 
        << produtos[j]->get_preco() << endl;
        delete produtos[j];
    }
    return 0;
}
