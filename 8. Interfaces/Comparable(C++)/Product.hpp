#ifndef _PRODUCT_H_
#define _PRODUCT_H_
#include <string>
#include <vector>
using namespace std;

class Product
{
private:
    string _nome;
    double _preco;

public:
    Product(string _nome, double _preco);
    bool operator<(const Product& p) const;
    string get_nome();
    double get_preco();
    void ordena_produtos(vector<Product *> produtos);
    ~Product();
};
#endif