#ifndef _HORA_H
#define _HORA_H
#include <stdio.h>
class Hora
{
private:
    int _hora;
    int _min;
    int _seg;

    void normalizar();

public:
    Hora(int h, int m, int s);
    static Hora ler();
    void print();
    Hora operator+(Hora h2);
    Hora operator+(int seg);
};

void Hora::normalizar()
{
    if (this->_seg >= 60)
    {
        this->_min += this->_seg / 60;
        this->_seg = this->_seg % 60;
    }
    else if (this->_seg < 0)
    {
        this->_seg += 60;
        this->_min--;
    }

    if (this->_min >= 60)
    {
        this->_hora += this->_min / 60;
        this->_min = this->_min % 60;
    }
    else if (this->_min < 0)
    {
        this->_min += 60;
        this->_hora--;
    }
    if (this->_min >= 24)
    {
        this->_hora = this->_hora % 24;
    }
    else if (this->_hora < 0)
    {
        this->_hora += 24;
    }
}

Hora::Hora(int h = 0, int m = 0, int s = 0) : _hora(h), _min(m), _seg(s)
{
    normalizar();
}

Hora Hora::ler()
{
    int hora, min, seg;
    scanf("%d %d %d", &hora, &min, &seg);

    return Hora(hora, min, seg);
}

void Hora::print()
{
    printf("%d %d %d\n", this->_hora, this->_min, this->_seg);
}

Hora Hora::operator+(Hora h2)
{
    Hora h_resultado;

    h_resultado._hora = this->_hora + h2._hora;
    h_resultado._min = this->_min + h2._min;
    h_resultado._seg = this->_seg + h2._seg;

    h_resultado.normalizar();
    return h_resultado;
}

Hora Hora::operator+(int seg)
{
    Hora h_resultado = *this;
    h_resultado._seg = this->_seg + seg;

    h_resultado.normalizar();
    return h_resultado;
}

#endif