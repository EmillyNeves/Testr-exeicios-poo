#include "Product.hpp"
Product::Product(string _nome, double _preco)
{
    this->_nome = _nome;
    this->_preco = _preco;
}

bool Product::operator<(const Product& p) const
{
    // mais barato primeiro
    if (this->_preco != p._preco) {
        return this->_preco < p._preco;
    }
    //ordena alfabeticamente
    return this->_nome < p._nome;
}

string Product::get_nome()
{
    return this->_nome;
}
double Product::get_preco()
{
    return this->_preco;
}
Product::~Product()
{
}
