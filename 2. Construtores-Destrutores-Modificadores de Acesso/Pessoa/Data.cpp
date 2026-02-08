#include "Data.hpp"
#include <stdio.h>
#include <iostream>

Data::Data(int dia, int mes, int ano) : dia(dia), mes(mes), ano(ano)
{
}
void Data::print()
{
    std::cout << "Data(" << dia << ", " << mes << ", " << ano << ")";
}