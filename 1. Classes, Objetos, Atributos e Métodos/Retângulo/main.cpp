#include <stdio.h>

class Restangulo
{
public:
    float altura, largura;

    float calulaPerimetro()
    {
        return ((this->altura * 2) + (this->largura * 2));
    }

    float calculaArea()
    {
        return (this->altura * this->largura);
    }
};

int main()
{
    Restangulo r;
    scanf("%f %f", &r.altura, &r.largura);

    printf("%.0f %.0f\n", r.calculaArea(), r.calulaPerimetro());

    return 0;
}